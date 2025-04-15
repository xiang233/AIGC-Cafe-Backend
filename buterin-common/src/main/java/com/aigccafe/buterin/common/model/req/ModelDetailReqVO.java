package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelDetailReqVO {
    private Long id;

    private String platform;

    private Long oriModelId;

    private String modelName;

    private String chnModelName;

    private String description;

    private String chnDescription;

    private Boolean nsfw;

    private String status;

    private String authorName;

    private Long downloadCnt;

    private String type;

    private String checkpointType;

    private String tags;

    private Long userId;

    private String manualTags;

    private String coverPath;
}
