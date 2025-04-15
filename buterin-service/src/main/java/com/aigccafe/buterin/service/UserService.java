package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.req.UserRegisterReqVO;
import com.aigccafe.buterin.common.model.resp.UserInfoRespVO;
import com.aigccafe.buterin.common.model.resp.UserStoreListRespVO;
import com.aigccafe.buterin.common.model.user.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    boolean userExist(String userName);

    boolean sendCode(String phoneNumber);

    boolean register(UserRegisterReqVO userRegisterReqVO);

    boolean resetPassword(UserRegisterReqVO userRegisterReqVO);

    boolean login(String userName, String password);

    UserInfoRespVO getUserInfo(Long userId);

    boolean updateUserInfo(Long userId, UserInfo userInfo);

    UserStoreListRespVO getUserStores(TargetType type, Long userId, Integer number, Integer offset);

    Map<Long, UserInfo> getUserInfoMap(List<Long> userIdList);
}
