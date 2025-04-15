package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.ModelVersionPO;
import com.aigccafe.buterin.common.model.md.ModelVersionPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface ModelVersionPOMapper {
    long countByExample(ModelVersionPOExample example);

    int deleteByExample(ModelVersionPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModelVersionPO record);

    int insertSelective(ModelVersionPO record);

    List<ModelVersionPO> selectByExampleWithBLOBsWithRowbounds(ModelVersionPOExample example, RowBounds rowBounds);

    List<ModelVersionPO> selectByExampleWithBLOBs(ModelVersionPOExample example);

    List<ModelVersionPO> selectByExampleWithRowbounds(ModelVersionPOExample example, RowBounds rowBounds);

    List<ModelVersionPO> selectByExample(ModelVersionPOExample example);

    ModelVersionPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModelVersionPO record, @Param("example") ModelVersionPOExample example);

    int updateByExampleWithBLOBs(@Param("record") ModelVersionPO record, @Param("example") ModelVersionPOExample example);

    int updateByExample(@Param("record") ModelVersionPO record, @Param("example") ModelVersionPOExample example);

    int updateByPrimaryKeySelective(ModelVersionPO record);

    int updateByPrimaryKeyWithBLOBs(ModelVersionPO record);

    int updateByPrimaryKey(ModelVersionPO record);
}