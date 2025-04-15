package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class QuestionReqVO {

    private Long id;

    private String title;

    private String srcContent;

    private String content;

    private String tags;
}
