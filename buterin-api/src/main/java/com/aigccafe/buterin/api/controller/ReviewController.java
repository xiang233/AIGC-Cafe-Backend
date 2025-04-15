package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.api.aspect.RateLimit;
import com.aigccafe.buterin.common.enumerate.PromptSortedType;
import com.aigccafe.buterin.common.enumerate.PromptType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.md.ModelStatus;
import com.aigccafe.buterin.common.model.prompt.PromptStatus;
import com.aigccafe.buterin.common.model.req.ModelReviewUpdateReqVO;
import com.aigccafe.buterin.service.ModelService;
import com.aigccafe.buterin.service.PromptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api(tags = "内容审核业务-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/review", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ReviewController {

    @Autowired
    private ModelService modelService;
    @Autowired
    private PromptService promptService;

    @ApiOperation(value = "[管理员权限]获取待审核模型列表信息", notes = "返回指定位置个数的模型列表信息")
    @GetMapping("/model/list")
    public BaseResponse getModelDownloadInfo(@RequestParam(name="status", required = false) ModelStatus status,
                                             @RequestParam(name="offset") Integer offset,
                                             @RequestParam(name="number") Integer number) {
        // StpUtil.checkRole(Role.ADMIN.name());
//        StpUtil.checkLogin();
        return BaseResponse.success(modelService.getModelListByStatus(status, offset, number));
    }

    @ApiOperation(value = "[管理员权限]更新模型信息", notes = "审核结束后要对模型进行判定，上线还是下线")
    @PostMapping("/model")
    public BaseResponse updateModel(@RequestBody ModelReviewUpdateReqVO model) {
        // StpUtil.checkRole(Role.ADMIN.name());
//        StpUtil.checkLogin();
        return BaseResponse.success(modelService.updateReviewedModel(model));
    }
//    @ApiOperation(value = "[管理员权限]更改模型状态", notes = "审核结束后要对模型进行判定，上线还是下线")
//    @PostMapping("/model/status")
//    public BaseResponse updateModelStatus(@RequestParam(name="modelId") Long modelId,
//                                          @RequestParam(name="status") ModelStatus status) {
//        // StpUtil.checkRole(Role.ADMIN.name());
//        return BaseResponse.success(modelService.updateModelStatus(modelId, status));
//    }
//
//    @ApiOperation(value = "[管理员权限]更改模型的标签", notes = "重新设定模型的标签")
//    @PostMapping("/model/tags")
//    public BaseResponse updateModelTags(@RequestParam(name="modelId") Long modelId,
//                                          @RequestParam(name="tags") String tags) {
//        // StpUtil.checkRole(Role.ADMIN.name());
//        return BaseResponse.success(modelService.updateModelTags(modelId, tags));
//    }
//
//    @ApiOperation(value = "[管理员权限]将某一张图片设置为模型封面", notes = "设置某一张图片为模型的封面")
//    @PostMapping("/model/cover")
//    public BaseResponse setModelCover(@RequestParam(name="modelId") Long modelId,
//                                      @RequestParam(name="imageId") Long imageId) {
//        // StpUtil.checkRole(Role.ADMIN.name());
//        return BaseResponse.success(modelService.setCoverImage(modelId, imageId));
//    }
    @ApiOperation(value = "[管理员权限]删除某一张图片", notes = "审核发现某些图片不宜展示，可进行删除")
    @PostMapping("/image/delete")
    public BaseResponse deleteImage(@RequestParam(name="imageId") Long imageId) {
        // StpUtil.checkRole(Role.ADMIN.name());
//        StpUtil.checkLogin();
        return BaseResponse.success(modelService.deleteImage(imageId));
    }

    @ApiOperation(value = "[管理员权限]获取所有提示词列表", notes = "获取所有的提示词列表")
    @RateLimit(value = 2.0)
    @GetMapping("/prompt/list")
    public BaseResponse getPromptList(@RequestParam(name="type") PromptType promptType,
                                      @RequestParam(name="status") PromptStatus promptStatus,
                                      @RequestParam(name="sortedType") PromptSortedType sortedType,
                                      @RequestParam(name="offset") Integer offset,
                                      @RequestParam(name="number") Integer number) {
        // StpUtil.checkRole(Role.ADMIN.name());
//        StpUtil.checkLogin();
        if (PromptType.SD.equals(promptType)) {
            return BaseResponse.success(promptService.getSdPromptListByCondition(null, offset, number, sortedType, promptStatus));
        } else if (PromptType.MJ.equals(promptType)) {
            return BaseResponse.success(promptService.getMjPromptListByCondition(null , offset, number, sortedType, promptStatus));
        } else {
            return BaseResponse.success(new ArrayList<>());
        }
    }

    @ApiOperation(value = "[管理员权限]更新提示词状态", notes = "更新某一个提示词图片的状态")
    @RateLimit(value = 2.0)
    @PostMapping("/prompt")
    public BaseResponse updatePrompt(@RequestParam(name="type") PromptType promptType,
                                     @RequestParam(name="id") Long promptId,
                                     @RequestParam(name="status") PromptStatus promptStatus) {
        // StpUtil.checkRole(Role.ADMIN.name());
//        StpUtil.checkLogin();
        return BaseResponse.success(promptService.updatePromptStatus(promptType, promptId, promptStatus));
    }
}
