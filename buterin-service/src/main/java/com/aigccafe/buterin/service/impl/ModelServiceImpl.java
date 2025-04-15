package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.*;
import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPO;
import com.aigccafe.buterin.common.model.md.*;
import com.aigccafe.buterin.common.model.req.*;
import com.aigccafe.buterin.common.model.resp.*;
import com.aigccafe.buterin.common.model.user.UserInfo;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.InteractionRepository;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.repository.OOSRepository;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.repository.mapper.ModelExtendMapper;
import com.aigccafe.buterin.service.HttpService;
import com.aigccafe.buterin.service.InteractionService;
import com.aigccafe.buterin.service.ModelService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OOSRepository oosRepository;
    @Autowired
    private HttpService httpService;
    @Autowired
    private ModelExtendMapper modelExtendMapper;
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private InteractionService interactionService;

    @Override
    public List<SimpleModelRespVO> getModelSimpleListByRank(Integer offset, Integer number) {
        List<ModelDetailPO> modelDetailPOList = modelRepository.selectModelDetailListByOffset(offset, number);
        List<Long> idList = modelDetailPOList.stream().map(ModelDetailPO::getId).collect(Collectors.toList());
        Map<Long, ModelFileCountPO> cntMap = modelRepository.countModelFile(idList);
        return modelDetailPOList.stream().filter(x -> cntMap.get(x.getId()) != null).map(model -> {
            ModelFileCountPO modelCnt = cntMap.get(model.getId());
            return SimpleModelRespVO.builder()
                    .id(model.getId())
                    .modelName(model.getModelName())
                    .downloadCnt(model.getDownloadCnt())
                    .versionCnt(modelCnt.getVersionCnt())
                    .fileCnt(modelCnt.getFileCnt())
                    .unTransferFileCnt(modelCnt.getUnTransferFileCnt())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<ModelRespVO> searchModelList(String keyword, Integer offset, Integer number) {
        if (Strings.isEmpty(keyword)) {
            return Lists.newArrayList();
        }
        List<ModelDetailPO> modelDetailPOList = modelExtendMapper.searchModelList(keyword, offset, number);
        return makeUpModelRespVO(modelDetailPOList);
    }


    @Override
    public List<ModelRespVO> getModelListByCondition(List<String> baseModelList, List<String> modelTypeList, String channel, Integer offset, Integer number, ModelSortedType sortedType) {
        List<ModelDetailPO> modelDetailPOList;
        if (Strings.isEmpty(channel)) {
            modelDetailPOList = modelRepository.selectModelListByCondition(baseModelList, modelTypeList, channel, offset, number, sortedType);
        } else {
            baseModelList = baseModelList.stream().map(x -> String.format("\"%s\"", x)).collect(Collectors.toList());
            String baseList = String.join(",", baseModelList);
            if (Strings.isEmpty(baseList)) {
                baseList = null;
            }
            modelTypeList = modelTypeList.stream().map(x -> String.format("\"%s\"", x)).collect(Collectors.toList());
            String typeList = String.join(",", modelTypeList);
            if (Strings.isEmpty(typeList)) {
                typeList = null;
            }

//            log.info("modelList:{}", typeList);
            String orderField = "download_cnt";
            if (ModelSortedType.DOWNLOAD.equals(sortedType)) {
                orderField = "download_cnt";
            }
            if (ModelSortedType.NEWEST.equals(sortedType)) {
                orderField = "updated_at";
            }
            modelDetailPOList = modelExtendMapper.selectModelListByChannel(channel, baseList, typeList, offset, number, orderField);
        }
        return makeUpModelRespVO(modelDetailPOList);
    }

    @Override
    public List<ModelRespVO> makeUpModelRespVO(List<ModelDetailPO> modelDetailPOList) {
        Long userId = 0L;
        if (StpUtil.isLogin()) {
            userId = StpUtil.getLoginIdAsLong();
        }

        List<Long> userIdList = modelDetailPOList.stream().parallel().map(ModelDetailPO::getUserId).distinct().collect(Collectors.toList());
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(userIdList).stream().collect(Collectors.toMap(UserPO::getId, obj -> obj));
        List<Long> modelIdList = modelDetailPOList.stream().parallel().map(ModelDetailPO::getId).collect(Collectors.toList());
        // 封面
        Map<Long, String> modelIdImageMap = modelRepository.selectModelImageListByModelIdList(modelIdList).stream()
                .collect(Collectors.toMap(ModelVersionImagePO::getModelId, ModelVersionImagePO::getRawPath, (x, y) -> x));
        Map<Long, InteractionStatPO> statPOMap = interactionRepository.selectInteractionStatList(TargetType.MODEL, modelIdList)
                .stream().collect(Collectors.toMap(InteractionStatPO::getTargetId, obj -> obj, (x, y) -> x));
//        log.info("statPOMap:{}", JSON.toJSONString(statPOMap));
        Map<Long, InteractionStatusRespVO> statusRespVOMap = interactionService.getUserInteractionMap(userId, TargetType.MODEL, modelIdList);
//        log.info("statusRespVOMap:{}", JSON.toJSONString(statusRespVOMap));
        return modelDetailPOList.stream().parallel().map(model -> {
            UserPO userPO = userPOMap.getOrDefault(model.getUserId(), userRepository.selectByName("aigccafe2023"));
            UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
            String coverPath = modelIdImageMap.get(model.getId());
            if (Strings.isEmpty(model.getCoverPath())) {
                model.setCoverPath(coverPath);
            }
            InteractionStatPO interactionStatPO = statPOMap.get(model.getId());
            InteractionStatusRespVO interactionStatusRespVO = statusRespVOMap.get(model.getId());
            InteractionStatRespVO statRespVO = InteractionStatRespVO.builder().build();
            if (interactionStatPO != null) {
                BeanUtils.copyProperties(interactionStatPO, statRespVO);
            }
            return ModelRespVO.builder()
                    .id(model.getId())
                    .modelName(model.getModelName())
                    .chnModelName(model.getChnModelName())
                    .type(model.getType())
                    .checkpointType(model.getCheckpointType())
                    .downloadCnt(model.getDownloadCnt())
                    .userId(userPO.getId())
                    .userName(userInfo.getNickname())
                    .avatarUrl(userInfo.getAvatarUrl())
                    .coverImgUrl(oosRepository.getSafeUrl(model.getCoverPath()))
                    .updatedAt(model.getUpdatedAt())
                    .interactionStat(statRespVO)
                    .interactionStatus(interactionStatusRespVO)
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public ModelDetailRespVO getModelDetail(Long modelId) {
        Long userId = 0L;
        if (StpUtil.isLogin()) {
            userId = StpUtil.getLoginIdAsLong();
        }
        ModelDetailPO modelDetailPO = modelRepository.selectModelDetailById(modelId);
        Preconditions.checkNotNull(modelDetailPO, "查询不到模型");
        List<ModelVersionPO> modelVersionPOList = modelRepository.selectVersionByModelId(modelId);
        ModelVersionPO firstVersion = modelVersionPOList.get(0);
        Map<String, Long> sortedVersionMap = Maps.newLinkedHashMap();
        for (ModelVersionPO version : modelVersionPOList) {
            sortedVersionMap.put(version.getVersionName(), version.getId());
        }
        UserPO userPO = userRepository.selectById(modelDetailPO.getUserId());
        ModelDetailRespVO detail = new ModelDetailRespVO();
        BeanUtils.copyProperties(modelDetailPO, detail);
        InteractionStatPO interactionStatPO = interactionRepository.selectInteractionStat(TargetType.MODEL, modelId);
        InteractionStatRespVO statRespVO = InteractionStatRespVO.builder().build();
        if (interactionStatPO != null) {
            BeanUtils.copyProperties(interactionStatPO, statRespVO);
        }
        Map<Long, InteractionStatusRespVO> interactionStatusMap = interactionService.getUserInteractionMap(userId,
                TargetType.MODEL, Collections.singletonList(modelId));

        detail.setInteractionStat(statRespVO);
        detail.setUserInfo(JSON.parseObject(userPO.getInfo(), UserInfo.class));
        detail.setVersionMap(sortedVersionMap);
        detail.setOriUrl(String.format("https://civitai.com/models/%s", modelDetailPO.getOriModelId()));
        ModelVersionDetailRespVO versionDetail = makeUpVersionInfo(firstVersion);
        detail.setFirstVersion(versionDetail);
        detail.setInteractionStatus(interactionStatusMap.get(modelId));
        return detail;
    }

    @Override
    public ModelVersionDetailRespVO getVersionDetail(Long modelId, Long versionId) {
        ModelVersionPO firstVersion = modelRepository.selectVersionById(versionId);
        return makeUpVersionInfo(firstVersion);
    }

    @Override
    public JSONObject getImagePrompt(Long imageId) {
        ModelVersionImagePOWithBLOBs modelInfo = modelRepository.selectImageById(imageId);
        String meta = modelInfo.getMeta();
        if (Strings.isEmpty(meta)) {
            meta = "{}";
        }
        return JSON.parseObject(meta);
    }

    private ModelVersionDetailRespVO makeUpVersionInfo(ModelVersionPO firstVersion) {
        if (firstVersion == null) {
            return null;
        }
        List<ModelVersionFilePO> versionFileList = modelRepository.selectFileByVersionId(firstVersion.getId());
        List<SimpleImagePO> versionImageList = modelRepository.selectSimpleImageByVersionId(firstVersion.getId());

        ModelVersionDetailRespVO versionDetail = new ModelVersionDetailRespVO();
        BeanUtils.copyProperties(firstVersion, versionDetail);

        List<ModelVersionFileDetailRespVO> files = versionFileList.stream().map(file -> {
            ModelVersionFileDetailRespVO fileResp = new ModelVersionFileDetailRespVO();
            BeanUtils.copyProperties(file, fileResp);
            if (Strings.isNotEmpty(file.getUrl())) {
                fileResp.setRawUrl(file.getUrl());
            } else {
                fileResp.setRawUrl(makeUpDownloadUrl(file.getOriVersionId(), file.getType(), file.getMetadata()));
            }
            return fileResp;
        }).collect(Collectors.toList());
        versionDetail.setFiles(files);

        List<SimpleVersionImageRespVO> images = versionImageList.stream().map(image -> {
            SimpleVersionImageRespVO imageRespVO = new SimpleVersionImageRespVO();
            BeanUtils.copyProperties(image, imageRespVO);
            imageRespVO.setVersionName(versionDetail.getVersionName());
            imageRespVO.setUrl(oosRepository.getSafeUrl(image.getNormalPath()));
            return imageRespVO;
        }).collect(Collectors.toList());
        versionDetail.setImages(images);
        return versionDetail;
    }

//    List<ModelVersionFilePO> reduceVersionFile(List<ModelVersionFilePO> modelVersionFilePOList) {
//        List<ModelVersionFilePO> destList = Lists.newArrayList();
//        // 如果只有一个文件，则直接返回
//        if (modelVersionFilePOList.size() <= 1) {
//            return modelVersionFilePOList;
//        }
//        // 先按format来进行筛选
//        Map<String, List<ModelVersionFilePO>> res = modelVersionFilePOList.stream()
//                .collect(Collectors.groupingBy(file -> {
//                    JSONObject data = JSON.parseObject(file.getMetadata());
//                    String format = data.getString("format");
//                    if (Strings.isEmpty(format)) {
//                        format = "Other";
//                    }
//                    return format;
//                }, Collectors.toList()));
//
//        List<ModelVersionFilePO> firstLevelList = Lists.newArrayList();
//        if (res.containsKey("SafeTensor")) {
//            firstLevelList = res.get("SafeTensor");
//        } else if (res.containsKey("PickleTensor")) {
//            firstLevelList = res.get("PickleTensor");
//        }
//        List<ModelVersionFilePO> firstOtherList = Lists.newArrayList();
//        if (res.containsKey("Other")) {
//            firstOtherList = res.get("Other");
//        }
//
//        res = firstLevelList.stream().collect(Collectors.groupingBy(file -> {
//                    JSONObject data = JSON.parseObject(file.getMetadata());
//                    String format = data.getString("fp");
//                    if (Strings.isEmpty(format)) {
//                        format = "Other";
//                    }
//                    return format;
//                }, Collectors.toList()));
//
//
//
//    }

    @Override
    public ModelInfoRespVO getModelFileInfo(Long modelId) {
        ModelDetailPO modelDetailPO = modelRepository.selectModelDetailById(modelId);
        Preconditions.checkNotNull(modelDetailPO, "查询不到模型");
        List<ModelVersionPO> modelVersionPOList = modelRepository.selectVersionByModelId(modelId);
        Map<Long, List<ModelVersionFilePO>> versionFileListMap = modelRepository.selectFileByModelId(modelId)
                .stream().collect(Collectors.groupingBy(ModelVersionFilePO::getVersionId, Collectors.toList()));

        List<ModelVersionInfoRespVO> versionInfoList = Lists.newArrayList();
        for (ModelVersionPO versionPO : modelVersionPOList) {
            List<ModelVersionFileInfoRespVO> fileInfoVOList = Lists.newArrayList();
            List<ModelVersionFilePO> modelVersionFilePOList = versionFileListMap.get(versionPO.getId());
            for (ModelVersionFilePO filePO : modelVersionFilePOList) {
                ModelVersionFileInfoRespVO fileInfoVO = ModelVersionFileInfoRespVO.builder()
                        .fileId(filePO.getId())
                        .fileName(filePO.getName())
                        .sizeKB(filePO.getSizekb())
                        .type(filePO.getType())
                        .metadata(filePO.getMetadata())
                        .downloadUrl(makeUpDownloadUrl(versionPO.getOriVersionId(), filePO.getType(), filePO.getMetadata()))
                        .transferUrl(filePO.getUrl())
                        .build();
                fileInfoVOList.add(fileInfoVO);
            }
            ModelVersionInfoRespVO versionInfoVO = ModelVersionInfoRespVO.builder()
                    .versionId(versionPO.getId())
                    .versionName(versionPO.getVersionName())
                    .baseModel(versionPO.getBaseModel())
                    .fileList(fileInfoVOList)
                    .build();

            versionInfoList.add(versionInfoVO);
        }
        Map<Long, ModelFileCountPO> cntMap = modelRepository.countModelFile(Collections.singletonList(modelId));
        ModelFileCountPO modelFileCount = cntMap.get(modelId);
        ModelInfoRespVO modelInfoRespVO = ModelInfoRespVO.builder()
                .id(modelDetailPO.getId())
                .modelName(modelDetailPO.getModelName())
                .type(modelDetailPO.getType())
                .checkpointType(modelDetailPO.getCheckpointType())
                .versionCnt(modelFileCount.getVersionCnt())
                .fileCnt(modelFileCount.getFileCnt())
                .unTransferFileCnt(modelFileCount.getUnTransferFileCnt())
                .versionList(versionInfoList)
                .build();
        return modelInfoRespVO;
    }

    @Override
    public ReviewModelListRespVO getModelListByStatus(ModelStatus modelStatus, Integer offset, Integer number) {
        List<ModelDetailPO> modelDetailPOList = modelRepository.selectModelListByStatus(modelStatus, offset, number);
        Long total = modelRepository.countByStatus(modelStatus);
        List<Long> modelIdList = modelDetailPOList.stream().map(ModelDetailPO::getId).collect(Collectors.toList());
        Map<Long, List<ModelVersionImagePO>> modelVersionImagePOList = modelRepository.selectModelImageListByModelIdList(modelIdList)
                .stream()
                .collect(Collectors.groupingBy(ModelVersionImagePO::getModelId, Collectors.toList()));

        List<ReviewModelRespVO> result = Lists.newArrayList();
        for (ModelDetailPO model : modelDetailPOList) {
//            log.info("id:{}", model.getId());
            Map<String, List<SimpleVersionImageRespVO>> versionImageListMap = Maps.newHashMap();
            if (modelVersionImagePOList.containsKey(model.getId())) {
                versionImageListMap = modelVersionImagePOList.get(model.getId()).stream().parallel()
                        .map(imagePO -> SimpleVersionImageRespVO.builder()
                                .versionName(imagePO.getVersionName())
                                .id(imagePO.getId())
                                .url(oosRepository.getSafeUrl(imagePO.getNormalPath()))
                                .path(imagePO.getNormalPath())
                                .build())
                        .collect(Collectors.groupingBy(SimpleVersionImageRespVO::getVersionName, Collectors.toList()));
            }

            ReviewModelRespVO modelRespVO = ReviewModelRespVO.builder()
                    .id(model.getId())
                    .modelName(model.getModelName())
                    .type(model.getType())
                    .checkpointType(model.getCheckpointType())
                    .description(model.getDescription())
                    .status(model.getStatus())
                    .images(versionImageListMap)
                    .build();
            result.add(modelRespVO);
        }
        return ReviewModelListRespVO.builder()
                .modelList(result)
                .total(total)
                .build();
    }


    @Override
    public Boolean updateTransferUrl(Long fileId, String url) {
        ModelVersionFilePO filePO = modelRepository.selectFileById(fileId);
        filePO.setUrl(url);
        log.info("fileInfo:{}", JSON.toJSONString(filePO));
        return modelRepository.update(filePO) > 0;
    }

    @Override
    public Boolean updateModelStatus(Long modelId, ModelStatus status) {
        boolean res = false;
        ModelDetailPO modelDetailPO = modelRepository.selectModelDetailById(modelId);
        if (modelDetailPO != null) {
            modelDetailPO.setStatus(status.name());
            res = modelRepository.update(modelDetailPO) > 0;
        }
        return res;
    }

    @Override
    public Boolean updateModelTags(Long modelId, String tags) {
        boolean res = false;
        ModelDetailPO modelDetailPO = modelRepository.selectModelDetailById(modelId);
        if (modelDetailPO != null) {
            modelDetailPO.setManualTags(tags);
            res = modelRepository.update(modelDetailPO) > 0;
        }
        return res;
    }

    @Override
    public Boolean updateReviewedModel(ModelReviewUpdateReqVO model) {
        Preconditions.checkNotNull(model, "参数为空");
        Preconditions.checkNotNull(model.getModelId(), "参数为空");
        Long modelId = model.getModelId();
        List<String> chManualTagList = Lists.newArrayList();
        if (Strings.isNotEmpty(model.getTags())) {
            String[] tagList = model.getTags().split(",");
            for (String tag : tagList) {
                Channel channel = Channel.valueOf(tag);
                chManualTagList.add(channel.getDesc());
            }
        }
        String chManualTags = Strings.join(chManualTagList, ',');
        ModelDetailPO modelDetailPO = modelRepository.selectModelDetailById(modelId);
        modelDetailPO.setManualTags(chManualTags);
        modelDetailPO.setStatus(model.getStatus());
        modelDetailPO.setCoverPath(model.getCoverPath());
        return modelRepository.update(modelDetailPO) > 0;
    }

    @Override
    public Boolean updateModelDetail(ModelDetailReqVO modelDetailReqVO) {
        ModelDetailPO modelDetailPO = new ModelDetailPO();
        BeanUtils.copyProperties(modelDetailReqVO, modelDetailPO);
        return modelRepository.update(modelDetailPO) > 0;
    }

    @Override
    public Boolean updateModelVersion(ModelVersionReqVO modelVersionReqVO) {
        ModelVersionPO modelVersionPO = new ModelVersionPO();
        BeanUtils.copyProperties(modelVersionReqVO, modelVersionPO);
        return modelRepository.update(modelVersionPO) > 0;
    }

    @Override
    public Boolean updateModelVersionFile(ModelVersionFileReqVO modelVersionFileReqVO) {
        ModelVersionFilePO modelVersionFilePO = new ModelVersionFilePO();
        BeanUtils.copyProperties(modelVersionFileReqVO, modelVersionFilePO);
        return modelRepository.update(modelVersionFilePO) > 0;
    }

    @Override
    public Boolean updateModelVersionImage(ModelVersionImageReqVO modelVersionImageReqVO) {
        ModelVersionImagePOWithBLOBs modelVersionImagePO = new ModelVersionImagePOWithBLOBs();
        BeanUtils.copyProperties(modelVersionImageReqVO, modelVersionImagePO);
        return modelRepository.update(modelVersionImagePO) > 0;
    }

    @Override
    public Boolean deleteImage(Long imageId) {
        return modelRepository.deleteModelImageById(imageId) > 0;
    }

    @Override
    public Boolean setCoverImage(Long modelId, Long imageId) {
        ModelDetailPO modelDetailPO = modelRepository.selectModelDetailById(modelId);
        ModelVersionImagePO imagePO = modelRepository.selectModelImage(imageId);
        modelDetailPO.setCoverPath(imagePO.getRawPath());
        return modelRepository.update(modelDetailPO) > 0;
    }

    @Override
    public String getDownloadUrl(String url) {
        if (url.contains("aigccafe.work")) {
            return url;
        }
        HttpRequestConfig requestConfig = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
//                .url(String.format("http://45.91.82.87:8012/transfer?url=%s", url))
                .url(String.format("http://38.55.109.9/forward?url=%s",url))
                .clientType(ClientType.HTTPCLIENT)
                .useProxy(false)
                .retry(5)
                .build();
        try {
            String res = httpService.requestRawText(requestConfig);
            log.info("请求返回：" + res);
            String pattern = "^['\"](.*)['\"]$";
            Pattern regex = Pattern.compile(pattern);
            Matcher matcher = regex.matcher(res);

            if (matcher.matches()) {
                return matcher.group(1);
            } else {
                return res;
            }
        } catch (Exception exp) {
            throw new RuntimeException("获取下载地址失败，请加群联系客服");
        }
    }

    private String makeUpDownloadUrl(Long versionId, String fileType, String metaData) {
        JSONObject meta = JSON.parseObject(metaData);
        String size = meta.getString("size");
        String format = meta.getString("format");
        String fp = meta.getString("fp");
        List<String> paramList = Lists.newArrayList();
        paramList.add(String.format("type=%s", URLEncoder.encode(fileType)));
        if (size != null) {
            paramList.add(String.format("size=%s", URLEncoder.encode(size)));
        }
        if (format != null) {
            paramList.add(String.format("format=%s", URLEncoder.encode(format)));
        }
        if (fp != null) {
            paramList.add(String.format("fp=%s", URLEncoder.encode(fp)));
        }
        String paramStr = Strings.join(paramList, '&');
        String url = String.format("https://civitai.com/api/download/models/%s?", versionId);
        return url + paramStr;
    }

    @Override
    public Map<String, String> getEnumInfo(EnumType enumType) {
        Map<String, String> enumInfo = Maps.newLinkedHashMap();
        if (EnumType.MODEL_TYPE.equals(enumType)) {
            for (ModelType modelType : ModelType.values()) {
                enumInfo.put(modelType.getValue(), modelType.name());
            }
        } else if (EnumType.CHANNEL.equals(enumType)) {
            for (Channel channel : Channel.values()) {
                enumInfo.put(channel.getDesc(), channel.name());
            }
        } else if (EnumType.BASE_MODEL.equals(enumType)) {
            enumInfo.put("SD 1.4", "SD 1.4");
            enumInfo.put("SD 1.5", "SD 1.5");
            enumInfo.put("SD 2.0", "SD 2.0");
            enumInfo.put("SD 2.0 768", "SD 2.0 768");
            enumInfo.put("SD 2.1", "SD 2.1");
            enumInfo.put("SD 2.1 768", "SD 2.1 768");
            enumInfo.put("SDXL 1.0", "SDXL 1.0");
            enumInfo.put("Other", "Other");
        }
        return enumInfo;
    }
}
