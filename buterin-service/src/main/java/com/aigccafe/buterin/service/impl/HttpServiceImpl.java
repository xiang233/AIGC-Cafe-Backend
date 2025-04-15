package com.aigccafe.buterin.service.impl;

import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.enumerate.HttpMethod;
import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.aigccafe.buterin.service.HttpService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class HttpServiceImpl implements HttpService {

//    private static OkHttpClient client = new OkHttpClient.Builder()
//            .retryOnConnectionFailure(false)
//            .readTimeout(20000, TimeUnit.MILLISECONDS)
//            .writeTimeout(20000, TimeUnit.MILLISECONDS)
//            .connectTimeout(20000, TimeUnit.MILLISECONDS)
//            .hostnameVerifier((s, sslSession) -> true)
//            .build();

    @Override
    public JSONObject requestJSONObject(HttpRequestConfig config) throws IOException {
        if (ClientType.HTTPCLIENT.equals(config.getClientType())) {
            HttpEntity entity = requestRawByHttpClient(config);
            String entityStr = EntityUtils.toString(entity);
//            log.info(entityStr);
            return JSONObject.parseObject(entityStr);
        } else {
            Response response = requestRawByOkHttp(config);
            assert response.body() != null;
            String responseStr = response.body().string();
            return JSONObject.parseObject(responseStr);
        }
    }

    @Override
    public byte[] requestBytes(HttpRequestConfig config) throws IOException {
        if (ClientType.HTTPCLIENT.equals(config.getClientType())) {
            HttpEntity entity = requestRawByHttpClient(config);
            return EntityUtils.toByteArray(entity);
        } else {
            Response response = requestRawByOkHttp(config);
            assert response.body() != null;
            return response.body().bytes();
        }
    }

    @Override
    public String requestRawText(HttpRequestConfig config) throws IOException {
        if (ClientType.HTTPCLIENT.equals(config.getClientType())) {
            HttpEntity entity = requestRawByHttpClient(config);
            return EntityUtils.toString(entity);
        } else {
            Response response = requestRawByOkHttp(config);
//            log.info("response:{}", JSON.toJSONString(response));
//            log.info("headers:{}", JSON.toJSONString(response.headers()));
            assert response.body() != null;
            return response.body().string();
        }
    }

    private Response requestRawByOkHttp(HttpRequestConfig config) throws IOException {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        if (config.isUseProxy() && !Strings.isNullOrEmpty(config.getProxyIp())) {
            String[] hostIp = config.getProxyIp().split(":");
            if (hostIp.length != 2) {
                throw new IOException("代理格式不对：" + config.getProxyIp());
            }
            String proxyHost = hostIp[0];
            int proxyPort = Integer.parseInt(hostIp[1]);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            clientBuilder.proxy(proxy);

            if (!Strings.isNullOrEmpty(config.getProxyUser()) && !Strings.isNullOrEmpty(config.getProxyPass())) {
                Authenticator proxyAuthenticator = (route, response) -> {
                    String credential = Credentials.basic(config.getProxyUser(), config.getProxyPass());
                    return response.request().newBuilder()
                            .header("Proxy-Authorization", credential)
                            .build();
                };
                clientBuilder.proxyAuthenticator(proxyAuthenticator);
            }
        }

        OkHttpClient client = clientBuilder.build();
        Request.Builder requestBuilder = new Request.Builder().url(config.getUrl());

        if (config.getHeaders() != null) {
            for (Map.Entry<String, String> header : config.getHeaders().entrySet()) {
                requestBuilder.addHeader(header.getKey(), header.getValue());
            }
        }

        if (HttpMethod.GET.equals(config.getHttpMethod())) {
            requestBuilder.get();
        } else if (HttpMethod.POST.equals(config.getHttpMethod())) {
            RequestBody body = config.getBody() != null ? RequestBody.create(MediaType.parse("application/json; charset=utf-8"), config.getBody()) : null;
            requestBuilder.post(body);
        }

        Request request = requestBuilder.build();
        Response res = null;

        for (int attempt = 0; attempt <= config.getRetry(); attempt++) {
            try (Response response = client.newCall(request).execute()) {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                res = response;
                break;
            } catch (IOException e) {
                if (attempt == config.getRetry()) {
                    throw e;
                }
            }
        }
        return res;
    }


    private HttpEntity requestRawByHttpClient(HttpRequestConfig config) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();

        // 代理设置
        if (config.isUseProxy() && !Strings.isNullOrEmpty(config.getProxyIp())) {
            String[] hostIp = config.getProxyIp().split(":");
            if (hostIp.length != 2)
                throw new IOException("代理格式不对：" + config.getProxyIp());
            HttpHost proxy = new HttpHost(hostIp[0], Integer.parseInt(hostIp[1]));
            requestConfigBuilder.setProxy(proxy);

            if (!Strings.isNullOrEmpty(config.getProxyUser()) && !Strings.isNullOrEmpty(config.getProxyPass())) {
                CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
                credentialsProvider.setCredentials(
                        new AuthScope(hostIp[0], Integer.parseInt(hostIp[1])),
                        new UsernamePasswordCredentials(config.getProxyUser(), config.getProxyPass())
                );
                httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
            }
        }
        httpClientBuilder.setDefaultRequestConfig(requestConfigBuilder.build());
        HttpClient httpClient = httpClientBuilder.build();

        HttpResponse response = null;
        HttpEntity httpEntity = null;

        for (int attempt = 0; attempt <= config.getRetry(); attempt++) {
            try {
                if (HttpMethod.GET.equals(config.getHttpMethod())) {
                    HttpGet httpGet = new HttpGet(config.getUrl());
                    if (config.getHeaders() != null) {
                        for (Map.Entry<String, String> header : config.getHeaders().entrySet()) {
                            httpGet.addHeader(header.getKey(), header.getValue());
                        }
                    }
                    response = httpClient.execute(httpGet);
//                    log.info("response:{}", JSON.toJSONString(response));
                } else if (HttpMethod.POST.equals(config.getHttpMethod())) {
                    HttpPost httpPost = new HttpPost(config.getUrl());
                    if (config.getHeaders() != null) {
                        for (Map.Entry<String, String> header : config.getHeaders().entrySet()) {
                            httpPost.addHeader(header.getKey(), header.getValue());
                        }
                    }
                    if (config.getBody() != null) {
                        HttpEntity entity = new StringEntity(config.getBody());
                        httpPost.setEntity(entity);
                    }
                    response = httpClient.execute(httpPost);
                }
                if (response != null) {
                    httpEntity = response.getEntity();
                    break;
                }
            } catch (IOException e) {
                if (attempt == config.getRetry()) {
                    throw e;
                }
            }
        }
        return httpEntity;
    }

    @Override
    public ResponseEntity<byte[]> getRequestByOkHttp3(Integer retry, String url) throws Exception {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .readTimeout(20000, TimeUnit.MILLISECONDS)
                .writeTimeout(20000, TimeUnit.MILLISECONDS)
                .connectTimeout(20000, TimeUnit.MILLISECONDS)
                .hostnameVerifier((s, sslSession) -> true);

//        OkHttpClient.Builder builder = client.newBuilder();
        builder = builder
                .sslSocketFactory(getSSLSocketFactory(), X_509_TRUST_MANAGER);
        OkHttpClient client = builder.build();
        Request requestData = new Request.Builder()
                .url(url)
                .method("GET", null)
                .build();

        Response res;
        for (int attempt = 0; attempt <= retry; attempt++) {
            try (Response response = client.newCall(requestData).execute()) {
                res = response;
                if (response.isSuccessful()) {
                    ResponseBody responseBody = res.body();
                    if (responseBody != null) {
                        byte[] bytes = responseBody.bytes();
                        org.springframework.http.MediaType mediaType = org.springframework.http.MediaType.parseMediaType(Objects.requireNonNull(responseBody.contentType()).toString());
                        HttpHeaders headers1 = new HttpHeaders();
                        headers1.setContentType(mediaType);
                        return new ResponseEntity<>(bytes, headers1, HttpStatus.OK);
                    }  else {
                        throw new RuntimeException("请求体为空");
                    }
                }
                break;
            } catch (Exception e) {
                if (attempt == retry) {
                    throw e;
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, new TrustManager[]{X_509_TRUST_MANAGER}, new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static final X509TrustManager X_509_TRUST_MANAGER = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[]{};
        }
    };

}
