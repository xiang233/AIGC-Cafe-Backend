package com.aigccafe.buterin.common.model.crawl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelListRequest {
    @Builder.Default
    private String sort = "Most Liked";

    @Builder.Default
    private String period = "AllTime";

    @Builder.Default
    private List<String> types = new ArrayList<>(Collections.singletonList("Checkpoint"));

    @Builder.Default
    private List<String> baseModels = new ArrayList<>(Collections.singletonList("SDXL 1.0"));

    @Builder.Default
    private String checkpointType = null;

    @Builder.Default
    private Boolean earlyAccess = false;

    @Builder.Default
    private Boolean favorites = false;

    @Builder.Default
    private Boolean hidden = false;

    @Builder.Default
    private Long cursor = null;

    @Builder.Default
    private Integer limit = 10;
}
