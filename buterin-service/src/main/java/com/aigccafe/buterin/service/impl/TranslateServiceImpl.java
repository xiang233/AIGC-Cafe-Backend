package com.aigccafe.buterin.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.enumerate.HttpMethod;
import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.util.RetryTask;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.service.HttpService;
import com.aigccafe.buterin.service.TranslateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

//import static com.aigccafe.buterin.common.Constant.BAIDU_APP_ID;
//import static com.aigccafe.buterin.common.Constant.BAIDU_SECRET_KEY;

@Service
@Slf4j
public class TranslateServiceImpl implements TranslateService {

    private static final String promptTemplate = "Translate the following html paragraph into Chinese, aiming for accuracy while omitting translation for proper nouns or abbreviations.Only the translation result is required.The text to be translated is as follows：%s";
    private static final String openAIUrl = "https://api.openai.com/v1/chat/completions";
    private static final String nplUrl = "https://nlp-translation.p.rapidapi.com/v1/translate";
    private static final String TRANS_API_HOST = "http://api.fanyi.baidu.com/api/trans/vip/translate";
    private static final String LANG_DETECT_HOST = "https://fanyi-api.baidu.com/api/trans/vip/language";

    static List<Long> blackIdList = Lists.newArrayList();

    @Value("${baidu.app-id}")
    private String baiduAppId;

    @Value("${baidu.secret-key}")
    private String baiduSecretKey;

    @Value("${openai.api-key}")
    private String openAiApiKey;
    
    @Autowired
    private HttpService httpService;
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public boolean translateModelContent(Integer number) {
        for (int i = 0; i <= number; i++) {
            List<ModelDetailPO> modelDetailPOList = modelRepository.selectUntranslatedModelList(2, blackIdList);
            log.info("数量：{}", modelDetailPOList.size());
            modelDetailPOList.stream().parallel().forEach(model -> {
                String content = model.getDescription();
                try {
                    log.info("模型： {},开始翻译", model.getModelName());
                    String chnContent = translateHtml(content);
                    chnContent = chnContent.replaceAll("^“|”$", "");
                    if ("".equals(chnContent)) {
                        chnContent = "无";
                    }
                    model.setChnDescription(chnContent);
                    modelRepository.update(model);
                    log.info("模型：{},翻译成功", model.getModelName());
                } catch (Exception exp) {
                    blackIdList.add(model.getId());
                    log.info(exp.getMessage());
                    log.info("模型:{}, 翻译失败，跳过", model.getModelName());
                }
            });
        }
        return true;
    }

    @Override
    public String translateHtml(String html) throws Exception {
        Document doc = Jsoup.parse(html);
        // 遍历每个元素
        Elements elements = doc.getAllElements();
        for (Element element : elements) {
            if (element.tagName().equals("p") || element.tagName().equals("h1") || element.tagName().equals("h2")
                    || element.tagName().equals("h3") || element.tagName().equals("li")) {
                String content = element.outerHtml();
                String innerContent = element.html();
                if (!Strings.isNullOrEmpty(innerContent)) {
                    log.info("源文本:{}", content);
                    RetryTask.retry(5, () -> {
                        String chContent = translateSentenceByNLP(content);
                        log.info("翻译文本:{}", chContent);
                        element.after(chContent);
                    });
                }
//                log.info(element.html());
            }
        }
       return doc.outerHtml();
    }

    @Override
    public String translateHtmlBySplit(String html) throws Exception {
//        html="<p>Hi, I’m product and car designer, and I’m so excited to test with AI, I think is a good tool for designing. This tool is so useful for the design process (shapes-ideas generation), but more than that it helps so much to refine aesthetically.</p><p>After a lot of training and testing images, I finally arrived at a stable model to generate product design images and iterations. Even that I’m trying to enhance it. Recommendation to use this model:<br /></p><ol><li><p>It is mandatory to use captions in the prompt like: “3D product render” or “product render”. I’m testing to enhance model using another “instance token”, probably I will change it, but it depends on the quality of image generation. I use this token especially to enhance “product rendering” captions and center it to a certain style, also I think that can be merged with another Lora Style. Even that I’m not so expert with training, and I will try with a different name if results get better.</p></li><li><p>Clip Skip 2. Go to settings-Stable Diffusion-Clip Skip, and put “2”. I trained model with this option.</p></li><li><p>Generate first some images by changing “Batch size”, select one, and go to img2img mode, duplicate or increase resolution (image size), with “denoise strength” of “0.3 to 0.5”. It is the same process of “hires.fix” in txt2img mode, but you can have more images generated to select. Try to preserve 512x512 (or just 512 in one side) because images are trained at this resolution, and when you change it the model-shapes start gets crazy, even that you can experiment.</p></li><li><p>Use new “extra tool” for enhancing image called “4x-UltraSharp”, to increase final resolution.</p></li><li><p>If you combine the model using Lora like “DreamShaper”, you can generate another kind of images with a little style, but trained style will decrease.</p></li><li><p>Use ControlNet to generate a more controlled shape of what you want, and even <strong>you can test it with sketches</strong>. Some images shown here were created with projects that I have done, if you like, you can take like a base one of my creations: <a target=\"_blank\" rel=\"ugc\" href=\"https://www.behance.net/eadesign1\"><u>https://www.behance.net/eadesign1</u></a></p></li><li><p>You can use this model for whatever you want. If there is another app that is using my model, and you have to pay for it, just let me know. If you use it for merge, I would just ask to contact me.</p></li><li><p>You can download “EasyNegative” embedding and use it.</p></li><li><p>Use VAE 560000 or 840000 of SD model 1.5, to increase the contrast of the images.</p><p></p></li></ol><p><br />The sample images here were created with my model, and it has not any inpainting or post-production, just were upscaled with A111 models. You have to consider that you have to experiment so much to arrive at these results because it is hard to test just once and get an ideal result. I use Automatic1111 with most used extensions. I tried with Lora also, but I prefer Dreambooth normal because it is more precise.</p><p></p><p>I trained this model with 100 images with a “minimalistic” style (probably I will train more styles). 75% were products and 22% transportation, from that most of these are speakers, smart robots, water bottles, and others. I will enhance the models by adding 100 more images with a variety of shapes and different types. I realized that these models work so well in vehicle-car shapes, even that if were not so many vehicles in the training dataset.</p><p><br />Example Prompt:</p><p></p><p>3D product render, futuristic water bottle, finely detailed, purism, ue 5, a computer rendering, minimalism, octane render, 4k</p><p>Negative prompt: (worst quality:2), (low quality:2), (normal quality:2), lowres, normal quality, bad_prompt, bad_prompt2, ((monochrome)), ((grayscale)), cropped, text, jpeg artifacts, signature, watermark, username, EasyNegative ,sketch, cartoon, drawing, anime, duplicate, blurry, semi-realistic, out of frame, worst quality, ugly, low quality, deformed</p><ul><li><p>Steps, from 20-40 (For EulerA is enough 20, and you can use also DPM++SDE Karras, but EulerA is better mostly)</p></li></ul><ul><li><p>CFG scale: 6-9 (Going for 10-15, to less style, but more realistic shape of object).</p></li></ul><p></p><p>You can follow me on my social networks. I will show my process and also design tips and tools:</p><p><a target=\"_blank\" rel=\"ugc\" href=\"https://www.facebook.com/eddiemauro.design\"><u>https://www.facebook.com/eddiemauro.design</u></a></p><p><a target=\"_blank\" rel=\"ugc\" href=\"https://www.instagram.com/eddiemauro.design/\"><u>https://www.instagram.com/eddiemauro.design/</u></a></p><p><a target=\"_blank\" rel=\"ugc\" href=\"https://www.linkedin.com/in/eddiemauro/\"><u>https://www.linkedin.com/in/eddiemauro/</u></a></p><p><a target=\"_blank\" rel=\"ugc\" href=\"https://www.behance.net/eadesign1\"><u>https://www.behance.net/eadesign1</u></a></p><p><br/></p>";
        // 解析HTML
        Document doc = Jsoup.parse(html);
        // 遍历每个元素
        Elements elements = doc.getAllElements();
        for (Element element : elements) {
            // 提取元素的内容
            String content = element.ownText().trim();
            if (!Strings.isNullOrEmpty(content)) {
                RetryTask.retry(5, () -> {
                    String chContent = translateSentenceByNLP(content);
                    log.info("翻译文本:{}", chContent);
                    element.text(chContent);
                });
            }
            // TODO一些图片的替换(这个后面做)
            String link = null;
            if (element.tagName().equals("img")) {
                link = element.attr("src");
                log.info("图片链接: {}", link);
            }
        }
        return doc.html();
    }

    private void translateHtmlBySegment(Node node) {
        // 处理文本节点
        if (node instanceof TextNode) {
            TextNode textNode = (TextNode) node;
            String translatedText = translateSentenceByNLP(textNode.text());

            textNode.text(translatedText);
        }
        // 处理子元素
        for (Node child : node.childNodes()) {
            translateHtmlBySegment(child);
        }
    }

    private String translate(String text) {
        // 调用翻译函数进行翻译，这里只是示例
        // 可以根据实际情况替换为你的翻译逻辑
        return "Translated: " + text;
    }

    @Override
    public String translateSentenceByNLP(String sentence) {
        Map<String, String> header = Maps.newHashMap();
        header.put("Content-Type", "application/json");
        header.put("X-RapidAPI-Key", "3defe65809mshcff1510ecc62098p13f5d7jsn9cc72af0008e");
        header.put("X-RapidAPI-Host", "nlp-translation.p.rapidapi.com");

        JSONObject data = new JSONObject();
        data.fluentPut("text", sentence);
        data.fluentPut("to", "zh-CN");
        data.fluentPut("protected_words", "Stable Diffusion;stable diffusion;midjourney;diffusion");

        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.POST)
                .clientType(ClientType.HTTPCLIENT)
                .useProxy(true)
                .proxyIp("127.0.0.1:9080")
                .headers(header)
                .url(nplUrl)
                .body(data.toJSONString())
                .retry(3)
                .build();
        try {
            JSONObject result = httpService.requestJSONObject(requestConfig);
//            log.info("result:{}", result.toJSONString());
            if (result.getInteger("status") == 200) {
                JSONObject textData = result.getJSONObject("translated_text");
                return textData.getString("zh-CN");
            } else {
                throw new RuntimeException("返回失败：" + result.toJSONString());
            }
        } catch (IOException e) {
            log.info("请求失败，忽略");
            return null;
        }
    }


    @Override
    public String translateSentenceByOpenAI(String sentence) {
        if (sentence.length() > 3000) {
            throw new RuntimeException("字符太多了");
        }
        String prompt = String.format(promptTemplate, sentence);
        Map<String, String> header = Maps.newHashMap();
        header.put("Content-Type", "application/json");
        header.put("Authorization", "Bearer " + openAiApiKey);
        JSONObject data = new JSONObject();
        data.fluentPut("model", "gpt-3.5-turbo");
        data.fluentPut("temperature", 0.9);
        JSONArray message = new JSONArray();
        JSONObject chat = new JSONObject();
        chat.fluentPut("role", "user");
        chat.fluentPut("content", prompt);
        message.add(chat);
        data.fluentPut("messages", message);
        log.info("request:{}", data.toJSONString());

        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.POST)
                .clientType(ClientType.HTTPCLIENT)
                .useProxy(true)
                .proxyIp("127.0.0.1:9080")
                .headers(header)
                .url(openAIUrl)
                .body(data.toJSONString())
                .retry(3)
                .build();
        try {
            JSONObject result = httpService.requestJSONObject(requestConfig);
            log.info("result:{}", result.toJSONString());
            JSONArray choices = result.getJSONArray("choices");
            if (choices != null && choices.size() > 0) {
                JSONObject choice = (JSONObject) choices.get(0);
                JSONObject msgInChoice = choice.getJSONObject("message");
                if (msgInChoice != null) {
                    return msgInChoice.getString("content").trim();
                } else {
                    throw new RuntimeException("返回失败，结果为：" + result.toJSONString());
                }
            } else {
                throw new RuntimeException("返回失败，结果为：" + result.toJSONString());
            }
        } catch (IOException e) {
            log.info("请求图片失败，忽略");
            return null;
        }
    }

    @Override
    public String translateSentenceByBaidu(String sentence, String lang) {
        Map<String, String> paramMap = buildParams(sentence, "auto", lang);
        String url = getUrlWithQueryString(TRANS_API_HOST, paramMap);

        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .url(url)
                .retry(3)
                .build();
        try {
            JSONObject result = httpService.requestJSONObject(requestConfig);
            log.info("result:{}", result.toJSONString());
            if (result.containsKey("trans_result")) {
                JSONArray resultArray = result.getJSONArray("trans_result");
                if (resultArray.size() > 0) {
                    JSONObject res = resultArray.getJSONObject(0);
                    return res.getString("dst");
                } else {
                    throw new RuntimeException("返回失败,结果为：" + result.toJSONString());
                }
            } else {
                throw new RuntimeException("返回失败,结果为：" + result.toJSONString());
            }
        } catch (IOException e) {
            log.info("请求失败：{}", e.getMessage());
            return null;
        }
    }

    @Override
    public String detectLangByBaidu(String sentence) {
        Map<String, String> paramMap = buildLangDetectParams(sentence);
        String url = getUrlWithQueryString(LANG_DETECT_HOST, paramMap);
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .url(url)
                .retry(3)
                .build();
        try {
            JSONObject result = httpService.requestJSONObject(requestConfig);
            log.info("result:{}", result.toJSONString());
            if (result.containsKey("data")) {
                JSONObject data = result.getJSONObject("data");
                return data.getString("src");
            } else {
                return "en";
            }
        } catch (IOException e) {
            log.info("请求失败：{}", e.getMessage());
            return "en";
        }
    }

    private Map<String, String> buildParams(String query, String from, String to) {
        Map<String, String> params = Maps.newHashMap();
        params.put("q", query);
        params.put("from", from);
        params.put("to", to);
        

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);
        // 签名
        String src = baiduAppId + query + salt + baiduSecretKey;
        params.put("appid", baiduAppId);
        params.put("sign", SecureUtil.md5(src));
        return params;
    }

    private Map<String, String> buildLangDetectParams(String query) {
        Map<String, String> params = Maps.newHashMap();
        params.put("q", query);
        params.put("appid", BAIDU_APP_ID);

        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);
        // 签名
        String src = baiduAppId + query + salt + baiduSecretKey;
        params.put("appid", baiduAppId);
        params.put("sign", SecureUtil.md5(src));

        return params;
    }

    public static String getUrlWithQueryString(String url, Map<String, String> params) {
        if (params == null) {
            return url;
        }
        StringBuilder builder = new StringBuilder(url);
        if (url.contains("?")) {
            builder.append("&");
        } else {
            builder.append("?");
        }
        int i = 0;
        for (String key : params.keySet()) {
            String value = params.get(key);
            if (value == null) { // 过滤空的key
                continue;
            }
            if (i != 0) {
                builder.append('&');
            }
            builder.append(key);
            builder.append('=');
            builder.append(URLEncoder.encode(value));
            i++;
        }
        return builder.toString();
    }

    @Override
    public String transferImageToLocal(String imageUrl) {
        return "";
    }
}
