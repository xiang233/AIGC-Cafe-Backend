package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.question.AnswerPO;
import com.aigccafe.buterin.common.model.question.AnswerPOExample;
import com.aigccafe.buterin.common.model.question.AnswerPOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface AnswerPOMapper {
    long countByExample(AnswerPOExample example);

    int deleteByExample(AnswerPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AnswerPOWithBLOBs record);

    int insertSelective(AnswerPOWithBLOBs record);

    List<AnswerPOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(AnswerPOExample example, RowBounds rowBounds);

    List<AnswerPOWithBLOBs> selectByExampleWithBLOBs(AnswerPOExample example);

    List<AnswerPO> selectByExampleWithRowbounds(AnswerPOExample example, RowBounds rowBounds);

    List<AnswerPO> selectByExample(AnswerPOExample example);

    AnswerPOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AnswerPOWithBLOBs record, @Param("example") AnswerPOExample example);

    int updateByExampleWithBLOBs(@Param("record") AnswerPOWithBLOBs record, @Param("example") AnswerPOExample example);

    int updateByExample(@Param("record") AnswerPO record, @Param("example") AnswerPOExample example);

    int updateByPrimaryKeySelective(AnswerPOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AnswerPOWithBLOBs record);

    int updateByPrimaryKey(AnswerPO record);
}