package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.*;
import com.aigccafe.buterin.common.model.interaction.InteractionStatPO;
import com.aigccafe.buterin.common.model.question.AnswerPO;
import com.aigccafe.buterin.common.model.question.AnswerPOWithBLOBs;
import com.aigccafe.buterin.common.model.question.QuestionPO;
import com.aigccafe.buterin.common.model.question.QuestionPOWithBLOBs;
import com.aigccafe.buterin.common.model.req.AnswerReqVO;
import com.aigccafe.buterin.common.model.req.QuestionReqVO;
import com.aigccafe.buterin.common.model.resp.*;
import com.aigccafe.buterin.common.model.user.UserInfo;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.CommunityRepository;
import com.aigccafe.buterin.repository.InteractionRepository;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.repository.mapper.QuestionExtendMapper;
import com.aigccafe.buterin.service.CommunityService;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private InteractionRepository interactionRepository;
    @Autowired
    private QuestionExtendMapper questionExtendMapper;

    @Override
    public Boolean addQuestion(QuestionReqVO questionReqVO) {
        Long userId = StpUtil.getLoginIdAsLong();
        QuestionPOWithBLOBs question = new QuestionPOWithBLOBs();
        BeanUtils.copyProperties(questionReqVO, question);
        question.setId(null);
        question.setUserId(userId);
        return communityRepository.insertQuestion(question);
    }

    @Override
    public Boolean updateQuestion(QuestionReqVO questionReqVO) {
        Preconditions.checkNotNull(questionReqVO.getId(), "帖子ID不能为空");
        QuestionPOWithBLOBs questionPOWithBLOBs = communityRepository.selectQuestionById(questionReqVO.getId());
        Long userIdRecord = questionPOWithBLOBs.getUserId();
        Long userId = StpUtil.getLoginIdAsLong();
        Preconditions.checkArgument(userId.equals(userIdRecord), "无操作权限");
        if (Strings.isNullOrEmpty(questionReqVO.getTitle())) {
            questionPOWithBLOBs.setTitle(questionReqVO.getTitle());
        }
        if (Strings.isNullOrEmpty(questionReqVO.getContent())) {
            questionPOWithBLOBs.setContent(questionReqVO.getContent());
        }
        if (Strings.isNullOrEmpty(questionReqVO.getSrcContent())) {
            questionPOWithBLOBs.setSrcContent(questionReqVO.getSrcContent());
        }
        if (Strings.isNullOrEmpty(questionReqVO.getTags())) {
            questionPOWithBLOBs.setTags(questionReqVO.getTags());
        }
        return communityRepository.updateQuestion(questionPOWithBLOBs);
    }

    @Override
    @Transactional
    public Boolean addAnswer(AnswerReqVO answerReqVO) {
        Long userId = StpUtil.getLoginIdAsLong();
        Preconditions.checkNotNull(answerReqVO.getQuestionId(), "缺少问题id");
        if (!communityRepository.questionExist(answerReqVO.getQuestionId())) {
            throw new RuntimeException("问题id不存在");
        }
        AnswerPOWithBLOBs answer = new AnswerPOWithBLOBs();
        BeanUtils.copyProperties(answerReqVO, answer);
        answer.setId(null);
        answer.setUserId(userId);
        if (communityRepository.insertAnswer(answer)) {
            return changeQuestionStat(answerReqVO.getQuestionId(), InteractionType.ANSWER, true);
        } else {
            return false;
        }
    }

    @Override
    public Boolean updateAnswer(AnswerReqVO answerReqVO) {
        Long userId = StpUtil.getLoginIdAsLong();
        Preconditions.checkNotNull(answerReqVO.getId(), "帖子ID不能为空");
        AnswerPOWithBLOBs answerPOWithBLOBs = communityRepository.selectAnswerById(answerReqVO.getId());
        Long userIdRecord = answerPOWithBLOBs.getUserId();
        Preconditions.checkArgument(userId.equals(userIdRecord), "无操作权限");
        if (Strings.isNullOrEmpty(answerReqVO.getContent())) {
            answerPOWithBLOBs.setContent(answerReqVO.getContent());
        }
        if (Strings.isNullOrEmpty(answerReqVO.getSrcContent())) {
            answerPOWithBLOBs.setSrcContent(answerReqVO.getSrcContent());
        }
        return communityRepository.updateAnswer(answerPOWithBLOBs);
    }

    @Override
    public Boolean deleteQuestion(Long questionId) {
        Preconditions.checkNotNull(questionId, "id为空");
        Long userId = StpUtil.getLoginIdAsLong();
        List<QuestionPO> questionPOList = communityRepository.selectSimpleQuestionByCondition(questionId, userId);
        if (questionPOList.size() > 0) {
            QuestionPO questionPO = questionPOList.get(0);
            questionPO.setIsDeleted(true);
            return communityRepository.updateQuestion((QuestionPOWithBLOBs) questionPO);
        } else {
            throw new RuntimeException("找不到要删除的项目，不存在");
        }
    }

    @Override
    @Transactional
    public Boolean deleteAnswer(Long answerId) {
        Preconditions.checkNotNull(answerId, "id为空");
        Long userId = StpUtil.getLoginIdAsLong();
        List<AnswerPO> answerPOList = communityRepository.selectSimpleAnswerByCondition(answerId, null, userId);
        if (answerPOList.size() > 0) {
            AnswerPO answerPO = answerPOList.get(0);
            answerPO.setIsDeleted(true);
            boolean res = communityRepository.updateAnswer((AnswerPOWithBLOBs) answerPO);
            if (res) {
                return changeQuestionStat(answerPO.getQuestionId(), InteractionType.ANSWER, false);
            } else {
                return false;
            }
        } else {
            throw new RuntimeException("找不到要删除的项目，不存在");
        }
    }

    @Override
    public QuestionListRespVO selectQuestionByCondition(QuestionSortedType sortedType, List<QuestionFilterType> filters,
                                                              String tag, Integer offset, Integer number) {
        List<QuestionPOWithBLOBs> questionList = communityRepository.selectQuestionByCondition(sortedType, filters, tag, offset, number);
        List<Long> questionIdList = questionList.stream().map(QuestionPOWithBLOBs::getId).collect(Collectors.toList());
        List<Long> userIdList = questionList.stream().map(QuestionPOWithBLOBs::getUserId).collect(Collectors.toList());
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(userIdList)
                .stream().collect(Collectors.toMap(UserPO::getId, obj -> obj, (x, y) -> x));
        Map<Long, InteractionStatPO> interactionStatMap = interactionRepository.selectInteractionStatList(TargetType.QUESTION, questionIdList)
                .stream().collect(Collectors.toMap(InteractionStatPO::getTargetId, obj -> obj, (x, y) -> x));

        List<QuestionReaderRespVO> respVOList = Lists.newArrayList();
        Long total = communityRepository.countQuestionByCondition(sortedType, filters, tag, offset, number);
        for (QuestionPOWithBLOBs question : questionList) {
            QuestionReaderRespVO respVO = convertToResp(question, userPOMap, interactionStatMap);
            respVOList.add(respVO);
        }
        return QuestionListRespVO.builder()
                .total(total)
                .questions(respVOList)
                .build();
    }

    @Override
    public List<QuestionReaderRespVO> searchQuestion(String keyword, Integer offset, Integer number) {
        List<QuestionPOWithBLOBs> questionList = questionExtendMapper.searchQuestionList(keyword, offset, number);
        List<Long> questionIdList = questionList.stream().map(QuestionPOWithBLOBs::getId).collect(Collectors.toList());
        List<Long> userIdList = questionList.stream().map(QuestionPOWithBLOBs::getUserId).collect(Collectors.toList());
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(userIdList)
                .stream().collect(Collectors.toMap(UserPO::getId, obj -> obj, (x, y) -> x));
        Map<Long, InteractionStatPO> interactionStatMap = interactionRepository.selectInteractionStatList(TargetType.QUESTION, questionIdList)
                .stream().collect(Collectors.toMap(InteractionStatPO::getTargetId, obj -> obj, (x, y) -> x));
        List<QuestionReaderRespVO> respVOList = Lists.newArrayList();
        for (QuestionPOWithBLOBs question : questionList) {
            QuestionReaderRespVO respVO = convertToResp(question, userPOMap, interactionStatMap);
            respVOList.add(respVO);
        }
        return respVOList;
    }

    @Override
    public QuestionReaderRespVO getQuestionDetail(Long questionId) {
        Preconditions.checkNotNull(questionId, "id不能为空");
        QuestionPOWithBLOBs questionPOWithBLOBs= communityRepository.selectQuestionById(questionId);
        UserPO userPO = userRepository.selectById(questionPOWithBLOBs.getUserId());
        InteractionStatPO statPO = interactionRepository.selectInteractionStat(TargetType.QUESTION, questionPOWithBLOBs.getId());
        return convertToResp(questionPOWithBLOBs, userPO, statPO);
    }

    @Override
    public List<AnswerReaderRespVO> getAnswerDetailListByCondition(Long questionId, AnswerSortedType sortedType,
                                                            Integer offset, Integer number) {
        Preconditions.checkNotNull(questionId, "questionId不能为空");
        List<AnswerPOWithBLOBs> answerPOList = communityRepository.selectAnswerByCondition(questionId, sortedType, offset, number);
        List<Long> userIdList = answerPOList.stream().map(AnswerPOWithBLOBs::getUserId).collect(Collectors.toList());
        Map<Long, UserPO> userPOMap = userRepository.selectByUserIdList(userIdList)
                .stream().collect(Collectors.toMap(UserPO::getId, obj -> obj, (x, y) -> x));
        List<AnswerReaderRespVO> respVOList = Lists.newArrayList();
        answerPOList.forEach(answerPO -> {
            AnswerReaderRespVO respVO = new AnswerReaderRespVO();
            BeanUtils.copyProperties(answerPO, respVO);
            UserPO userPO = userPOMap.get(answerPO.getUserId());
            if (userPO != null) {
                respVO.setUserInfo(JSON.parseObject(userPO.getInfo(), UserInfo.class));
            }
            respVO.setCreated_time(DateTimeUtils.formatDatetime(answerPO.getCreatedAt()));
            respVO.setCreated_time(DateTimeUtils.formatDatetime(answerPO.getCreatedAt()));
            respVOList.add(respVO);
        });
        return respVOList;
    }

    @Override
    public QuestionSourceRespVO getQuestionSource(Long questionId) {
        QuestionPOWithBLOBs question =communityRepository.selectQuestionById(questionId);
        return QuestionSourceRespVO.builder()
                .id(question.getId())
                .title(question.getTitle())
                .srcContent(question.getSrcContent())
                .tags(question.getTags())
                .build();
    }

    @Override
    public AnswerSourceRespVO getAnswerSource(Long answerId) {
        AnswerPOWithBLOBs answer = communityRepository.selectAnswerById(answerId);
        return AnswerSourceRespVO.builder()
                .id(answer.getId())
                .srcContent(answer.getSrcContent())
                .build();
    }

    @Override
    public boolean changeQuestionStat(Long questionId, InteractionType type, boolean add) {
        List<QuestionPO> questionPOS = communityRepository.selectSimpleQuestionByCondition(questionId, null);
        for(QuestionPO questionPO : questionPOS) {
            if (InteractionType.SUPPORT.equals(type)) {
                Long cnt = questionPO.getSupportCnt();
                cnt = cnt + (add? 1 : -1);
                questionPO.setSupportCnt(cnt);
                return communityRepository.updateQuestion((QuestionPOWithBLOBs) questionPO);
            } else if (InteractionType.ANSWER.equals(type)) {
                Long cnt = questionPO.getAnswerCnt();
                cnt = cnt + (add? 1 : -1);
                questionPO.setAnswerCnt(cnt);
                return communityRepository.updateQuestion((QuestionPOWithBLOBs) questionPO);
            } else if (InteractionType.VIEW.equals(type)) {
                Long cnt = questionPO.getViewCnt();
                cnt = cnt + (add? 1 : -1);
                questionPO.setViewCnt(cnt);
                return communityRepository.updateQuestion((QuestionPOWithBLOBs) questionPO);
            }
        }
        return true;
    }

    @Override
    public boolean changeAnswerStat(Long answerId, InteractionType type, boolean add) {
        List<AnswerPO> answerPOS = communityRepository.selectSimpleAnswerByCondition(answerId, null, null);
        for(AnswerPO answerPO : answerPOS) {
            if (InteractionType.AGREE.equals(type)) {
                Long cnt = answerPO.getAgreeCnt();
                cnt = cnt + (add? 1 : -1);
                answerPO.setAgreeCnt(cnt);
                return communityRepository.updateAnswer((AnswerPOWithBLOBs) answerPO);
            } else if (InteractionType.DISAGREE.equals(type)) {
                Long cnt = answerPO.getDisagreeCnt();
                cnt = cnt + (add? 1 : -1);
                answerPO.setDisagreeCnt(cnt);
                return communityRepository.updateAnswer((AnswerPOWithBLOBs) answerPO);
            }
        }
        return true;
    }


    private QuestionReaderRespVO convertToResp(QuestionPOWithBLOBs questionPO, Map<Long, UserPO> userInfoMap,
                                               Map<Long, InteractionStatPO> statMap) {
        QuestionReaderRespVO respVO = new QuestionReaderRespVO();
        BeanUtils.copyProperties(questionPO, respVO);
        UserPO userPO = userInfoMap.get(questionPO.getUserId());
        if (userPO != null) {
            respVO.setUserInfo(JSON.parseObject(userPO.getInfo(), UserInfo.class));
        }
        InteractionStatPO interactionStatPO = statMap.get(questionPO.getId());
        // 设置support、un_support数
        if (interactionStatPO != null) {
            respVO.setSupportCnt(interactionStatPO.getSupportCount());
            respVO.setUnSupportCnt(interactionStatPO.getUnSupportCount());
        } else {
            respVO.setSupportCnt(0L);
            respVO.setUnSupportCnt(0L);
        }
        // 时间格式化
        respVO.setCreated_time(DateTimeUtils.formatDatetime(questionPO.getCreatedAt()));
        respVO.setCreated_time(DateTimeUtils.formatDatetime(questionPO.getCreatedAt()));
        return respVO;
    }

    private QuestionReaderRespVO convertToResp(QuestionPOWithBLOBs questionPO, UserPO userPO, InteractionStatPO statPO) {
        QuestionReaderRespVO respVO = new QuestionReaderRespVO();
        BeanUtils.copyProperties(questionPO, respVO);
        if (userPO != null) {
            respVO.setUserInfo(JSON.parseObject(userPO.getInfo(), UserInfo.class));
        }
        // 设置support、un_support数
        if (statPO != null) {
            respVO.setSupportCnt(statPO.getSupportCount());
            respVO.setUnSupportCnt(statPO.getUnSupportCount());
        } else {
            respVO.setSupportCnt(0L);
            respVO.setUnSupportCnt(0L);
        }
        // 时间格式化
        respVO.setCreated_time(DateTimeUtils.formatDatetime(questionPO.getCreatedAt()));
        respVO.setCreated_time(DateTimeUtils.formatDatetime(questionPO.getCreatedAt()));
        return respVO;
    }
}
