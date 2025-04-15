package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.md.ModelVersionImagePO;
import com.aigccafe.buterin.common.model.md.ModelVersionImagePOExample;
import com.aigccafe.buterin.common.model.md.ModelVersionImagePOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface ModelVersionImagePOMapper {
    long countByExample(ModelVersionImagePOExample example);

    int deleteByExample(ModelVersionImagePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ModelVersionImagePOWithBLOBs record);

    int insertSelective(ModelVersionImagePOWithBLOBs record);

    List<ModelVersionImagePOWithBLOBs> selectByExampleWithBLOBsWithRowbounds(ModelVersionImagePOExample example, RowBounds rowBounds);

    List<ModelVersionImagePOWithBLOBs> selectByExampleWithBLOBs(ModelVersionImagePOExample example);

    List<ModelVersionImagePO> selectByExampleWithRowbounds(ModelVersionImagePOExample example, RowBounds rowBounds);

    List<ModelVersionImagePO> selectByExample(ModelVersionImagePOExample example);

    ModelVersionImagePOWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ModelVersionImagePOWithBLOBs record, @Param("example") ModelVersionImagePOExample example);

    int updateByExampleWithBLOBs(@Param("record") ModelVersionImagePOWithBLOBs record, @Param("example") ModelVersionImagePOExample example);

    int updateByExample(@Param("record") ModelVersionImagePO record, @Param("example") ModelVersionImagePOExample example);

    int updateByPrimaryKeySelective(ModelVersionImagePOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ModelVersionImagePOWithBLOBs record);

    int updateByPrimaryKey(ModelVersionImagePO record);
}