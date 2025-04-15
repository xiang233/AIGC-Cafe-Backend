package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.question.QuestionPO;
import com.aigccafe.buterin.common.model.question.QuestionPOExample;
import com.aigccafe.buterin.common.model.question.QuestionPOWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface QuestionPOMapper {
    long countByExample(QuestionPOExample example);

    int deleteByExample(QuestionPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QuestionPOWithBLOBs record);

    int insertSelective(QuestionPOWithBLOBs record);

    List<QuestionPOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(QuestionPOExample example, RowBounds rowBounds);

    List<QuestionPOWithBLOBs> selectByExampleWithBLOBs(QuestionPOExample example);

    List<QuestionPO> selectByExampleWithRowbounds(QuestionPOExample example, RowBounds rowBounds);

    List<QuestionPO> selectByExample(QuestionPOExample example);

    QuestionPOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") QuestionPOWithBLOBs record, @Param("example") QuestionPOExample example);

    int updateByExampleWithBLOBs(@Param("record") QuestionPOWithBLOBs record, @Param("example") QuestionPOExample example);

    int updateByExample(@Param("record") QuestionPO record, @Param("example") QuestionPOExample example);

    int updateByPrimaryKeySelective(QuestionPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(QuestionPOWithBLOBs record);

    int updateByPrimaryKey(QuestionPO record);
}