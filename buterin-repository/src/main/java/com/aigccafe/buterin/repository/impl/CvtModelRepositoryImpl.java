package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.enumerate.ModelType;
import com.aigccafe.buterin.common.model.cvt.*;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.repository.CvtModelRepository;
import com.aigccafe.buterin.repository.mapper.CvtModelDetailPOMapper;
import com.aigccafe.buterin.repository.mapper.CvtModelDetectPOMapper;
import com.aigccafe.buterin.repository.mapper.CvtModelVersionImagePOMapper;
import com.google.common.base.Strings;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CvtModelRepositoryImpl implements CvtModelRepository {

    @Autowired
    private CvtModelDetectPOMapper cvtModelDetectPOMapper;
    @Autowired
    private CvtModelDetailPOMapper cvtModelDetailPOMapper;
    @Autowired
    private CvtModelVersionImagePOMapper cvtModelVersionImagePOMapper;

    @Override
    public CvtModelDetectPO selectDetectByModelId(Long modelId) {
        CvtModelDetectPOExample example = new CvtModelDetectPOExample();
        CvtModelDetectPOExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(modelId).andIsDeletedEqualTo(false);
        List<CvtModelDetectPO> cvtModelDetectPOS = cvtModelDetectPOMapper.selectByExample(example);
        return cvtModelDetectPOS.size()>0 ? cvtModelDetectPOS.get(0) : null;
    }

    @Override
    public List<CvtModelDetectPO> getNotUpdatedModelList(ModelType modelType, Integer num) {
        CvtModelDetectPOExample example = new CvtModelDetectPOExample();
        CvtModelDetectPOExample.Criteria criteria = example.createCriteria();
        criteria.andModelTypeEqualTo(modelType.getValue());
        criteria.andDetailUpdateEqualTo(false).andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(0, num);
        return cvtModelDetectPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public int setModelDetailUpdated(Long modelId) {
        CvtModelDetectPO cvtModelDetectPO = selectDetectByModelId(modelId);
        cvtModelDetectPO.setDetailUpdate(true);
        return update(cvtModelDetectPO);
    }

    @Override
    public int setModelVersionImageUpdated(Long modelId) {
        CvtModelDetailPO detail = selectSimpleCvtDetailByModelId(modelId);
        detail.setVersionImageUpdate(true);
        return cvtModelDetailPOMapper.updateByPrimaryKey(detail);
    }

    @Override
    public CvtModelDetailPOWithBLOBs selectCvtDetailByModelId(Long modelId) {
        CvtModelDetailPOExample example = new CvtModelDetailPOExample();
        CvtModelDetailPOExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(modelId).andIsDeletedEqualTo(false);
        List<CvtModelDetailPOWithBLOBs> cvtModelDetailPOList = cvtModelDetailPOMapper.selectByExampleWithBLOBs(example);
        return cvtModelDetailPOList.size() > 0 ? cvtModelDetailPOList.get(0) : null;
    }

    @Override
    public List<CvtModelDetailPOWithBLOBs> getVersionImageNotUpdateModelList(Integer num) {
        CvtModelDetailPOExample example = new CvtModelDetailPOExample();
        CvtModelDetailPOExample.Criteria criteria = example.createCriteria();
        criteria.andVersionImageUpdateEqualTo(false).andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(0, num);
        return cvtModelDetailPOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public List<CvtModelDetailPOWithBLOBs> getNotMergedModelList(Integer num, String type) {
        CvtModelDetailPOExample example = new CvtModelDetailPOExample();
        CvtModelDetailPOExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(type)) {
            criteria.andTypeEqualTo(type);
        }
        // 过滤掉不合时宜的内容
//        criteria.andNsfwEqualTo(false);
        // 取出还未merge的模型（有些可能是更新的）
        criteria.andMergedEqualTo(false).andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(0, num);
        example.setOrderByClause("id asc");
        return cvtModelDetailPOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public CvtModelDetailPO selectSimpleCvtDetailByModelId(Long modelId) {
        CvtModelDetailPOExample example = new CvtModelDetailPOExample();
        CvtModelDetailPOExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(modelId).andIsDeletedEqualTo(false);
        List<CvtModelDetailPO> cvtModelDetailPOList = cvtModelDetailPOMapper.selectByExample(example);
        return cvtModelDetailPOList.size()>0 ? cvtModelDetailPOList.get(0) : null;
    }

    @Override
    public List<CvtModelVersionImagePOWithBLOBs> selectModelVersionImageList(Long modelId, Long versionId) {
        CvtModelVersionImagePOExample example = new CvtModelVersionImagePOExample();
        CvtModelVersionImagePOExample.Criteria criteria = example.createCriteria();
        criteria.andModelIdEqualTo(modelId)
                .andModelVersionIdEqualTo(versionId)
                .andIsDeletedEqualTo(false);
        return cvtModelVersionImagePOMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public CvtModelVersionImagePO selectSimpleCvtVersionImageByImageId(Long imageId) {
        CvtModelVersionImagePOExample example = new CvtModelVersionImagePOExample();
        CvtModelVersionImagePOExample.Criteria criteria = example.createCriteria();
        criteria.andImageIdEqualTo(imageId);
        List<CvtModelVersionImagePO> cvtModelVersionImagePOList = cvtModelVersionImagePOMapper.selectByExample(example);
        return cvtModelVersionImagePOList.size()>0 ? cvtModelVersionImagePOList.get(0) : null;
    }

    @Override
    public int update(CvtModelDetectPO cvtModelDetectPO) {
        if (cvtModelDetectPO.getId() == null) {
            cvtModelDetectPO.setCreatedAt(DateTimeUtils.nowSeconds());
            cvtModelDetectPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            cvtModelDetectPO.setIsDeleted(false);
            return cvtModelDetectPOMapper.insertSelective(cvtModelDetectPO);
        } else {
            cvtModelDetectPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            return cvtModelDetectPOMapper.updateByPrimaryKeySelective(cvtModelDetectPO);
        }
    }

    @Override
    public int update(CvtModelDetailPOWithBLOBs cvtModelDetailPO) {
        if (cvtModelDetailPO.getId() == null) {
            cvtModelDetailPO.setCreatedAt(DateTimeUtils.nowSeconds());
            cvtModelDetailPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            cvtModelDetailPO.setIsDeleted(false);
            return cvtModelDetailPOMapper.insertSelective(cvtModelDetailPO);
        } else {
            cvtModelDetailPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            return cvtModelDetailPOMapper.updateByPrimaryKeySelective(cvtModelDetailPO);
        }
    }

    @Override
    public int update(CvtModelVersionImagePOWithBLOBs cvtModelVersionImagePO) {
        if (cvtModelVersionImagePO.getId() == null) {
            cvtModelVersionImagePO.setCreatedAt(DateTimeUtils.nowSeconds());
            cvtModelVersionImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            cvtModelVersionImagePO.setIsDeleted(false);
            return cvtModelVersionImagePOMapper.insertSelective(cvtModelVersionImagePO);
        } else {
            cvtModelVersionImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            return cvtModelVersionImagePOMapper.updateByPrimaryKeySelective(cvtModelVersionImagePO);
        }
    }
}
