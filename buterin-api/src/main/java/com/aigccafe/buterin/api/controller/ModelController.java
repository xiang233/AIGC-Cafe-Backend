package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.api.aspect.RateLimit;
import com.aigccafe.buterin.common.enumerate.Channel;
import com.aigccafe.buterin.common.enumerate.EnumType;
import com.aigccafe.buterin.common.enumerate.ModelSortedType;
import com.aigccafe.buterin.common.enumerate.ModelType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.req.ModelDetailReqVO;
import com.aigccafe.buterin.common.model.req.ModelVersionFileReqVO;
import com.aigccafe.buterin.common.model.req.ModelVersionImageReqVO;
import com.aigccafe.buterin.common.model.req.ModelVersionReqVO;
import com.aigccafe.buterin.service.ModelService;
import com.aigccafe.buterin.service.SecurityService;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Api(tags = "模型信息-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/model", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ModelController {

    @Autowired
    private ModelService modelService;
    @Autowired
    private SecurityService securityService;

    @ApiOperation(value = "获取枚举映射", notes = "指定类别获取频道、模型类型、底模等的枚举信息")
    @GetMapping("/enumInfo")
    public BaseResponse getEnumInfo(@RequestParam(name="enumType", required = false) EnumType enumType) {
        return BaseResponse.success(modelService.getEnumInfo(enumType));
    }


    @ApiOperation(value = "获取模型列表", notes = "首页模型列表接口")
    @RateLimit(value = 10.0)
    @GetMapping("/list")
    public BaseResponse getModelListInfo(@RequestHeader(name = "_x5sec_mime_", required = false) String signature,
                                         @RequestParam(name="modelType", required = false) List<ModelType> modelTypeList,
                                         @RequestParam(name="baseModel", required = false) List<String> baseModelList,
                                         @RequestParam(name="channel", required = false) Channel channel,
                                         @RequestParam(name="offset") Integer offset,
                                         @RequestParam(name="number") Integer number,
                                         @RequestParam(name="sortedType", required = false, defaultValue = "DOWNLOAD") ModelSortedType sortedType) {
        List<String> modelTypeValueList = Lists.newArrayList();
        if (baseModelList == null) {
            baseModelList = Lists.newArrayList();
        }
        if (CollectionUtils.isNotEmpty(modelTypeList)) {
            modelTypeValueList = modelTypeList.stream().map(ModelType::getValue).collect(Collectors.toList());
        }
        String channelValue = channel == null ? null : channel.getDesc();
        return BaseResponse.success(modelService.getModelListByCondition(baseModelList, modelTypeValueList, channelValue, offset, number, sortedType));
    }

    @ApiOperation(value = "搜索列表", notes = "根据关键词搜索模型，会从标题、作者、标签搜索")
    @GetMapping("/search")
    public BaseResponse searchModelListInfo(@RequestHeader(name = "_x5sec_mime_", required = false) String signature,
                                            @RequestParam(name="keyword") String keyword,
                                            @RequestParam(name="offset") Integer offset,
                                            @RequestParam(name="number") Integer number) {
        securityService.checkSecurity(String.format("%s_%s_%s", keyword, offset, number), signature);
        return BaseResponse.success(modelService.searchModelList(keyword, offset, number));
    }

    @ApiOperation(value = "获取模型详情信息", notes = "模型详情页面以及第一个版本的信息")
    @GetMapping("/detail")
    @RateLimit(value = 1.0)
    public BaseResponse getModelDetail(@RequestHeader(name = "_x5sec_mime_", required = false) String signature,
                                       @RequestParam(name="modelId") Long modelId) {
        securityService.checkSecurity(String.format("%s", modelId), signature);
        return BaseResponse.success(modelService.getModelDetail(modelId));
    }

    @ApiOperation(value = "获取图片的提示词信息", notes = "获取某一张图片的提示词信息")
    @GetMapping("/image/prompt")
    @RateLimit(value = 1.0)
    public BaseResponse getImagePrompt(@RequestHeader(name = "_x5sec_mime_", required = false) String signature,
                                       @RequestParam(name="imageId") Long imageId) {
        securityService.checkSecurity(String.format("%s", imageId), signature);
        return BaseResponse.success(modelService.getImagePrompt(imageId));
    }

    @ApiOperation(value = "获取模型版本的详情信息", notes = "获取模型版本详细信息")
    @GetMapping("/version/detail")
    @RateLimit(value = 3.0)
    public BaseResponse getModelVersionDetail(@RequestHeader(name = "_x5sec_mime_", required = false) String signature,
                                              @RequestParam(name="modelId") Long modelId,
                                              @RequestParam(name="versionId") Long versionId) {
        securityService.checkSecurity(String.format("%s_%s", modelId, versionId), signature);

        return BaseResponse.success(modelService.getVersionDetail(modelId, versionId));
    }

    @ApiOperation(value = "[登录态]获取真实下载链接", notes = "获得真正的下载链接")
    @GetMapping("/version/download")
    @RateLimit(value = 3.0)
    public BaseResponse getDownloadUrl(@RequestHeader(name = "_x5sec_mime_", required = false) String signature,
                                       @RequestParam(name = "url") String url) {
//        securityService.checkSecurity(String.format("%s", url), signature);
//        StpUtil.checkLogin();
        //boolean isLogin = StpUtil.isLogin();
        boolean isLogin = true;
        if (isLogin) {
            String res = modelService.getDownloadUrl(url);
            return BaseResponse.success(res);
        } else {
            return BaseResponse.fail("需要登录后才能下载哦！", 401);
        }
    }

    @ApiOperation(value = "更新模型详情", notes = "新增或者更新模型信息")
    @PostMapping("/detail")
    public BaseResponse updateModelDetail(@RequestBody ModelDetailReqVO modelDetailReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(modelService.updateModelDetail(modelDetailReqVO));
    }

    @ApiOperation(value = "更新版本详情", notes = "新增或者更新模型版本信息")
    @PostMapping("/version")
    public BaseResponse updateModelVersion(@RequestBody ModelVersionReqVO modelVersionReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(modelService.updateModelVersion(modelVersionReqVO));
    }

    @ApiOperation(value = "新增或更新版本文件", notes = "新增或更新版本文件")
    @PostMapping("/version/file")
    public BaseResponse updateModelVersionFile(@RequestBody ModelVersionFileReqVO modelVersionFileReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(modelService.updateModelVersionFile(modelVersionFileReqVO));
    }

    @ApiOperation(value = "新增或更新版本展示图片", notes = "新增或更新版本展示图片")
    @PostMapping("/version/image")
    public BaseResponse updateModelVersionImage(@RequestBody ModelVersionImageReqVO modelVersionImageReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(modelService.updateModelVersionImage(modelVersionImageReqVO));
    }
}
