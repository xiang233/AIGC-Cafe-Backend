package com.aigccafe.buterin.common.model.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    NORMAL("normal", "普通用户"),
    ADMIN("admin", "管理员");

    private final String value;
    private final String desc;
}
