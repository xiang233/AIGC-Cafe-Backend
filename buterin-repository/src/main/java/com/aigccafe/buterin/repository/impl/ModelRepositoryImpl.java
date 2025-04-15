package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.enumerate.ModelSortedType;
import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.model.md.*;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.repository.mapper.*;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
@Slf4j
public class ModelRepositoryImpl implements ModelRepository {

    @Autowired
    private ModelDetailPOMapper modelPOMapper;
    @Autowired
    private ModelVersionPOMapper modelVersionPOMapper;
    @Autowired
    private ModelVersionFilePOMapper modelVersionFilePOMapper;
    @Autowired
    private ModelVersionImagePOMapper modelVersionImagePOMapper;
    @Autowired
    private ModelExtendMapper modelExtendMapper;
    @Autowired
    private StableGalleryImagePOMapper stableGalleryImagePOMapper;

    @Override
    public Long update(ModelDetailPO modelPO) {
        if (modelPO.getId() == null) {
            modelPO.setCreatedAt(DateTimeUtils.nowSeconds());
            modelPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelPO.setIsDeleted(false);
            try {
                modelPOMapper.insert(modelPO);
            } catch (DuplicateKeyException e) {
                log.info("记录已存在");
            }
        } else {
            modelPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelPOMapper.updateByPrimaryKeySelective(modelPO);
        }
        return modelPO.getId();
    }

    @Override
    public Long update(ModelVersionPO modelVersionPO) {
        if (modelVersionPO.getId() == null) {
            modelVersionPO.setCreatedAt(DateTimeUtils.nowSeconds());
            modelVersionPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelVersionPO.setIsDeleted(false);
            try {
                modelVersionPOMapper.insertSelective(modelVersionPO);
            } catch (DuplicateKeyException e) {
                log.info("记录已存在");
            }
        } else {
            modelVersionPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelVersionPOMapper.updateByPrimaryKeySelective(modelVersionPO);
        }
        return modelVersionPO.getId();
    }

    @Override
    public Long update(ModelVersionFilePO modelVersionFilePO) {
        if (modelVersionFilePO.getId() == null) {
            modelVersionFilePO.setCreatedAt(DateTimeUtils.nowSeconds());
            modelVersionFilePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelVersionFilePO.setIsDeleted(false);
            try {
                modelVersionFilePOMapper.insertSelective(modelVersionFilePO);
            } catch (DuplicateKeyException e) {
                log.info("记录已存在");
            }
        } else {
            modelVersionFilePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            int res = modelVersionFilePOMapper.updateByPrimaryKey(modelVersionFilePO);
            log.info("更新结果：{}", res);
        }
        return modelVersionFilePO.getId();
    }

    @Override
    public Long update(ModelVersionImagePOWithBLOBs modelVersionImagePO) {
        if (modelVersionImagePO.getId() == null) {
            modelVersionImagePO.setCreatedAt(DateTimeUtils.nowSeconds());
            modelVersionImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelVersionImagePO.setIsDeleted(false);
            try {
                modelVersionImagePOMapper.insertSelective(modelVersionImagePO);
            } catch (DuplicateKeyException e) {
                log.info("记录已存在");
            }
        } else {
            modelVersionImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            modelVersionImagePOMapper.updateByPrimaryKeySelective(modelVersionImagePO);
        }
        return modelVersionImagePO.getId();
    }

    @Override
    public Long update(StableGalleryImagePOWithBLOBs stableGalleryImagePO) {
        if (stableGalleryImagePO.getId() == null) {
            stableGalleryImagePO.setCreatedAt(DateTimeUtils.nowSeconds());
            stableGalleryImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            stableGalleryImagePO.setIsDeleted(false);
            try {
                stableGalleryImagePOMapper.insertSelective(stableGalleryImagePO);
            } catch (DuplicateKeyException e) {
                log.info("记录已存在");
            }
        } else {
            stableGalleryImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            stableGalleryImagePOMapper.updateByPrimaryKeySelective(stableGalleryImagePO);
        }
        return stableGalleryImagePO.getId();
    }


    @Override
    public int deleteModelImageById(Long imageId) {
        ModelVersionImagePO imagePO = modelVersionImagePOMapper.selectByPrimaryKey(imageId);
        imagePO.setIsDeleted(true);
        return modelVersionImagePOMapper.updateByPrimaryKey(imagePO);
    }

    @Override
    public ModelDetailPO selectModelDetailById(Long id) {
        return modelPOMapper.selectByPrimaryKey(id);
    }

    @Override
    public ModelDetailPO selectModelDetailByOriId(Long oriModelId) {
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        criteria.andOriModelIdEqualTo(oriModelId);
        List<ModelDetailPO> modelDetailPOList = modelPOMapper.selectByExample(example);
        return modelDetailPOList.size() > 0 ? modelDetailPOList.get(0) : null;
    }

    @Override
    public List<ModelDetailPO> selectModelListByStatus(ModelStatus status, Integer offset, Integer number) {
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status.name());
        }
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(offset, number);
        example.setOrderByClause("id asc");
        return modelPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<ModelDetailPO> selectUntranslatedModelList(Integer number, List<Long> blackIdList) {
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(ModelStatus.ONLINE.name());
        criteria.andChnDescriptionIsNull();
        if (CollectionUtils.isNotEmpty(blackIdList)) {
            criteria.andIdNotIn(blackIdList);
        }
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(0, number);
        return modelPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public Long countByStatus(ModelStatus status) {
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status.name());
        }
        criteria.andIsDeletedEqualTo(false);
        return modelPOMapper.countByExample(example);
    }

    @Override
    public ModelVersionFilePO selectFileById(Long id) {
        return modelVersionFilePOMapper.selectByPrimaryKey(id);
    }

    @Override
    public ModelVersionFilePO selectFileByOriId(Long oriModelId, Long oriVersionId, Long oriFileId) {
        ModelVersionFilePOExample example = new ModelVersionFilePOExample();
        ModelVersionFilePOExample.Criteria criteria = example.createCriteria();
        criteria.andOriModelIdEqualTo(oriModelId).andOriVersionIdEqualTo(oriVersionId).andOriFileIdEqualTo(oriFileId);
        List<ModelVersionFilePO> modelVersionFilePOList = modelVersionFilePOMapper.selectByExample(example);
        return modelVersionFilePOList.size() > 0 ? modelVersionFilePOList.get(0) : null;
    }

    @Override
    // TODO: 模型更新顺序目前应当按照创建时间，目前不支持，只能按版本名称
    public List<ModelVersionPO> selectVersionByModelId(Long id) {
        ModelVersionPOExample example = new ModelVersionPOExample();
        ModelVersionPOExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(id).andIsDeletedEqualTo(false);
        example.setOrderByClause("version_name desc");
        return modelVersionPOMapper.selectByExample(example);
    }

    @Override
    public ModelVersionPO selectVersionByOriVersionId(Long oriModelId, Long oriVersionId) {
        ModelVersionPOExample example = new ModelVersionPOExample();
        ModelVersionPOExample.Criteria criteria = example.createCriteria();
        criteria.andOriModelIdEqualTo(oriModelId).andOriVersionIdEqualTo(oriVersionId);
        List<ModelVersionPO> modelVersionPOList = modelVersionPOMapper.selectByExample(example);
        return modelVersionPOList.size() > 0 ? modelVersionPOList.get(0) : null;
    }

    @Override
    public List<ModelVersionFilePO> selectFileByModelId(Long id) {
        ModelVersionFilePOExample example = new ModelVersionFilePOExample();
        ModelVersionFilePOExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(id).andIsDeletedEqualTo(false);
        return modelVersionFilePOMapper.selectByExample(example);
    }

    @Override
    public List<ModelVersionFilePO> selectFileByVersionId(Long id) {
        ModelVersionFilePOExample example = new ModelVersionFilePOExample();
        ModelVersionFilePOExample.Criteria criteria = example.createCriteria();
        criteria.andVersionIdEqualTo(id).andIsDeletedEqualTo(false);
        return modelVersionFilePOMapper.selectByExample(example);
    }


    @Override
    public List<SimpleImagePO> selectSimpleImageByModelId(Long id) {
        return modelExtendMapper.selectSimpleImageByModelId(id);
    }

    @Override
    public List<SimpleImagePO> selectSimpleImageByVersionId(Long id) {
        return modelExtendMapper.selectSimpleImageByVersionId(id);
    }


    @Override
    public List<ModelDetailPO> selectModelDetailListByOffset(Integer offset, Integer number) {
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(offset, number);
        return modelPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<ModelDetailPO> selectModelDetailListByIdList(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Lists.newArrayList();
        }
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(idList)) {
            criteria.andIdIn(idList);
        }
        criteria.andIsDeletedEqualTo(false);
        return modelPOMapper.selectByExample(example);
    }

    @Override
    public ModelVersionPO selectVersionById(Long versionId) {
        return modelVersionPOMapper.selectByPrimaryKey(versionId);
    }

    @Override
    public List<ModelDetailPO> selectModelListByCondition(List<String> baseModelList, List<String> typeList, String channel, Integer offset, Integer number, ModelSortedType sortedType) {
        ModelDetailPOExample example = new ModelDetailPOExample();
        ModelDetailPOExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(baseModelList)) {
            criteria.andBaseModelIn(baseModelList);
        }
        if (CollectionUtils.isNotEmpty(typeList)) {
            criteria.andTypeIn(typeList);
        }
        if (!Strings.isEmpty(channel)) {
            criteria.andManualTagsLike("%" + channel + "%");
        }
        criteria.andStatusEqualTo(ModelStatus.ONLINE.name());
        criteria.andIsDeletedEqualTo(false);
        if (ModelSortedType.DOWNLOAD.equals(sortedType)) {
            example.setOrderByClause("download_cnt desc");
        }
        if (ModelSortedType.NEWEST.equals(sortedType)) {
            example.setOrderByClause("updated_at desc");
        }
        RowBounds rowBounds = new RowBounds(offset, number);
        return modelPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<ModelVersionImagePO> selectModelImageListByModelIdList(List<Long> modelList) {
        ModelVersionImagePOExample example = new ModelVersionImagePOExample();
        ModelVersionImagePOExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        if (!CollectionUtils.isEmpty(modelList)) {
            criteria.andModelIdIn(modelList);
        }
        return modelVersionImagePOMapper.selectByExample(example);
    }

    @Override
    public ModelVersionImagePO selectModelImage(Long id) {
        return modelVersionImagePOMapper.selectByPrimaryKey(id);
    }

    @Override
    public ModelVersionImagePOWithBLOBs selectImageByOriId(Long oriModelId, Long oriVersionId, Long oriImageId) {
        ModelVersionImagePOExample example = new ModelVersionImagePOExample();
        ModelVersionImagePOExample.Criteria criteria = example.createCriteria();
        criteria.andOriModelIdEqualTo(oriModelId).andOriVersionIdEqualTo(oriVersionId).andOriImageIdEqualTo(oriImageId);
        List<ModelVersionImagePOWithBLOBs> modelVersionImagePOList = modelVersionImagePOMapper.selectByExampleWithBLOBs(example);
        return modelVersionImagePOList.size()>0 ? modelVersionImagePOList.get(0) : null;
    }

    @Override
    public List<ModelVersionImagePOWithBLOBs> selectImageByCondition(List<Long> idList, Integer offset, Integer number) {
        ModelVersionImagePOExample example = new ModelVersionImagePOExample();
        ModelVersionImagePOExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(idList)) {
            criteria.andIdIn(idList);
        }
        criteria.andIsDeletedEqualTo(false);
        criteria.andNsfwEqualTo(false);
        example.setOrderByClause("url desc");
        RowBounds rowBounds = new RowBounds(offset, number);
        return modelVersionImagePOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public List<StableGalleryImagePO> selectStableImageByCondition(List<Long> idList, Integer offset, Integer number, PromptSortedType sortedType, PromptStatus status) {
        StableGalleryImagePOExample example = new StableGalleryImagePOExample();
        StableGalleryImagePOExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(idList)) {
            criteria.andIdIn(idList);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status.name());
        }
        criteria.andIsDeletedEqualTo(false);
        if (PromptSortedType.NEWEST.equals(sortedType)) {
            example.setOrderByClause("updated_at desc");
        }
        if (PromptSortedType.VIEW.equals(sortedType)) {
            example.setOrderByClause("view_cnt desc");
        }
        RowBounds rowBounds = new RowBounds(offset, number);
        return stableGalleryImagePOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<StableGalleryImagePOWithBLOBs> selectUnTranslateImageByCondition(PromptStatus status) {
        StableGalleryImagePOExample example = new StableGalleryImagePOExample();
        StableGalleryImagePOExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status.name());
        }
        criteria.andIsDeletedEqualTo(false);
        return stableGalleryImagePOMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public StableGalleryImagePOWithBLOBs selectStableImageById(Long id) {
        StableGalleryImagePOExample example = new StableGalleryImagePOExample();
        StableGalleryImagePOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andIsDeletedEqualTo(false);
        List<StableGalleryImagePOWithBLOBs> stableGalleryImagePOS = stableGalleryImagePOMapper.selectByExampleWithBLOBs(example);
        return stableGalleryImagePOS.size() > 0 ? stableGalleryImagePOS.get(0) : null;
    }

    @Override
    public ModelVersionImagePOWithBLOBs selectImageById(Long imageId) {
        return modelVersionImagePOMapper.selectByPrimaryKey(imageId);
    }

    @Override
    public Map<Long, ModelFileCountPO> countModelFile(List<Long> idList) {
        String idListStr = Strings.join(idList, ',');
//        log.info("idList:" + idListStr);
        List<ModelFileCountPO> modelFileCountPOList = modelExtendMapper.countModelFile(idListStr);
//        log.info("modelFileCountPOList size:{}", modelFileCountPOList.size());
//        log.info("modelFileCountPOList:{}", JSON.toJSONString(modelFileCountPOList));
        return modelFileCountPOList.stream().collect(Collectors.toMap(ModelFileCountPO::getModelId, obj -> obj));
    }


}
