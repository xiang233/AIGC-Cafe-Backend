package com.aigccafe.buterin.repository;

import com.aigccafe.buterin.common.model.user.SmsCodePO;
import com.aigccafe.buterin.common.model.user.UserPO;

import java.util.List;

public interface UserRepository {

    SmsCodePO selectSmsCode(String phoneNumber);

    boolean updateSmsCode(String phoneNumber, String code, Long expiredAt);

    boolean insert(UserPO userPO);

    UserPO selectById(Long userId);

    UserPO selectByName(String userName);

    UserPO selectByPhone(String phoneNumber);

    List<UserPO> selectByUserIdList(List<Long> idList);

    boolean update(UserPO userPO);
}
