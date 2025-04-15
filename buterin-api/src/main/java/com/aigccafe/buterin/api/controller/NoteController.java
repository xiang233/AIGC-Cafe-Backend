package com.aigccafe.buterin.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.ArticleFormatType;
import com.aigccafe.buterin.common.enumerate.ArticleStatus;
import com.aigccafe.buterin.common.model.BaseResponse;
import com.aigccafe.buterin.common.model.req.NoteReqVO;
import com.aigccafe.buterin.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "采集笔记-API")
@RestController
@Validated
@Slf4j
@RequestMapping(value = "/cafe/knowledge", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class NoteController {

    @Autowired
    private DocumentService documentService;

    @ApiOperation(value = "更新笔记", notes = "更新实践笔记")
    @PostMapping("/note")
    public BaseResponse updateNote(@RequestBody NoteReqVO noteReqVO) {
        StpUtil.checkLogin();
        return BaseResponse.success(documentService.updateNote(noteReqVO));
    }

    @ApiOperation(value = "获取笔记列表", notes = "获取笔记列表，分页")
    @GetMapping("/notes")
    public BaseResponse getNoteList(@RequestParam(value = "status", defaultValue = "ONLINE") ArticleStatus status,
                                    @RequestParam(value = "offset") Integer offset,
                                    @RequestParam(value = "number") Integer number) {
        return BaseResponse.success(documentService.getNoteList(status, offset, number));
    }

    @ApiOperation(value = "获取所有的笔记列表", notes = "获取笔记列表，分页")
    @GetMapping("/review/notes")
    public BaseResponse getAllNoteList(@RequestParam(value = "offset") Integer offset,
                                    @RequestParam(value = "number") Integer number) {
        return BaseResponse.success(documentService.getNoteList(null, offset, number));
    }

    @ApiOperation(value = "获取笔记详情", notes = "用于用户浏览的笔记详情，edit判断是否传md5源码（用于编辑）")
    @GetMapping("/note/detail")
    public BaseResponse getNoteDetail(@RequestParam(value="format") ArticleFormatType type,
                                          @RequestParam(value = "id") Long nodeId) {
        return BaseResponse.success(documentService.getNoteDetail(type, nodeId));
    }
}
