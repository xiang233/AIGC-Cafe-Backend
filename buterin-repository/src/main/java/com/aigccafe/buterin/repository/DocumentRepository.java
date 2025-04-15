package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.enumerate.ArticleStatus;
import com.aigccafe.buterin.common.enumerate.DocumentType;
import com.aigccafe.buterin.common.model.doc.*;
import com.aigccafe.buterin.common.model.md.ModelDetailPO;

import java.util.List;

public interface DocumentRepository {

    int insert(DocumentPO modelPO);

    int insert(ArticlePOWithBLOBs articlePO);

    int insert(OuterArticlePOWithBLOBs outArticlePO);

    int update(DocumentPO modelPO);

    int update(ArticlePOWithBLOBs articlePO);

    int update(OuterArticlePOWithBLOBs outArticlePO);

    List<DocumentPO> selectDocumentByCondition(DocumentType type, Integer offset, Integer number);

    DocumentPO selectDocumentById(Long documentId);

    ArticlePOWithBLOBs selectArticleById(Long articleId);

    ArticlePO selectSimpleArticleById(Long article);

    List<ArticlePO> selectArticleByCondition(Long documentId, Long parentId);

    OuterArticlePOWithBLOBs selectNoteById(Long noteId);

    List<OuterArticlePO> selectSimpleNoteByCondition(ArticleStatus status, String tag, Integer offset, Integer number);

    Long countSimpleNoteByCondition(ArticleStatus status, String tag);

}
