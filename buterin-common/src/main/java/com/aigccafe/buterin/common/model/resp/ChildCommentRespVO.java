package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ChildCommentRespVO {

    private Long id;

    private Long userId;

    private String userName;

    private String avatarUrl;

    private String commentType;

    private String parentUserName;

    private String content;

    private Long likesCount;

    private String date;
}
