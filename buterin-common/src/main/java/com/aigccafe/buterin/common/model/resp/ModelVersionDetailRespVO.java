package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ModelVersionDetailRespVO {

    private Long id;

    private String versionName;

    private String description;

    private String baseModel;

    private String lastUpdatedAt;

    List<ModelVersionFileDetailRespVO> files;

    List<SimpleVersionImageRespVO> images;
}
