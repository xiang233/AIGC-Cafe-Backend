package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DocumentType {
    SD("Stable Diffusion合集"),
    MJ("Midjourney合集"),
    OTHER("其他便利信息");

    private final String value;
}
