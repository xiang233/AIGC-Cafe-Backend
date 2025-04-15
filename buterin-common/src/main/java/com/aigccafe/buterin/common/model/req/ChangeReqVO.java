package com.aigccafe.buterin.common.model.req;

import com.aigccafe.buterin.common.enumerate.JourneyTaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ChangeReqVO {
    private Long sessionId;

    private JourneyTaskType taskType;

    private Long taskId;

    private Integer index;
}
