package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ImagineReqVO {

    private Long sessionId;

    private String imagePath;

    //private String notifyHook;

    private String prompt;

    private String state;

    @Builder.Default
    private String lang = "en";
}
