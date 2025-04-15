package com.aigccafe.buterin.common.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse {

    private int status;

    private String msg;

    private Object data;

    public static BaseResponse success(Object data) {
        return BaseResponse.builder()
                .status(0)
                .msg("")
                .data(data)
                .build();
    }

    public static BaseResponse fail(String message) {
        return BaseResponse.builder()
                .status(403)
                .msg(message)
                .build();
    }

    public static BaseResponse fail(String message, int status) {
        return BaseResponse.builder()
                .status(status)
                .msg(message)
                .build();
    }
}
