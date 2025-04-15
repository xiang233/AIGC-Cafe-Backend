package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.comment.CommentPO;
import com.aigccafe.buterin.common.model.comment.CommentPOExample;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPO;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPOExample;
import com.aigccafe.buterin.common.model.interaction.SimpleInteractionPO;
import com.aigccafe.buterin.common.model.interaction.SimpleInteractionPOExample;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.InteractionRepository;
import com.aigccafe.buterin.repository.mapper.CommentPOMapper;
import com.aigccafe.buterin.repository.mapper.InteractionStatPOMapper;
import com.aigccafe.buterin.repository.mapper.SimpleInteractionPOMapper;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;


@Repository
@Slf4j
public class InteractionRepositoryImpl implements InteractionRepository {

    @Autowired
    private CommentPOMapper commentPOMapper;
    @Autowired
    private SimpleInteractionPOMapper simpleInteractionPOMapper;
    @Autowired
    private InteractionStatPOMapper interactionStatPOMapper;

    @Override
    public CommentPO selectCommentById(Long commentId) {
        return  commentPOMapper.selectByPrimaryKey(commentId);
    }


    @Override
    public List<CommentPO> selectCommentByCondition(TargetType targetType, Long targetId, List<String> commentTypeList,
                                                    List<Long> parentCommentIdList, Integer offset, Integer number) {
        CommentPOExample example = new CommentPOExample();
        CommentPOExample.Criteria criteria = example.createCriteria();
        if (targetType != null) {
            criteria.andTargetTypeEqualTo(targetType.name());
        }
        if (targetId != null) {
            criteria.andTargetIdEqualTo(targetId);
        }
        if (!CollectionUtils.isEmpty(commentTypeList)) {
            criteria.andCommentTypeIn(commentTypeList);
        }
        if (parentCommentIdList != null) {
            criteria.andParentCommentIdIn(parentCommentIdList);
        }
        criteria.andIsDeletedEqualTo(false);
        example.setOrderByClause("created_at asc");
        RowBounds rowBounds = new RowBounds(offset, number);
        return commentPOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public Long countCommentByCondition(TargetType targetType, Long targetId, List<String> commentTypeList,
                                 List<Long> parentCommentIdList, Integer offset, Integer number) {
        CommentPOExample example = new CommentPOExample();
        CommentPOExample.Criteria criteria = example.createCriteria();
        if (targetType != null) {
            criteria.andTargetTypeEqualTo(targetType.name());
        }
        if (targetId != null) {
            criteria.andTargetIdEqualTo(targetId);
        }
        if (!CollectionUtils.isEmpty(commentTypeList)) {
            criteria.andCommentTypeIn(commentTypeList);
        }
        if (parentCommentIdList != null) {
            criteria.andParentCommentIdIn(parentCommentIdList);
        }
        criteria.andIsDeletedEqualTo(false);
        return commentPOMapper.countByExample(example);
    }

    @Override
    public List<CommentPO> selectCommentByCondition(TargetType targetType, Long targetId, List<String> commentTypeList,
                                                    List<Long> parentCommentIdList) {
        CommentPOExample example = new CommentPOExample();
        CommentPOExample.Criteria criteria = example.createCriteria();
        if (targetType != null) {
            criteria.andTargetTypeEqualTo(targetType.name());
        }
        if (targetId != null) {
            criteria.andTargetIdEqualTo(targetId);
        }
        if (!CollectionUtils.isEmpty(commentTypeList)) {
            criteria.andCommentTypeIn(commentTypeList);
        }
        if (!CollectionUtils.isEmpty(parentCommentIdList)) {
            criteria.andParentCommentIdIn(parentCommentIdList);
        }
        criteria.andIsDeletedEqualTo(false);
        return commentPOMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public Boolean insertComment(CommentPO commentPO) {
        commentPO.setLikesCount(0L);
        commentPO.setCreatedAt(DateTimeUtils.nowSeconds());
        commentPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        commentPO.setIsDeleted(false);
        return commentPOMapper.insertSelective(commentPO) > 0;
    }

    @Override
    public Boolean updateComment(CommentPO commentPO) {
        commentPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return commentPOMapper.updateByPrimaryKeySelective(commentPO) > 0;
    }

    @Override
    public Boolean insertSimpleInteraction(SimpleInteractionPO simpleInteraction) {
        simpleInteraction.setCreatedAt(DateTimeUtils.nowSeconds());
        simpleInteraction.setUpdatedAt(DateTimeUtils.nowSeconds());
        simpleInteraction.setIsDeleted(false);
        return simpleInteractionPOMapper.insertSelective(simpleInteraction) > 0;
    }

    @Override
    public SimpleInteractionPO selectSimpleInteraction(InteractionType type, TargetType targetType, Long targetId, Long userId) {
        Preconditions.checkArgument(type != null && targetType != null && targetId != null && userId != null, "参数缺失");
        SimpleInteractionPOExample example = new SimpleInteractionPOExample();
        SimpleInteractionPOExample.Criteria criteria = example.createCriteria();
        criteria.andInteractionTypeEqualTo(type.name());
        criteria.andTargetTypeEqualTo(targetType.name());
        criteria.andTargetIdEqualTo(targetId);
        criteria.andUserIdEqualTo(userId);
        List<SimpleInteractionPO> res = simpleInteractionPOMapper.selectByExample(example);
        return res.size() > 0 ? res.get(0) : null;
    }

    @Override
    public List<SimpleInteractionPO> selectSimpleInteractionList(InteractionType type, TargetType targetType, Long userId,
                                                                 Integer offset, Integer number) {
        Preconditions.checkArgument(type != null && targetType != null && userId != null, "参数缺失");
        SimpleInteractionPOExample example = new SimpleInteractionPOExample();
        SimpleInteractionPOExample.Criteria criteria = example.createCriteria();
        criteria.andInteractionTypeEqualTo(type.name());
        criteria.andTargetTypeEqualTo(targetType.name());
        criteria.andUserIdEqualTo(userId);
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(offset, number);
        return simpleInteractionPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<SimpleInteractionPO> selectUserInteractionsByCondition(List<String> interactionTypeList, TargetType targetType,
                                                                       Long userId, List<Long> targetIdList) {
        SimpleInteractionPOExample example = new SimpleInteractionPOExample();
        SimpleInteractionPOExample.Criteria criteria = example.createCriteria();
        if (CollectionUtils.isNotEmpty(interactionTypeList)) {
            criteria.andInteractionTypeIn(interactionTypeList);
        } else {
            return Lists.newArrayList();
        }
        if (targetType != null) {
            criteria.andTargetTypeEqualTo(targetType.name());
        }
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        if (CollectionUtils.isNotEmpty(targetIdList)) {
            criteria.andTargetIdIn(targetIdList);
        } else {
            return Lists.newArrayList();
        }
        criteria.andIsDeletedEqualTo(false);
        return simpleInteractionPOMapper.selectByExample(example);
    }


    @Override
    public Long countSimpleInteractionList(InteractionType type, TargetType targetType, Long userId) {
        Preconditions.checkArgument(type != null && targetType != null && userId != null, "参数缺失");
        SimpleInteractionPOExample example = new SimpleInteractionPOExample();
        SimpleInteractionPOExample.Criteria criteria = example.createCriteria();
        criteria.andInteractionTypeEqualTo(type.name());
        criteria.andTargetTypeEqualTo(targetType.name());
        criteria.andUserIdEqualTo(userId);
        criteria.andIsDeletedEqualTo(false);
        return simpleInteractionPOMapper.countByExample(example);
    }


    @Override
    public Boolean deleteSimpleInteraction(Long id) {
        return simpleInteractionPOMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public InteractionStatPO selectInteractionStat(TargetType targetType, Long targetId) {
        List<InteractionStatPO> interactionStatPOList = selectInteractionStatList(targetType, Collections.singletonList(targetId));
        return CollectionUtils.isNotEmpty(interactionStatPOList) ? interactionStatPOList.get(0) : null;
    }

    @Override
    public List<InteractionStatPO> selectInteractionStatList(TargetType targetType, List<Long> targetIdList) {
        if (targetType == null || CollectionUtils.isEmpty(targetIdList)) {
            return Lists.newArrayList();
        }
        InteractionStatPOExample example = new InteractionStatPOExample();
        InteractionStatPOExample.Criteria criteria = example.createCriteria();
        criteria.andTargetTypeEqualTo(targetType.name());
        criteria.andTargetIdIn(targetIdList);
        return interactionStatPOMapper.selectByExample(example);
    }

    @Override
    public Boolean addInteractionStat(InteractionType type, TargetType targetType, Long targetId, Long count, Double value) {
        InteractionStatPO interactionStatPO = selectInteractionStat(targetType, targetId);
        boolean insert = false;
        if (interactionStatPO == null) {
            insert = true;
            interactionStatPO = new InteractionStatPO();
            interactionStatPO.setTargetType(targetType.name());
            interactionStatPO.setTargetId(targetId);
            interactionStatPO.setLikeCount(0L);
            interactionStatPO.setStoreCount(0L);
            interactionStatPO.setDownloadCount(0L);
            interactionStatPO.setCommentCount(0L);
            interactionStatPO.setScoreCount(0L);
            interactionStatPO.setScoreSum(0.0);
            interactionStatPO.setCreatedAt(DateTimeUtils.nowSeconds());
            interactionStatPO.setUpdatedAt(DateTimeUtils.nowSeconds());
            interactionStatPO.setIsDeleted(false);
        }
        if (InteractionType.LIKE.equals(type)) {
            interactionStatPO.setLikeCount(interactionStatPO.getLikeCount() + count);
        }
        if (InteractionType.STORE.equals(type)) {
            interactionStatPO.setStoreCount(interactionStatPO.getStoreCount() + count);
        }
        if (InteractionType.COMMENT.equals(type)) {
            interactionStatPO.setCommentCount(interactionStatPO.getCommentCount() + count);
        }
        if (InteractionType.DOWNLOAD.equals(type)) {
            interactionStatPO.setDownloadCount(interactionStatPO.getDownloadCount() + count);
        }
        if (InteractionType.SCORE.equals(type)) {
            interactionStatPO.setScoreCount(interactionStatPO.getScoreCount() + count);
            interactionStatPO.setScoreSum(interactionStatPO.getScoreSum() + value);
        }
        if (InteractionType.AGREE.equals(type)) {
            interactionStatPO.setAgreeCount(interactionStatPO.getAgreeCount() + count);
        }
        if (InteractionType.DISAGREE.equals(type)) {
            interactionStatPO.setDisagreeCount(interactionStatPO.getDisagreeCount() + count);
        }
        if (InteractionType.SUPPORT.equals(type)) {
            interactionStatPO.setSupportCount(interactionStatPO.getSupportCount() + count);
        }
        if (InteractionType.UN_SUPPORT.equals(type)) {
            interactionStatPO.setUnSupportCount(interactionStatPO.getUnSupportCount() + count);
        }

        if (insert) {
            return interactionStatPOMapper.insertSelective(interactionStatPO) > 0;
        } else {
            return interactionStatPOMapper.updateByPrimaryKeySelective(interactionStatPO) > 0;
        }
    }

}
