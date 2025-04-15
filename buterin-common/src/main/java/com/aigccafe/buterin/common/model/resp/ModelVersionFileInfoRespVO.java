package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelVersionFileInfoRespVO {

    private Long fileId;

    private String fileName;

    private Double sizeKB;

    private String type;

    private String metadata;

    private String downloadUrl;

    private String transferUrl;
}
