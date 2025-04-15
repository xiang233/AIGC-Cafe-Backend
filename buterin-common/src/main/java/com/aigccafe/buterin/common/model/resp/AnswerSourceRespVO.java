package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class AnswerSourceRespVO {
    private Long id;

    private String srcContent;

}
