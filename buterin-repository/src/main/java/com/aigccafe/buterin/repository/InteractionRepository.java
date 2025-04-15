package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.comment.CommentPO;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPO;
import com.aigccafe.buterin.common.model.interaction.SimpleInteractionPO;
import java.util.List;

public interface InteractionRepository {

    CommentPO selectCommentById(Long commentId);

    List<CommentPO> selectCommentByCondition(TargetType targetType, Long targetId, List<String> commentTypeList,
                                             List<Long> parentCommentIdList, Integer offset, Integer number);

    Long countCommentByCondition(TargetType targetType, Long targetId, List<String> commentTypeList,
                                             List<Long> parentCommentIdList, Integer offset, Integer number);

    List<CommentPO> selectCommentByCondition(TargetType targetType, Long targetId, List<String> commentTypeList,
                                             List<Long> parentCommentIdList);

    Boolean insertComment(CommentPO commentPO);

    Boolean updateComment(CommentPO commentPO);

    Boolean insertSimpleInteraction(SimpleInteractionPO simpleInteraction);

    SimpleInteractionPO selectSimpleInteraction(InteractionType type, TargetType targetType, Long targetId, Long userId);

    List<SimpleInteractionPO> selectSimpleInteractionList(InteractionType type, TargetType targetType, Long userId, Integer offset, Integer number);

    List<SimpleInteractionPO> selectUserInteractionsByCondition(List<String> interactionTypeList, TargetType targetType, Long userId, List<Long> targetIdList);

    Long countSimpleInteractionList(InteractionType type, TargetType targetType, Long userId);

    Boolean deleteSimpleInteraction(Long id);

    InteractionStatPO selectInteractionStat(TargetType targetType, Long targetId);

    List<InteractionStatPO> selectInteractionStatList(TargetType targetType, List<Long> targetIdList);

    Boolean addInteractionStat(InteractionType type, TargetType targetType, Long targetId, Long count, Double value);
}
