package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.enumerate.*;
import com.aigccafe.buterin.common.model.crawl.ModelDetailRequest;
import com.aigccafe.buterin.common.model.crawl.ModelListRequest;
import com.aigccafe.buterin.common.model.crawl.ModelVersionImageRequest;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetailPOWithBLOBs;
import com.aigccafe.buterin.common.model.cvt.CvtModelDetectPO;
import com.aigccafe.buterin.common.model.doc.OuterArticlePOWithBLOBs;
import com.aigccafe.buterin.common.model.journey.JourneyGalleryImagePO;
import com.aigccafe.buterin.common.model.journey.MjShowcaseLogPO;
import com.aigccafe.buterin.common.model.md.*;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.common.util.ConvertorUtil;
import com.aigccafe.buterin.common.util.SystemUtil;
import com.aigccafe.buterin.repository.CvtModelRepository;
import com.aigccafe.buterin.repository.DocumentRepository;
import com.aigccafe.buterin.repository.JourneyRepository;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.service.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CrawlTaskServiceImpl implements CrawlTaskService {

    @Autowired
    private CrawlService crawlService;
    @Autowired
    private CvtModelRepository cvtModelRepository;
    @Autowired
    private TranslateService translateService;
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private JourneyRepository journeyRepository;
    @Autowired
    private JourneyService journeyService;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private PromptService promptService;


    @Override
    public void updateModelList(ModelType modelType, Integer batch, Integer batchNum, Long cursor) {
        //Long cursor = 52961L; // lora坐标
//        Long cursor = 36520L;
        for(int i = 0; i < batch; i++) {
            log.info("====================");
            log.info("准备第{}次采集", i + 1);
            ModelListRequest crawlRequest = ModelListRequest.builder()
                    .types(Collections.singletonList(modelType.getValue()))
//                    .types(Collections.singletonList("LORA"))
                    .checkpointType(null)
                    .cursor(cursor)
                    .limit(batchNum)
                    .build();
            try {
                JSONObject response = crawlService.crawlModelList(crawlRequest);
                log.info("{}", response.toJSONString());
                Pair<Long, JSONArray> pairData = crawlService.parseModelListJson(response);
                cursor = crawlService.updateModelListRecord(crawlRequest, pairData);
                log.info("下次坐标为：{}", cursor);
            } catch (Exception exp) {
                log.info("请求失败，跳出循环,错误信息:{}", exp.getMessage());
                exp.printStackTrace();
                break;
            }
            log.info("====================");
        }
    }

    @Override
    public void updateModelDetail(ModelType modelType, Integer number) {
        // 获取未更新模型
        List<CvtModelDetectPO> cvtModelDetectPOList = cvtModelRepository.getNotUpdatedModelList(modelType, number);
        int successCnt = 0;
        int failCnt = 0;
        int totalCnt = cvtModelDetectPOList.size();
        for (int i = 0 ; i < cvtModelDetectPOList.size(); i++) {
            CvtModelDetectPO model = cvtModelDetectPOList.get(i);
            ModelDetailRequest request = ModelDetailRequest.builder()
                    .id(model.getModelId().intValue())
                    .checkPointType(model.getCheckpointType())
                    .sortType("Most Liked")
                    .type(model.getModelType())
                    .name(model.getModelName().toLowerCase())
                    .build();
            try {
                log.info("==========================");
                log.info("总更新量：{}, 当前位置：{}， 完成度：{}%", totalCnt, i + 1, 100 * (i + 1)/totalCnt);
                log.info("更新模型详情：{},{}", model.getModelId(), model.getModelName());
                JSONArray responseArray = crawlService.crawlModelDetail(request);
                crawlService.updateModelDetailRecord(responseArray);
                successCnt++;
                log.info("模型更新完毕");
                log.info("==========================");
            } catch (Exception exp) {
                log.info("请求失败,错误信息:{}", exp.getMessage());
                exp.printStackTrace();
                failCnt++;
            }
        }
        log.info("任务完成，总量：{}, 完成：{}, 失败：{}, 失败率：{}%", totalCnt, successCnt, failCnt, (100 * failCnt)/(totalCnt + 1));
    }

    @Override
    public void updateModelVersionImage(Integer number) {
        log.info("获取模型信息-前");
        List<CvtModelDetailPOWithBLOBs> modelDetails = cvtModelRepository.getVersionImageNotUpdateModelList(number);
        log.info("获取模型信息");
        int totalCnt = modelDetails.size();
        if (totalCnt == 0) {
            log.info("没有需更新的模型了，退出");
            return;
        }
        int totalVersionCnt = 0;
        int failCnt = 0;
        for (int i = 0; i < modelDetails.size(); i++) {
            CvtModelDetailPOWithBLOBs model = modelDetails.get(i);
            Long modelId = model.getModelId();
            JSONObject userInfo = JSON.parseObject(model.getUserInfo());
            Long userId = userInfo.getLong("id");
            JSONArray versionList = JSON.parseArray(model.getModelVersionList());
            List<Long> versionIdList = versionList.stream().map(version -> {
                JSONObject verData = (JSONObject) version;
                return verData.getLong("id");
            }).collect(Collectors.toList());
            log.info("==========================");
            log.info("总更新量：{}, 当前位置：{}， 完成度：{}%", totalCnt, i + 1, 100 * (i + 1)/totalCnt);
            log.info("模型：{}, 用户：{}, 版本列表：{}", modelId, userId, JSON.toJSONString(versionIdList));
            for (Long versionId : versionIdList) {
                totalVersionCnt++;
                ModelVersionImageRequest request = ModelVersionImageRequest.builder()
                        .modelId(modelId)
                        .modelVersionId(versionId)
                        .prioritizedUserIds(Collections.singletonList(userId))
                        .build();
                try {
                    log.info("准备采集模型：{},版本：{} 的图片", request.getModelId(), request.getModelVersionId());
                    JSONObject response = crawlService.crawlModelVersionImage(request);
                    log.info("请求成功");
                    crawlService.updateModelVersionImageRecord(request.getModelId(), response);
                } catch (Exception exp) {
                    log.info("采集图片过程出现异常,modelId{},versionId:{},exp:{}", modelId, versionId, exp.getMessage());
                    failCnt++;
                    exp.printStackTrace();
                }
            }
            cvtModelRepository.setModelVersionImageUpdated(modelId);
            log.info("==========================");
        }
        log.info("任务完成，版本总量：{}， 失败：{}，失败率：{}%", totalVersionCnt, failCnt, (100 * failCnt)/totalVersionCnt);
    }

    @Override
    public void updatePostedImage() {
    }

    @Override
    public void mergeModelInfo(ModelType modelType, Integer number) {
        log.info("==========================");
        List<CvtModelDetailPOWithBLOBs> cvtModelDetails = cvtModelRepository.getNotMergedModelList(number, modelType.getValue());
        log.info("待合并模型量：" + cvtModelDetails.size());
        for(CvtModelDetailPOWithBLOBs cvtModelDetail : cvtModelDetails) {
            log.info("正在更新模型:{},{}", cvtModelDetail.getModelId(), cvtModelDetail.getModelName());
            crawlService.modelMergedInMysql(cvtModelDetail);
            log.info("模型更新完毕");
        }
        log.info("==========================");
    }

    @Override
    public void updateOuterArticle(String url) {
        try {
            // 默认用户 ""
            Long userId = 1000000L;

            // 解析，并去除掉一些不需要的东西
            String rawHtml = crawlService.crawlSdArtArticle(url);

            // 转化为本地cdn资源
            String html = crawlService.convertToLocalHtml(rawHtml);
//            String html = rawHtml;

            // 提取文章关键信息
           JSONObject info = crawlService.extractArticleInfo(html);
           log.info("提取文章关键信息:{}", info.toJSONString());

            // 翻译
            html = translateService.translateHtml(html);
//            log.info(html);

            // 转化为md5
            String mdText = ConvertorUtil.convertHtmlToMarkdown(html);

            // 添加转载说明
            String notion = String.format("原文作者%s， [原文链接](%s)", info.getString("author"), url);
            mdText = mdText + "\n" + notion;

            log.info(mdText);

            // 信息存储入库
            OuterArticlePOWithBLOBs article = new OuterArticlePOWithBLOBs();
            article.setRawUrl(url);
            article.setUserId(userId);
            article.setTitle(info.getString("title"));
            article.setCoverPath(info.getString("coverUrl"));
            article.setBrief(info.getString("brief"));
            article.setRawHtml(rawHtml);
            article.setContent(mdText);
            article.setHtml("");
            article.setTags(info.getString("tags"));
            article.setStatus(ArticleStatus.REVIEW.name());
            documentRepository.insert(article);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @Override
    public void updateGalleryImageLog(Integer page, Integer batch, String tab) {
        for (int i = 0; i < batch; i++) {
            int currentPage = page + i;
            try {
                log.info("=========采集第{}页===========", currentPage);
                JSONArray result = crawlService.crawlShowcaseImage(tab, currentPage, 35);
//                log.info("返回结果：{}", JSON.toJSONString(result));
                result.forEach(obj -> {
                    JSONObject item = (JSONObject) obj;
//                    log.info("采集日志：{}", JSON.toJSONString(item));
                    String imageId = item.getString("id");
                    MjShowcaseLogPO logPO = journeyRepository.selectMjImageLogByImageId(imageId);
                    if (logPO == null) {
                        logPO = new MjShowcaseLogPO();
                        logPO.setImageId(imageId);
                        logPO.setRawLog(item.toJSONString());
                        logPO.setStore(false);
                        Boolean res = journeyRepository.insertMjShowcaseLog(logPO);
                        if (res) {
                            log.info("========={},记录插入成功===========", imageId);
                        } else {
                            log.info("=========记录插入失败===========");
                        }
                    } else {
                        log.info("=========记录已存在，跳过===========");
                    }
                });
                Thread.sleep(3000);
            } catch (Exception exp) {
                log.info("采集第{}页过程中出现异常：{}", currentPage, exp.getMessage());
            }
            log.info("=========第{}页,采集结束===========", currentPage);
        }
    }

    @Override
    public void updateGalleryImage(Integer number) {
        List<MjShowcaseLogPO> imageLogList = journeyRepository.selectUnStoreImageLog(number);
        log.info("========本次有{}张图片需要转存========", imageLogList.size());
        for (MjShowcaseLogPO imageLog : imageLogList) {
//            log.info("记录:{}", JSON.toJSONString(imageLog));
            String rawLog = imageLog.getRawLog();
//            log.info("日志:{}", rawLog);

            JSONObject imageData = JSON.parseObject(rawLog);
            String imageId = imageLog.getImageId();
            String prompt = imageData.getString("full_command");
            JSONArray imageUrls = imageData.getJSONArray("image_paths");
            if (imageUrls.size() > 0) {
                String midImageUrl = imageUrls.getString(0);
                log.info("获取到图片链接，进行转存:{}", midImageUrl);
                String rawImagePath = journeyService.storeOuterImage(midImageUrl);
                log.info("原图转存路径：{}", rawImagePath);
                String imagePath = journeyService.resizeOssPath(rawImagePath);
                log.info("展示图转存路径：{}", imagePath);

                JourneyGalleryImagePO galleryImagePO = new JourneyGalleryImagePO();
                galleryImagePO.setSource(GalleryImageSource.SHOWCASE.name());
                galleryImagePO.setImageId(imageId);
                galleryImagePO.setPrompt(prompt);
                galleryImagePO.setImagePath(imagePath);
                galleryImagePO.setRawImagePath(rawImagePath);
                galleryImagePO.setMidImageUrl(midImageUrl);
                galleryImagePO.setPrice(0.0);
                galleryImagePO.setViewCnt(0);
                boolean res = journeyRepository.insertJourneyGalleryImage(galleryImagePO);
                if (res) {
                    log.info("图片转存成功！");
                    MjShowcaseLogPO logPO = journeyRepository.selectMjImageLogByImageId(imageId);
                    logPO.setStore(true);
                    journeyRepository.updateMjShowcaseLog(logPO);
                } else {
                    log.info("转存失败！");
                }
            } else {
                log.info("图片不存在，转存失败,ID:{}", imageId);
            }
        }
    }

    @Override
    public void transferStableGalleryImage(Integer batchNum) {
        Integer offset = 200 * (batchNum - 1);
        List<ModelVersionImagePOWithBLOBs> versionImageList = modelRepository.selectImageByCondition(null, offset, 200);
        log.info("数据载入完毕，开始更新......");
        for (ModelVersionImagePOWithBLOBs imagePOWithBLOBs : versionImageList) {
            String meta = imagePOWithBLOBs.getMeta();
            if (meta == null || meta.equals("{}")) {
                continue;
            }
            StableGalleryImagePOWithBLOBs sdImage = new StableGalleryImagePOWithBLOBs();
            sdImage.setSource(GalleryImageSource.SHOWCASE.name());
            sdImage.setImageId(imagePOWithBLOBs.getId().toString());
            sdImage.setModelId(imagePOWithBLOBs.getModelId());
            sdImage.setModelName(imagePOWithBLOBs.getModelName());
            sdImage.setVersionId(imagePOWithBLOBs.getVersionId());
            sdImage.setVersionName(imagePOWithBLOBs.getVersionName());
            sdImage.setRawUrl(imagePOWithBLOBs.getUrl());
            sdImage.setRawImagePath(imagePOWithBLOBs.getRawPath());
            sdImage.setImagePath(imagePOWithBLOBs.getNormalPath());
            sdImage.setMeta(imagePOWithBLOBs.getMeta());
            sdImage.setAuthorInfo(imagePOWithBLOBs.getAuthorInfo());
            sdImage.setPrice(0.0);
            sdImage.setViewCnt(0);
            sdImage.setStatus(PromptStatus.READY.name());
            modelRepository.update(sdImage);
            log.info("图片{},更新成功！", imagePOWithBLOBs.getId());
        }
        log.info("offset:{}, number:{}, 更新成功", offset, 200);
    }

    @Override
    public void updateAllBaseModel(Integer batchNum) {
        Integer offset = 500 * (batchNum - 1);
        List<ModelDetailPO>  modelDetailPOList = modelRepository.selectModelListByStatus(null, offset, 500);
        for (ModelDetailPO detailPO : modelDetailPOList) {
            Long modelId = detailPO.getId();
            Optional<String> baseModelOp = modelRepository.selectVersionByModelId(modelId).stream().map(ModelVersionPO::getBaseModel).reduce((x, y) -> x);
            String baseModel = "other";
            if (baseModelOp.isPresent()) {
                baseModel = baseModelOp.get();
            }
            detailPO.setBaseModel(baseModel);
            modelRepository.update(detailPO);
        }
    }

    @Override
    public void updatePromptTranslate(PromptType type) {
        if (PromptType.SD.equals(type)) {
            List<StableGalleryImagePOWithBLOBs> imagePOS = modelRepository.selectUnTranslateImageByCondition(PromptStatus.ONLINE);
            for(StableGalleryImagePOWithBLOBs image : imagePOS) {
                String cnMeta = image.getCnMeta();
                if (Strings.isNullOrEmpty(cnMeta)) {
                    try {
                        promptService.translateSdPrompt(image.getId());
                        log.info("image:{},翻译成功", image.getId());
                        Thread.sleep(200);
                    } catch (Exception exception) {
                        log.info("翻译出现异常：{}", exception.getMessage());
                    }
                }
            }
        }
        if (PromptType.MJ.equals(type)) {
            List<JourneyGalleryImagePO> imagePOS = journeyRepository.selectGalleryImageByCondition(null, PromptSortedType.NEWEST, PromptStatus.ONLINE, 0, 1000);
            for(JourneyGalleryImagePO image : imagePOS) {
                String cnPrompt = image.getCnPrompt();
                if (Strings.isNullOrEmpty(cnPrompt)) {
                    try {
                        promptService.translateMjPrompt(image.getId());
                        log.info("image:{},翻译成功", image.getId());
                        Thread.sleep(200);
                    } catch (Exception exception) {
                        log.info("翻译出现异常：{}", exception.getMessage());
                    }
                }
            }
        }
    }
}
