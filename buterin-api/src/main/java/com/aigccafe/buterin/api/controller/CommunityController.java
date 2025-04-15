package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.api.aspect.RateLimit;
import com.aigccafe.buterin.common.enumerate.AnswerSortedType;
import com.aigccafe.buterin.common.enumerate.QuestionFilterType;
import com.aigccafe.buterin.common.enumerate.QuestionSortedType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.req.AnswerReqVO;
import com.aigccafe.buterin.common.model.req.QuestionReqVO;
import com.aigccafe.buterin.service.CommunityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "社区问答-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/community", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @ApiOperation(value = "发起一个问题", notes = "用户发起一条问题帖子,id不用传")
    @PutMapping("/question")
    @RateLimit(value = 1.0)
    public BaseResponse newQuestion(@RequestBody QuestionReqVO questionReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.addQuestion(questionReqVO));
    }

    @ApiOperation(value = "修改问题", notes = "只传需要修改的部分，需传id")
    @PostMapping("/question")
    @RateLimit(value = 1.0)
    public BaseResponse updateQuestion(@RequestBody QuestionReqVO questionReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.updateQuestion(questionReqVO));
    }

    @ApiOperation(value = "删除问题", notes = "软删除，需传id，不会删除下面的回答")
    @Delete("/question")
    public BaseResponse deleteQuestion(@RequestParam(value = "id") Long questionId) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.deleteQuestion(questionId));
    }

    @ApiOperation(value = "发起一个回答", notes = "新增一条回答帖子,id不用传")
    @PutMapping("/answer")
    public BaseResponse newAnswer(@RequestBody AnswerReqVO answerReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.addAnswer(answerReqVO));
    }

    @ApiOperation(value = "修改回答", notes = "只需传修改的部分，需传id")
    @PostMapping("/answer")
    public BaseResponse updateAnswer(@RequestBody AnswerReqVO answerReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.updateAnswer(answerReqVO));
    }

    @ApiOperation(value = "删除回答", notes = "软删除，需传id")
    @Delete("/answer")
    public BaseResponse deleteAnswer(@RequestParam(value = "id") Long answerId) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.deleteAnswer(answerId));
    }

    @ApiOperation(value = "按条件列出帖子", notes = "按条件排序列出帖子（时间区间、赞成量、浏览量等）")
    @GetMapping("/question/list")
    public BaseResponse getQuestionByCondition(@RequestParam(value = "sortedType") QuestionSortedType sortedType,
                                               @RequestParam(value = "filters", required = false) List<QuestionFilterType> filters,
                                               @RequestParam(value = "tags", required = false) String tag,
                                               @RequestParam(value = "offset") Integer offset,
                                               @RequestParam(value = "number") Integer number) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.selectQuestionByCondition(sortedType, filters, tag, offset, number));
    }

    @ApiOperation(value = "帖子搜索接口", notes = "按关键词搜索相关的问题")
    @GetMapping("/question/search")
    public BaseResponse searchQuestion(@RequestParam(value = "keyword") String keyword,
                                       @RequestParam(value = "offset") Integer offset,
                                       @RequestParam(value = "number") Integer number) {
        StpUtil.checkLogin();
        return BaseResponse.success(communityService.searchQuestion(keyword, offset, number));
    }

    @ApiOperation(value = "查看帖子详情", notes = "看帖子详情信息")
    @GetMapping("/question/detail")
    public BaseResponse getQuestionDetail(@RequestParam(value = "id") Long questionId) {
        return BaseResponse.success(communityService.getQuestionDetail(questionId));
    }

    @ApiOperation(value = "查看回答列表", notes = "拉取某一个帖子下的回答列表（包括回答的评论）")
    @GetMapping("/answer/list")
    public BaseResponse getAnswerDetailList(@RequestParam(value = "id") Long questionId,
                                            @RequestParam(value = "sortedType") AnswerSortedType sortedType,
                                            @RequestParam(value = "offset") Integer offset,
                                            @RequestParam(value = "number") Integer number) {
        return BaseResponse.success(communityService.getAnswerDetailListByCondition(questionId, sortedType, offset, number));
    }

    @ApiOperation(value = "查看帖子源码", notes = "查看帖子源码")
    @GetMapping("/question/source")
    public BaseResponse getQuestionSource(@RequestParam(value = "id") Long questionId) {
        return BaseResponse.success(communityService.getQuestionSource(questionId));
    }

    @ApiOperation(value = "查看回答源码", notes = "查看回答源码")
    @GetMapping("/answer/source")
    public BaseResponse getAnswerSource(@RequestParam(value = "id") Long answerId) {
        return BaseResponse.success(communityService.getAnswerSource(answerId));
    }
}
