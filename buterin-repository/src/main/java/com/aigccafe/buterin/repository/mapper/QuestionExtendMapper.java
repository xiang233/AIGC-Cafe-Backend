package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.question.QuestionPOWithBLOBs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionExtendMapper {

    @Select("select * from question where MATCH(title,content,tags) AGAINST('${keyword}' IN BOOLEAN MODE) AND is_deleted=0 ORDER BY support_cnt DESC LIMIT #{offset}, #{number}")
    List<QuestionPOWithBLOBs> searchQuestionList(@Param("keyword") String keyword, @Param("offset") int offset, @Param("number") int number);
}
