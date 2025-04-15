package com.aigccafe.buterin.common.model.crawl;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelDetailRequest {
    private Integer id;

    @JSONField(serialize = false)
    private String name;

    @JSONField(serialize = false)
    private String type;

    @JSONField(serialize = false)
    private String checkPointType;

    @JSONField(serialize = false)
    private String sortType;
}
