package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelVersionFileReqVO {
    private Long id;

    private String platform;

    private Long modelId;

    private String modelName;

    private Long versionId;

    private String versionName;

    private Long oriModelId;

    private Long oriVersionId;

    private Long oriFileId;

    private Double sizekb;

    private String type;

    private String name;

    private String metadata;

    private String url;
}
