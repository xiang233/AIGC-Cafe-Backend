package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelVersionImageReqVO {
    private Long id;

    private String platform;

    private Long modelId;

    private String modelName;

    private Long versionId;

    private String versionName;

    private Long oriModelId;

    private Long oriVersionId;

    private Long oriImageId;

    private String url;

    private Boolean nsfw;

    private Integer width;

    private Integer height;

    private String mimetype;

    private String rawPath;

    private String normalPath;

    private String meta;

    private String authorInfo;
}
