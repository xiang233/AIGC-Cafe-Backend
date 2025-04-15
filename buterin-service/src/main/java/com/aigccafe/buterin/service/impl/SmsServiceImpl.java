package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.Constant;
import com.aigccafe.buterin.service.SmsService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public Boolean sendCode(String verifyCode, String phone) {
        JSONObject data = new JSONObject();
        data.fluentPut("code", verifyCode);
        try {
        com.aliyun.dysmsapi20170525.Client client = createClient(Constant.ACCESS_KEY_ID, Constant.ACCESS_KEY_SECRET);
        com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest()
                .setSignName("AIGCCAFE")
                .setTemplateCode("SMS_272570870")
                .setTemplateParam(data.toJSONString())
                .setPhoneNumbers(phone);
        SendSmsResponse sendResp =  null;

            sendResp = client.sendSms(sendSmsRequest);
            String code = sendResp.body.code;
            log.info("sms response:{}", JSON.toJSONString(sendResp));
            if (!com.aliyun.teautil.Common.equalString(code, "OK")) {
                return false;
            }
        } catch (Exception _error) {
            log.info("发码失败，请重试或联系客服，错误信息: " + _error.getMessage());
            return false;
        }
        return true;
    }

    private static com.aliyun.dysmsapi20170525.Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        com.aliyun.teaopenapi.models.Config config = new com.aliyun.teaopenapi.models.Config()
                // 必填，您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 必填，您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new com.aliyun.dysmsapi20170525.Client(config);
    }
}

