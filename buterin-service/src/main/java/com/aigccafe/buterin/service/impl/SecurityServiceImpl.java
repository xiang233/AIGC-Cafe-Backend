package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.util.SecUtil;
import com.aigccafe.buterin.service.SecurityService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    private static final String TOKEN = "ONX3293&*_@@JON!9*&_@#!dfFAOMO\\\"$@!ilNEE";

    @Override
    public void checkSecurity(String targetId, String authCode) {

        String tmp =  "MD_" + TOKEN + targetId + TOKEN;
        String md5Result = SecUtil.md5(tmp);
//        if (!Strings.isNullOrEmpty(md5Result) && !md5Result.equals(authCode)) {
//            throw new RuntimeException("挤爆了，请稍后再试");
//        }
    }
}
