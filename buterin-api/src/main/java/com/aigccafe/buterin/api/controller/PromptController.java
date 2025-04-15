package com.aigccafe.buterin.api.controller;

import com.aigccafe.buterin.api.aspect.RateLimit;
import com.aigccafe.buterin.common.enumerate.*;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.service.PromptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@Api(tags = "图片提示词-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/prompt", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PromptController {

    @Autowired
    private PromptService promptService;

    @ApiOperation(value = "获取提示词列表", notes = "提示词列表接口")
    @RateLimit(value = 5.0)
    @GetMapping("/list")
    public BaseResponse getPromptListInfo(@RequestParam(name="type", required = false, defaultValue = "SD") PromptType promptType,
                                          @RequestParam(name="offset") Integer offset,
                                          @RequestParam(name="number") Integer number,
                                          @RequestParam(name="sortedType", required = false, defaultValue = "VIEW") PromptSortedType sortedType) {

        if (PromptType.SD.equals(promptType)) {
            return BaseResponse.success(promptService.getPromptListByCondition(null, offset, number, sortedType));
        } else if (PromptType.MJ.equals(promptType)) {
            return BaseResponse.success(promptService.getMjPromptListByCondition(null , offset, number, sortedType, PromptStatus.ONLINE));
        } else {
            return BaseResponse.success(new ArrayList<>());
        }
    }

    @ApiOperation(value = "[新]获取提示词列表", notes = "提示词列表新接口")
    @RateLimit(value = 5.0)
    @GetMapping("/new/list")
    public BaseResponse getPromptList(@RequestParam(name="type") PromptType promptType,
                                          @RequestParam(name="offset") Integer offset,
                                          @RequestParam(name="number") Integer number,
                                          @RequestParam(name="sortedType") PromptSortedType sortedType) {

        if (PromptType.SD.equals(promptType)) {
            return BaseResponse.success(promptService.getSdPromptListByCondition(null, offset, number, sortedType, PromptStatus.ONLINE));
        } else if (PromptType.MJ.equals(promptType)) {
            return BaseResponse.success(promptService.getMjPromptListByCondition(null , offset, number, sortedType, PromptStatus.ONLINE));
        } else {
            return BaseResponse.success(new ArrayList<>());
        }
    }

    @ApiOperation(value = "[新]获取提示词详情", notes = "提示词详情，需要登录态")
    @RateLimit(value = 2.0)
    @GetMapping("/detail")
    public BaseResponse getPromptDetail(@RequestParam(name="type") PromptType promptType,
                                        @RequestParam(name="promptId") Long promptId) {
        if (PromptType.SD.equals(promptType)) {
            return BaseResponse.success(promptService.getSdPromptDetail(promptId));
        } else if (PromptType.MJ.equals(promptType)) {
            return BaseResponse.success(promptService.getMjPromptDetail(promptId));
        } else {
            return BaseResponse.success("{}");
        }
    }

    @ApiOperation(value = "提示词搜索接口", notes = "提示词搜索的接口，支持中英文")
    @RateLimit(value = 2.0)
    @GetMapping("/search")
    public BaseResponse search(@RequestParam(name="type") PromptType promptType,
                               @RequestParam(name="keyword") String keyword,
                               @RequestParam(name="offset") Integer offset,
                               @RequestParam(name="number") Integer number) {
        if (PromptType.SD.equals(promptType)) {
            return BaseResponse.success(promptService.searchSdPromptList(keyword, offset, number));
        } else if (PromptType.MJ.equals(promptType)) {
            return BaseResponse.success(promptService.searchMjPromptList(keyword, offset, number));
        } else {
            return BaseResponse.success("{}");
        }
    }

    @ApiOperation(value = "查看翻译后的提示词", notes = "将英文的提示词翻译为中文")
    @RateLimit(value = 2.0)
    @GetMapping("/translate")
    public BaseResponse translate(@RequestParam(name="type") PromptType promptType,
                                  @RequestParam(name="id") Long promptId) {
        if (PromptType.SD.equals(promptType)) {
            return BaseResponse.success(promptService.translateSdPrompt(promptId));
        } else if (PromptType.MJ.equals(promptType)) {
            return BaseResponse.success(promptService.translateMjPrompt(promptId));
        } else {
            return BaseResponse.success("{}");
        }
    }
}
