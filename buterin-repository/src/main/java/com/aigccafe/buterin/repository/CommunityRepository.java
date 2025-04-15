package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.enumerate.AnswerSortedType;
import com.aigccafe.buterin.common.enumerate.QuestionFilterType;
import com.aigccafe.buterin.common.enumerate.QuestionSortedType;
import com.aigccafe.buterin.common.model.question.AnswerPO;
import com.aigccafe.buterin.common.model.question.AnswerPOWithBLOBs;
import com.aigccafe.buterin.common.model.question.QuestionPO;
import com.aigccafe.buterin.common.model.question.QuestionPOWithBLOBs;

import java.util.List;

public interface CommunityRepository {

    Boolean insertQuestion(QuestionPOWithBLOBs questionPOWithBLOBs);

    Boolean updateQuestion(QuestionPOWithBLOBs questionPOWithBLOBs);

    Boolean questionExist(Long questionId);

    QuestionPOWithBLOBs selectQuestionById(Long id);

    List<QuestionPO> selectSimpleQuestionByCondition(Long id, Long userId);

    Boolean insertAnswer(AnswerPOWithBLOBs answerPOWithBLOBs);

    Boolean updateAnswer(AnswerPOWithBLOBs answerPOWithBLOBs);

    AnswerPOWithBLOBs selectAnswerById(Long id);

    List<AnswerPO> selectSimpleAnswerByCondition(Long id, Long questionId, Long userId);

    List<QuestionPOWithBLOBs> selectQuestionByCondition(QuestionSortedType sortedType, List<QuestionFilterType> filters,
                              String tag, Integer offset, Integer number);

    List<AnswerPOWithBLOBs> selectAnswerByCondition(Long questionId, AnswerSortedType sortedType, Integer offset, Integer number);

    Long countQuestionByCondition(QuestionSortedType sortedType, List<QuestionFilterType> filters,
                                  String tag, Integer offset, Integer number);

}
