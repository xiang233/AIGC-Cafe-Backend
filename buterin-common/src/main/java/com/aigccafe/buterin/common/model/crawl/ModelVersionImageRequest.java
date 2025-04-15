package com.aigccafe.buterin.common.model.crawl;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModelVersionImageRequest {

    @Builder.Default
    private String period = "AllTime";

    @Builder.Default
    private String sort = "Most Reactions";

    @JSONField(serialize = false)
    private Long modelId;

    private Long modelVersionId;

    private List<Long> prioritizedUserIds;

    @Builder.Default
    private Integer limit = 100;

    @Builder.Default
    private Long cursor = null;
}
