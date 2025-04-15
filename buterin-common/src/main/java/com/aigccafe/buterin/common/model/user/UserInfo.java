package com.aigccafe.buterin.common.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserInfo {

    private String nickname;

    private String avatarUrl;

    @Builder.Default
    private String profile = "作者很懒，还没有写些什么";
}
