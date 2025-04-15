package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.req.LoginReqVO;
import com.aigccafe.buterin.common.model.req.UserInfoReqVO;
import com.aigccafe.buterin.common.model.req.UserRegisterReqVO;
import com.aigccafe.buterin.common.model.resp.UserInfoRespVO;
import com.aigccafe.buterin.common.model.user.UserInfo;
import com.aigccafe.buterin.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否已存在", notes = "判断用户名是否已存在")
    @GetMapping("/name/existence")
    public BaseResponse userNameExist(@RequestParam String userName) {
        boolean res = userService.userExist(userName);
        if (res) {
            return BaseResponse.success("用户名可注册");
        } else {
            return BaseResponse.fail("用户名已存在");
        }
    }

    @ApiOperation(value = "获取验证码", notes = "填入一个符合标准的手机号，然后发起验证码请求")
    @GetMapping("/register/sms")
    public BaseResponse getSmsCode(@RequestParam String phoneNumber) {
        boolean res = userService.sendCode(phoneNumber);
        if (res) {
            return BaseResponse.success("已发送");
        } else {
            return BaseResponse.fail("发送失败，请重试");
        }
    }

    @ApiOperation(value = "注册新用户", notes = "使用手机号注册一个新用户")
    @PostMapping("/register")
    public BaseResponse register(@RequestBody UserRegisterReqVO userRegisterReqVO) {
        boolean res = userService.register(userRegisterReqVO);
        if (res) {
            return BaseResponse.success("注册成功");
        } else {
            return BaseResponse.fail("注册失败");
        }
    }

    @ApiOperation(value = "重新设置密码", notes = "忘记密码，重新设置密码")
    @PostMapping("/password/reset")
    public BaseResponse resetPassword(@RequestBody UserRegisterReqVO userRegisterReqVO) {
        boolean res = userService.resetPassword(userRegisterReqVO);
        if (res) {
            return BaseResponse.success("注册成功");
        } else {
            return BaseResponse.fail("注册失败");
        }
    }

    @ApiOperation(value = "用户登录", notes = "使用账号+密码的方式登录")
    @PostMapping("/login")
    public BaseResponse loginByPassword(@RequestBody LoginReqVO loginReqVO) {
        boolean res = userService.login(loginReqVO.getUserName(), loginReqVO.getPassword());
        if (res) {
            return BaseResponse.success("登录成功");
        } else {
            return BaseResponse.fail("登录失败", 401);
        }
    }

    @ApiOperation(value = "用户登出", notes = "用户登出")
    @PostMapping("/logout")
    public BaseResponse logout() {
        StpUtil.logout();
        return BaseResponse.success(true);
    }

    @ApiOperation(value = "[登录态]获取当前用户信息", notes = "获取用户的信息")
    @GetMapping("/info")
    public BaseResponse getUserInfo() {
        StpUtil.checkLogin();
        Long userId = StpUtil.getLoginIdAsLong();
        UserInfoRespVO userInfo = userService.getUserInfo(userId);
        return BaseResponse.success(userInfo);
    }

    @ApiOperation(value = "[登录态]修改当前用户信息", notes = "修改用户的信息")
    @PostMapping("/info")
    public BaseResponse updateUserInfo(@RequestBody UserInfoReqVO userInfo) {
        StpUtil.checkLogin();
        Long userId = StpUtil.getLoginIdAsLong();
        return BaseResponse.success(userService.updateUserInfo(userId, userInfo.getUserInfo()));
    }

    @ApiOperation(value = "[登录态]获取我的收藏信息", notes = "获取用户我的收藏信息")
    @GetMapping("/stores")
    public BaseResponse getUserStores(@RequestParam(name = "type") TargetType type,
                                      @RequestParam(name = "number") Integer number,
                                      @RequestParam(name = "offset") Integer offset) {
        StpUtil.checkLogin();
        Long userId = StpUtil.getLoginIdAsLong();
        return BaseResponse.success(userService.getUserStores(type, userId, number, offset));
    }
}
