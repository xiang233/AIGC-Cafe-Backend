package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum QuestionFilterType {
    WEEK,
    MONTH,
    ALL_TIME,
    UN_ANSWER,
    ANSWERED,
    APPROVED,
    UN_APPROVED
}
