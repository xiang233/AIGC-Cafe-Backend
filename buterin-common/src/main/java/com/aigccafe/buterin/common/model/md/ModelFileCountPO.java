package com.aigccafe.buterin.common.model.md;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@AllArgsConstructor
@Data
public class ModelFileCountPO implements Serializable {
    private Long modelId;

    private Integer versionCnt;

    private Integer fileCnt;

    private Integer unTransferFileCnt;
}
