package com.aigccafe.buterin.common.enumerate;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum JourneyMemberType {

    NORMAL_MONTH("社区版", "¥30元/每月",
            Lists.newArrayList("生成的图片是公开的，会自动分享到社区",
                    "每月200张快速出图",
                    "图片永久保存",
                    "限一个账号使用"
            ), 200, 30.0, 2592000L),
    PRIVATE_MONTH("私密版", "¥45元/每月",
            Lists.newArrayList("生成的图片是私密的，不会自动分享到社区",
                    "每月200张快速出图",
                    "图片永久保存",
                    "限一个账号使用"
            ) ,200, 45.0, 2592000L);

    private String value;

    private String title;

    private List<String> descriptions;

    private Integer fastNumber;

    private Double price;

    private Long duration;
}
