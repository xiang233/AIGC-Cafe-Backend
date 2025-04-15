package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.enumerate.HttpMethod;
import com.aigccafe.buterin.common.enumerate.Platform;
import com.aigccafe.buterin.common.model.md.ModelStatus;
import com.aigccafe.buterin.common.model.crawl.ModelDetailRequest;
import com.aigccafe.buterin.common.model.crawl.ModelListRequest;
import com.aigccafe.buterin.common.model.crawl.ModelVersionImageRequest;
import com.aigccafe.buterin.common.model.cvt.*;
import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.aigccafe.buterin.common.model.md.*;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.repository.CvtModelRepository;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.repository.OOSRepository;
import com.aigccafe.buterin.service.CrawlService;
import com.aigccafe.buterin.service.HttpService;
import com.aigccafe.buterin.service.ImageService;
import com.aigccafe.buterin.service.TranslateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.model.CannedAccessControlList;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.aigccafe.buterin.common.Constant.VERSION_IMAGE_DIR;

@Service
@Slf4j
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    private HttpService httpService;
    @Autowired
    private CvtModelRepository cvtModelRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private OOSRepository oosRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private TranslateService translateService;

    @Override
    public JSONObject crawlModelList(ModelListRequest request) throws Exception {
        JSONObject json = (JSONObject) JSON.toJSON(request);
        JSONObject requestJson = new JSONObject();
        requestJson.fluentPut("json", json);
        if (request.getCursor() == null) {
            JSONArray cursor = new JSONArray(Arrays.asList("undefined"));
            JSONObject values = new JSONObject().fluentPut("cursor", cursor);
            JSONObject meta = new JSONObject().fluentPut("values", values);
            requestJson.fluentPut("meta", meta);
        }
        String requestStr = JSON.toJSONString(requestJson);
        String inputTmp = "%7B%22json%22%3A%7B%22limit%22%3A100%2C%22sort%22%3A%22Highest%20Rated%22%2C%22period%22%3A%22AllTime%22%2C%22earlyAccess%22%3Afalse%2C%22favorites%22%3Afalse%2C%22hidden%22%3Afalse%2C%22cursor%22%3A14816%7D%7D";
        String targetUrl = "https://civitai.com/api/trpc/model.getAll?input=" + URLEncoder.encode(requestStr);
        //String targetUrl = "https://civitai.com/api/trpc/model.getAll?input=" + inputTmp;
        // 添加headers
        Map<String, String> headers = Maps.newHashMap();
        headers.put("authority", "civitai.com");
        headers.put("accept", "*/*");
        headers.put("accept-language", "zh-CN,zh;q=0.9");
        headers.put("content-type", "application/json");
        //headers.put("cookie", "__Host-next-auth.csrf-token=e3948df6fe122f17013c201eea15d322693285f33ecbe8a5002ab9f21e3f452b%7Cde9c209b21441c63db7a44a736e5609e9a01bc496f650c837b6a876423080b02; __Secure-next-auth.callback-url=https%3A%2F%2Fcivitai.com; __stripe_mid=15b256a1-e112-4da7-b2b2-7af49f0f6e9b7089c4; __stripe_sid=0bf0850c-edf4-4812-8fa2-49133f65d7343bc833");
        //headers.put("cookie", "__stripe_mid=2565e67b-c6d7-4b2c-89c9-439f9e66cc54cf0072; __Host-next-auth.csrf-token=3e2f3854e7e879951e0c83a9537eca550bbfd3e8317b041e2439b53dd138dd73%7C92d02bcebaafbd5b4d0cab92b2e679cbc83acafb4649640f5063afd2c331e61c; __Secure-next-auth.callback-url=https%3A%2F%2Fcivitai.com%2F; __stripe_sid=8a27ba4a-1564-4ebe-9089-8e63eea516f1626b89; __Secure-civitai-token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..nv6-tBLwglSGW4aa.ydkbvOEvq5BFmmQso1o1gJDBa3kHB7gDBqtITKSdnUJh-ImeY_AwcmPFwZ-U5FM1rjXoZ6AUSjn1fIM9AhWJZhviR8gA_rC4bvEkcR9DWNshvanNVPav__2KhKxyoGuwcO0e8pl_RdkzsE0eWHJqrExWJe8fwaz4NWTfPRbDHLeH-etb857nSRyGVo8zJNgvUws60k0HwnOgDrZJIPL-WG5w48lV8SePZdu1cxyPjunJWI-CAnX-bkwYlFekY_0thJX-M1TbfNAYSpd_AvSP-lAfjXFXxBfCBQ4xqFRvxcmPAmwsjsmRP5txRaUstZcAQ91JA7beYpwKCLcGc1Ai5JHnN0vOiIsgg82p4TfyFKMXf2YHVVSSI_DWs5aVC-7c9Qpfy1rwHrcdIyqOFz40oAFKHJ9_JU_PUjKq-FRL094HC80QrrVvC3IDPWH4NLWKEehCy5MurDndA5Cv61CZy3vffb_0L0BP2vPszpueJoRB_c-Y-qVZ1BaDtpAC17e3NEIZGgKYZUFAVh4-Hf2V0CU0rLo-HOf4vffqZM_LGmoST370vQAOxto7s4v5P8qstaxCewna7Gx8IH-xjb7u1nu3txqOSA08NoOGWkEe0AWQlHYDrvF_kucV0U0k-WZJViakbxIhXAi1756wmpeQhG-E48kHIXsvj1EeGAzTgHgCNl2fd0qlpTykbLe5xYF9nbhbqqCBTA_nwS-MnadONea7yImcqNjtdH-VrN1djXqYb9ARZUaJ3myQtl8pUjEBrORm2kGw7sUxX5s2p0MaSN9gyX4XdTlJk7lGtzvwpLqRMtN4eF0OdRHejCgz021tjarp2STaLRuAhihEdIVEYritJ3O2AfK5eRDQ3CY8tvnzeYlmIqRnWiHVxy5WBzkyEyt86ICwu_LFzTu0vXTv21gCm0-i-dJo0SmXXD7JyBBwaDsozCzIC50_qabFjok3PtYPvxMWblw4kbqZJpaCdZhiv6s0_BB7-HOrZl0wy13PvjAUcr8Dpj5DMGOu3SUSFi9Vt_lHefxcwrisgFlSrwptow_qP8JJdWPmOahmPT7dhyNz24oRT4908yiESFPJFJPFv_DCZR5Jw6N5TSo.Xqd9AoaoXg0qBZ5_Vglzkg");
        headers.put("cookie", "__stripe_mid=2565e67b-c6d7-4b2c-89c9-439f9e66cc54cf0072; __Secure-next-auth.callback-url=https%3A%2F%2Fcivitai.com; __Host-next-auth.csrf-token=39bd3fcf3bb2e99f78570eb5dd4e6e3b4ce940aa0e50b369cbb1b54eaa34ddb7%7Ce3e978595bdabffa169bac7bfa90169bbcaf826431b934efe1a0dad6ae43da14; __stripe_sid=455b5887-0c59-455c-812a-4a0c732071f5064a7d; __Secure-civitai-token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..QgTt-GJbqAzsASRl.WGGFihB6ksvGfRGFkRDqgctcEKDYKE6n05JV5ZElp3-8IwWio8UuW6oFzbC3ZczSrAAtKRpwRqWH2MHjRr3awiDFtbmZbFVd5Qr_hjznEBnnsjwYOEu6B45Z-UDh9e31EhCBUnnsmUjEmleZRkJFGE1ZY9auMN2xxVkzahgf7Jg9ZF9QpXoDwsH2xg5pj7coRXJPF3aZFKaf2HdCL9fkZzweDZPfRikkjcB7XCAt8EVbgoVuoKqaY8ECkBsLyHv7aD7qMZOc_WkPwu6k4nk6TZkfBD5Dgwa9r7kitkEqm1R0Js5NHyVDS3xf9RovEHrOsJyGHNimwS-J7WJUu3Ik7NhRcxr-hWQsU1YQVPTA7_X3CtsGni94OKZu-7yV_a5b8I_Hq6qNsRjSbe-Y14BROTWZWKxCHZ6ymCXPVRrhmuAAToiuqiKrzDIhPrIHf_F7QF0eABz9N-f7gs7tG3YpoMGnxgiOjjaiJ0R8z0tolBzqWgALu5EMhqdZqIbhlmDV-T94AV5ybalnlw4fmTEDx7kSv_2tHBwgIA2wo57bX5k187yuH_lweL5P1JI_mTnpb1rf2kD9O7P13eb-KYWMQOsYALL48K6eGhxmqC3h8wIFFP7aZVyqmwQBJ5nZhbGDzu_RbnSFnlSONVXtZNPzZHREJfbfP_F9XAOUIXiqIohcr0NILvnauo0o2hcL3QCQvTtxELbmmNFZpuqpH_2zJM5HUsYjlrfZSe9NX1AfhawAR72Xw1DE8ztd5q_xM9370rBGvgPT1gqQbe6tBu4v4Tq4GmtFenyUgj0dvs5Hq1JLbN_z5DfISMuj8lZaCi7wEdQew7LxR8vw49JkuQhcqFnkkbNSX7HufurH8O2a6YpF4SEypORmY4fJm19JQWKwstVo3x7D2BrQWzxqrByMG_q5pwyszzH3GWCHkj6l4XKLVBj0UkyE_VGNwzISyZHPqxm9WuR0hNkQh8_wKwHuTQasOJeDvT6ZJezc5O861FxzJHP9L9manQLNyFAEnaSCgj-ksCoE6tqbUVt6hGbZvyMNJZiR4kCe3Hwe4nWE8smJ_fP-NLHs2kZrVOnOP58awN1Z2Qsu0MU_5YTV7wCE6n_PfOpaHwzdUvZPVd5d6Q.FgA9xArC878qtK-S97aZ4Q");
        headers.put("referer", "https://civitai.com/");
        headers.put("sec-ch-ua", "\"Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("sec-ch-ua-platform", "\"macOS\"");
        headers.put("sec-fetch-dest", "empty");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-site", "same-origin");
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");

        log.info("url:{}", targetUrl);
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .useProxy(true)
                .headers(headers)
                .proxyIp("127.0.0.1:9080")
                .url(targetUrl)
                .retry(3)
                .build();
        return httpService.requestJSONObject(requestConfig);
    }

    @Override
    public JSONArray crawlModelDetail(ModelDetailRequest request) throws Exception {
        JSONObject json = (JSONObject) JSON.toJSON(request);
        JSONObject requestJson = new JSONObject();
        requestJson.fluentPut("json", json);
        JSONObject requestData = new JSONObject();
        requestData.fluentPut("0", requestJson);
        String requestStr = JSON.toJSONString(requestData);
        String targetUrl = "https://civitai.com/api/trpc/model.getById?batch=1&input=" + URLEncoder.encode(requestStr);

        // 添加headers
        String referer = String.format("https://civitai.com/models/%s/%s", request.getId(), request.getName());
        String cookie = "__Host-next-auth.csrf-token=ed28b891a6da774518a37cf53c7847fe664fd93b016e3cb3ec799476b0654195%7Ca60cd6da6c7bab2fecb1d5f071dc8f563d2a4839139895b94215fcc27013bfd7; __Secure-next-auth.callback-url=https%3A%2F%2Fcivitai.com; __stripe_mid=a7c289fc-8509-4d36-b7f2-3643fc039041af5985; __stripe_sid=eb16f915-db64-4ee1-b78f-8bf3a0321e93cac130; f_types="
                + URLEncoder.encode(request.getType())
                + "; f_ckptType="
                + URLEncoder.encode(request.getCheckPointType())
                +"; f_sort="
                + URLEncoder.encode(request.getSortType());

        Map<String, String> headers = Maps.newHashMap();
        headers.put("authority", "civitai.com");
        headers.put("accept", "*/*");
        headers.put("accept-language", "zh-CN,zh;q=0.9");
        headers.put("content-type", "application/json");
        headers.put("cookie", cookie);
        headers.put("referer", referer);
        headers.put("sec-ch-ua", "\"Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("sec-ch-ua-platform", "\"macOS\"");
        headers.put("sec-fetch-dest", "empty");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-site", "same-origin");
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");

        log.info("请求:{}", targetUrl);
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .useProxy(true)
                .headers(headers)
                .proxyIp("127.0.0.1:9080")
                .url(targetUrl)
                .retry(3)
                .build();
        String res = httpService.requestRawText(requestConfig);
        return JSONObject.parseArray(res);
    }

    @Override
    public JSONObject crawlModelVersionImage(ModelVersionImageRequest request) throws Exception {
        JSONObject json = (JSONObject) JSON.toJSON(request);
        JSONObject requestJson = new JSONObject();
        requestJson.fluentPut("json", json);
        if (request.getCursor() == null) {
            JSONArray cursor = new JSONArray(Arrays.asList("undefined"));
            JSONObject values = new JSONObject().fluentPut("cursor", cursor);
            JSONObject meta = new JSONObject().fluentPut("values", values);
            requestJson.fluentPut("meta", meta);
        }
        String requestStr = JSON.toJSONString(requestJson);
        String targetUrl = "https://civitai.com/api/trpc/image.getInfinite?input=" + URLEncoder.encode(requestStr);

        // 添加headers
        Map<String, String> headers = Maps.newHashMap();
        String referer = String.format("https://civitai.com/models/%s?modelVersionId=%s", request.getModelId(), request.getModelVersionId());
        headers.put("authority", "civitai.com");
        headers.put("accept", "*/*");
        headers.put("accept-language", "zh-CN,zh;q=0.9");
        headers.put("content-type", "application/json");
        // 此处使用过期的cookie可防止过于暴露的图片
//        headers.put("cookie", "__Host-next-auth.csrf-token=ed28b891a6da774518a37cf53c7847fe664fd93b016e3cb3ec799476b0654195%7Ca60cd6da6c7bab2fecb1d5f071dc8f563d2a4839139895b94215fcc27013bfd7; __Secure-next-auth.callback-url=https%3A%2F%2Fcivitai.com; __stripe_mid=a7c289fc-8509-4d36-b7f2-3643fc039041af5985; f_types=%5B%22Checkpoint%22%5D; f_ckptType=Trained; f_sort=Most%20Liked; __stripe_sid=c95cbf6a-2d1c-4d79-8e1e-e2815105b66d16e330");
        headers.put("cookie", "__stripe_mid=2565e67b-c6d7-4b2c-89c9-439f9e66cc54cf0072; __Secure-next-auth.callback-url=https%3A%2F%2Fcivitai.com; __Host-next-auth.csrf-token=39bd3fcf3bb2e99f78570eb5dd4e6e3b4ce940aa0e50b369cbb1b54eaa34ddb7%7Ce3e978595bdabffa169bac7bfa90169bbcaf826431b934efe1a0dad6ae43da14; __stripe_sid=709a95bc-5262-4ad4-afb0-c9034dfd7446aa3ed9; __Secure-civitai-token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..aWuX7oNPByCjHUkG.i_HYHCXqOV3GPO104o9Pgb0yRTPOfkElgaGp64QaGVIDJNqDcA0SjJPLZ-s4NU5dBtwWRNlQHGNwEqioPrDtsJyNS30KaH_NrE2_oRsPErTX6P8Tn65TWC5peDZTeuWrKZKsjlo9Tr9b5SN9SDBHTl8tzZk9JosXWhhkKLA9sj4B-Qf9ndk_kWCxdNM2l8k-YUe2l9CgYV2g2XqI08m87QchMbbM99bzzLOdJZueaYjHCfltrAI6kze0HLfB6hAQJgTrJrXoszcDmy8T-f-dXWv_5Mun699d6XVJDEhh9gqoa6rSInSX4UUMqabYYYiSakoqcLtxBLLPFD2wpnuvCKlUT1CYDiKblw2loW5GyvhAKrIGD8PKYFIEPIu6sTmjbfrjmKqdDglCC4X053VQyP-FV0KqeBjE4j_7UWl4IxcUhUTLuWyoIznnSVvY8xvUB6Vr2TnLtusCybp65o4E1UDC6xUt-Oq-YIO196d5gCd-EmLyilELCH6uZBrtozE7YWj5lavpdrmrjWAyIcGSc-KET2wgwZHd5O91ShPMmoWGtB3osvnw5Vn6psMjw20F3gkmtp-O4vMH9_nw1eWmxdsENinDVosDcovjQCca9Y5clwAgFZwKv3j3HAOoIW6qZZK12Qx7Pp61Mcb-sf8tkw7HjPH1nvb9xWCduR7LvM9K1Fj161aFvpBt1sGo5bEIrHEv6ubdhKrOFzNcrSP5JLdQm3sUFnoJ_xNd2FiGtu5EHV8P55m-fHDei0MBibuPCzM9z3aXSiC1eUivjX50ZxorJl8Xn9s9Q22iz41-R7GxGtItaVqeJkQKtnC5V2inmLp5xy32snGTl1m8AlL-vQItssUyQ5qdYVOT4AI9fchlQZJypqU2cABw7FDXVZnkyPUaO2vOv6A6dwiQrDzIIW8GFyCyp7cDOF7q0ehYc8FY0FySZZfuKUB3e3K-I9LobIYUkoFvz-M8FOD9svxZcsWMtD8y2VJB5_F8N2ob9Tt2wxV2v4Kc_4KGVIztAlvVS-a3a6At-40uIJQNQDGOdlNmgTTSxVZsVC7Au7ntPWgz8Sdxm4MHM-Qj0X7XWAr1wZaGA4yAcl5B55ySuH4RpUYJnwBoqS9FFUfb_SwMdg.qAYuMt39oSaRLETEPyvH7g");
        headers.put("referer", referer);
        headers.put("sec-ch-ua", "\"Google Chrome\";v=\"111\", \"Not(A:Brand\";v=\"8\", \"Chromium\";v=\"111\"");
        headers.put("sec-ch-ua-mobile", "?0");
        headers.put("sec-ch-ua-platform", "\"macOS\"");
        headers.put("sec-fetch-dest", "empty");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-site", "same-origin");
        headers.put("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36");

        log.info("url:{}", targetUrl);
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .useProxy(true)
                .headers(headers)
                .proxyIp("127.0.0.1:9080")
                .url(targetUrl)
                .retry(3)
                .build();
        return httpService.requestJSONObject(requestConfig);
    }


    @Override
    public Pair<Long, JSONArray> parseModelListJson(JSONObject data) throws NullPointerException {
        JSONObject result = data.getJSONObject("result");
        JSONObject innerData = result.getJSONObject("data");
        JSONObject jsonData = innerData.getJSONObject("json");
        Long nextCursor = jsonData.getLong("nextCursor");
        JSONArray jsonArray = jsonData.getJSONArray("items");
        return new Pair<>(nextCursor, jsonArray);
    }

    @Override
    public Long updateModelListRecord(ModelListRequest requestInfo, Pair<Long, JSONArray> data) throws RuntimeException {
        Long nextCursor = data.getKey();
        JSONArray itemList = data.getValue();
        itemList.forEach(item -> {
            JSONObject itemData = (JSONObject)item;
            Long modelId = itemData.getLong("id");
            String modelName = itemData.getString("name");
            String lastVersionAt = itemData.getString("lastVersionAt");
            JSONObject coverImageData = itemData.getJSONObject("image");
            JSONObject rank_info = itemData.getJSONObject("rank");
            if (Strings.isNullOrEmpty(lastVersionAt)) {
                lastVersionAt = "0";
            }
            log.info("+++++++++++++++++++++++++++++");
            // 插入或者更新数据库记录
            CvtModelDetectPO cvtModelDetectPO = cvtModelRepository.selectDetectByModelId(modelId);
            if (cvtModelDetectPO == null) {
                log.info("找到的是新模型:{},{}", modelId, modelName);
                cvtModelDetectPO = new CvtModelDetectPO();
                cvtModelDetectPO.setModelId(modelId);
                cvtModelDetectPO.setModelName(modelName);
                cvtModelDetectPO.setModelType(StringUtils.join(requestInfo.getTypes(), ","));
                cvtModelDetectPO.setCheckpointType(getDefault(requestInfo.getCheckpointType()));
                cvtModelDetectPO.setRequestInfo(JSON.toJSONString(requestInfo));
                if (coverImageData != null) {
                    cvtModelDetectPO.setCoverImageData(coverImageData.toJSONString());
                } else {
                    cvtModelDetectPO.setCoverImageData("{}");
                }
                if (rank_info != null) {
                    cvtModelDetectPO.setRankInfo(JSON.toJSONString(rank_info));
                } else {
                    cvtModelDetectPO.setRankInfo("{}");
                }
                cvtModelDetectPO.setDetailUpdate(false);
                cvtModelDetectPO.setLastVersionAt(lastVersionAt);
            } else {
                log.info("找到的是旧模型:{},{}", modelId, modelName);
                if (lastVersionAt.compareTo(cvtModelDetectPO.getLastVersionAt()) > 0) {
                    log.info("旧模型发现有版本更新");
                    ModelDetailPO modelDetailPO = modelRepository.selectModelDetailByOriId(modelId);
                    if (ModelStatus.OFFLINE.name().equals(modelDetailPO.getStatus())) {
                        log.info("========很遗憾，旧模型发现已人工下线，所以本次我们略过更新哦==========");
                    } else {
                        cvtModelDetectPO.setLastVersionAt(lastVersionAt);
                        if (coverImageData != null) {
                            cvtModelDetectPO.setCoverImageData(coverImageData.toJSONString());
                        }
                        cvtModelDetectPO.setDetailUpdate(false);
                    }
                } else {
                    log.info("模型没发现有版本更新，本次跳过");
                }
            }
            int res = cvtModelRepository.update(cvtModelDetectPO);
            if (res > 0) {
                log.info("model({})记录更新成功", modelId);
            } else {
                log.info("model({})记录更新失败", modelId);
            }
            log.info("+++++++++++++++++++++++++++++");
        });
        return nextCursor;
    }

    @Override
    public int updateModelDetailRecord(JSONArray response) throws RuntimeException {
        Preconditions.checkArgument(response.get(0) != null, "返回体为空，请排查");
        log.info("解析返回体......");
        JSONObject firstData = (JSONObject) response.get(0);
        JSONObject data = firstData.getJSONObject("result").getJSONObject("data").getJSONObject("json");
        Long modelId = data.getLong("id");
        String modelName = data.getString("name");
        String description = getDefault(data.getString("description"));
        Boolean nsfw = getJsonDefaultBoolean(data, "nsfw");
        String type = getJsonDefaultString(data, "type");
        String checkpointType = getJsonDefaultString(data, "checkpointType");
        String userInfo = getDefault(data.getJSONObject("user").toJSONString());
        String modelVersionList =getDefault(data.getJSONArray("modelVersions").toJSONString());
        String rankInfo = getDefault(data.getJSONObject("rank").toJSONString());
        String tagsInfo = getDefault(data.getJSONArray("tagsOnModels").toJSONString());
        String lastUpdatedAt = getDefault(data.getString("updatedAt"));

        CvtModelDetailPOWithBLOBs cvtModelDetailPO = cvtModelRepository.selectCvtDetailByModelId(modelId);
        int res = 0;
        if (cvtModelDetailPO == null) {
            log.info("模型的详情还未更新，更新进库......");
            cvtModelDetailPO = new CvtModelDetailPOWithBLOBs();
            cvtModelDetailPO.setModelId(modelId);
            cvtModelDetailPO.setModelName(modelName);
            cvtModelDetailPO.setDescription(description);
            cvtModelDetailPO.setNsfw(nsfw);
            cvtModelDetailPO.setType(type);
            cvtModelDetailPO.setCheckpointtype(checkpointType);
            cvtModelDetailPO.setUserInfo(userInfo);
            cvtModelDetailPO.setModelVersionList(modelVersionList);
            cvtModelDetailPO.setRankInfo(rankInfo);
            cvtModelDetailPO.setTagsInfo(tagsInfo);
            cvtModelDetailPO.setLastUpdatedAt(lastUpdatedAt);
            cvtModelDetailPO.setVersionImageUpdate(false);
            cvtModelDetailPO.setPostImageUpdate(false);
            cvtModelDetailPO.setMerged(false);
            cvtModelDetailPO.setNeedCheckUpdate(false);
            res = cvtModelRepository.update(cvtModelDetailPO);
        } else {
            if (lastUpdatedAt.compareTo(cvtModelDetailPO.getLastUpdatedAt()) > 0) {
                log.info("模型的详情有变更，更新并标记......");
                cvtModelDetailPO.setModelName(modelName);
                cvtModelDetailPO.setDescription(description);
                cvtModelDetailPO.setNsfw(nsfw);
                cvtModelDetailPO.setType(type);
                cvtModelDetailPO.setCheckpointtype(checkpointType);
                cvtModelDetailPO.setUserInfo(userInfo);
                cvtModelDetailPO.setModelVersionList(modelVersionList);
                cvtModelDetailPO.setRankInfo(rankInfo);
                cvtModelDetailPO.setTagsInfo(tagsInfo);
                cvtModelDetailPO.setLastUpdatedAt(lastUpdatedAt);
                cvtModelDetailPO.setVersionImageUpdate(false);
                cvtModelDetailPO.setMerged(false);
                cvtModelDetailPO.setNeedCheckUpdate(false);
                res = cvtModelRepository.update(cvtModelDetailPO);
            } else {
                log.info("模型的详情不必更新");
                return 1;
            }
        }
        if (res > 0) {
            log.info("操作成功！");
            cvtModelRepository.setModelDetailUpdated(modelId);
        } else {
            log.info("操作失败！");
        }
        return res;
    }

    @Override
    public int updateModelVersionImageRecord(Long modelId, JSONObject response) throws RuntimeException {
        JSONObject jsonData = response.getJSONObject("result").getJSONObject("data").getJSONObject("json");
        JSONArray itemList = jsonData.getJSONArray("items");
        itemList.forEach(item -> {
            JSONObject itemData = (JSONObject)item;

            // 提取信息
            Long imageId = itemData.getLong("id");
            CvtModelVersionImagePO cvtModelVersionImage = cvtModelRepository.selectSimpleCvtVersionImageByImageId(imageId);
            if (cvtModelVersionImage == null) {
                log.info("图片不在库中，进行存储");
                // 提取
                Long postId = getDefault(itemData.getLong("postId"));
                Long modelVersionId = getDefault(itemData.getLong("modelVersionId"));
                String url = itemData.getString("url");
                String nsfwStr = getJsonDefaultString(itemData, "nsfw");
                if (!"None".equals(nsfwStr)) {
                    log.info("图片被标记为瑟瑟，跳过.......");
                } else {
                    Integer width = getJsonDefaultInteger(itemData, "width");
                    Integer height = getJsonDefaultInteger(itemData, "height");
                    JSONObject meta = itemData.getJSONObject("meta");
                    if (meta == null) {
                        meta = new JSONObject();
                    }
                    String mimeType = getDefault(itemData.getString("mimeType"));
                    JSONObject userInfo = itemData.getJSONObject("user");
                    if (userInfo == null) {
                        userInfo = new JSONObject();
                    }

                    // 载入
                    CvtModelVersionImagePOWithBLOBs cvtModelVersionImagePO = new  CvtModelVersionImagePOWithBLOBs();
                    cvtModelVersionImagePO.setImageId(imageId);
                    cvtModelVersionImagePO.setModelId(modelId);
                    cvtModelVersionImagePO.setModelVersionId(modelVersionId);
                    cvtModelVersionImagePO.setPostId(postId);
                    cvtModelVersionImagePO.setUrl(url);
                    cvtModelVersionImagePO.setNsfw(false);
                    cvtModelVersionImagePO.setWidth(width);
                    cvtModelVersionImagePO.setHeight(height);
                    cvtModelVersionImagePO.setMeta(JSON.toJSONString(meta));
                    cvtModelVersionImagePO.setMimetype(mimeType);
                    cvtModelVersionImagePO.setUserInfo(JSON.toJSONString(userInfo));
                    cvtModelRepository.update(cvtModelVersionImagePO);
                    log.info("采集成功");
                }
            } else {
                log.info("图片已存在，忽略此次结果");
            }
        });
        return 1;
    }

    @Override
    public String crawlSdArtArticle(String url) {
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .url(url)
                .retry(3)
                .build();

        String articleHtml = "";
        try {
            String html = httpService.requestRawText(requestConfig);
            if (Strings.isNullOrEmpty(html)) {
                throw new RuntimeException(url + " 返回为空,需要排查");
            }
            Document document = Jsoup.parse(html);
            Element element = document.selectFirst("article");
            // 去掉不要的元素
            Elements adElements = element.select(".mv-ad-box"); // 选择所有具有class="mv-ad-box"的元素
            adElements.remove();
            Elements wrappers = element.select(".awac-wrapper"); // 选择所有具有class="awac-wrapper"的元素
            wrappers.remove();
            Elements others = element.select(".addtoany_share_save_container.addtoany_content.addtoany_content_bottom");
            others.remove();
            articleHtml = element.outerHtml();
        } catch (Exception exp) {
            log.info("爬出{} 过程出错，错误详情：{}", url, exp.getMessage());
        }
        return articleHtml;
    }

    @Override
    public String convertToLocalHtml(String html) {
        // 解析 HTML 文本
        Document document = Jsoup.parse(html);

        // 获取所有的 img 标签
        Elements imgElements = document.select("img");

        // 遍历每个 img 标签
        for (Element imgElement : imgElements) {
            // 删除多余的属性值
            Attributes attributes = imgElement.attributes();
            for (Attribute attribute : attributes) {
                String attributeName = attribute.getKey();
                if (attributeName.startsWith("data-")) {
                    // 删除属性
                    imgElement.removeAttr(attributeName);
                }
            }
            // 获取原始的 src 属性值
            String originalSrc = imgElement.attr("src");
            if (!originalSrc.startsWith("http")) {
                continue;
            }
            String newSrc = imageService.storeImageOnOOS(originalSrc, ClientType.HTTPCLIENT);
            log.info("图片转储结果：{}", newSrc);
            if (Strings.isNullOrEmpty(newSrc)) {
                throw new RuntimeException("图片转本地失败，请排查");
            }
            // 更新 src 属性
            imgElement.attr("src", newSrc);
        }

        // 获取所有附件 并进行转储
        // 输出修改后的 HTML
//        log.info(document.outerHtml());
        return document.html();
    }

    @Override
    public JSONObject extractArticleInfo(String html) {
        // 解析 HTML 文本
        Document document = Jsoup.parse(html);

        JSONObject data = new JSONObject();
        // 获取所有的 img 标签
        Element firstImage = document.selectFirst("img");
        String firstImageUrl = firstImage.attr("src");
        data.fluentPut("coverUrl", firstImageUrl);
        Element titleElement = document.selectFirst("h1");

        String title = titleElement.text();
        title = translateService.translateSentenceByNLP(title);
        data.fluentPut("title", title);

        StringBuilder brief = new StringBuilder();
        Elements sentenceList = document.select("p");
        for(Element element : sentenceList) {
            String pText = element.text();
            String chText = translateService.translateSentenceByNLP(pText);
            log.info(chText);
            brief.append(chText);
            if (brief.length() > 500) {
                break;
            }
        }
        data.fluentPut("brief", brief.toString());

        // 标签
        Element tags = document.selectFirst(".tags-links");
        String tagsStr = tags.text();
        if (tagsStr.startsWith("Tagged")) {
            tagsStr= tagsStr.substring("Tagged".length());
        }
        data.fluentPut("tags", tagsStr.trim());

        //作者
        Element author = document.selectFirst(".byline");
        String authorStr = author.text();
        if (authorStr.startsWith("By")) {
            authorStr= authorStr.substring("By".length());
        }
        data.fluentPut("author", authorStr.trim());
        return data;
    }

    @Override
    public int modelMergedInMysql(CvtModelDetailPOWithBLOBs cvtModelDetailPO) {
        Long oriModelId = cvtModelDetailPO.getModelId();
        ModelDetailPO modelPO = modelRepository.selectModelDetailByOriId(oriModelId);
        if (modelPO == null) {
            modelPO = new ModelDetailPO();
        }
        int res = 1;
        try {
            // 模型信息更新
            modelPO.setPlatform(Platform.CVT.name());
            modelPO.setOriModelId(cvtModelDetailPO.getModelId());
            modelPO.setModelName(cvtModelDetailPO.getModelName());
            modelPO.setDescription(cvtModelDetailPO.getDescription());
            modelPO.setNsfw(cvtModelDetailPO.getNsfw());
            modelPO.setStatus(ModelStatus.READY.name());
            JSONObject userInfo = JSON.parseObject(cvtModelDetailPO.getUserInfo());
            String userName = getJsonDefaultString(userInfo, "username");
            modelPO.setAuthorName(userName);
            modelPO.setType(cvtModelDetailPO.getType());
            modelPO.setCheckpointType(cvtModelDetailPO.getCheckpointtype());
            JSONObject rankInfo = JSON.parseObject(cvtModelDetailPO.getRankInfo());
            Long downloadCnt = getJsonDefaultLong(rankInfo, "downloadCountAllTime");
            modelPO.setDownloadCnt(downloadCnt);
            String tags = parseJsonTags(cvtModelDetailPO.getTagsInfo());
            modelPO.setTags(tags);
            modelPO.setUserId(1000000L);
            modelPO.setManualTags("");
            modelPO.setCoverPath("");

            // 模型版本信息更新
            JSONArray versionJsonList = JSON.parseArray(cvtModelDetailPO.getModelVersionList());
            // 获取baseModel信息
            Optional<String> baseModelOp = versionJsonList.stream().map(version -> getJsonDefaultString((JSONObject) version, "baseModel")).reduce((x, y) -> x);
            String baseModel = "other";
            if (baseModelOp.isPresent()) {
                baseModel = baseModelOp.get();
            }
            modelPO.setBaseModel(baseModel);
            Long modelId = modelRepository.update(modelPO);
            log.info("模型更新完成：{}", modelId);

            for(Object element : versionJsonList) {
                JSONObject version = (JSONObject) element;
                Long oriVersionId = getJsonDefaultLong(version, "id");
                ModelVersionPO modelVersionPO = modelRepository.selectVersionByOriVersionId(oriModelId, oriVersionId);
                if (modelVersionPO == null) {
                    modelVersionPO = new ModelVersionPO();
                }
                modelVersionPO.setPlatform(Platform.CVT.name());
                modelVersionPO.setModelId(modelId);
                modelVersionPO.setOriModelId(oriModelId);
                modelVersionPO.setOriVersionId(oriVersionId);
                modelVersionPO.setVersionName(getJsonDefaultString(version, "name"));
                modelVersionPO.setDescription(getJsonDefaultString(version, "description"));
                modelVersionPO.setBaseModel(getJsonDefaultString(version, "baseModel"));
                modelVersionPO.setStatus(ModelStatus.READY.name());
                JSONObject versionRank = version.getJSONObject("rank");
                modelVersionPO.setDownloadCnt(getJsonDefaultLong(versionRank, "downloadCountAllTime"));
                modelVersionPO.setLastUpdatedAt(getJsonDefaultString(version, "updatedAt"));
                Long versionId = modelRepository.update(modelVersionPO);
                log.info("版本更新完成：{}", versionId);

                JSONArray versionFileArray = version.getJSONArray("files");
                log.info("版本文件数量：{}", versionFileArray.size());
                int vIndex = 1;
                for (Object fileElement : versionFileArray) {
                    JSONObject file = (JSONObject) fileElement;
                    Long oriFileId = getJsonDefaultLong(file, "id");
                    ModelVersionFilePO versionFilePO = modelRepository.selectFileByOriId(oriModelId, oriVersionId, oriFileId);
                    if (versionFilePO == null) {
                        versionFilePO = new ModelVersionFilePO();
                    }
                    versionFilePO.setPlatform(Platform.CVT.name());
                    versionFilePO.setModelId(modelId);
                    versionFilePO.setModelName(cvtModelDetailPO.getModelName());
                    versionFilePO.setVersionId(versionId);
                    versionFilePO.setVersionName(modelVersionPO.getVersionName());
                    versionFilePO.setOriVersionId(modelVersionPO.getOriVersionId());
                    versionFilePO.setOriModelId(modelVersionPO.getOriModelId());
                    versionFilePO.setOriFileId(oriFileId);
                    versionFilePO.setSizekb(getJsonDefaultDouble(file, "sizeKB"));
                    versionFilePO.setType(getJsonDefaultString(file, "type"));
                    versionFilePO.setName(getJsonDefaultString(file, "name"));
                    JSONObject metaData = file.getJSONObject("metadata");
                    if (metaData != null) {
                        versionFilePO.setMetadata(metaData.toJSONString());
                    } else {
                        versionFilePO.setMetadata("");
                    }
                    versionFilePO.setUrl("");
                    modelRepository.update(versionFilePO);
                    log.info("版本文件{}更新完毕", vIndex);
                    vIndex++;
                }
                List<CvtModelVersionImagePOWithBLOBs> cvtImages = cvtModelRepository.selectModelVersionImageList(modelVersionPO.getOriModelId(), modelVersionPO.getOriVersionId());
                log.info("版本{}图片共有:{}", versionId, cvtImages.size());
                int index = 0;
                int numOfThreads = 8; // 您可以根据需要调整线程池中的线程数量
                ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);

                for (CvtModelVersionImagePOWithBLOBs cvtImage : cvtImages) {
                    ModelDetailPO finalModelPO = modelPO;
                    ModelVersionPO finalModelVersionPO = modelVersionPO;
                    int finalIndex = index;
                    executorService.submit(() -> {
                        Long oriImageId = cvtImage.getImageId();
                        ModelVersionImagePOWithBLOBs versionImagePO = modelRepository.selectImageByOriId(oriModelId, oriVersionId, oriImageId);
                        if (versionImagePO == null) {
                            versionImagePO = new ModelVersionImagePOWithBLOBs();
                            versionImagePO.setPlatform(Platform.CVT.name());
                            versionImagePO.setModelId(finalModelPO.getId());
                            versionImagePO.setModelName(finalModelPO.getModelName());
                            versionImagePO.setVersionId(finalModelVersionPO.getId());
                            versionImagePO.setVersionName(finalModelVersionPO.getVersionName());
                            versionImagePO.setOriModelId(finalModelPO.getOriModelId());
                            versionImagePO.setOriVersionId(finalModelVersionPO.getOriVersionId());
                            versionImagePO.setOriImageId(cvtImage.getImageId());
                            String url = makeUpCvtImagerUrl(cvtImage.getUrl());
                            versionImagePO.setUrl(url);
                            versionImagePO.setNsfw(cvtImage.getNsfw());
                            versionImagePO.setWidth(cvtImage.getWidth());
                            versionImagePO.setHeight(cvtImage.getHeight());
                            versionImagePO.setMeta(cvtImage.getMeta());
                            versionImagePO.setMimetype(cvtImage.getMimetype());
                            versionImagePO.setAuthorInfo(cvtImage.getUserInfo());

                            // 下载图片并转储到oss
                            Long begin = DateTimeUtils.nowSeconds();
                            HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                                    .httpMethod(HttpMethod.GET)
                                    .clientType(ClientType.HTTPCLIENT)
                                    .useProxy(true)
                                    .proxyIp("127.0.0.1:9080")
                                    .url(url)
                                    .retry(3)
                                    .build();
                            String date = DateTimeUtils.formatConsecutiveDate(DateTimeUtils.nowSeconds() * 1000);
                            String fileName = String.format("%s-%s-%s.%s", modelId, versionId, finalIndex, "jpeg");

                            String imagePath = String.format("%s/%s/%s", VERSION_IMAGE_DIR, date, fileName);
                            log.info("请求图片地址：{}", url);
                            byte[] imageBytes = new byte[0];
                            try {
                                imageBytes = httpService.requestBytes(requestConfig);
                            } catch (IOException e) {
                                log.info("请求图片失败，忽略");
                                return;
                            }
                            Long end = DateTimeUtils.nowSeconds();
                            log.info("请求图片耗时：{}", end - begin);
                            begin = DateTimeUtils.nowSeconds();
                            oosRepository.uploadImage(imagePath, imageBytes, CannedAccessControlList.Default);
                            versionImagePO.setRawPath(imagePath);
                            versionImagePO.setNormalPath(imagePath);
                            modelRepository.update(versionImagePO);
                            end = DateTimeUtils.nowSeconds();
                            log.info("上传oos耗时：{}", end - begin);
                            log.info("版本{}图片{}转储完毕", versionId, finalIndex);
                        } else {
                            log.info("图片已存在，不进行更新");
                        }
                    });
                    index++;
                }
                executorService.shutdown();
                try {
                    // 等待所有任务完成，您可以根据需要调整超时时间
                    if (!executorService.awaitTermination(3600, TimeUnit.SECONDS)) {
                        log.info("所有任务完成！");
                        executorService.shutdownNow();
                    }
                } catch (InterruptedException e) {
                    executorService.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
            cvtModelDetailPO.setMerged(true);
            cvtModelRepository.update(cvtModelDetailPO);
        } catch (Exception exp) {
            res = 0;
            log.info("merge合并过程中出错");
            exp.printStackTrace();
        }
        return res;
    }

    @Override
    public String transferUrl(String url) {
        return "";
    }

    @Override
    public JSONArray crawlShowcaseImage(String tab, Integer page, Integer amount) {
//        long timestamp = DateTimeUtils.nowMilliSeconds();
//        String dateStr = DateTimeUtils.formatNormalDatetime(timestamp);
        String url = "https://www.midjourney.com/api/app/recent-jobs/?amount=" +
                amount +
                "&dedupe=true&jobStatus=completed&jobType=upscale&orderBy=" +
                tab +
                "&page=" + page +
                "&refreshApi=0&searchType=null&service=main&user_id_ranked_score=0%2C4%2C5&_ql=todo&_qurl=https%3A%2F%2Fwww.midjourney.com%2Fapp%2Ffeed%2F%3Fsort%3D" +
                tab;
        JSONObject headers = new JSONObject();
        String cookie = "imageSize=medium; imageLayout_2=hover; getImageAspect=2; fullWidth=false; showHoverIcons=true; __Host-next-auth.csrf-token=f0360d218019b818d14b3d0ab2797b41b56dab4b15d85c6061fa5d1bf41f1661%7C1e55aeecb98c159e2554d131880390246b14685eae5ba12fb2189b4f75db60e3; _ga=GA1.1.1071545525.1688987551; __Secure-next-auth.callback-url=https%3A%2F%2Fwww.midjourney.com%2Fapp%2F; __stripe_mid=429ed288-805b-4109-b3cc-683c601294d631b646; cf_clearance=xvhXpbKqA9vmmratb3O5TOik8Lr9eb5hdgESw0GHBio-1689847384-0-0.2.1689847384; __cf_bm=7DG4gDwlTPcPcMCy324w5MvuU_BwatRM7.ulC5ErwiY-1689850814-0-AexYX7Zz9xW32yCFfEWK7aS05zJWLN2V796ecOTKaLp2TPN9qfqAzcGqOx91xMJSi7Fbz7gZVi128zlIQqOHg+Q=; __stripe_sid=a4184bcc-c6b2-4a6e-9e39-c5750d7e7f38227c6e; __Secure-next-auth.session-token=eyJhbGciOiJkaXIiLCJlbmMiOiJBMjU2R0NNIn0..r9tQFH6-LshwOGrH.7H58yP-1ifh5ljMQNz968BRyYitHJs6h-R0KcjJPJyVOcr_ybIZ0n17_1UilAXssRD0ZyzTEvpnr_f9aDaqdgQBvYTuSlBCVdn_lGx5L2XxQ7E3tVHF4B2II7PwjPNfgsQCUbZdRzWUfjfrcLikk7l8jCwTFZ-a0GVlgSgMAjuwl5mC4XuxI_0QlAdeYONkQjIDn5JnkEEfoen20siUMYEIrZGt1i1IYaqsXaloBQjoMSrYm8k9AH91MJ3lY-hQQW4UFUoLbvjs0gLyLFW1nyLD_gawD_Z94WXQ6LQ6cMr4PgKWFWwbFmt2ovIW1AG-gF_GKSm2EwZaydKXbONCPujRx9gJC5pLRw_VIRPcLUaf9dS9M9noYOn496IyXBxEu0R4KiR25Qp3PgoMd1OltxyyIkC-9fEA1VHrIfA6mEyAYqw8YYK27zg-z_5xigMBheiuK73D7Ob8hu0uyNY6-O8YoJPlri-VL0fLl7iRZmYCB5AlYP2ewAxdjhlqn2DKPZSmnYUccwOIbFRjYcHpXPp8tDoOarUwfPLIYBt3m7Fg7BemRGELDBkFzXOJoVkty1b6Dn5meNmu5iy0yI9Muk50fHOhK75h8Pj1KaNQG0Aw3vJoV73ooPxzvGjLL_PtUf5B03_Wm1EZ--rcZhXLCgoGd7JzhV1o42ewFoToTTSQQ03V5S8F9BAWBkwY5fShKoc7Jbey_VlyryXjQOlHLyVzU5LCkcEkIEaeOlhDEzlnS7CEgGrIxbfv85DuwcSS3ngkzhadfhUGyAb1kQ_XorQFUJPvmnwTB7qRN1Het543ez2LwuXYx15-ruk_kj5iqvN1WjGLmHbmoX5PEnQlwuebXcbWm3wBB-NTNCb5U_2TrMKjYV8RoF_xg12vJ7SSXY4K20JCCwBaELhu2GyIvXpJfOruUR0ps6kZTrkjsczIvCecZ6T6yoUyNWRwQHbssSr1xonAU5sC-k9783Sx8lDhjaugUL2E4SOPjGPVr7602G4qIjLGljrgOVFHZl7gnhkJpE_Fo6j7FzebG6eIlVZtBSoa8AD788xYy6QfD-pQuxpf8x85t6N5Er0gLVg7y0BjGdArR_a2NjkVCZPcnh8ksznMPhCj1uXJq4rcPpf9S_4TvpxYJhSMTV5n7aJMIN6cVG92dwbQXBkRD3OGygHO-Js0xhGDY9GuMk1Rkbi2JKeX2KUku4Nyqr8uU_tbQt-FYEROloNa4iK1u0IcK-J4q3JpSKlf5IoxHCguVH1N1aMO9vi_et373CytDfB8awc_zJT3kE4daanaRJoAHtN2PtN3-Aa5U_i5ui2Ce2-TH7TbtiwMhsjXQkQE-L-YJu_8vR2SpHEFBePj258MmY0imvCxn8dLJoGZA7imj1AoNiPFZtYY8UsreABvQ-7_PVDYnk5Vn8nyRcDR0vZ6ABklQd3BvYGRgsyJYIzqvnbwYlFakO3fWcckbsJEmHZT8UT-zszwecLzD5pnMtbTMZzPg63FJelezjGxewX1e-Lsih60y7QirtOX_MuPzPJGATxHBcuCmMpKhZRgbkFLkKHHzxjVepSL1gKaLwjNAwZerIwbz5LXAzumGbfNtwpBuv9RUFiV3a3dNRHVRYE8j0oKIu4UFY6ucV4eoUyYZxf7TKfUqiO1C1N_1hn0fU99ZucPV4EZ6vUChT2UdKdUYAipKBWYH2KXum_-qNnja4C4UMz889i7-d8ef-qwJCE54HoPpYOywc2z1I2UJMbSqDI2V6b2vqzEBRICSgDDtrroRX-MuO4gewtcTuKJFBZZ3MmcFu1jzC-rNsRzUMiD9hXw_9n3NVizu2ojmdpYELIELDeUyP12UJSCF2mq_aqbrFAN5bfACh3YgkJYPOHd2VLJYtVQbU7u7Ho3oNzWrAT2JMnHAiwJb6wTRQB45QdJrTHkYUKaS_ztgzghhPi4s7Z4v6tafZIG2rNxba7yw602BVlj-AmyJRGvKLGgFnPSAQ_dm8KJFKNoidwEmC1flehFET1KUqYk0RqeOLyNBYjq6Cxizl69wJ9dm9Qm87GE2BY8nMOtAFGpuU0PiGD6_C6uG5jy4re11o6WyOqegJC7A_WiSYqbCm8fId6IlPdFFW-gbB2OvmBSgr3Hf0HIEdtcLA5kVsw8.eplHEcxCBInfC98v52co6g; _dd_s=rum=0&expire=1689852001628; _ga_Q0DQ5L7K0D=GS1.1.1689850795.5.1.1689851102.0.0.0";
        headers.fluentPut("cookie", cookie);
        headers.fluentPut("authority", "www.midjourney.com");
        headers.fluentPut("accept","*/*");
        headers.fluentPut("accept-language", "zh-CN,zh;q=0.9");
        headers.fluentPut("referer", "https://www.midjourney.com/app/feed/?sort=" + tab);
        headers.fluentPut("sec-ch-ua", "\"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\"");
        headers.fluentPut("sec-ch-ua-mobile", "?0");
        headers.fluentPut("sec-ch-ua-platform", "\"macOS\"");
        headers.fluentPut("sec-fetch-dest", "empty");
        headers.fluentPut("sec-fetch-mode", "cors");
        headers.fluentPut("sec-fetch-site", "same-origin");
        headers.fluentPut("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36");

        JSONObject data = new JSONObject();
        data.fluentPut("url", url);
        data.fluentPut("headers", headers);

        Map<String, String> requestHeader = Maps.newHashMap();
        requestHeader.put("Content-Type", "application/json");
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .url("http://127.0.0.1:8012/common/transfer")
                .httpMethod(HttpMethod.POST)
                .clientType(ClientType.HTTPCLIENT)
                .headers(requestHeader)
                .body(data.toJSONString())
                .retry(3)
                .build();
        try {
//            log.info("请求体：{}", JSON.toJSONString(requestConfig));
            String resText = httpService.requestRawText(requestConfig);
//            log.info("返回体：{}", resText);
            return JSON.parseArray(resText);
        } catch (Exception exp) {
            exp.printStackTrace();
            log.info("请求失败：{}", exp.getMessage());
            return new JSONArray();
        }
    }

    private String makeUpCvtImagerUrl(String target) {
        // 固定宽度为512
        return String.format("https://imagecache.civitai.com/xG1nkqKTMzGDvpLrqFT7WA/%s/width=512", target);
    }

    private  String parseJsonTags(String jsonString) {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        StringBuilder tags = new StringBuilder();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONObject tagObject = jsonObject.getJSONObject("tag");
            String tagName = tagObject.getString("name");
            if (i > 0) {
                tags.append(",");
            }
            tags.append(tagName);
        }
        return tags.toString();
    }

    private String getDefault(String object) {
        if (object == null) {
            return "";
        } else {
            return object;
        }
    }

    private Long getDefault(Long object) {
        if (object == null) {
            return 0L;
        } else {
            return object;
        }
    }

    private Integer getDefault(Integer object) {
        if (object == null) {
            return 0;
        } else {
            return object;
        }
    }

    private Boolean getDefault(Boolean object) {
        if (object == null) {
            return false;
        } else {
            return object;
        }
    }

    private String getJsonDefaultString(JSONObject data, String key) {
        String res = "";
        try {
            res = data.getString(key);
            if (res == null) {
                res = "";
            }
        } catch (Exception ignored) {
        }
        return res;
    }

    private Long getJsonDefaultLong(JSONObject data, String key) {
        Long res = 0L;
        try {
            res = data.getLong(key);
            if (res == null) {
                res = 0L;
            }
        } catch (Exception ignored) {
        }
        return res;
    }

    private Integer getJsonDefaultInteger(JSONObject data, String key) {
        Integer res = 0;
        try {
            res = data.getInteger(key);
            if (res == null) {
                res = 0;
            }
        } catch (Exception ignored) {
        }
        return res;
    }

    private Boolean getJsonDefaultBoolean(JSONObject data, String key) {
        Boolean res = false;
        try {
            res = data.getBoolean(key);
            if (res == null) {
                res = false;
            }
        } catch (Exception ignored) {
        }
        return res;
    }

    private Double getJsonDefaultDouble(JSONObject data, String key) {
        Double res = 0.0;
        try {
            res = data.getDouble(key);
            if (res == null) {
                res = 0.0;
            }
        } catch (Exception ignored) {
        }
        return res;
    }
}
