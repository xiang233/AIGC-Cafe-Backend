package com.aigccafe.buterin.repository.mapper;

import com.aigccafe.buterin.common.model.user.SmsCodePO;
import com.aigccafe.buterin.common.model.user.SmsCodePOExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface SmsCodePOMapper {
    long countByExample(SmsCodePOExample example);

    int deleteByExample(SmsCodePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsCodePO record);

    int insertSelective(SmsCodePO record);

    List<SmsCodePO> selectByExampleWithRowbounds(SmsCodePOExample example, RowBounds rowBounds);

    List<SmsCodePO> selectByExample(SmsCodePOExample example);

    SmsCodePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsCodePO record, @Param("example") SmsCodePOExample example);

    int updateByExample(@Param("record") SmsCodePO record, @Param("example") SmsCodePOExample example);

    int updateByPrimaryKeySelective(SmsCodePO record);

    int updateByPrimaryKey(SmsCodePO record);
}