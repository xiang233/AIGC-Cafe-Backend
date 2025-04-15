package com.aigccafe.buterin.common.model.resp;

import com.aigccafe.buterin.common.enumerate.PromptType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class MjPromptDetailRespVO {
    private PromptType type;

    private Long id;

    private String url;

    private String prompt;

    private double price;

    private Integer viewCnt;
}
