package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum JourneyTaskStatus {
    SUBMITTED("已提交"),
    NOT_START("未开始"),
    IN_PROGRESS("处理中"),
    FAILURE("失败"),
    SUCCESS("已完成");
    private String description;
}
