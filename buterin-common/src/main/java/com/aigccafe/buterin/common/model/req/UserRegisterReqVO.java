package com.aigccafe.buterin.common.model.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class UserRegisterReqVO {

    private String phoneNumber;

    private String userName;

    private String password;

    private String code;
}
