package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.req.CommentReqVO;
import com.aigccafe.buterin.common.model.req.InteractionReqVO;
import com.aigccafe.buterin.common.model.resp.ChildCommentRespVO;
import com.aigccafe.buterin.common.model.resp.CommentRespVO;
import com.aigccafe.buterin.common.model.resp.InteractionStatusRespVO;

import java.util.List;
import java.util.Map;

public interface InteractionService {

    List<CommentRespVO> getCommentsByTarget(TargetType targetType, Long targetId, Integer offset, Integer number);

    List<ChildCommentRespVO> getCommentReplies(Long commentId, Integer offset, Integer number);

    Boolean addComment(CommentReqVO commentReqVO);

    Boolean deleteComment(Long commentId);

    Boolean addSimpleInteraction(InteractionReqVO interactionReqVO);

    List<Long> getUserTargetIdList(Long userId, InteractionType type, TargetType targetType, Integer offset, Integer number);

    Long countUserTargetIdList(Long userId, InteractionType type, TargetType targetType);

    Map<Long, InteractionStatusRespVO> getUserInteractionMap(Long userId, TargetType targetType, List<Long> targetIdList);
}
