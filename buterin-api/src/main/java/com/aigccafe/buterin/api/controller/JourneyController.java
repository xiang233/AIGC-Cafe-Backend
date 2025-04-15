package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.JourneyMemberType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.req.ChangeReqVO;
import com.aigccafe.buterin.common.model.req.ImagineReqVO;
import com.aigccafe.buterin.common.model.req.SessionReqVO;
import com.aigccafe.buterin.service.JourneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "MJ绘图-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/journey", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @ApiOperation(value = "新增或者更新一个绘图会话", notes = "更新名称时，才需要传id，新增时，sessionName传不传都可以")
    @PostMapping("/session")
    public BaseResponse updateSession(@RequestBody SessionReqVO sessionReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(journeyService.updateSession(sessionReqVO));
    }

    @ApiOperation(value = "删除一个绘图会话", notes = "删除一个会话")
    @DeleteMapping("/session")
    public BaseResponse deleteAnSession(@RequestParam(value = "id") Long sessionId) {
        StpUtil.checkLogin();
        return BaseResponse.success(journeyService.deleteSession(sessionId));
    }

    @ApiOperation(value = "获取用户的会话列表", notes = "可下拉，下拉加载更多")
    @GetMapping("/sessionList")
    public BaseResponse getSessionList(@RequestParam(value="offset") Integer offset,
                                       @RequestParam(value="number") Integer number) {
        StpUtil.checkLogin();
        Long userId = StpUtil.getLoginIdAsLong();
        return BaseResponse.success(journeyService.getSessionList(userId, offset, number));
    }

    @ApiOperation(value = "提交Imagine任务", notes = "提交一个Imagine画图任务")
    @PostMapping("/submit/imagine")
    public BaseResponse imagine(@RequestBody ImagineReqVO imagineReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(journeyService.submitImagine(imagineReqVO));
    }

    @ApiOperation(value = "提交图片变化任务", notes = "对指定任务生成的图片进行变化（放大或者变形）")
    @PostMapping("/submit/change")
    public BaseResponse change(@RequestBody ChangeReqVO changeReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(journeyService.submitChange(changeReqVO));
    }

    @ApiOperation(value = "获取某个任务最新的状态", notes = "获取某个任务最新的状态")
    @GetMapping("/task")
    public BaseResponse getTask(@RequestParam(value = "id") Long id) {
        log.info(StpUtil.getTokenValue());
        StpUtil.checkLogin();
        return BaseResponse.success(journeyService.getJourneyTask(id));
    }

    @ApiOperation(value = "获取某一个session下的任务列表", notes = "获取会话下的任务列表，按创建时间倒序")
    @GetMapping("/taskList")
    public BaseResponse getTaskList(@RequestParam(value = "id") Long sessionId,
                                    @RequestParam(value = "offset") Integer offset,
                                    @RequestParam(value = "number") Integer number) {
        StpUtil.checkLogin();
        return BaseResponse.success(journeyService.getJourneyTaskList(sessionId, offset, number));
    }

    @ApiOperation(value = "获取图片", notes = "code为源链接转码")
    @GetMapping("/image/{code}")
    public ResponseEntity<byte[]> getOuterImage(@PathVariable("code") String code) {
        // StpUtil.checkLogin();
        return journeyService.getOuterImage(code);
    }

    @ApiOperation(value = "获取会员产品介绍", notes = "获取会员产品介绍")
    @GetMapping("/member/introduction")
    public BaseResponse getJourneyMemberIntro() {
        // StpUtil.checkLogin();
        return BaseResponse.success(journeyService.getJourneyMemberIntro());
    }

    @ApiOperation(value = "设置某人为会员", notes = "获取会员产品介绍")
    @PostMapping("/member")
    public BaseResponse setJourneyMember(@RequestParam(value = "userId") Long userId,
                                         @RequestParam(value = "memberType") JourneyMemberType memberType) {
        // 验证是否为管理员
        boolean res = journeyService.addJourneyMember(userId, memberType);
        if (res) {
            return BaseResponse.success("添加成功");
        } else {
            return BaseResponse.fail("添加失败");
        }
    }
}
