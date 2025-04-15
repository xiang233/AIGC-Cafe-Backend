package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.ArticleFormatType;
import com.aigccafe.buterin.common.enumerate.DocumentType;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.req.ArticleReqVO;
import com.aigccafe.buterin.common.model.req.DocumentReqVO;
import com.aigccafe.buterin.common.model.req.ModelDetailReqVO;
import com.aigccafe.buterin.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "知识中心-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/knowledge", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ArticleController {

    @Autowired
    private DocumentService documentService;

    @ApiOperation(value = "新增文档", notes = "新增一个文档")
    @PutMapping("/document")
    public BaseResponse insertDocument(@RequestBody DocumentReqVO documentReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(documentService.createDocument(documentReqVO));
    }

    @ApiOperation(value = "更新文档", notes = "更新文档信息")
    @PostMapping("/document")
    public BaseResponse updateDocument(@RequestBody DocumentReqVO documentReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(documentService.updateDocument(documentReqVO));
    }

    @ApiOperation(value = "更新文档排列顺序", notes = "更新文档顺序,orderList为以逗号分隔好的新排列次序")
    @PostMapping("/document/order")
    public BaseResponse updateDocumentOrder(@RequestParam(value = "orderList") String orderList) {
        StpUtil.checkLogin();
        return BaseResponse.success(documentService.updateDocumentOrder(orderList));
    }

    @ApiOperation(value = "获取文档分类列表", notes = "获取文档分类列表")
    @GetMapping("/document/types")
    public BaseResponse getDocumentTypeList() {
        return BaseResponse.success(documentService.getDocumentTypeList());
    }

    @ApiOperation(value = "获取文档卡片列表", notes = "获取文档卡片列表，type可不指定")
    @GetMapping("/documents")
    public BaseResponse getDocumentList(@RequestParam(value = "type", required = false) DocumentType type,
                                        @RequestParam(value = "offset") Integer offset,
                                        @RequestParam(value = "number") Integer number) {
        return BaseResponse.success(documentService.getDocumentList(type, offset, number));
    }

    @ApiOperation(value = "新增一篇文章", notes = "新增一篇文章，如果有父文章，parentId需要有值")
    @PutMapping("/article")
    public BaseResponse insertArticle(@RequestBody ArticleReqVO articleReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(documentService.createArticle(articleReqVO));
    }

    @ApiOperation(value = "更新文章", notes = "更新一篇文章的内容")
    @PostMapping("/article")
    public BaseResponse updateArticle(@RequestBody ArticleReqVO articleReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(documentService.updateArticle(articleReqVO));
    }

    @ApiOperation(value = "获取某一文档下文章列表结构", notes = "获取某一文档下所有文章的列表结构")
    @GetMapping("/document/struct")
    public BaseResponse getDocumentStruct(@RequestParam(value = "id") Long documentId) {
        return BaseResponse.success(documentService.getDocumentStruct(documentId));
    }

    @ApiOperation(value = "获取某一文章的内容", notes = "获取某一指定文章指定格式的内容")
    @GetMapping("/article")
    public BaseResponse getArticleHtml(@RequestParam(value="format") ArticleFormatType type,
                                       @RequestParam(value = "id") Long articleId) {
        return BaseResponse.success(documentService.getArticle(type, articleId));
    }

}
