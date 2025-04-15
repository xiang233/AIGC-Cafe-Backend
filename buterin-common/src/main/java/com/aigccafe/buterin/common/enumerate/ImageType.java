package com.aigccafe.buterin.common.enumerate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ImageType {

    AVATAR("user_avatar", "image/auto-orient,1/resize,m_lfit,w_200/quality,q_90/format,jpeg"),
    BACKGROUND("user_cover", "image/auto-orient,1/resize,m_lfit,w_600/quality,q_90/format,jpeg"),
    ARTICLE("article", "image/auto-orient,1/resize,m_lfit,w_512/quality,q_90/format,jpeg"),
    MODEL("version", "image/auto-orient,1/resize,m_lfit,w_512/quality,q_90/format,jpeg"),
    OUTER_ARTICLE("outer_article", "image/auto-orient,1/resize,m_lfit,w_512/quality,q_90/format,jpeg"),
    JOURNEY("journey_gallery", "image/auto-orient,1/resize,m_lfit,w_512/quality,q_90/format,jpeg");

    private final String dir;
    private final String resizeCmd;
}
