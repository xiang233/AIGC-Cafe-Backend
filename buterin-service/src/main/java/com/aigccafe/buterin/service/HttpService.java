package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

public interface HttpService {

    JSONObject requestJSONObject(HttpRequestConfig config) throws IOException;

    String requestRawText(HttpRequestConfig config) throws IOException;

    byte[] requestBytes(HttpRequestConfig config) throws IOException;

    ResponseEntity<byte[]> getRequestByOkHttp3(Integer retry, String url) throws Exception;
}
