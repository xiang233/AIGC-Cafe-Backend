package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.enumerate.ModelSortedType;
import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.model.md.*;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;

import java.util.List;
import java.util.Map;

public interface ModelRepository {

    Long update(ModelDetailPO modelPO);

    Long update(ModelVersionPO modelVersionPO);

    Long update(ModelVersionFilePO modelVersionFilePO);

    Long update(ModelVersionImagePOWithBLOBs modelVersionImagePO);

    Long update(StableGalleryImagePOWithBLOBs stableGalleryImagePO);

    int deleteModelImageById(Long imageId);

    ModelDetailPO selectModelDetailById(Long id);

    ModelDetailPO selectModelDetailByOriId(Long oriModelId);

    List<ModelDetailPO> selectModelListByStatus(ModelStatus status, Integer offset, Integer number);

    List<ModelDetailPO> selectUntranslatedModelList(Integer number, List<Long> blackIdList);

    Long countByStatus(ModelStatus status);

    List<ModelDetailPO> selectModelListByCondition(List<String> baseModelList, List<String> typeList, String channel, Integer offset, Integer number, ModelSortedType sortedType);

    ModelVersionPO selectVersionById(Long versionId);

    List<ModelVersionPO> selectVersionByModelId(Long id);

    ModelVersionPO selectVersionByOriVersionId(Long oriModelId, Long oriVersionId);

    List<ModelVersionFilePO> selectFileByModelId(Long id);

    List<ModelVersionFilePO> selectFileByVersionId(Long id);

    List<SimpleImagePO> selectSimpleImageByModelId(Long id);

    List<SimpleImagePO> selectSimpleImageByVersionId(Long id);

    ModelVersionFilePO selectFileById(Long id);

    ModelVersionFilePO selectFileByOriId(Long oriModelId, Long oriVersionId, Long oriFileId);

    List<ModelDetailPO> selectModelDetailListByOffset(Integer offset, Integer number);

    List<ModelDetailPO> selectModelDetailListByIdList(List<Long> idList);

    ModelVersionImagePO selectModelImage(Long id);

    List<ModelVersionImagePO> selectModelImageListByModelIdList(List<Long> modelList);

    ModelVersionImagePOWithBLOBs selectImageByOriId(Long oriModelId, Long oriVersionId, Long oriImageId);

    ModelVersionImagePOWithBLOBs selectImageById(Long imageId);

    List<ModelVersionImagePOWithBLOBs> selectImageByCondition(List<Long> idList, Integer offset, Integer number);

    List<StableGalleryImagePO> selectStableImageByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType, PromptStatus status);

    List<StableGalleryImagePOWithBLOBs> selectUnTranslateImageByCondition(PromptStatus status);

    StableGalleryImagePOWithBLOBs selectStableImageById(Long id);

    Map<Long, ModelFileCountPO> countModelFile(List<Long> idList);
}
