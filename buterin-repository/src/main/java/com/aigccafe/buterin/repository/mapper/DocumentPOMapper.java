package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.doc.DocumentPO;
import com.aigccafe.buterin.common.model.doc.DocumentPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface DocumentPOMapper {
    long countByExample(DocumentPOExample example);

    int deleteByExample(DocumentPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DocumentPO record);

    int insertSelective(DocumentPO record);

    List<DocumentPO> selectByExampleWithRowbounds(DocumentPOExample example, RowBounds rowBounds);

    List<DocumentPO> selectByExample(DocumentPOExample example);

    DocumentPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DocumentPO record, @Param("example") DocumentPOExample example);

    int updateByExample(@Param("record") DocumentPO record, @Param("example") DocumentPOExample example);

    int updateByPrimaryKeySelective(DocumentPO record);

    int updateByPrimaryKey(DocumentPO record);
}