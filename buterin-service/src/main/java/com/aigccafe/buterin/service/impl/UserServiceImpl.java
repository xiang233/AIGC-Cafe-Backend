package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.InteractionType;
import com.aigccafe.buterin.common.enumerate.TargetType;
import com.aigccafe.buterin.common.model.md.ModelDetailPO;
import com.aigccafe.buterin.common.model.req.UserRegisterReqVO;
import com.aigccafe.buterin.common.model.resp.MjPromptRespVO;
import com.aigccafe.buterin.common.model.resp.SdPromptRespVO;
import com.aigccafe.buterin.common.model.resp.UserInfoRespVO;
import com.aigccafe.buterin.common.model.resp.UserStoreListRespVO;
import com.aigccafe.buterin.common.model.user.Role;
import com.aigccafe.buterin.common.model.user.SmsCodePO;
import com.aigccafe.buterin.common.model.user.UserInfo;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.common.util.RandomUtil;
import com.aigccafe.buterin.common.util.SecUtil;
import com.aigccafe.buterin.repository.ModelRepository;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.service.*;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import static com.aigccafe.buterin.common.Constant.SYSTEM_AVATAR_LIST;

@Service
public class UserServiceImpl implements UserService {

    private final static int SMS_CODE_SIZE = 6;
    private final static int SALT_SIZE = 6;
    private final static int EXPIRE_DURATION = 10 * 60;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SmsService smsService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private PromptService promptService;
    @Autowired
    private InteractionService interactionService;

    private static final Random RANDOM = new Random();

    @Override
    public boolean userExist(String userName) {
        Preconditions.checkNotNull(userName, "输入为空");
        UserPO userPO = userRepository.selectByName(userName);
        return userPO != null;
    }

    @Override
    public boolean sendCode(String phoneNumber) {
        // 校验号码
        Preconditions.checkArgument(phoneNumber.startsWith("1")
                && phoneNumber.length() == 11, "号码不合法");

        // 校验是否已注册过
        if (userRepository.selectByPhone(phoneNumber) != null) {
            throw new RuntimeException("号码已被注册，请更换号码");
        }

        // 随机生成一个验证码
        String randomCode = RandomUtil.generateRandomNumberString(SMS_CODE_SIZE);

        // 使用第三方服务发送一个验证码
        boolean transfered = smsService.sendCode(randomCode, phoneNumber);

        // 存储验证码及过期时间
        if (transfered) {
            Long currentTime = DateTimeUtils.nowSeconds();
            Long expiredAt = currentTime + EXPIRE_DURATION;
            return userRepository.updateSmsCode(phoneNumber, randomCode, expiredAt);
        } else {
            throw new RuntimeException("验证码发送失败，请重试");
        }
    }

    @Override
    public boolean register(UserRegisterReqVO userRegisterReqVO) {
        // 验证
        Preconditions.checkNotNull(userRegisterReqVO, "请求体为空");
        UserPO user = userRepository.selectByName(userRegisterReqVO.getUserName());
        if (user != null) {
            throw new RuntimeException("用户名已存在，请换一个");
        }
        String phoneNumber = userRegisterReqVO.getPhoneNumber();
        String code = userRegisterReqVO.getCode();
        SmsCodePO smsCodePO = userRepository.selectSmsCode(phoneNumber);
        if (smsCodePO == null) {
            throw new RuntimeException("验证码不存在，请重新发送");
        }
        String codeInStore = smsCodePO.getCode();
        Long expiredAt = smsCodePO.getExpiredAt();
        if (expiredAt < DateTimeUtils.nowSeconds()) {
            throw new RuntimeException("验证码已过期，请刷新重新注册");
        }
        if (!codeInStore.equals(code)) {
            throw new RuntimeException("验证码不正确，请重试");
        }
        // 注册
        String salt = RandomUtil.generateRandomEnglishString(SALT_SIZE);
        String enCodePassword = SecUtil.passwordEncode(userRegisterReqVO.getPassword(), salt);
        UserPO userPO = new UserPO();
        userPO.setUserName(userRegisterReqVO.getUserName());
        userPO.setPhoneNumber(phoneNumber);
        userPO.setPassword(enCodePassword);
        userPO.setSalt(salt);
        String randomAvatarUrl = getRandomAvatarUrl();
        UserInfo userInfo = UserInfo.builder()
                .nickname(userRegisterReqVO.getUserName())
                .avatarUrl(randomAvatarUrl)
                .build();
        userPO.setInfo(JSON.toJSONString(userInfo));
        userPO.setRole(Role.NORMAL.name());
        userPO.setLocked(false);
        boolean res = userRepository.insert(userPO);
        if (res) {
            StpUtil.login(userPO.getId());
        }
        return res;
    }

    @Override
    public boolean resetPassword(UserRegisterReqVO userRegisterReqVO) {
        Preconditions.checkNotNull(userRegisterReqVO, "请求体为空");
        UserPO user = userRepository.selectByName(userRegisterReqVO.getUserName());
        if (user == null) {
            throw new RuntimeException("用户名不存在");
        }
        String phoneNumber = userRegisterReqVO.getPhoneNumber();
        String code = userRegisterReqVO.getCode();
        SmsCodePO smsCodePO = userRepository.selectSmsCode(phoneNumber);
        if (smsCodePO == null) {
            throw new RuntimeException("验证码不存在，请重新发送");
        }
        String codeInStore = smsCodePO.getCode();
        Long expiredAt = smsCodePO.getExpiredAt();
        if (expiredAt < DateTimeUtils.nowSeconds()) {
            throw new RuntimeException("验证码已过期，请刷新重新注册");
        }
        if (!codeInStore.equals(code)) {
            throw new RuntimeException("验证码不正确，请重试");
        }
        // 注册
        String salt = RandomUtil.generateRandomEnglishString(SALT_SIZE);
        String enCodePassword = SecUtil.passwordEncode(userRegisterReqVO.getPassword(), salt);
        user.setPassword(enCodePassword);
        user.setSalt(salt);
        boolean res = userRepository.update(user);
        if (res) {
            StpUtil.login(user.getId());
        }
        return res;
    }


    @Override
    public boolean login(String userName, String password) {
        UserPO userPO = userRepository.selectByName(userName);
        if (userPO != null) {
            userRepository.selectByPhone(userName);
        }
        Preconditions.checkNotNull(userPO, "用户不存在，请检查您的用户名或者国内手机号");
        String salt = userPO.getSalt();
        String userPassword = SecUtil.passwordEncode(password, salt);
        String enCodePassword = userPO.getPassword();
        if (enCodePassword.equals(userPassword)) {
            Long userId = userPO.getId();
            StpUtil.login(userId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserInfoRespVO getUserInfo(Long userId) {
        UserPO userPO = userRepository.selectById(userId);
        return UserInfoRespVO.builder()
                .userId(userPO.getId())
                .userName(userPO.getUserName())
                .role(userPO.getRole())
                .userInfo(JSON.parseObject(userPO.getInfo(), UserInfo.class))
                .points(userPO.getPoints())
                .build();
    }

    @Override
    public boolean updateUserInfo(Long userId, UserInfo userInfo) {
        UserPO userPO = userRepository.selectById(userId);
        userPO.setInfo(JSON.toJSONString(userInfo));
        return userRepository.update(userPO);
    }

    @Override
    public UserStoreListRespVO getUserStores(TargetType type, Long userId, Integer number, Integer offset) {
        UserStoreListRespVO resp = new UserStoreListRespVO();
        List<Long> targetIdList = interactionService.getUserTargetIdList(userId, InteractionType.STORE, type, offset, number);
        Long total = interactionService.countUserTargetIdList(userId, InteractionType.STORE, type);
        resp.setTargetType(type);
        resp.setTotal(total);

        if (TargetType.MODEL.equals(type)) {
            List<ModelDetailPO> modelDetailPOS = modelRepository.selectModelDetailListByIdList(targetIdList);
            resp.setModelList(modelService.makeUpModelRespVO(modelDetailPOS));
        } else if (TargetType.SD_IMAGE.equals(type)) {
            List<SdPromptRespVO> sdPromptRespVOS = promptService.getSdPromptListByCondition(targetIdList, 0, total.intValue(), null, null);
            resp.setSdPromptList(sdPromptRespVOS);
        } else if (TargetType.MJ_IMAGE.equals(type)) {
            List<MjPromptRespVO> mjPromptRespVOS = promptService.getMjPromptListByCondition(targetIdList, 0, total.intValue(), null, null);
            resp.setMjPromptList(mjPromptRespVOS);
        } else {
            throw new RuntimeException("暂不支持次类型");
        }
        return resp;
    }

    @Override
    public Map<Long, UserInfo> getUserInfoMap(List<Long> userIdList) {
        List<UserPO> userPOList = userRepository.selectByUserIdList(userIdList);
        return userPOList.stream()
                .collect(Collectors.toMap(UserPO::getId, obj -> JSON.parseObject(obj.getInfo(),UserInfo.class), (x, y) -> x));
    }

    private String getRandomAvatarUrl() {
        return SYSTEM_AVATAR_LIST[RANDOM.nextInt(SYSTEM_AVATAR_LIST.length)];
    }
}
