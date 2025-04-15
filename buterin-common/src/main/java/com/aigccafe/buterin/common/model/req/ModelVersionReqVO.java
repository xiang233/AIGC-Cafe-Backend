package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelVersionReqVO {
    private Long id;

    private String platform;

    private Long modelId;

    private Long oriModelId;

    private Long oriVersionId;

    private String versionName;

    private String baseModel;

    private String status;

    private Long downloadCnt;

    private String lastUpdatedAt;

    private String description;
}
