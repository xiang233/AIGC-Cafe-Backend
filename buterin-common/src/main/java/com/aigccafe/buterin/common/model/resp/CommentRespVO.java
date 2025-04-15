package com.aigccafe.buterin.common.model.resp;

import com.aigccafe.buterin.common.enumerate.CommentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class CommentRespVO {
    private Long id;

    private Long userId;

    private String userName;

    private String avatarUrl;

    private String commentType;

    private Long likesCount;

    private String content;

    private String date;

    private Integer childCommentCount;

    private ChildCommentRespVO firstReplyComment;
}
