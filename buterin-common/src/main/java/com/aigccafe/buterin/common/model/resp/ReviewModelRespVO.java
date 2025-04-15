package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@Data
public class ReviewModelRespVO {

    private Long id;

    private String modelName;

    private String type;

    private String checkpointType;

    private String description;

    private String status;

    private Map<String, List<SimpleVersionImageRespVO>> images;
}
