package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Channel {
    SELECTED("精选"),
    SDXL("SDXL"),
    CHINESE("国风"),
    ANIME("动漫"),
    ART_STYLE("艺术风"),
    THREE_DIM("3D"),
    REALISTIC("写实"),
    SCENERY("自然风景"),
    BUILDING("建筑"),
    CLOTHES("服饰配件"),
    MAN_STYLE("男生"),
    ANIMAL("动物"),
    PLANE_DESIGN("平面设计"),
    TOOLS("工具"),
    OTHER("其他类型");
    private final String desc;
}
