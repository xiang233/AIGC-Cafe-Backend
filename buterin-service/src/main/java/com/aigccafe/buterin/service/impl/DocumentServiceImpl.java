package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.ArticleFormatType;
import com.aigccafe.buterin.common.enumerate.ArticleStatus;
import com.aigccafe.buterin.common.enumerate.DocumentType;
import com.aigccafe.buterin.common.model.doc.*;
import com.aigccafe.buterin.common.model.req.ArticleReqVO;
import com.aigccafe.buterin.common.model.req.DocumentReqVO;
import com.aigccafe.buterin.common.model.req.NoteReqVO;
import com.aigccafe.buterin.common.model.resp.*;
import com.aigccafe.buterin.common.model.user.UserInfo;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.DocumentRepository;
import com.aigccafe.buterin.repository.OOSRepository;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.service.DocumentService;
import com.aigccafe.buterin.service.UserService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OOSRepository oosRepository;
    @Autowired
    private UserService userService;

    @Override
    public Boolean createDocument(DocumentReqVO documentReqVO) {
        documentReqVO.setId(null);
        Long userId = StpUtil.getLoginIdAsLong();
        DocumentPO documentPO = new DocumentPO();
        BeanUtils.copyProperties(documentReqVO, documentPO);
        documentPO.setDocumentType(documentReqVO.getDocumentType().name());
        documentPO.setUserId(userId);
        return documentRepository.insert(documentPO) > 0;
    }

    @Override
    public Boolean updateDocument(DocumentReqVO documentReqVO) {
        DocumentPO documentPO = new DocumentPO();
        BeanUtils.copyProperties(documentReqVO, documentPO);
        documentPO.setDocumentType(documentReqVO.getDocumentType().name());
        return documentRepository.update(documentPO) > 0;
    }

    @Override
    public boolean updateDocumentOrder(String documentList) {
        List<Long> documentIdList  = Arrays.stream(documentList.split(",")).map(Long::parseLong).collect(Collectors.toList());
        long currentTime = DateTimeUtils.nowSeconds();
        int index = 0;
        for (Long documentId : documentIdList) {
            DocumentPO document = documentRepository.selectDocumentById(documentId);
            document.setCreatedAt(currentTime + index);
            documentRepository.update(document);
            index++;
        }
        return true;
    }

    @Override
    public Boolean updateNote(NoteReqVO noteReqVO) {
        OuterArticlePOWithBLOBs notePO = new OuterArticlePOWithBLOBs();
        BeanUtils.copyProperties(noteReqVO, notePO);
        if (noteReqVO.getStatus() != null) {
            notePO.setStatus(noteReqVO.getStatus().name());
        }
        return documentRepository.update(notePO) > 0;
    }

    @Override
    public List<DocumentRespVO> getDocumentList(DocumentType type, Integer offset, Integer number) {
        List<DocumentPO> documentPOList = documentRepository.selectDocumentByCondition(type, offset, number);
        List<Long> userIdList = documentPOList.stream().map(DocumentPO::getUserId).collect(Collectors.toList());
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(userIdList)
                .stream().collect(Collectors.toMap(UserPO::getId, obj -> obj, (x, y) -> x));
        List<DocumentRespVO> documentRespVOList = Lists.newArrayList();

        for(DocumentPO documentPO : documentPOList) {
            UserPO userPO = userPOMap.get(documentPO.getUserId());
            UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
            DocumentRespVO respVO = DocumentRespVO.builder()
                    .id(documentPO.getId())
                    .documentName(documentPO.getDocumentName())
                    .documentType(documentPO.getDocumentType())
                    .coverImageUrl(oosRepository.getSafeUrl(documentPO.getCoverPath()))
                    .userId(documentPO.getUserId())
                    .userName(userPO.getUserName())
                    .avatarUrl(userInfo.getAvatarUrl())
                    .profile(documentPO.getProfile())
                    .build();
            documentRespVOList.add(respVO);
        }
        return documentRespVOList;
    }

    @Override
    public List<JSONObject> getDocumentTypeList() {
        List<JSONObject> result = Lists.newArrayList();
        for(DocumentType type : DocumentType.values()) {
            JSONObject data = new JSONObject();
            data.fluentPut("name", type.name());
            data.fluentPut("value", type.getValue());
            result.add(data);
        }
        return result;
    }

    private Boolean addDocumentChild(Long documentId, Long articleId) {
        DocumentPO documentPO = documentRepository.selectDocumentById(documentId);
        if (documentPO != null) {
            String articleList = documentPO.getArticleIdList() != null ? documentPO.getArticleIdList() : "";
            List<String> childList = Lists.newArrayList();
            if (Strings.isNotEmpty(articleList)) {
                childList = Lists.newArrayList(articleList.split(","));
            }
            childList.add(articleId.toString());
            documentPO.setArticleIdList(Strings.join(childList, ','));
            return documentRepository.update(documentPO) > 0;
        } else {
            return false;
        }
    }

    private Boolean addArticleChild(Long fatherId, Long childId) {
        ArticlePO articlePO = documentRepository.selectSimpleArticleById(fatherId);
        if (articlePO != null) {
            String articleList = articlePO.getChildIdList() != null ? articlePO.getChildIdList() : "";
            List<String> childList = Lists.newArrayList(articleList.split(","));
            childList.add(childId.toString());
            articlePO.setChildIdList(Strings.join(childList, ','));
            ArticlePOWithBLOBs articlePOWithBLOBs = new ArticlePOWithBLOBs();
            BeanUtils.copyProperties(articlePO, articlePOWithBLOBs);
            return documentRepository.update(articlePOWithBLOBs) > 0;
        } else {
            return false;
        }
    }

    @Override
    public Boolean createArticle(ArticleReqVO articleReqVO) {
        Long userId = StpUtil.getLoginIdAsLong();
        ArticlePOWithBLOBs articlePO = new ArticlePOWithBLOBs();
        BeanUtils.copyProperties(articleReqVO, articlePO);
        articlePO.setUserId(userId);
        if (articlePO.getParentId() == null)
            articlePO.setParentId(0L);
        int res = documentRepository.insert(articlePO);
        if (res > 0) {
            if (articlePO.getParentId() == 0) {
                // 更新document节点信息
                return addDocumentChild(articlePO.getDocumentId(), articlePO.getId());
            } else {
                // 更新父文章节点信息
                return addArticleChild(articlePO.getParentId(), articlePO.getId());
            }
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateArticle(ArticleReqVO articleReqVO) {
        ArticlePOWithBLOBs articlePO = new ArticlePOWithBLOBs();
        BeanUtils.copyProperties(articleReqVO, articlePO);
        // 其他字段更新无作用
        articlePO.setParentId(null);
        articlePO.setDocumentId(null);
        // 如果是更新操作，parentId不设置
        return documentRepository.update(articlePO) > 0;
    }

    @Override
    public List<SimpleArticleRespVO> getDocumentStruct(Long documentId) {
        List<ArticlePO> articlePOS = documentRepository.selectArticleByCondition(documentId, 0L);
        List<SimpleArticleRespVO> simpleArticleRespVOList = Lists.newArrayList();
        articlePOS.stream().forEach(articlePO -> {
            SimpleArticleRespVO respVO = SimpleArticleRespVO.builder()
                    .id(articlePO.getId())
                    .title(articlePO.getTitle())
                    .build();
            simpleArticleRespVOList.add(respVO);
        });
        return simpleArticleRespVOList;
    }

    @Override
    public NoteListRespVO getNoteList(ArticleStatus status, Integer offset, Integer number) {
        List<OuterArticlePO> articlePOS = documentRepository.selectSimpleNoteByCondition(status, null, offset, number);
        List<SimpleNoteRespVO> simpleNoteRespVOList = Lists.newArrayList();
        List<Long> authorIdList = articlePOS.stream().map(OuterArticlePO::getUserId).collect(Collectors.toList());
        Map<Long, UserInfo> userInfoMap = userService.getUserInfoMap(authorIdList);
        articlePOS.stream().parallel().forEach(articlePO -> {
            SimpleNoteRespVO respVO = SimpleNoteRespVO.builder()
                    .id(articlePO.getId())
                    .title(articlePO.getTitle())
                    .brief(articlePO.getBrief())
                    .tags(articlePO.getTags())
                    .coverUrl(articlePO.getCoverPath())
                    .status(articlePO.getStatus())
                    .build();
            if (userInfoMap.containsKey(articlePO.getUserId())) {
                respVO.setAuthorInfo(userInfoMap.get(articlePO.getUserId()));
            }
            simpleNoteRespVOList.add(respVO);
        });

        Long total = documentRepository.countSimpleNoteByCondition(status, null);
        return NoteListRespVO.builder()
                .noteList(simpleNoteRespVOList)
                .total(total)
                .build();
    }


    @Override
    public ArticleRespVO getArticle(ArticleFormatType type, Long articleId) {
        Preconditions.checkNotNull(articleId, "articleId不能为空");
        ArticlePOWithBLOBs articlePOWithBLOBs = documentRepository.selectArticleById(articleId);
        Preconditions.checkNotNull(articlePOWithBLOBs, "文章不存在");
        UserPO userPO = userRepository.selectById(articlePOWithBLOBs.getUserId());
        UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
        String content = type.equals(ArticleFormatType.HTML) ? articlePOWithBLOBs.getHtml() : articlePOWithBLOBs.getContent();
        return ArticleRespVO.builder()
                .userId(userPO.getId())
                .userName(userInfo.getNickname())
                .avatarUrl(oosRepository.getSafeUrl(userInfo.getAvatarUrl()))
                .title(articlePOWithBLOBs.getTitle())
                .tags(articlePOWithBLOBs.getTags())
                .content(content)
                .build();
    }

    @Override
    // TODO： 需要识别是否是管理员
    public NoteRespVO getNoteDetail(ArticleFormatType type, Long noteId) {
        if (type.equals(ArticleFormatType.MD)) {
            // 检查是否是管理员
            StpUtil.checkLogin();
        }
        OuterArticlePOWithBLOBs notePO = documentRepository.selectNoteById(noteId);

        Preconditions.checkNotNull(notePO, "笔记不存在");
        UserPO userPO = userRepository.selectById(notePO.getUserId());
        UserInfo userInfo = JSON.parseObject(userPO.getInfo(), UserInfo.class);
        String content = type.equals(ArticleFormatType.HTML) ? notePO.getHtml() : notePO.getContent();
        return NoteRespVO.builder()
                .id(notePO.getId())
                .title(notePO.getTitle())
                .brief(notePO.getBrief())
                .authorInfo(userInfo)
                .content(content)
                .tags(notePO.getTags())
                .build();
    }

}
