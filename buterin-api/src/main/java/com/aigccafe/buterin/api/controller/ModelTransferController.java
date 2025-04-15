package com.aigccafe.buterin.api.controller;

import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.service.ModelService;
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

@Api(tags = "文件转储业务-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/transfer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ModelTransferController {

    @Autowired
    private ModelService modelService;

    final static String TOKEN = "aigccage@1233";

    @ApiOperation(value = "获取模型列表", notes = "通过offset、number来遍历所有模型，会返回模型所有版本、版本文件个数、更新url个数等")
    @GetMapping("/model/list")
    public BaseResponse getModelDownloadInfo(@RequestParam(name="token") String token,
                                             @RequestParam(name="offset") Integer offset,
                                             @RequestParam(name="number") Integer number) {
        if (!TOKEN.equals(token)) {
            return BaseResponse.fail("没有权限");
        }
        return BaseResponse.success(modelService.getModelSimpleListByRank(offset, number));
    }

    @ApiOperation(value = "获取模型信息", notes = "会返回指定模型的版本信息，每个版本下的文件信息及源下载地址")
    @GetMapping("/model/info")
    public BaseResponse getModelDownloadInfo(@RequestParam(name="token") String token,
                                             @RequestParam(name="id") Long modelId) {
        if (!TOKEN.equals(token)) {
            return BaseResponse.fail("没有权限");
        }
       return BaseResponse.success(modelService.getModelFileInfo(modelId));
    }

    @ApiOperation(value = "更新某一个文件的转存地址", notes = "下载并转储完后，需把生成的下载url更新到对应的文件记录中")
    @GetMapping("/update/transferUrl")
    public BaseResponse updateFileUrl(@RequestParam(name="token") String token,
                                      @RequestParam(name="fileId") Long fileId,
                                      @RequestParam(name="transferUrl") String url) {
        if (!TOKEN.equals(token)) {
            return BaseResponse.fail("没有权限");
        }
        return BaseResponse.success(modelService.updateTransferUrl(fileId, url));
    }
}
