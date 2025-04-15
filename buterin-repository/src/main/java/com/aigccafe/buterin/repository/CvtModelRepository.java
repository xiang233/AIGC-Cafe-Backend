package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.enumerate.ModelType;
import com.aigccafe.buterin.common.model.cvt.*;

import java.util.List;

public interface CvtModelRepository {

    CvtModelDetectPO selectDetectByModelId(Long modelId);

    CvtModelDetailPOWithBLOBs selectCvtDetailByModelId(Long modelId);

    CvtModelDetailPO selectSimpleCvtDetailByModelId(Long modelId);

    List<CvtModelVersionImagePOWithBLOBs> selectModelVersionImageList(Long modelId, Long versionId);

    CvtModelVersionImagePO selectSimpleCvtVersionImageByImageId(Long imageId);

    List<CvtModelDetectPO> getNotUpdatedModelList(ModelType modelType, Integer num);

    List<CvtModelDetailPOWithBLOBs> getVersionImageNotUpdateModelList(Integer num);

    List<CvtModelDetailPOWithBLOBs> getNotMergedModelList(Integer num, String type);

    int setModelDetailUpdated(Long modelId);

    int setModelVersionImageUpdated(Long modelId);

    int update(CvtModelDetectPO cvtModelDetectPO);

    int update(CvtModelDetailPOWithBLOBs cvtModelDetailPO);

    int update(CvtModelVersionImagePOWithBLOBs cvtModelVersionImagePO);
}
