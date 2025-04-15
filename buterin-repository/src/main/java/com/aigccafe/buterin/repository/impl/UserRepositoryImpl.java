package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.model.user.SmsCodePO;
import com.aigccafe.buterin.common.model.user.SmsCodePOExample;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.model.user.UserPOExample;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.repository.mapper.SmsCodePOMapper;
import com.aigccafe.buterin.repository.mapper.UserPOMapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserPOMapper userPOMapper;
    @Autowired
    private SmsCodePOMapper smsCodePOMapper;

    @Override
    public SmsCodePO selectSmsCode(String phoneNumber) {
        SmsCodePOExample example = new SmsCodePOExample();
        SmsCodePOExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneNumberEqualTo(phoneNumber).andIsDeletedEqualTo(false);
        example.setOrderByClause("created_at desc");
        List<SmsCodePO> smsCodePOList = smsCodePOMapper.selectByExample(example);
        return smsCodePOList.size() > 0 ? smsCodePOList.get(0) : null;
    }

    @Override
    public UserPO selectByName(String userName) {
        UserPOExample example = new UserPOExample();
        UserPOExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName).andIsDeletedEqualTo(false);
        List<UserPO> userPOS = userPOMapper.selectByExample(example);
        return userPOS.size() > 0 ? userPOS.get(0) : null;
    }

    @Override
    public UserPO selectById(Long userId) {
        UserPOExample example = new UserPOExample();
        UserPOExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId).andIsDeletedEqualTo(false);
        List<UserPO> userPOS = userPOMapper.selectByExample(example);
        return userPOS.size() > 0 ? userPOS.get(0) : null;
    }

    @Override
    public UserPO selectByPhone(String phoneNumber) {
        UserPOExample example = new UserPOExample();
        UserPOExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneNumberEqualTo(phoneNumber).andIsDeletedEqualTo(false);
        List<UserPO> userPOS = userPOMapper.selectByExample(example);
        return userPOS.size() > 0 ? userPOS.get(0) : null;
    }

    @Override
    public List<UserPO> selectByUserIdList(List<Long> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Lists.newArrayList();
        }
        UserPOExample example = new UserPOExample();
        UserPOExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList).andIsDeletedEqualTo(false);
        return userPOMapper.selectByExample(example);
    }

    @Override
    public boolean updateSmsCode(String phoneNumber, String code, Long expiredAt) {
        SmsCodePO smsCodePO = selectSmsCode(phoneNumber);
        if (smsCodePO == null) {
            smsCodePO = new SmsCodePO();
            smsCodePO.setPhoneNumber(phoneNumber);
            smsCodePO.setCode(code);
            smsCodePO.setExpiredAt(expiredAt);
            smsCodePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            smsCodePO.setCreatedAt(DateTimeUtils.nowSeconds());
            smsCodePO.setIsDeleted(false);
            return smsCodePOMapper.insertSelective(smsCodePO) > 0;
        } else {
            smsCodePO.setCode(code);
            smsCodePO.setExpiredAt(expiredAt);
            smsCodePO.setUpdatedAt(DateTimeUtils.nowSeconds());
            return smsCodePOMapper.updateByPrimaryKeySelective(smsCodePO) > 0;
        }
    }

    @Override
    public boolean insert(UserPO userPO) {
        userPO.setCreatedAt(DateTimeUtils.nowSeconds());
        userPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        userPO.setIsDeleted(false);
        return userPOMapper.insertSelective(userPO) > 0;
    }

    @Override
    public boolean update(UserPO userPO) {
        userPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        return userPOMapper.updateByPrimaryKeySelective(userPO) > 0;
    }


}
