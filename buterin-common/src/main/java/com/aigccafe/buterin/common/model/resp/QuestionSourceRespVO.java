package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class QuestionSourceRespVO {

    private Long id;

    private String title;

    private String tags;

    private String srcContent;
}
