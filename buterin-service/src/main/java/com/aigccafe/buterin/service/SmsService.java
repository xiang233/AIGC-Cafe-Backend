package com.aigccafe.buterin.service;

import com.aliyun.dysmsapi20170525.models.SendSmsResponse;

public interface SmsService {
    Boolean sendCode(String verifyCode, String phone);
}
