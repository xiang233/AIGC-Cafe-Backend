package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class InteractionStatusRespVO {

    @Builder.Default
    Boolean like = false;

    @Builder.Default
    Boolean store = false;
}
