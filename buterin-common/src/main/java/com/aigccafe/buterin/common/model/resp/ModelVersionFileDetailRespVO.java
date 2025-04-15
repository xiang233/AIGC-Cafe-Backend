package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ModelVersionFileDetailRespVO {

    private Long id;

    private Double sizekb;

    private String type;

    private String name;

    private String metadata;

    private String rawUrl;

    private String url;
}
