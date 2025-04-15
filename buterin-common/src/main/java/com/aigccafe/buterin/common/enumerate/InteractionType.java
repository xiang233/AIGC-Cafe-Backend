package com.aigccafe.buterin.common.enumerate;

public enum InteractionType {
    LIKE,
    STORE,
    DOWNLOAD,
    COMMENT,
    SCORE,
    AGREE,
    DISAGREE,
    SUPPORT,
    UN_SUPPORT,
    VIEW,
    // 不会在Interaction表中记录
    ANSWER
}
