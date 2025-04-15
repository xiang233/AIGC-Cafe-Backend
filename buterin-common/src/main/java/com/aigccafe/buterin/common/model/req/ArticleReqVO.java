package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ArticleReqVO {
    private Long id;

    private Long documentId;

    private Long parentId;

    private String title;

    private String content;

    private String html;

    private String tags;
}
