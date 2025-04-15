package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class AnswerReqVO {

    private Long id;

    private Long questionId;

    private String content;

    private String srcContent;

}
