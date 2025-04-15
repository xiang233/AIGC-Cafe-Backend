package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SimpleModelRespVO {
    private Long id;

    private String modelName;

    private Long downloadCnt;

    private Integer versionCnt;

    private Integer fileCnt;

    private Integer unTransferFileCnt;
}
