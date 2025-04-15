package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.enumerate.AnswerSortedType;
import com.aigccafe.buterin.common.enumerate.QuestionFilterType;
import com.aigccafe.buterin.common.enumerate.QuestionSortedType;
import com.aigccafe.buterin.common.enumerate.QuestionStatus;
import com.aigccafe.buterin.common.model.question.*;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.repository.CommunityRepository;
import com.aigccafe.buterin.repository.mapper.AnswerPOMapper;
import com.aigccafe.buterin.repository.mapper.QuestionPOMapper;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class CommunityRepositoryImpl implements CommunityRepository {
    @Autowired
    private QuestionPOMapper questionPOMapper;
    @Autowired
    private AnswerPOMapper answerPOMapper;

    private final static Long WEEK_DURATION = 3600 * 24 * 7L;
    private final static Long MONTH_DURATION = 3600 * 24 * 30L;

    @Override
    public Boolean insertQuestion(QuestionPOWithBLOBs questionPOWithBLOBs) {
        questionPOWithBLOBs.setAnswerCnt(0L);
        questionPOWithBLOBs.setViewCnt(0L);
        questionPOWithBLOBs.setSupportCnt(0L);
        questionPOWithBLOBs.setCreatedAt(DateTimeUtils.nowSeconds());
        questionPOWithBLOBs.setUpdatedAt(DateTimeUtils.nowSeconds());
        questionPOWithBLOBs.setIsDeleted(false);
        return questionPOMapper.insertSelective(questionPOWithBLOBs) > 0;
    }

    @Override
    public Boolean insertAnswer(AnswerPOWithBLOBs answerPOWithBLOBs) {
        answerPOWithBLOBs.setApproved(false);
        answerPOWithBLOBs.setCreatedAt(DateTimeUtils.nowSeconds());
        answerPOWithBLOBs.setUpdatedAt(DateTimeUtils.nowSeconds());
        answerPOWithBLOBs.setIsDeleted(false);
        return answerPOMapper.insertSelective(answerPOWithBLOBs) > 0;
    }

    @Override
    public Boolean questionExist(Long questionId) {
        QuestionPOExample example = new QuestionPOExample();
        QuestionPOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(questionId);
        criteria.andIsDeletedEqualTo(false);
        return questionPOMapper.countByExample(example) > 0;
    }

    @Override
    public Boolean updateQuestion(QuestionPOWithBLOBs questionPOWithBLOBs) {
        questionPOWithBLOBs.setUpdatedAt(DateTimeUtils.nowSeconds());
        return questionPOMapper.updateByPrimaryKeySelective(questionPOWithBLOBs) > 0;
    }

    @Override
    public Boolean updateAnswer(AnswerPOWithBLOBs answerPOWithBLOBs) {
        answerPOWithBLOBs.setUpdatedAt(DateTimeUtils.nowSeconds());
        return answerPOMapper.updateByPrimaryKeySelective(answerPOWithBLOBs) > 0;
    }

    @Override
    public QuestionPOWithBLOBs selectQuestionById(Long id) {
       return questionPOMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<QuestionPO> selectSimpleQuestionByCondition(Long id, Long userId) {
        QuestionPOExample example = new QuestionPOExample();
        QuestionPOExample.Criteria criteria = example.createCriteria();
        if (id != null) {
            criteria.andIdEqualTo(id);
        }
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andIsDeletedEqualTo(false);
        return questionPOMapper.selectByExample(example);
    }

    @Override
    public AnswerPOWithBLOBs selectAnswerById(Long id) {
        return answerPOMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AnswerPO> selectSimpleAnswerByCondition(Long id, Long questionId, Long userId) {
        AnswerPOExample example = new AnswerPOExample();
        AnswerPOExample.Criteria criteria = example.createCriteria();
        if (id != null) {
            criteria.andIdEqualTo(id);
        }
        if (questionId != null) {
            criteria.andQuestionIdEqualTo(questionId);
        }
        if (userId != null) {
            criteria.andUserIdEqualTo(userId);
        }
        criteria.andIsDeletedEqualTo(false);
        return answerPOMapper.selectByExample(example);
    }

    @Override
    public List<QuestionPOWithBLOBs> selectQuestionByCondition(QuestionSortedType sortedType, List<QuestionFilterType> filters,
                                                                   String tag, Integer offset, Integer number) {
        QuestionPOExample example = new QuestionPOExample();
        QuestionPOExample.Criteria criteria = example.createCriteria();
        // 设置筛选器
        if (filters != null) {
            for (QuestionFilterType filter : filters) {
                setFilter(criteria, filter);
            }
        }
        if (!Strings.isNullOrEmpty(tag)) {
            criteria.andTagsLike("%" + tag + "%");
        }
        criteria.andIsDeletedEqualTo(false);
        // 设置排序规则
        setOrderByClause(example, sortedType);
        // 切片
        RowBounds rowBounds = new RowBounds(offset, number);
        return questionPOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public List<AnswerPOWithBLOBs> selectAnswerByCondition(Long questionId, AnswerSortedType sortedType, Integer offset, Integer number) {
        AnswerPOExample example = new AnswerPOExample();
        AnswerPOExample.Criteria criteria = example.createCriteria();

        criteria.andIsDeletedEqualTo(false);

        // 设置排序规则
        if (AnswerSortedType.NEWEST.equals(sortedType)) {
            example.setOrderByClause("updated_at desc");
        }
        if (AnswerSortedType.OLDEST.equals(sortedType)) {
            example.setOrderByClause("created_at desc");
        }
        if (AnswerSortedType.VOTE.equals(sortedType)) {
            example.setOrderByClause("agree_cnt desc");
        }
        // 切片
        RowBounds rowBounds = new RowBounds(offset, number);
        return answerPOMapper.selectByExampleWithBLOBsWithRowbounds(example, rowBounds);
    }

    @Override
    public Long countQuestionByCondition(QuestionSortedType sortedType, List<QuestionFilterType> filters,
                                         String tag, Integer offset, Integer number) {
        QuestionPOExample example = new QuestionPOExample();
        QuestionPOExample.Criteria criteria = example.createCriteria();
        // 设置筛选器
        if (filters != null) {
            for (QuestionFilterType filter : filters) {
                setFilter(criteria, filter);
            }
        }
        if (!Strings.isNullOrEmpty(tag)) {
            criteria.andTagsLike("%" + tag + "%");
        }
        criteria.andIsDeletedEqualTo(false);
        return questionPOMapper.countByExample(example);
    }

    private void setFilter(QuestionPOExample.Criteria criteria, QuestionFilterType filter) {
        if (QuestionFilterType.ALL_TIME.equals(filter)) {
        } else if (QuestionFilterType.WEEK.equals(filter)) {
            criteria.andCreatedAtBetween(DateTimeUtils.nowSeconds() - WEEK_DURATION , DateTimeUtils.nowSeconds());
        } else if (QuestionFilterType.MONTH.equals(filter)) {
            criteria.andCreatedAtBetween(DateTimeUtils.nowSeconds() - MONTH_DURATION , DateTimeUtils.nowSeconds());
        } else if (QuestionFilterType.UN_ANSWER.equals(filter)) {
            criteria.andAnswerCntEqualTo(0L);
        } else if (QuestionFilterType.ANSWERED.equals(filter)) {
            criteria.andAnswerCntGreaterThan(0L);
        } else if (QuestionFilterType.APPROVED.equals(filter)) {
            criteria.andStatusEqualTo(QuestionStatus.APPROVED.name());
        }
    }

    private void setOrderByClause(QuestionPOExample example, QuestionSortedType type) {
        if (QuestionSortedType.NEWEST.equals(type)) {
            example.setOrderByClause("updated_at desc");
        } else if (QuestionSortedType.VIEW.equals(type)) {
            example.setOrderByClause("view_cnt desc");
        } else if (QuestionSortedType.ANSWER.equals(type)) {
            example.setOrderByClause("answer_cnt desc");
        } else if (QuestionSortedType.SUPPORT.equals(type)) {
            example.setOrderByClause("support_cnt desc");
        }
    }
}
