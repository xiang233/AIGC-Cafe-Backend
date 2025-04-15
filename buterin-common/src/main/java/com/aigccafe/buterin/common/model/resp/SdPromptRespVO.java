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
public class SdPromptRespVO {

    private PromptType type;

    private Long id;

    private Long modelId;

    private String modelName;

    private Long versionId;

    private String versionName;

    private String meta;

    private String authorName;

    private String url;

    private double price;

    private Integer viewCnt;

    private InteractionStatRespVO interactionStat;

    private InteractionStatusRespVO interactionStatus;
}
