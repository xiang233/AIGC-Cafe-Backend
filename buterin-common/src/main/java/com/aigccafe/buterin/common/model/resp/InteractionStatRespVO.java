package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class InteractionStatRespVO {

    @Builder.Default
    private Long likeCount = 0L;

    @Builder.Default
    private Long storeCount = 0L;

    @Builder.Default
    private Long commentCount = 0L;

    @Builder.Default
    private Long downloadCount = 0L;

    @Builder.Default
    private Long scoreCount = 0L;

    @Builder.Default
    private Double scoreSum = 0.0;
}
