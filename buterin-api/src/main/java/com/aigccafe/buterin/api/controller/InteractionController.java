package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.md.ModelStatus;
import com.aigccafe.buterin.common.model.req.CommentReqVO;
import com.aigccafe.buterin.common.model.req.InteractionReqVO;
import com.aigccafe.buterin.service.InteractionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户交互行为-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/interact", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @ApiOperation(value = "[登录态]", notes = "发表评论")
    @PostMapping("/comment")
    public BaseResponse postAnComment(@RequestBody CommentReqVO comment ) {
        StpUtil.checkLogin();
        return BaseResponse.success(interactionService.addComment(comment));
    }

    @ApiOperation(value = "[登录态]", notes = "删除评论")
    @Delete("/comment")
    public BaseResponse deleteComment(@RequestParam(name="commentId") Long commentId) {
        StpUtil.checkLogin();
        return BaseResponse.success(interactionService.deleteComment(commentId));
    }

    @ApiOperation(value = "获取评论列表", notes = "此接口会返回指定条数（<20）评论信息，会显示子评论个数，以及第一条子评论（如果有）")
    @GetMapping("/comments")
    public BaseResponse getCommentList(@RequestParam(name="targetType") TargetType targetType,
                                       @RequestParam(name="targetId") Long targetId,
                                       @RequestParam(name="offset") Integer offset,
                                       @RequestParam(name="number") Integer number) {
        return BaseResponse.success(interactionService.getCommentsByTarget(targetType, targetId, offset, number));
    }

    @ApiOperation(value = "获取某一个评论下子评论列表", notes = "获取某一条评论下的子评论列表")
    @GetMapping("/comment/replies")
    public BaseResponse getCommentReplyList(@RequestParam(name="commentId") Long commentId,
                                            @RequestParam(name="offset") Integer offset,
                                            @RequestParam(name="number") Integer number) {
        return BaseResponse.success(interactionService.getCommentReplies(commentId, offset, number));
    }

    @ApiOperation(value = "[登录态]记录交互行为（点赞、收藏等）", notes = "添加普通的交互行为")
    @PostMapping("/interaction")
    public BaseResponse addSimpleInteraction(@RequestBody InteractionReqVO interactionReqVO ) {
        return BaseResponse.success(interactionService.addSimpleInteraction(interactionReqVO));
    }
}
