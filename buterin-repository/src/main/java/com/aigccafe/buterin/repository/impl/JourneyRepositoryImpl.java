package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.model.journey.*;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.common.util.SecUtil;
import com.aigccafe.buterin.repository.JourneyRepository;
import com.aigccafe.buterin.repository.mapper.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JourneyRepositoryImpl implements JourneyRepository {

    @Autowired
    private JourneySessionPOMapper journeySessionPOMapper;
    @Autowired
    private JourneyTaskPOMapper journeyTaskPOMapper;
    @Autowired
    private JourneyTaskLogPOMapper journeyTaskLogPOMapper;
    @Autowired
    private JourneyShortUrlPOMapper journeyShortUrlPOMapper;
    @Autowired
    private JourneyMemberPOMapper journeyMemberPOMapper;
    @Autowired
    private JourneyGalleryImagePOMapper journeyGalleryImagePOMapper;
    @Autowired
    private MjShowcaseLogPOMapper mjShowcaseLogPOMapper;

    @Override
    public JourneySessionPO selectSessionById(Long id) {
        return journeySessionPOMapper.selectByPrimaryKey(id);
    }

    @Override
    public JourneyTaskPO selectTaskById(Long id) {
        return journeyTaskPOMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean insertSession(JourneySessionPO session) {
        session.setCreatedAt(DateTimeUtils.nowSeconds());
        session.setUpdatedAt(DateTimeUtils.nowSeconds());
        session.setIsDeleted(false);
        return journeySessionPOMapper.insertSelective(session) > 0;
    }

    @Override
    public Boolean insertTask(JourneyTaskPO journeyTaskPO) {
        journeyTaskPO.setCreatedAt(DateTimeUtils.nowSeconds());
        journeyTaskPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        journeyTaskPO.setIsDeleted(false);
        return journeyTaskPOMapper.insertSelective(journeyTaskPO) > 0;
    }

    @Override
    public Boolean insertJourneyMember(JourneyMemberPO journeyMemberPO) {
        journeyMemberPO.setCreatedAt(DateTimeUtils.nowSeconds());
        journeyMemberPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        journeyMemberPO.setIsDeleted(false);
        return journeyMemberPOMapper.insertSelective(journeyMemberPO) > 0;
    }

    @Override
    public Boolean insertJourneyGalleryImage(JourneyGalleryImagePO galleryImagePO) {
        galleryImagePO.setCreatedAt(DateTimeUtils.nowSeconds());
        galleryImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        galleryImagePO.setIsDeleted(false);
        return journeyGalleryImagePOMapper.insertSelective(galleryImagePO) > 0;
    }

    @Override
    public Boolean insertMjShowcaseLog(MjShowcaseLogPO mjShowcaseLogPO) {
        mjShowcaseLogPO.setCreatedAt(DateTimeUtils.nowSeconds());
        mjShowcaseLogPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        mjShowcaseLogPO.setIsDeleted(false);
        return mjShowcaseLogPOMapper.insertSelective(mjShowcaseLogPO) > 0;
    }

    @Override
    public Boolean updateSession(JourneySessionPO session) {
        session.setUpdatedAt(DateTimeUtils.nowSeconds());
        return journeySessionPOMapper.updateByPrimaryKeySelective(session) > 0;
    }

    @Override
    public Boolean updateTask(JourneyTaskPO journeyTaskPO) {
        journeyTaskPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return journeyTaskPOMapper.updateByPrimaryKeySelective(journeyTaskPO) > 0;
    }

    @Override
    public Boolean updateJourneyMember(JourneyMemberPO journeyMemberPO) {
        journeyMemberPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return journeyMemberPOMapper.updateByPrimaryKeySelective(journeyMemberPO) > 0;
    }

    @Override
    public Boolean updateJourneyGalleryImage(JourneyGalleryImagePO galleryImagePO) {
        galleryImagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return journeyGalleryImagePOMapper.updateByPrimaryKeySelective(galleryImagePO) > 0;
    }

    @Override
    public Boolean updateMjShowcaseLog(MjShowcaseLogPO mjShowcaseLogPO) {
        mjShowcaseLogPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return mjShowcaseLogPOMapper.updateByPrimaryKeySelective(mjShowcaseLogPO) > 0;
    }

    @Override
    public Boolean updateGalleryImage(JourneyGalleryImagePO imagePO) {
        imagePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return journeyGalleryImagePOMapper.updateByPrimaryKeySelective(imagePO) > 0;
    }

    @Override
    public List<JourneySessionPO> selectByCondition(Long userId, Integer offset, Integer number) {
        JourneySessionPOExample example = new JourneySessionPOExample();
        JourneySessionPOExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andIsDeletedEqualTo(false);
        example.setOrderByClause("created_at desc");
        RowBounds rowBounds = new RowBounds(offset, number);
        return journeySessionPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<JourneyTaskPO> selectTaskByCondition(Long userId, Long sessionId, Integer offset, Integer number) {
        JourneyTaskPOExample example = new JourneyTaskPOExample();
        JourneyTaskPOExample.Criteria criteria = example.createCriteria();
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (sessionId != null) {
            criteria.andSessionIdEqualTo(sessionId);
        }
        criteria.andIsDeletedEqualTo(false);
        example.setOrderByClause("created_at desc");
        RowBounds rowBounds = new RowBounds(offset, number);
        return journeyTaskPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public JourneyMemberPO selectMemberByUserId(Long userId) {
        Preconditions.checkNotNull(userId, "userId为空");
        JourneyMemberPOExample example = new JourneyMemberPOExample();
        JourneyMemberPOExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andIsDeletedEqualTo(false);
        List<JourneyMemberPO> memberPOList = journeyMemberPOMapper.selectByExample(example);
        return memberPOList.size() > 0 ? memberPOList.get(0) : null;
    }

    @Override
    public JourneyGalleryImagePO selectGalleryImageById(Long id) {
        JourneyGalleryImagePOExample example = new JourneyGalleryImagePOExample();
        JourneyGalleryImagePOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andIsDeletedEqualTo(false);
        List<JourneyGalleryImagePO> imagePOS = journeyGalleryImagePOMapper.selectByExample(example);
        return imagePOS.size()>0 ? imagePOS.get(0): null;
    }


    @Override
    public List<JourneyGalleryImagePO> selectGalleryImageByCondition(List<Long> idList, PromptSortedType sortedType, PromptStatus status, Integer offset, Integer number) {
        JourneyGalleryImagePOExample example = new JourneyGalleryImagePOExample();
        JourneyGalleryImagePOExample.Criteria criteria = example.createCriteria();
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
        return journeyGalleryImagePOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public MjShowcaseLogPO selectMjImageLogByImageId(String imageId) {
        MjShowcaseLogPOExample example = new MjShowcaseLogPOExample();
        MjShowcaseLogPOExample.Criteria criteria = example.createCriteria();
        criteria.andImageIdEqualTo(imageId);
        criteria.andIsDeletedEqualTo(false);
        List<MjShowcaseLogPO> mjShowcaseLogs = mjShowcaseLogPOMapper.selectByExample(example);
        return mjShowcaseLogs.size() > 0 ? mjShowcaseLogs.get(0) : null;
    }

    @Override
    public List<MjShowcaseLogPO> selectUnStoreImageLog(Integer number) {
        MjShowcaseLogPOExample example = new MjShowcaseLogPOExample();
        MjShowcaseLogPOExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        criteria.andStoreEqualTo(false);
        RowBounds rowBounds = new RowBounds(0, number);
        return mjShowcaseLogPOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public Boolean errorLog(Long taskId, String log) {
        JourneyTaskLogPO logPO = new JourneyTaskLogPO();
        logPO.setTaskId(taskId);
        logPO.setErrorLog(log);
        logPO.setErrorLog(log);
        logPO.setCreatedAt(DateTimeUtils.nowSeconds());
        logPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        logPO.setIsDeleted(false);
        return journeyTaskLogPOMapper.insertSelective(logPO) > 0;
    }

    @Override
    public String addShortCode(String url) {
        String code = SecUtil.md5(url);
        JourneyShortUrlPO shortUrlPO = new JourneyShortUrlPO();
        shortUrlPO.setUrl(url);
        shortUrlPO.setShortCode(code);
        shortUrlPO.setCreatedAt(DateTimeUtils.nowSeconds());
        shortUrlPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        shortUrlPO.setIsDeleted(false);
        journeyShortUrlPOMapper.insertSelective(shortUrlPO);
        return code;
    }

    @Override
    public String selectRawUrlByCode(String code) {
        Preconditions.checkNonEmpty(code, "请求值为空");
        JourneyShortUrlPOExample example = new JourneyShortUrlPOExample();
        JourneyShortUrlPOExample.Criteria criteria = example.createCriteria();
        criteria.andShortCodeEqualTo(code);
        criteria.andIsDeletedEqualTo(false);
        List<JourneyShortUrlPO> shortUrlPOList = journeyShortUrlPOMapper.selectByExample(example);
        Preconditions.checkNonEmpty(shortUrlPOList, "查询不到");
        JourneyShortUrlPO shortUrlPO = shortUrlPOList.get(0);
        return shortUrlPO.getUrl();
    }
}
