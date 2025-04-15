package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.AnswerSortedType;
import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.QuestionFilterType;
import com.aigccafe.buterin.common.enumerate.QuestionSortedType;
import com.aigccafe.buterin.common.model.req.AnswerReqVO;
import com.aigccafe.buterin.common.model.req.QuestionReqVO;
import com.aigccafe.buterin.common.model.resp.*;

import java.util.List;

public interface CommunityService {

    Boolean addQuestion(QuestionReqVO questionReqVO);

    Boolean updateQuestion(QuestionReqVO questionReqVO);

    Boolean deleteQuestion(Long questionId);

    Boolean addAnswer(AnswerReqVO answerReqVO);

    Boolean updateAnswer(AnswerReqVO answerReqVO);

    Boolean deleteAnswer(Long answerId);

    QuestionListRespVO selectQuestionByCondition(QuestionSortedType sortedType, List<QuestionFilterType> filters,
                                                       String tag, Integer offset, Integer number);

    List<QuestionReaderRespVO> searchQuestion(String keyword, Integer offset, Integer number);

    QuestionReaderRespVO getQuestionDetail(Long questionId);

    List<AnswerReaderRespVO> getAnswerDetailListByCondition(Long questionId, AnswerSortedType sortedType,
                                                            Integer offset, Integer number);

    QuestionSourceRespVO getQuestionSource(Long questionId);

    AnswerSourceRespVO getAnswerSource(Long answerId);

    boolean changeQuestionStat(Long questionId, InteractionType type, boolean add);

    boolean changeAnswerStat(Long answerId, InteractionType type, boolean add);
}
