package com.aigccafe.buterin.common.model.req;

import com.aigccafe.buterin.common.enumerate.CommentType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class CommentReqVO {

    private CommentType commentType;

    private TargetType targetType;

    private Long targetId;

    private Long parentUserId;

    private Long parentCommentId;

    private String content;
}
