package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.log.WebLogPO;
import com.aigccafe.buterin.common.model.log.WebLogPOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

@Component
public interface WebLogPOMapper {
    long countByExample(WebLogPOExample example);

    int deleteByExample(WebLogPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WebLogPO record);

    int insertSelective(WebLogPO record);

    List<WebLogPO> selectByExampleWithRowbounds(WebLogPOExample example, RowBounds rowBounds);

    List<WebLogPO> selectByExample(WebLogPOExample example);

    WebLogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WebLogPO record, @Param("example") WebLogPOExample example);

    int updateByExample(@Param("record") WebLogPO record, @Param("example") WebLogPOExample example);

    int updateByPrimaryKeySelective(WebLogPO record);

    int updateByPrimaryKey(WebLogPO record);
}