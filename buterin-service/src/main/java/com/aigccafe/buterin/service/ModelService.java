package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.EnumType;
import com.aigccafe.buterin.common.enumerate.ModelSortedType;
import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.md.ModelStatus;
import com.aigccafe.buterin.common.model.req.*;
import com.aigccafe.buterin.common.model.resp.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface ModelService {

    List<SimpleModelRespVO> getModelSimpleListByRank(Integer offset, Integer number);

    List<ModelRespVO> searchModelList(String keyword, Integer offset, Integer number);

    List<ModelRespVO> getModelListByCondition(List<String> baseModelList, List<String> modelTypeList, String channel, Integer offset, Integer number, ModelSortedType sortedType);

    List<ModelRespVO> makeUpModelRespVO(List<ModelDetailPO> modelDetailPOList);

    ReviewModelListRespVO getModelListByStatus(ModelStatus modelStatus, Integer offset, Integer number);

    ModelInfoRespVO getModelFileInfo(Long modelId);

    ModelDetailRespVO getModelDetail(Long modelId);

    ModelVersionDetailRespVO getVersionDetail(Long modelId, Long versionId);

    JSONObject getImagePrompt(Long imageId);

    Boolean updateTransferUrl(Long fileId, String url);

    Boolean updateModelStatus(Long modelId, ModelStatus status);

    Boolean updateModelTags(Long modelId, String tags);

    Boolean setCoverImage(Long modelId, Long imageId);

    Boolean updateReviewedModel(ModelReviewUpdateReqVO model);

    Boolean updateModelDetail(ModelDetailReqVO modelDetailReqVO);

    Boolean updateModelVersion(ModelVersionReqVO modelVersionReqVO);

    Boolean updateModelVersionFile(ModelVersionFileReqVO modelVersionFileReqVO);

    Boolean updateModelVersionImage(ModelVersionImageReqVO modelVersionImageReqVO);

    Boolean deleteImage(Long imageId);

    String getDownloadUrl(String url);

    Map<String, String> getEnumInfo(EnumType enumType);
}
