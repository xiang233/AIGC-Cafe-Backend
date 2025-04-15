package com.aigccafe.buterin.api.config;

import cn.dev33.satoken.exception.NotLoginException;
import com.aigccafe.buterin.common.model.BaseResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 未登录异常
    @ExceptionHandler(NotLoginException.class)
    public BaseResponse handlerException(NotLoginException e) {
        return BaseResponse.fail("未登录", 401);
    }

    // 风控异常

    // 默认异常拦截
    @ExceptionHandler(Exception.class)
    public BaseResponse handlerException(Exception e) {
        e.printStackTrace();
        return BaseResponse.fail(e.getMessage(), 403);
    }
}
