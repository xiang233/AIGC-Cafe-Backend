package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.ArticleFormatType;
import com.aigccafe.buterin.common.enumerate.ArticleStatus;
import com.aigccafe.buterin.common.enumerate.DocumentType;
import com.aigccafe.buterin.common.model.req.ArticleReqVO;
import com.aigccafe.buterin.common.model.req.DocumentReqVO;
import com.aigccafe.buterin.common.model.req.NoteReqVO;
import com.aigccafe.buterin.common.model.resp.*;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface DocumentService {

    Boolean createDocument(DocumentReqVO documentReqVO);

    Boolean updateDocument(DocumentReqVO documentReqVO);

    boolean updateDocumentOrder(String documentList);

    Boolean updateNote(NoteReqVO noteReqVO);

    List<DocumentRespVO> getDocumentList(DocumentType type, Integer offset, Integer number);

    List<JSONObject> getDocumentTypeList();

    Boolean createArticle(ArticleReqVO articleReqVO);

    Boolean updateArticle(ArticleReqVO articleReqVO);

    List<SimpleArticleRespVO> getDocumentStruct(Long documentId);

    ArticleRespVO getArticle(ArticleFormatType type, Long articleId);

    NoteListRespVO getNoteList(ArticleStatus status, Integer offset, Integer number);

    NoteRespVO getNoteDetail(ArticleFormatType type, Long noteId);
}
