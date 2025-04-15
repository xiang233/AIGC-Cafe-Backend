package com.aigccafe.buterin.common.model.resp;

import com.aigccafe.buterin.common.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ModelDetailRespVO {

    private Long id;

    private String modelName;

    private String chnModelName;

    private String description;

    private String chnDescription;

    private String authorName;

    private String oriUrl;

    private Long downloadCnt;

    private String type;

    private String checkpointType;

    private Long userId;

    private UserInfo userInfo;

    private Map<String, Long> versionMap;

    private ModelVersionDetailRespVO firstVersion;

    private InteractionStatRespVO interactionStat;

    private InteractionStatusRespVO interactionStatus;
}
