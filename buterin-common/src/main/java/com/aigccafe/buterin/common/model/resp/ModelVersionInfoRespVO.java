package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class ModelVersionInfoRespVO {
    private Long versionId;

    private String versionName;

    private String baseModel;

    private List<ModelVersionFileInfoRespVO> fileList;
}
