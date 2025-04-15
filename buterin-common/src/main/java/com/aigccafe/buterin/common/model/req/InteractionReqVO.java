package com.aigccafe.buterin.common.model.req;

import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class InteractionReqVO {

    private InteractionType interactionType;

    private TargetType targetType;

    private Long targetId;

    @Builder.Default
    private Boolean cancel = false;

    @Builder.Default
    private Double value = 0.0;
}
