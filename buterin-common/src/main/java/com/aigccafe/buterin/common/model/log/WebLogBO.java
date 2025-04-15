package com.aigccafe.buterin.common.model.log;

import com.aigccafe.buterin.common.model.BaseEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebLogBO extends BaseEntity<Long> {
    private Long userId;

    private String ip;

    private Long duration;

    private String method;

    private String basePath;

    private String uri;

    private String description;

    private Object parameter;

    public static WebLogPO castToPO(WebLogBO webLogBO) {
        WebLogPO webLogPO =new WebLogPO();
        BeanUtils.copyProperties(webLogBO, webLogPO);
        //webLogPO.setParameter(JSON.toJSONString(webLogBO.getParameter()));
        webLogPO.setParameter("");
        return webLogPO;
    }
}
