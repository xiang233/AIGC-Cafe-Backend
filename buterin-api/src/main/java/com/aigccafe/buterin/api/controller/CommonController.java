package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "通用接口-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/common", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommonController {


    @Autowired
    private ImageService imageService;


    @ApiOperation(value = "[登录态]上传头像到云", notes = "图片上传到云，会自动缩小到符合头像大小")
    @PostMapping(value = "/avatar/image")
    public BaseResponse putUserAvatarImage(@RequestParam(name="file") MultipartFile file) {
        StpUtil.checkLogin();
        return BaseResponse.success(imageService.uploadAvatar(file));
    }

    @ApiOperation(value = "[登录态]上传图片到云", notes = "图片上传到云，会自动缩小到符合头像大小")
    @PostMapping(value = "/article/image")
    public BaseResponse putArticleImage(@RequestParam(name="file") MultipartFile file) {
        StpUtil.checkLogin();
        return BaseResponse.success(imageService.uploadArticleImage(file));
    }

    @ApiOperation(value = "[登录态]上传图片到云", notes = "图片上传到云，会自动缩小到符合头像大小")
    @PostMapping(value = "/article/images")
    public BaseResponse putArticleImageList(@RequestParam(name="file") MultipartFile[] file) {
        StpUtil.checkLogin();
        return BaseResponse.success(imageService.uploadArticleImageList(file));
    }
}
