package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.ModelVersionFilePO;
import com.aigccafe.buterin.common.model.md.ModelVersionFilePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface ModelVersionFilePOMapper {
    long countByExample(ModelVersionFilePOExample example);

    int deleteByExample(ModelVersionFilePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModelVersionFilePO record);

    int insertSelective(ModelVersionFilePO record);

    List<ModelVersionFilePO> selectByExampleWithRowbounds(ModelVersionFilePOExample example, RowBounds rowBounds);

    List<ModelVersionFilePO> selectByExample(ModelVersionFilePOExample example);

    ModelVersionFilePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModelVersionFilePO record, @Param("example") ModelVersionFilePOExample example);

    int updateByExample(@Param("record") ModelVersionFilePO record, @Param("example") ModelVersionFilePOExample example);

    int updateByPrimaryKeySelective(ModelVersionFilePO record);

    int updateByPrimaryKey(ModelVersionFilePO record);
}