package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.enumerate.PromptType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPO;
import com.aigccafe.buterin.common.model.journey.JourneyGalleryImagePO;
import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.md.ModelVersionImagePOWithBLOBs;
import com.aigccafe.buterin.common.model.md.StableGalleryImagePO;
import com.aigccafe.buterin.common.model.md.StableGalleryImagePOWithBLOBs;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.common.model.resp.*;
import com.aigccafe.buterin.repository.InteractionRepository;
import com.aigccafe.buterin.repository.JourneyRepository;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.repository.OOSRepository;
import com.aigccafe.buterin.repository.mapper.PromptExtendMapper;
import com.aigccafe.buterin.service.InteractionService;
import com.aigccafe.buterin.service.PromptService;
import com.aigccafe.buterin.service.TranslateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PromptServiceImpl implements PromptService {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private JourneyRepository journeyRepository;
    @Autowired
    private OOSRepository oosRepository;
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private InteractionService interactionService;
    @Autowired
    private PromptExtendMapper promptExtendMapper;
    @Autowired
    private TranslateService translateService;


    @Override
    @Deprecated
    public List<SdPromptRespVO> getPromptListByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType) {
        List<ModelVersionImagePOWithBLOBs> imagePOWithBLOBs = modelRepository.selectImageByCondition(idList, offset, number);
//        log.info("数目:{}", imagePOWithBLOBs.size());
        return imagePOWithBLOBs.stream().parallel()
                .filter(image -> (!"{}".equals(image.getMeta())))
                .map(image -> {
                    JSONObject jsonObject = JSONObject.parseObject(image.getAuthorInfo());
                    String authorName = jsonObject.getString("username");
                    return SdPromptRespVO.builder()
                            .id(image.getId())
                            .authorName(authorName)
                            .modelId(image.getModelId())
                            .modelName(image.getModelName())
                            .versionId(image.getVersionId())
                            .versionName(image.getVersionName())
                            .meta(image.getMeta())
                            .url(oosRepository.getSafeUrl(image.getRawPath()))
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public List<SdPromptRespVO> getSdPromptListByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType, PromptStatus status) {
        List<StableGalleryImagePO> imagePOWithBLOBs = modelRepository.selectStableImageByCondition(idList, offset, number, sortedType, status);
        return makeUpSdPromptList(imagePOWithBLOBs);
    }

    private List<SdPromptRespVO> makeUpSdPromptList( List<StableGalleryImagePO> imagePOWithBLOBs) {
        Long userId = 0L;
        if (StpUtil.isLogin()) {
            userId = StpUtil.getLoginIdAsLong();
        }
        List<Long> imageIdList = imagePOWithBLOBs.stream().map(StableGalleryImagePO::getId).collect(Collectors.toList());
        Map<Long, InteractionStatPO> statPOMap = interactionRepository.selectInteractionStatList(TargetType.SD_IMAGE, imageIdList)
                .stream().collect(Collectors.toMap(InteractionStatPO::getTargetId, obj -> obj, (x, y) -> x));
        Map<Long, InteractionStatusRespVO> statusRespVOMap = interactionService.getUserInteractionMap(userId, TargetType.SD_IMAGE, imageIdList);
//        log.info("数目:{}", imagePOWithBLOBs.size());
        return imagePOWithBLOBs.stream().parallel()
                .map(image -> {
                    InteractionStatPO interactionStatPO = statPOMap.get(image.getId());
                    InteractionStatusRespVO interactionStatusRespVO = statusRespVOMap.get(image.getId());
                    InteractionStatRespVO statRespVO = InteractionStatRespVO.builder().build();
                    if (interactionStatPO != null) {
                        BeanUtils.copyProperties(interactionStatPO, statRespVO);
                    }
                    return SdPromptRespVO.builder()
                            .type(PromptType.SD)
                            .id(image.getId())
                            .modelId(image.getModelId())
                            .modelName(image.getModelName())
                            .versionId(image.getVersionId())
                            .versionName(image.getVersionName())
                            .url(oosRepository.getSafeUrl(image.getImagePath()))
                            .price(image.getPrice())
                            .viewCnt(image.getViewCnt())
                            .interactionStat(statRespVO)
                            .interactionStatus(interactionStatusRespVO)
                            .build();
                }).collect(Collectors.toList());
    }

    @Override
    public List<MjPromptRespVO> getMjPromptListByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType, PromptStatus status) {
        List<JourneyGalleryImagePO> galleryImagePOS = journeyRepository.selectGalleryImageByCondition(idList, sortedType, status, offset, number);
        return makeUpMjPromptList(galleryImagePOS);
    }

    private List<MjPromptRespVO> makeUpMjPromptList(List<JourneyGalleryImagePO> galleryImagePOS) {
        Long userId = 0L;
        if (StpUtil.isLogin()) {
            userId = StpUtil.getLoginIdAsLong();
        }
        List<Long> imageIdList = galleryImagePOS.stream().map(JourneyGalleryImagePO::getId).collect(Collectors.toList());
        Map<Long, InteractionStatPO> statPOMap = interactionRepository.selectInteractionStatList(TargetType.MJ_IMAGE, imageIdList)
                .stream().collect(Collectors.toMap(InteractionStatPO::getTargetId, obj -> obj, (x, y) -> x));
        Map<Long, InteractionStatusRespVO> statusRespVOMap = interactionService.getUserInteractionMap(userId, TargetType.MJ_IMAGE, imageIdList);

        return galleryImagePOS.stream()
                .map(galleryImagePO -> {
                    InteractionStatPO interactionStatPO = statPOMap.get(galleryImagePO.getId());
                    InteractionStatusRespVO interactionStatusRespVO = statusRespVOMap.get(galleryImagePO.getId());
                    InteractionStatRespVO statRespVO = InteractionStatRespVO.builder().build();
                    if (interactionStatPO != null) {
                        BeanUtils.copyProperties(interactionStatPO, statRespVO);
                    }
                    return MjPromptRespVO.builder()
                            .type(PromptType.MJ)
                            .id(galleryImagePO.getId())
                            .url(oosRepository.getSafeUrl(galleryImagePO.getImagePath()))
                            .price(galleryImagePO.getPrice())
                            .viewCnt(galleryImagePO.getViewCnt())
                            .interactionStat(statRespVO)
                            .interactionStatus(interactionStatusRespVO)
                            .build();
                })
                .collect(Collectors.toList());
    }

    @Override
    public SdPromptDetailRespVO getSdPromptDetail(Long promptId) {
        StpUtil.checkLogin();
        StableGalleryImagePOWithBLOBs imagePOWithBLOBs = modelRepository.selectStableImageById(promptId);
        imagePOWithBLOBs.setViewCnt(imagePOWithBLOBs.getViewCnt() + 1);
        modelRepository.update(imagePOWithBLOBs);
        return SdPromptDetailRespVO.builder()
                .type(PromptType.SD)
                .id(imagePOWithBLOBs.getId())
                .modelId(imagePOWithBLOBs.getModelId())
                .modelName(imagePOWithBLOBs.getModelName())
                .versionId(imagePOWithBLOBs.getVersionId())
                .versionName(imagePOWithBLOBs.getVersionName())
                .meta(imagePOWithBLOBs.getMeta())
                .url(oosRepository.getSafeUrl(imagePOWithBLOBs.getRawImagePath()))
                .price(imagePOWithBLOBs.getPrice())
                .viewCnt(imagePOWithBLOBs.getViewCnt())
                .build();
    }

    @Override
    public MjPromptDetailRespVO getMjPromptDetail(Long promptId) {
        StpUtil.checkLogin();
        JourneyGalleryImagePO imagePO = journeyRepository.selectGalleryImageById(promptId);
        imagePO.setViewCnt(imagePO.getViewCnt() + 1);
        journeyRepository.updateJourneyGalleryImage(imagePO);
        return MjPromptDetailRespVO.builder()
                .type(PromptType.MJ)
                .id(imagePO.getId())
                .prompt(imagePO.getPrompt())
                .url(oosRepository.getSafeUrl(imagePO.getRawImagePath()))
                .price(imagePO.getPrice())
                .viewCnt(imagePO.getViewCnt())
                .build();
    }

    @Override
    public Boolean updatePromptStatus(PromptType type, Long promptId, PromptStatus promptStatus) {
        StpUtil.checkLogin();
        if (PromptType.SD.equals(type)) {
            StableGalleryImagePOWithBLOBs stableGalleryImagePO = modelRepository.selectStableImageById(promptId);
            stableGalleryImagePO.setStatus(promptStatus.name());
            return modelRepository.update(stableGalleryImagePO) > 0;
        } else if (PromptType.MJ.equals(type)) {
            JourneyGalleryImagePO journeyGalleryImagePO = journeyRepository.selectGalleryImageById(promptId);
            journeyGalleryImagePO.setStatus(promptStatus.name());
            return journeyRepository.updateJourneyGalleryImage(journeyGalleryImagePO);
        } else {
            return false;
        }
    }

    @Override
    public List<SdPromptRespVO> searchSdPromptList(String keyword, Integer offset, Integer number) {
        if (Strings.isEmpty(keyword)) {
            return Lists.newArrayList();
        } else {
            keyword = translateService.translateSentenceByBaidu(keyword, "en");
        }
        List<StableGalleryImagePO> stableGalleryImagePOS = promptExtendMapper.searchSdPromptList(keyword, offset, number);
        return makeUpSdPromptList(stableGalleryImagePOS);
    }

    @Override
    public List<MjPromptRespVO> searchMjPromptList(String keyword, Integer offset, Integer number) {
        if (Strings.isEmpty(keyword)) {
            return Lists.newArrayList();
        } else {
            keyword = translateService.translateSentenceByBaidu(keyword, "en");
        }
        List<JourneyGalleryImagePO> journeyGalleryImagePOS = promptExtendMapper.searchMjPromptList(keyword, offset, number);
        return makeUpMjPromptList(journeyGalleryImagePOS);
    }

    @Override
    public String translateSdPrompt(Long promptId) {
        StpUtil.checkLogin();
        StableGalleryImagePOWithBLOBs imagePOWithBLOBs = modelRepository.selectStableImageById(promptId);
        if (Strings.isNotEmpty(imagePOWithBLOBs.getCnMeta())) {
            return imagePOWithBLOBs.getCnMeta();
        }
        if (Strings.isEmpty(imagePOWithBLOBs.getMeta()) || imagePOWithBLOBs.getMeta().equals("{}")) {
            throw new RuntimeException("无内容可翻译");
        }
        JSONObject meta = JSON.parseObject(imagePOWithBLOBs.getMeta());
        String prompt = meta.getString("prompt");
        String negativePrompt = meta.getString("negativePrompt");
        if (Strings.isNotEmpty(prompt)) {
            String cnPrompt = translatePrompt(prompt, "zh");
            meta.put("prompt", cnPrompt);
        }
        if (Strings.isNotEmpty(negativePrompt)) {
            String cnNegativePrompt = translatePrompt(negativePrompt, "zh");
            meta.put("negativePrompt", cnNegativePrompt);
        }
        imagePOWithBLOBs.setCnMeta(meta.toJSONString());
        modelRepository.update(imagePOWithBLOBs);
        return meta.toJSONString();
    }

    @Override
    public String translateMjPrompt(Long promptId) {
        StpUtil.checkLogin();
        JourneyGalleryImagePO imagePO = journeyRepository.selectGalleryImageById(promptId);
        if (Strings.isNotEmpty(imagePO.getCnPrompt())) {
            return imagePO.getCnPrompt();
        }
        String prompt = imagePO.getPrompt();
        if (Strings.isEmpty(prompt)) {
            throw new RuntimeException("无可翻译内容");
        }
        String cnPrompt = translatePrompt(prompt, "zh");
        imagePO.setCnPrompt(cnPrompt);
        journeyRepository.updateJourneyGalleryImage(imagePO);
        return cnPrompt;
    }

    @Override
    public String translateMjPromptToEnglish(String prompt) {
        return translatePrompt(prompt, "en");
    }


    private String translatePrompt(String prompt, String lang) {
        List<String> segments = splitMjPrompt(prompt);
        String descriptionStr = segments.get(0);
        String argumentsStr = segments.get(1);
        String cnDescriptionStr = translateService.translateSentenceByBaidu(descriptionStr, lang);
//        String cnDescriptionStr = descriptionStr;
        return String.format("%s %s", cnDescriptionStr, argumentsStr);
    }

    @Override
    public List<String> splitMjPrompt(String prompt) {
        prompt = prompt.toLowerCase();
        Pattern argumentPattern = Pattern.compile("--\\w+\\s*(?:\\S+\\s*)*");
        Matcher matcher = argumentPattern.matcher(prompt);

        StringBuilder description = new StringBuilder();
        StringBuilder arguments = new StringBuilder();

        int lastMatchEnd = 0;
        while (matcher.find()) {
            String argument = matcher.group().trim();
            int matchStart = matcher.start();

            description.append(prompt.substring(lastMatchEnd, matchStart));
            arguments.append(argument).append(" ");

            lastMatchEnd = matcher.end();
        }
        description.append(prompt.substring(lastMatchEnd));
        String descriptionStr = description.toString().trim();
        String argumentsStr = arguments.toString().trim();
        List<String> segmentList = new ArrayList<>();
        if (Strings.isEmpty(descriptionStr)) {
            descriptionStr = "";
        }
        segmentList.add(descriptionStr);
        if (Strings.isEmpty(argumentsStr)) {
            argumentsStr = "";
        }
        segmentList.add(argumentsStr);
        return segmentList;
    }
}
