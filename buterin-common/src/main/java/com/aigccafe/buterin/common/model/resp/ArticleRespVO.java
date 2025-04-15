package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ArticleRespVO {
    private Long userId;

    private String userName;

    private String avatarUrl;

    private String title;

    private String tags;

    private String content;
}
