package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.enumerate.ArticleStatus;
import com.aigccafe.buterin.common.enumerate.DocumentType;
import com.aigccafe.buterin.common.model.doc.*;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.repository.DocumentRepository;
import com.aigccafe.buterin.repository.mapper.ArticlePOMapper;
import com.aigccafe.buterin.repository.mapper.DocumentPOMapper;
import com.aigccafe.buterin.repository.mapper.OuterArticlePOMapper;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Slf4j
@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    @Autowired
    private DocumentPOMapper documentPOMapper;
    @Autowired
    private ArticlePOMapper articlePOMapper;
    @Autowired
    private OuterArticlePOMapper outerArticlePOMapper;

    @Override
    public int insert(DocumentPO documentPO) {
        documentPO.setCreatedAt(DateTimeUtils.nowSeconds());
        documentPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        documentPO.setIsDeleted(false);
        return documentPOMapper.insertSelective(documentPO);
    }

    @Override
    public int insert(ArticlePOWithBLOBs articlePO) {
        articlePO.setCreatedAt(DateTimeUtils.nowSeconds());
        articlePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        articlePO.setIsDeleted(false);
        return articlePOMapper.insertSelective(articlePO);
    }

    @Override
    public int insert(OuterArticlePOWithBLOBs outArticlePO) {
        outArticlePO.setCreatedAt(DateTimeUtils.nowSeconds());
        outArticlePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        outArticlePO.setStatus(ArticleStatus.REVIEW.name());
        outArticlePO.setIsDeleted(false);
        return outerArticlePOMapper.insertSelective(outArticlePO);
    }


    @Override
    public int update(DocumentPO documentPO) {
        documentPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return documentPOMapper.updateByPrimaryKeySelective(documentPO);
    }

    @Override
    public int update(ArticlePOWithBLOBs articlePO) {
        articlePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return articlePOMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public int update(OuterArticlePOWithBLOBs outArticlePO) {
        outArticlePO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return outerArticlePOMapper.updateByPrimaryKeySelective(outArticlePO);
    }

    @Override
    public List<DocumentPO> selectDocumentByCondition(DocumentType type, Integer offset, Integer number) {
        DocumentPOExample example = new DocumentPOExample();
        DocumentPOExample.Criteria criteria = example.createCriteria();
        if (type != null) {
            criteria.andDocumentTypeEqualTo(type.name());
        }
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(offset, number);
        example.setOrderByClause("created_at asc");
        return documentPOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public List<ArticlePO> selectArticleByCondition(Long documentId, Long parentId) {
        ArticlePOExample example = new ArticlePOExample();
        ArticlePOExample.Criteria criteria = example.createCriteria();

        if (documentId != null) {
            criteria.andDocumentIdEqualTo(documentId);
        }
        if (parentId != null) {
            criteria.andParentIdEqualTo(parentId);
        }
        criteria.andIsDeletedEqualTo(false);
        return articlePOMapper.selectByExample(example);
    }


    @Override
    public DocumentPO selectDocumentById(Long documentId) {
        DocumentPOExample example = new DocumentPOExample();
        DocumentPOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(documentId);
        criteria.andIsDeletedEqualTo(false);
        List<DocumentPO> documentPOS = documentPOMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(documentPOS) ? documentPOS.get(0) : null;
    }

    @Override
    public ArticlePOWithBLOBs selectArticleById(Long articleId) {
        ArticlePOExample example = new ArticlePOExample();
        ArticlePOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(articleId);
        criteria.andIsDeletedEqualTo(false);
        List<ArticlePOWithBLOBs> articlePOS = articlePOMapper.selectByExampleWithBLOBs(example);
        return CollectionUtils.isNotEmpty(articlePOS) ? articlePOS.get(0) : null;
    }

    @Override
    public ArticlePO selectSimpleArticleById(Long articleId) {
        ArticlePOExample example = new ArticlePOExample();
        ArticlePOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(articleId);
        criteria.andIsDeletedEqualTo(false);
        List<ArticlePO> articlePOS = articlePOMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(articlePOS) ? articlePOS.get(0) : null;
    }

    @Override
    public OuterArticlePOWithBLOBs selectNoteById(Long noteId) {
        OuterArticlePOExample example = new OuterArticlePOExample();
        OuterArticlePOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(noteId);
        criteria.andIsDeletedEqualTo(false);
        List<OuterArticlePOWithBLOBs> notePOList = outerArticlePOMapper.selectByExampleWithBLOBs(example);
        return CollectionUtils.isNotEmpty(notePOList) ? notePOList.get(0) : null;
    }

    @Override
    public List<OuterArticlePO> selectSimpleNoteByCondition(ArticleStatus status, String tag, Integer offset, Integer number) {
        OuterArticlePOExample example = new OuterArticlePOExample();
        OuterArticlePOExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(tag)) {
            criteria.andTagsLike("%" + tag + "$");
        }
        if (status != null) {
            criteria.andStatusEqualTo(status.name());
        }
        criteria.andIsDeletedEqualTo(false);
        RowBounds rowBounds = new RowBounds(offset, number);
        return outerArticlePOMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public Long countSimpleNoteByCondition(ArticleStatus status, String tag) {
        OuterArticlePOExample example = new OuterArticlePOExample();
        OuterArticlePOExample.Criteria criteria = example.createCriteria();
        if (!Strings.isNullOrEmpty(tag)) {
            criteria.andTagsLike("%" + tag + "$");
        }
        if (status != null) {
            criteria.andStatusEqualTo(status.name());
        }
        criteria.andIsDeletedEqualTo(false);
        return outerArticlePOMapper.countByExample(example);
    }

}
