package com.aigccafe.buterin.common.model.resp;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class ModelRespVO {

    private Long id;

    private String modelName;

    private String chnModelName;

    private String type;

    private String checkpointType;

    private Long downloadCnt;

    private Long userId;

    private String userName;

    private String avatarUrl;

    private String coverImgUrl;

    private Long updatedAt;

    private InteractionStatRespVO interactionStat;

    private InteractionStatusRespVO interactionStatus;
}
