package com.aigccafe.buterin.common.model.req;

import com.aigccafe.buterin.common.enumerate.ArticleStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class NoteReqVO {
    private Long id;

    private String title;

    private String content;

    private String html;

    private String tags;

    private ArticleStatus status;
}
