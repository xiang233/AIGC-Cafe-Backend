package com.aigccafe.buterin.common.model.http;

import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.enumerate.HttpMethod;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.Proxy;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HttpRequestConfig {
    private HttpMethod httpMethod;

    private ClientType clientType;

    private String url;

    private Map<String, String> headers;

    private String body;

    private byte[] byteBody;

    private boolean useProxy;

    @Builder.Default
    private Proxy.Type proxyType = Proxy.Type.HTTP;

    private String proxyIp;

    private String proxyUser;

    private String proxyPass;

    private Integer retry;
}
