package com.aigccafe.buterin.common.model.prompt;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PromptStatus {
    READY(0, "待审核"),
    OFFLINE(1, "有风险，不展示"),
    ONLINE(2, "已上线");

    private final int code;
    private final String desc;
}
