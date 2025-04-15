package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ModelInfoRespVO {
    private Long id;

    private String modelName;

    private String type;

    private String checkpointType;

    private Integer versionCnt;

    private Integer fileCnt;

    private Integer unTransferFileCnt;

    private List<ModelVersionInfoRespVO> versionList;
}
