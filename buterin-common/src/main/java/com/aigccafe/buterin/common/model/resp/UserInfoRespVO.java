package com.aigccafe.buterin.common.model.resp;


import com.aigccafe.buterin.common.model.user.UserInfo;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserInfoRespVO {

    private Long userId;

    private String userName;

    private String role;

    private UserInfo userInfo;

    private Long points;
}
