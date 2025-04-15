package com.aigccafe.buterin.api.controller;


import com.aigccafe.buterin.common.enumerate.ClientType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.service.CrawlService;
import com.aigccafe.buterin.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/proxy", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProxyController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private CrawlService crawlService;

    final static String TOKEN = "TING_KONG_RONG_XBION_JOHON_NOWQQ";

    @GetMapping("/hello")
    public BaseResponse hello() {
        return BaseResponse.success("hello world!");
    }


    @GetMapping("/fileUrl")
    public BaseResponse transferUrl(@RequestParam(value = "token") String token,
                                    @RequestParam(value = "url") String url) {
        if (!TOKEN.equals(token)) {
            return BaseResponse.fail("无权限");
        } else {
            return BaseResponse.success(crawlService.transferUrl(url));
        }
    }

    @GetMapping("/image")
    public BaseResponse storeImage(@RequestParam(value = "token") String token,
                                   @RequestParam(value = "url") String url) {
        if (!TOKEN.equals(token)) {
            return BaseResponse.fail("无权限");
        } else {
            return BaseResponse.success(imageService.storeImageOnOOS(url, ClientType.OKHTTP));
        }
    }
}
