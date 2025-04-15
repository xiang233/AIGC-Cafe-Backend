package com.aigccafe.buterin.common.model.req;

import com.aigccafe.buterin.common.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserInfoReqVO {
    private Long userId;

    private UserInfo userInfo;
}
