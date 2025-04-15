package com.aigccafe.buterin.common.model.resp;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class SimpleVersionImageRespVO {
    private String versionName;

    private Long id;

    private String url;

    private String path;
}
