package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.doc.ArticlePO;
import com.aigccafe.buterin.common.model.doc.ArticlePOExample;
import com.aigccafe.buterin.common.model.doc.ArticlePOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface ArticlePOMapper {
    long countByExample(ArticlePOExample example);

    int deleteByExample(ArticlePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticlePOWithBLOBs record);

    int insertSelective(ArticlePOWithBLOBs record);

    List<ArticlePOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(ArticlePOExample example, RowBounds rowBounds);

    List<ArticlePOWithBLOBs> selectByExampleWithBLOBs(ArticlePOExample example);

    List<ArticlePO> selectByExampleWithRowbounds(ArticlePOExample example, RowBounds rowBounds);

    List<ArticlePO> selectByExample(ArticlePOExample example);

    ArticlePOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticlePOWithBLOBs record, @Param("example") ArticlePOExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticlePOWithBLOBs record, @Param("example") ArticlePOExample example);

    int updateByExample(@Param("record") ArticlePO record, @Param("example") ArticlePOExample example);

    int updateByPrimaryKeySelective(ArticlePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ArticlePOWithBLOBs record);

    int updateByPrimaryKey(ArticlePO record);
}