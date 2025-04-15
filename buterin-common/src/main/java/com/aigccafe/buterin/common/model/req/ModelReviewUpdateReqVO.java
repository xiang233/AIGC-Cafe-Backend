package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelReviewUpdateReqVO {
    private Long modelId;

    private String status;

    private String tags;

    private String coverPath;
}
