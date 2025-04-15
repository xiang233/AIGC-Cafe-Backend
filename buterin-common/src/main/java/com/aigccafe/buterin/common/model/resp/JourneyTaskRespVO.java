package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class JourneyTaskRespVO {
    Long taskId;

    String taskType;

    String description;

    String status;

    String failReason;

    String progress;

    String imageUrl;

    String rawImageUrl;

    Long submitTime;

    Long startTime;

    Long finishTime;
}
