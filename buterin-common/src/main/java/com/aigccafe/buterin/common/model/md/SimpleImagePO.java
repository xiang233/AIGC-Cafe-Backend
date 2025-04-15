package com.aigccafe.buterin.common.model.md;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SimpleImagePO {

    private Long id;

    private Long versionId;

    private String normalPath;

    private String meta;
}
