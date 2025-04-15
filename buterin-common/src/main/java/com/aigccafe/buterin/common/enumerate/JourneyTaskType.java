package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum JourneyTaskType {
    IMAGINE("绘画"),
    DESCRIBE("描述"),
    BLEND("图片混合"),
    UPSCALE("放大"),
    VARIATION("变换"),
    REROLL("重新生成");
    private String description;
}
