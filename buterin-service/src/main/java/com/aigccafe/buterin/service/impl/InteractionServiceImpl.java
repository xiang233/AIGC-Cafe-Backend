package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.CommentType;
import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.comment.CommentPO;
import com.aigccafe.buterin.common.model.interaction.SimpleInteractionPO;
import com.aigccafe.buterin.common.model.md.ModelVersionFilePO;
import com.aigccafe.buterin.common.model.req.CommentReqVO;
import com.aigccafe.buterin.common.model.req.InteractionReqVO;
import com.aigccafe.buterin.common.model.resp.ChildCommentRespVO;
import com.aigccafe.buterin.common.model.resp.CommentRespVO;
import com.aigccafe.buterin.common.model.resp.InteractionStatusRespVO;
import com.aigccafe.buterin.common.model.user.UserInfo;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.InteractionRepository;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.service.CommunityService;
import com.aigccafe.buterin.service.InteractionService;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommunityService communityService;

    @Override
    public List<CommentRespVO> getCommentsByTarget(TargetType targetType, Long targetId, Integer offset, Integer number) {
        Preconditions.checkArgument(number < 20, "评论获取过多");
        Preconditions.checkArgument(offset >= 0, "offset值非法");
        List<String> commentTypeList = Collections.singletonList(CommentType.REPLY_0.name());

        // 取number条0级评论
        List<CommentPO> commentPOList = interactionRepository.selectCommentByCondition(targetType, targetId,
                commentTypeList, null, offset, number);

        // 取所有1级评论并保留第一条
        commentTypeList = Lists.newArrayList(CommentType.REPLY_1.name(), CommentType.REPLY_2.name());
        List<Long> parentCommentIdList = commentPOList.stream().map(CommentPO::getId).collect(Collectors.toList());
        List<CommentPO> childCommentList = interactionRepository.selectCommentByCondition(targetType, targetId, commentTypeList, parentCommentIdList);
        Map<Long, Integer> commentReplyCountMap = childCommentList.stream().collect(Collectors.toMap(CommentPO::getParentCommentId, obj -> 1, Integer::sum));
        Map<Long, CommentPO> commentReplyMap = childCommentList.stream()
                .collect(Collectors.toMap(CommentPO::getParentCommentId, obj -> obj, (x, y) -> x));

        // 取用户信息
        Set<Long> userIdSet = commentPOList.stream().map(CommentPO::getUserId).collect(Collectors.toSet());
        userIdSet.addAll(commentReplyMap.values().stream().map(CommentPO::getUserId).collect(Collectors.toList()));
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(Lists.newArrayList(userIdSet))
                .stream()
                .collect(Collectors.toMap(UserPO::getId, obj -> obj));

        List<CommentRespVO> commentRespVOList = Lists.newArrayList();
        for (CommentPO comment : commentPOList) {
            CommentRespVO commentRespVO = new CommentRespVO();
            BeanUtils.copyProperties(comment, commentRespVO);
            CommentPO replyComment = commentReplyMap.get(comment.getId());
            if (replyComment != null) {
                ChildCommentRespVO childComment = new ChildCommentRespVO();
                BeanUtils.copyProperties(replyComment, childComment);
                UserPO userPO = userPOMap.get(replyComment.getUserId());
                if (userPO != null) {
                    UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
                    childComment.setUserName(userPO.getUserName());
                    childComment.setAvatarUrl(userInfo.getAvatarUrl());
                }
                UserPO parentUser = userPOMap.get(replyComment.getParentUserId());
                if (parentUser != null) {
                    childComment.setParentUserName(parentUser.getUserName());
                }
                childComment.setDate(DateTimeUtils.formatDateHour(replyComment.getCreatedAt() * 1000));
                commentRespVO.setFirstReplyComment(childComment);
            }
            UserPO userPO = userPOMap.get(comment.getUserId());
            if (userPO != null) {
                UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
                commentRespVO.setUserName(userPO.getUserName());
                commentRespVO.setAvatarUrl(userInfo.getAvatarUrl());
            }
            Integer replyCount = commentReplyCountMap.get(comment.getId());
            if (replyCount != null) {
                commentRespVO.setChildCommentCount(replyCount);
            } else {
                commentRespVO.setChildCommentCount(0);
            }
            commentRespVO.setDate(DateTimeUtils.formatDateHour(comment.getCreatedAt() * 1000));
            commentRespVOList.add(commentRespVO);
        }
        return commentRespVOList;
    }

    @Override
    public List<ChildCommentRespVO> getCommentReplies(Long parentCommentId, Integer offset, Integer number) {
        Preconditions.checkArgument(number < 20, "评论获取过多");
        Preconditions.checkArgument(offset >= 0, "offset值非法");
        List<String> commentTypeList = Lists.newArrayList(CommentType.REPLY_1.name(), CommentType.REPLY_2.name());
        List<Long> parentCommentIdList = Collections.singletonList(parentCommentId);
        List<CommentPO> commentPOList = interactionRepository.selectCommentByCondition(null, null,
                commentTypeList, parentCommentIdList, offset, number);
//        log.info("commont:{}", JSON.toJSONString(commentPOList));

        Set<Long> userIdSet = commentPOList.stream().map(CommentPO::getUserId).collect(Collectors.toSet());
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(Lists.newArrayList(userIdSet))
                .stream()
                .collect(Collectors.toMap(UserPO::getId, obj -> obj));

        List<ChildCommentRespVO> childCommentList = Lists.newArrayList();
        commentPOList.forEach(comment -> {
            ChildCommentRespVO childComment = new ChildCommentRespVO();
            BeanUtils.copyProperties(comment, childComment);
            UserPO userPO = userPOMap.get(comment.getUserId());
            if (userPO != null) {
                UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
                childComment.setUserName(userPO.getUserName());
                childComment.setAvatarUrl(userInfo.getAvatarUrl());
            }
            UserPO parentUser = userPOMap.get(comment.getParentUserId());
            if (parentUser != null) {
                childComment.setParentUserName(parentUser.getUserName());
            }
            childComment.setDate(DateTimeUtils.formatDateHour(comment.getCreatedAt() * 1000));
            childCommentList.add(childComment);
        });
        return childCommentList;
    }

    @Override
    public Boolean addComment(CommentReqVO commentReqVO) {
        if (commentReqVO.getCommentType().equals(CommentType.REPLY_1) || commentReqVO.getCommentType().equals(CommentType.REPLY_2)) {
            Preconditions.checkNotNull(commentReqVO.getParentCommentId(), "缺少父评论id");
            Preconditions.checkNotNull(commentReqVO.getParentUserId(), "缺少父评论用户id");
        }
        Long userId = StpUtil.getLoginIdAsLong();
        CommentPO commentPO = new CommentPO();
        BeanUtils.copyProperties(commentReqVO, commentPO);
        commentPO.setCommentType(commentReqVO.getCommentType().name());
        commentPO.setTargetType(commentReqVO.getTargetType().name());
        commentPO.setUserId(userId);
        return interactionRepository.insertComment(commentPO);
    }

    @Override
    public Boolean deleteComment(Long commentId) {
        Long userId = StpUtil.getLoginIdAsLong();
        CommentPO commentPO = interactionRepository.selectCommentById(commentId);
        if (userId.equals(commentPO.getUserId())) {
            commentPO.setIsDeleted(true);
            return interactionRepository.updateComment(commentPO);
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean addSimpleInteraction(InteractionReqVO interactionReqVO) {
        Long userId = StpUtil.getLoginIdAsLong();
        Boolean cancel = interactionReqVO.getCancel();
        // 执行或者取消
        SimpleInteractionPO simpleInteractionPO = interactionRepository.selectSimpleInteraction(interactionReqVO.getInteractionType(),
                interactionReqVO.getTargetType(), interactionReqVO.getTargetId(), userId);
        // 增加
        if (!cancel) {
            if (simpleInteractionPO == null) {
                simpleInteractionPO = new SimpleInteractionPO();
                BeanUtils.copyProperties(interactionReqVO, simpleInteractionPO);
                simpleInteractionPO.setUserId(userId);
                simpleInteractionPO.setInteractionType(interactionReqVO.getInteractionType().name());
                simpleInteractionPO.setTargetType(interactionReqVO.getTargetType().name());
                simpleInteractionPO.setExt("{}");
                Boolean res = interactionRepository.insertSimpleInteraction(simpleInteractionPO);
                // 增加统计
                if (res) {
                    // 有一些记录需要操作同步到answer或者question表
                    if (interactionReqVO.getTargetType().equals(TargetType.QUESTION)
                            || interactionReqVO.getTargetType().equals(TargetType.ANSWER)) {
                        communityInteractionUpdate(interactionReqVO.getTargetType(), interactionReqVO.getInteractionType(),
                                interactionReqVO.getTargetId(), true);
                    }
                    return interactionRepository.addInteractionStat(interactionReqVO.getInteractionType(),
                            interactionReqVO.getTargetType(), interactionReqVO.getTargetId(), 1L, interactionReqVO.getValue());
                }
            }
        } else {
        // 取消
            if (simpleInteractionPO != null) {
                Long id = simpleInteractionPO.getId();
                Boolean res = interactionRepository.deleteSimpleInteraction(id);
                // 减少统计
                if (res) {
                    // 有一些记录需要操作同步到answer或者question表
                    if (interactionReqVO.getTargetType().equals(TargetType.QUESTION)
                            || interactionReqVO.getTargetType().equals(TargetType.ANSWER)) {
                        communityInteractionUpdate(interactionReqVO.getTargetType(), interactionReqVO.getInteractionType(),
                                interactionReqVO.getTargetId(), false);
                    }
                    return interactionRepository.addInteractionStat(interactionReqVO.getInteractionType(),
                            interactionReqVO.getTargetType(), interactionReqVO.getTargetId(), -1L, -interactionReqVO.getValue());
                }
            }
        }
        return true;
    }

    @Override
    public List<Long> getUserTargetIdList(Long userId, InteractionType type, TargetType targetType, Integer offset, Integer number) {
        return interactionRepository.selectSimpleInteractionList(type, targetType, userId, offset, number)
                .stream()
                .map(SimpleInteractionPO::getTargetId)
                .collect(Collectors.toList());
    }

    @Override
    public Long countUserTargetIdList(Long userId, InteractionType type, TargetType targetType) {
        return interactionRepository.countSimpleInteractionList(type, targetType, userId);
    }

    @Override
    public Map<Long, InteractionStatusRespVO> getUserInteractionMap(Long userId, TargetType targetType, List<Long> targetIdList) {
        List<String> interactionTypeList = Arrays.asList(InteractionType.LIKE.name(), InteractionType.STORE.name());
        List<SimpleInteractionPO> interactionPOList = Lists.newArrayList();
        if (userId != null) {
            interactionPOList = interactionRepository.selectUserInteractionsByCondition(interactionTypeList, targetType, userId, targetIdList);
//            log.info("interactionTypeList:{}", JSON.toJSONString(interactionTypeList));
//            log.info("targetType:{}", targetType);
//            log.info("userId:{}", userId);
//            log.info("targetIdList:{}", targetIdList);
        }
        Map<Long, List<SimpleInteractionPO>> interactionMap = interactionPOList.stream()
                .collect(Collectors.groupingBy(SimpleInteractionPO::getTargetId, Collectors.toList()));
//        log.info("interactionMap:{}", JSON.toJSONString(interactionMap));


        Map<Long, InteractionStatusRespVO> interactionStatusRespVOMap = Maps.newHashMap();
        for (Long targetId : targetIdList) {
            InteractionStatusRespVO interactionStatus = InteractionStatusRespVO.builder().build();
            List<SimpleInteractionPO> simpleInteractionList = interactionMap.get(targetId);
            if (CollectionUtils.isNotEmpty(simpleInteractionList)) {
                for (SimpleInteractionPO interactionPO : simpleInteractionList) {
                    if (interactionPO.getInteractionType().equals(InteractionType.LIKE.name())) {
                        interactionStatus.setLike(true);
                    } else if (interactionPO.getInteractionType().equals(InteractionType.STORE.name())) {
                        interactionStatus.setStore(true);
                    }
                }
            }
            interactionStatusRespVOMap.put(targetId, interactionStatus);
        }
        return interactionStatusRespVOMap;
    }


    private void communityInteractionUpdate(TargetType targetType, InteractionType interactionType, Long targetId, boolean add) {
        if (TargetType.QUESTION.equals(targetType)) {
            communityService.changeQuestionStat(targetId, interactionType, add);
        } else if (TargetType.ANSWER.equals(targetType)) {
            communityService.changeAnswerStat(targetId, interactionType, add);
        }
    }
}
