package com.aigccafe.buterin.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.aigccafe.buterin.common.enumerate.*;
import com.aigccafe.buterin.common.model.http.HttpRequestConfig;
import com.aigccafe.buterin.common.model.journey.ImageInfo;
import com.aigccafe.buterin.common.model.journey.JourneyMemberPO;
import com.aigccafe.buterin.common.model.journey.JourneySessionPO;
import com.aigccafe.buterin.common.model.journey.JourneyTaskPO;
import com.aigccafe.buterin.common.model.req.ChangeReqVO;
import com.aigccafe.buterin.common.model.req.ImagineReqVO;
import com.aigccafe.buterin.common.model.req.SessionReqVO;
import com.aigccafe.buterin.common.model.resp.ImagineRespVO;
import com.aigccafe.buterin.common.model.resp.JourneyMemberIntroRespVO;
import com.aigccafe.buterin.common.model.resp.JourneyTaskRespVO;
import com.aigccafe.buterin.common.model.resp.SessionRespVO;
import com.aigccafe.buterin.common.model.user.UserPO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.common.util.Preconditions;
import com.aigccafe.buterin.repository.JourneyRepository;
import com.aigccafe.buterin.repository.OOSRepository;
import com.aigccafe.buterin.repository.UserRepository;
import com.aigccafe.buterin.service.HttpService;
import com.aigccafe.buterin.service.JourneyService;
import com.aigccafe.buterin.service.PromptService;
import com.aigccafe.buterin.service.TranslateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static com.aigccafe.buterin.common.enumerate.ImageType.JOURNEY;

@Service
@Slf4j
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;
    @Autowired
    private HttpService httpService;
    @Autowired
    private OOSRepository oosRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PromptService promptService;
    @Autowired
    private TranslateService translateService;

    @Value("${spring.profiles.active}")
    private String env;

    private final static Long TASK_CONSUME_POINT = 20L;

    @Override
    public Long updateSession(SessionReqVO sessionReqVO) {
        Long userId = StpUtil.getLoginIdAsLong();
        Long id = sessionReqVO.getId();
        if (id != null) {
            JourneySessionPO session = journeyRepository.selectSessionById(id);
            if (session != null) {
                Preconditions.checkArgument(session.getUserId().equals(userId), "无权限");
                Preconditions.checkNonEmpty(sessionReqVO.getSessionName(), "名称不能为空");
                session.setSessionName(sessionReqVO.getSessionName());
                journeyRepository.updateSession(session);
                return id;
            } else {
                throw new RuntimeException("wrong session id");
            }
        } else {
            JourneySessionPO sessionPO = new JourneySessionPO();
            String sessionName = sessionReqVO.getSessionName();
            if (Strings.isNullOrEmpty(sessionName)) {
                String date = DateTimeUtils.nowDateTime();
                sessionName = String.format("新的任务-%s", date);
            }
            sessionPO.setUserId(userId);
            sessionPO.setSessionName(sessionName);
            journeyRepository.insertSession(sessionPO);
            return sessionPO.getId();
        }
    }

    @Override
    public boolean deleteSession(Long sessionId) {
        Long userId = StpUtil.getLoginIdAsLong();
        JourneySessionPO session = journeyRepository.selectSessionById(sessionId);
        Preconditions.checkArgument(session.getUserId().equals(userId), "无权限");
        session.setIsDeleted(true);
        return journeyRepository.updateSession(session);
    }

    @Override
    public List<SessionRespVO> getSessionList(Long userId, Integer offset, Integer number) {
        List<JourneySessionPO> journeySessionPOS = journeyRepository.selectByCondition(userId, offset, number);
        return journeySessionPOS.stream().
                map(x -> SessionRespVO.builder()
                        .sessionName(x.getSessionName())
                        .id(x.getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ImagineRespVO submitImagine(ImagineReqVO imagineReqVO) {
        Preconditions.checkNonEmpty(imagineReqVO.getPrompt(), "提示词不能为空");
        Preconditions.checkNotNull(imagineReqVO.getSessionId(), "sessionId不能为空");
        Long userId = StpUtil.getLoginIdAsLong();

        // 验证用户是否有提交任务的权限
        JourneySessionPO sessionPO = journeyRepository.selectSessionById(imagineReqVO.getSessionId());
        Preconditions.checkNotNull(sessionPO, "会话id非法");
        Preconditions.checkArgument(sessionPO.getUserId().equals(userId), "无权限");

        // 验证是否是会员
        UserPO user = userRepository.selectById(userId);
        boolean isMember = checkJourneyMember(userId);
        Preconditions.checkArgument(isMember || user.getPoints() >= TASK_CONSUME_POINT, "您还未订阅会员且积分不够，您可选择购买会员或者充值积分");

        // 1、远端提交任务
        String prompt = imagineReqVO.getPrompt();
        // 如果用户输入的是中文，需要翻译并提交给mj
        String lang = translateService.detectLangByBaidu(prompt);
        if ("zh".equals(lang)) {
            prompt = promptService.translateMjPromptToEnglish(prompt);
        }
        JSONObject data = new JSONObject();
        data.fluentPut("prompt", prompt);
        if (Strings.isNullOrEmpty(imagineReqVO.getState())) {
            data.fluentPut("state", imagineReqVO.getState());
        }
        // 暂时不使用回调
//        if (Strings.isNullOrEmpty(imagineReqVO.getState())) {
//            data.fluentPut("notifyHook", imagineReqVO.getNotifyHook());
//        }

        // 使用参考图，此处暂时不使用
        if (Strings.isNullOrEmpty(imagineReqVO.getImagePath())) {
            String base64String = "";
            // oosRepository.getBase64Image(imagineReqVO.getImagePath());
            data.fluentPut("base64", base64String);
        }

        Map<String, String> header = Maps.newHashMap();
        header.put("Content-Type", "application/json");
        HttpRequestConfig config = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.POST)
                .clientType(ClientType.HTTPCLIENT)
                .url("http://45.91.82.87:8080/mj/submit/imagine")
                .headers(header)
                .body(data.toJSONString())
                .retry(3)
                .build();

        JSONObject result = null;
        try {
            result = httpService.requestJSONObject(config);
            log.info(result.toJSONString());
        } catch (Exception exp) {
            journeyRepository.errorLog(userId, exp.getMessage());
            return ImagineRespVO.builder()
                    .code(110)
                    .description("远程服务失效，请重试，如仍旧有问题，请联系客服排查！")
                    .build();
        }

        Integer code = result.getInteger("code");
        if (code == 1) {
            //
            String oriTaskId = result.getString("result");
            // 提交成功，记录任务
            JourneyTaskPO task = new JourneyTaskPO();
            task.setSessionId(imagineReqVO.getSessionId());
            task.setUserId(userId);
            task.setTaskType(JourneyTaskType.IMAGINE.name());
            task.setReferImageList(imagineReqVO.getImagePath());
            task.setPrompt(imagineReqVO.getPrompt());
            task.setOriTaskId(oriTaskId);
            task.setStatus(JourneyTaskStatus.SUBMITTED.name());
            task.setProgress("0%");

            boolean res = journeyRepository.insertTask(task);
            consumeTaskPoint(user);
            if (!res) {
                throw new RuntimeException("插入数据时出现异常，请联系客服排查！");
            }
            return ImagineRespVO.builder()
                    .code(result.getInteger("code"))
                    .taskId(task.getId())
                    .description(result.getString("description"))
                    .build();
        } else {
            // 错误情况
            return ImagineRespVO.builder()
                    .code(result.getInteger("code"))
                    .description(result.getString("description"))
                    .build();
        }
    }

    @Override
    public ImagineRespVO submitChange(ChangeReqVO changeReqVO) {
        Preconditions.checkNotNull(changeReqVO.getSessionId(), "sessionId不能为空");
        Preconditions.checkArgument(
                changeReqVO.getTaskType().equals(JourneyTaskType.VARIATION)
                || changeReqVO.getTaskType().equals(JourneyTaskType.REROLL)
                || changeReqVO.getTaskType().equals(JourneyTaskType.UPSCALE), "任务类型参数错误");
        Preconditions.checkNotNull(changeReqVO.getTaskId(), "任务ID不为空");
        if (changeReqVO.getTaskType().equals(JourneyTaskType.VARIATION) || changeReqVO.getTaskType().equals(JourneyTaskType.UPSCALE)) {
            Preconditions.checkNotNull(changeReqVO.getIndex(), "缺少index参数");
            Preconditions.checkArgument(changeReqVO.getIndex() >= 1 && changeReqVO.getIndex() <=4, "index取值为1～4");
        }

        // 验证用户是否有权限
        Long userId = StpUtil.getLoginIdAsLong();
        UserPO user = userRepository.selectById(userId);
        JourneySessionPO sessionPO = journeyRepository.selectSessionById(changeReqVO.getSessionId());
        Preconditions.checkNotNull(sessionPO, "会话id非法");
        Preconditions.checkArgument(sessionPO.getUserId().equals(userId), "无权限");

        // 验证是否是会员或者点数是否足够
        boolean isMember = checkJourneyMember(userId);
        Preconditions.checkArgument(isMember || user.getPoints() >= TASK_CONSUME_POINT, "您还未订阅会员且积分不够，您可选择购买会员或者充值积分");


        Long taskId = changeReqVO.getTaskId();
        JourneyTaskPO fatherTask = journeyRepository.selectTaskById(taskId);
        String oriTaskId = fatherTask.getOriTaskId();

        // 放大任务直接返回值就行
        if (changeReqVO.getTaskType().equals(JourneyTaskType.UPSCALE)) {
            JourneyTaskPO task = new JourneyTaskPO();
            task.setSessionId(changeReqVO.getSessionId());
            task.setUserId(userId);
            task.setTaskType(changeReqVO.getTaskType().name());
            task.setReferImageList("");
            task.setImageIndex(changeReqVO.getIndex());
            task.setPrompt(fatherTask.getPrompt());
            task.setFatherTaskId(changeReqVO.getTaskId());
            task.setOriTaskId("");
            int index = changeReqVO.getIndex();
            if (!Strings.isNullOrEmpty(fatherTask.getMidSubImageList())) {
                String[] midImageList = fatherTask.getMidSubImageList().split(",");
                if (midImageList.length == 4) {
                    task.setMidImageUrl(midImageList[index - 1]);
                    task.setdImageUrl(midImageList[index - 1]);
                }
            }
            if (!Strings.isNullOrEmpty(fatherTask.getSubImagePathList())) {
                String[] imagePathList = fatherTask.getSubImagePathList().split(",");
                if (imagePathList.length == 4) {
                    task.setImagePath(imagePathList[index - 1]);
                }
            }
            if (!Strings.isNullOrEmpty(fatherTask.getRawSubImagePathList())) {
                String[] rawImagePathList = fatherTask.getRawSubImagePathList().split(",");
                if (rawImagePathList.length == 4) {
                    task.setRawImagePath(rawImagePathList[index - 1]);
                }
            }
            if (task.getMidImageUrl() != null || task.getImagePath() != null) {
                task.setStatus(JourneyTaskStatus.SUCCESS.name());
                task.setProgress("100%");
                task.setSubmitTime(DateTimeUtils.nowMilliSeconds());
                task.setFinishTime(DateTimeUtils.nowMilliSeconds());
                task.setStartTime(DateTimeUtils.nowMilliSeconds());
                journeyRepository.insertTask(task);
                return ImagineRespVO.builder()
                        .code(1)
                        .taskId(task.getId())
                        .description("提交成功")
                        .build();
            } else {
                return ImagineRespVO.builder()
                        .code(110)
                        .description("失败，源任务不存在或者存在异常")
                        .build();
            }
        } else {
            JSONObject data = new JSONObject();
            data.fluentPut("action", changeReqVO.getTaskType().name());
            data.fluentPut("index", changeReqVO.getIndex());
            data.fluentPut("notifyHook", "");
            data.fluentPut("state", "");
            data.fluentPut("taskId", oriTaskId.toString());
            Map<String, String> header = Maps.newHashMap();
            header.put("Content-Type", "application/json");
            HttpRequestConfig config = HttpRequestConfig.builder()
                    .httpMethod(HttpMethod.POST)
                    .clientType(ClientType.HTTPCLIENT)
                    .url("http://45.91.82.87:8080/mj/submit/change")
                    .headers(header)
                    .body(data.toJSONString())
                    .retry(3)
                    .build();

            JSONObject result = null;
            try {
                result = httpService.requestJSONObject(config);
            } catch (Exception exp) {
                journeyRepository.errorLog(userId, exp.getMessage());
                return ImagineRespVO.builder()
                        .code(110)
                        .description("远程服务失效，请重试，如仍旧有问题，请联系客服排查！")
                        .build();
            }
            Integer code = result.getInteger("code");
            if (code == 1) {
                //
                String newOriTaskId = result.getString("result");
                // 提交成功，记录任务
                JourneyTaskPO task = new JourneyTaskPO();
                task.setSessionId(changeReqVO.getSessionId());
                task.setUserId(userId);
                task.setTaskType(changeReqVO.getTaskType().name());
                task.setReferImageList("");
                task.setImageIndex(changeReqVO.getIndex());
                task.setPrompt(fatherTask.getPrompt());
                task.setFatherTaskId(changeReqVO.getTaskId());
                task.setOriTaskId(newOriTaskId);
                task.setStatus(JourneyTaskStatus.SUBMITTED.name());
                task.setProgress("0%");
                consumeTaskPoint(user);
                boolean res = journeyRepository.insertTask(task);
                if (!res) {
                    throw new RuntimeException("插入数据时出现异常，请联系客服排查！");
                }
                return ImagineRespVO.builder()
                        .code(result.getInteger("code"))
                        .taskId(task.getId())
                        .description(result.getString("description"))
                        .build();
            } else {
                // 错误情况
                return ImagineRespVO.builder()
                        .code(result.getInteger("code"))
                        .description(result.getString("description"))
                        .build();
            }
        }
    }

    @Override
    public JourneyTaskRespVO getJourneyTask(Long id) {
        JourneyTaskPO taskPO = journeyRepository.selectTaskById(id);
        Preconditions.checkNotNull(taskPO, "任务不存在");
        String oriTaskId = taskPO.getOriTaskId();
        Long userId = StpUtil.getLoginIdAsLong();
        Preconditions.checkArgument(taskPO.getUserId().equals(userId), "无权限");
        JourneyTaskType taskType = JourneyTaskType.valueOf(taskPO.getTaskType());
        String description = String.format("[%s]:%s", taskType.getDescription(), taskPO.getPrompt());

        // 如果是放大任务或者是已经完成|失败的任务，直接组织信息返回
        if (taskType.equals(JourneyTaskType.UPSCALE)
                || taskPO.getStatus().equals(JourneyTaskStatus.SUCCESS.name())
                || taskPO.getStatus().equals(JourneyTaskStatus.FAILURE.name()))  {
            String imagePath = taskPO.getImagePath();
            String rawImagePath = taskPO.getRawImagePath();
            String imageUrl = "";
            String rawImageUrl = "";
            if (!Strings.isNullOrEmpty(imagePath)) {
                imageUrl = oosRepository.getSafeUrl(imagePath);
                rawImageUrl = oosRepository.getSafeUrl(rawImagePath);
            } else if (!Strings.isNullOrEmpty(taskPO.getdImageUrl())){
                imageUrl = taskPO.getdImageUrl();
                rawImageUrl = taskPO.getdImageUrl();
            } else if (!Strings.isNullOrEmpty(taskPO.getMidImageUrl())) {
                imageUrl = taskPO.getMidImageUrl();
                rawImageUrl = taskPO.getMidImageUrl();
            }

            return JourneyTaskRespVO.builder()
                    .taskId(id)
                    .taskType(taskPO.getTaskType())
                    .description(description)
                    .status(taskPO.getStatus())
                    .failReason("")
                    .progress(taskPO.getProgress())
                    .imageUrl(imageUrl)
                    .rawImageUrl(rawImageUrl)
                    .submitTime(taskPO.getSubmitTime())
                    .startTime(taskPO.getStartTime())
                    .finishTime(taskPO.getFinishTime())
                    .build();
        }

        Map<String, String> header = Maps.newHashMap();
        header.put("Content-Type", "application/x-www-form-urlencoded");
        HttpRequestConfig config = HttpRequestConfig.builder()
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .url(String.format("http://45.91.82.87:8080/mj/task/%s/fetch", oriTaskId))
                .retry(3)
                .build();
        JSONObject result = null;
        try {
            result = httpService.requestJSONObject(config);
        } catch (Exception exp) {
            journeyRepository.errorLog(userId, exp.getMessage());
            throw new RuntimeException("远程服务失效，请重试，如仍旧有问题，请联系客服排查！");
        }
        if (result == null) {
            throw new RuntimeException("查询失败，请重试，如仍旧有问题，请联系客服排查！");
        }

        // 状态更新到表里或者返回
        log.info("result:{}", JSON.toJSONString(result));
        if (result.containsKey("action")) {
            String imageUrl = result.getString("imageUrl");
            String progress = result.getString("progress");
            String status = result.getString("status");
            Long submitTime = result.getLong("submitTime");
            Long startTime = result.getLong("startTime");
            Long finishTime = result.getLong("finishTime");
            String rawImageUrl = imageUrl;

            // 如果是生产完了，需转存并写下图片链接记录，如果还未生产完，返回临时图片的短地址
            if (!Strings.isNullOrEmpty(imageUrl)) {
                if (JourneyTaskStatus.SUCCESS.name().equals(status)) {
                    ImageInfo imageInfo = storeAndMakeUpImageInfo(taskPO, imageUrl);
                    imageUrl = imageInfo.getImageUrl();
                    rawImageUrl = imageInfo.getRawImageUrl();
                } else {
                    String shortCode = journeyRepository.addShortCode(imageUrl);
                    imageUrl = String.format(hostUrl() + "/cafe/journey/image/%s", shortCode);
                    rawImageUrl = imageUrl;
                }
            }
            if (!Strings.isNullOrEmpty(progress)) {
                taskPO.setProgress(progress);
            }
            if (!Strings.isNullOrEmpty(status)) {
                taskPO.setStatus(status);
            }
            if (submitTime != null) {
                taskPO.setSubmitTime(submitTime);
            }
            if (startTime != null) {
                taskPO.setStartTime(startTime);
            }
            if (finishTime != null) {
                taskPO.setFinishTime(finishTime);
            }
            if (!Strings.isNullOrEmpty(result.getString("failReason"))) {
                taskPO.setFailReason(result.getString("failReason"));
            }
            taskPO.setTaskResp(result.toJSONString());
            journeyRepository.updateTask(taskPO);
            return JourneyTaskRespVO.builder()
                    .taskId(id)
                    .taskType(taskPO.getTaskType())
                    .description(description)
                    .status(status)
                    .failReason(result.getString("failReason"))
                    .progress(progress)
                    .imageUrl(imageUrl)
                    .rawImageUrl(rawImageUrl)
                    .submitTime(result.getLong("submitTime"))
                    .startTime(result.getLong("startTime"))
                    .finishTime(result.getLong("finishTime"))
                    .build();
        } else {
            throw new RuntimeException("查询任务失败，请重试");
        }
    }

    @Override
    public List<JourneyTaskRespVO> getJourneyTaskList(Long sessionId, Integer offset, Integer number) {
        Long userId = StpUtil.getLoginIdAsLong();
        List<JourneyTaskPO> taskList = journeyRepository.selectTaskByCondition(userId, sessionId, offset, number);
        return taskList.stream().map(taskPO -> {
            JourneyTaskType taskType = JourneyTaskType.valueOf(taskPO.getTaskType());
            String description = String.format("[%s]:%s", taskType.getDescription(), taskPO.getPrompt());

            String imagePath = taskPO.getImagePath();
            String rawImagePath = taskPO.getRawImagePath();
            String imageUrl = "";
            String rawImageUrl = "";
            if (!Strings.isNullOrEmpty(imagePath)) {
                imageUrl = oosRepository.getSafeUrl(imagePath);
                rawImageUrl = oosRepository.getSafeUrl(rawImagePath);
            } else if (!Strings.isNullOrEmpty(taskPO.getdImageUrl())){
                imageUrl = taskPO.getdImageUrl();
                rawImageUrl = imageUrl;
            } else if (!Strings.isNullOrEmpty(taskPO.getMidImageUrl())) {
                imageUrl = taskPO.getMidImageUrl();
                rawImageUrl = taskPO.getMidImageUrl();
            }
            return JourneyTaskRespVO.builder()
                    .taskId(taskPO.getId())
                    .taskType(taskPO.getTaskType())
                    .description(description)
                    .status(taskPO.getStatus())
                    .failReason(taskPO.getFailReason())
                    .progress(taskPO.getProgress())
                    .imageUrl(imageUrl)
                    .rawImageUrl(rawImageUrl)
                    .submitTime(taskPO.getSubmitTime())
                    .startTime(taskPO.getStartTime())
                    .finishTime(taskPO.getFinishTime())
                    .build();
        }).collect(Collectors.toList());
    }

    ImageInfo storeAndMakeUpImageInfo(JourneyTaskPO taskPO, String imageUrl) {
        String midImageUrl = "";
        String dImageUrl = "";
        String imagePath = "";
        String rawImagePath = "";
        if (!Strings.isNullOrEmpty(taskPO.getImagePath())) {
            return ImageInfo.builder().imageUrl(oosRepository.getSafeUrl(taskPO.getImagePath()))
                    .rawImageUrl(oosRepository.getSafeUrl(taskPO.getRawImagePath()))
                    .build();
        }
        try {
            String shortCode = journeyRepository.addShortCode(imageUrl);
            dImageUrl = String.format(hostUrl() + "/cafe/journey/image/%s", shortCode);
            taskPO.setdImageUrl(dImageUrl);
            String midId = parseMidImageId(imageUrl);
            midImageUrl = String.format("https://cdn.midjourney.com/%s/grid_0.png", midId);
            String partOneUrl = String.format("https://cdn.midjourney.com/%s/0_0.png", midId);
            String partTwoUrl = String.format("https://cdn.midjourney.com/%s/0_1.png", midId);
            String partThreeUrl = String.format("https://cdn.midjourney.com/%s/0_2.png", midId);
            String partFourUrl = String.format("https://cdn.midjourney.com/%s/0_3.png", midId);
            taskPO.setMidImageUrl(midImageUrl);
            // 5张图片转储
            List<String> midUrls = Lists.newArrayList(imageUrl, partOneUrl, partTwoUrl, partThreeUrl, partFourUrl);
            List<String> rawMidPaths = midUrls.stream().parallel().map(this::storeOuterImage).collect(Collectors.toList());
            List<String> midPaths = rawMidPaths.stream().parallel().map(this::resizeOssPath).collect(Collectors.toList());

            imagePath = midPaths.get(0);
            rawImagePath = rawMidPaths.get(0);
            List<String> subPaths = midPaths.subList(1, midPaths.size());
            List<String> rawSubPaths = rawMidPaths.subList(1, midPaths.size());
            List<String> subMidUrls = midUrls.subList(1, midUrls.size());
            taskPO.setRawImagePath(rawImagePath);
            taskPO.setImagePath(imagePath);
            taskPO.setRawSubImagePathList(String.join(",", rawSubPaths));
            taskPO.setSubImagePathList(String.join(",", subPaths));
            taskPO.setMidSubImageList(String.join(",", subMidUrls));
        } catch (Exception exp) {
            log.info("转出或者解析图片出现错误");
        }
        if (!Strings.isNullOrEmpty(imagePath)) {
            return ImageInfo.builder()
                    .imageUrl(oosRepository.getSafeUrl(imagePath))
                    .rawImageUrl(oosRepository.getSafeUrl(rawImagePath))
                    .build();
        }
        if (!Strings.isNullOrEmpty(dImageUrl)) {
            return ImageInfo.builder()
                    .imageUrl(dImageUrl)
                    .rawImageUrl(dImageUrl)
                    .build();
        }
        if (!Strings.isNullOrEmpty(midImageUrl)) {
            return ImageInfo.builder()
                    .imageUrl(midImageUrl)
                    .rawImageUrl(midImageUrl)
                    .build();
        }
        return ImageInfo.builder()
                .imageUrl(imageUrl)
                .rawImageUrl(imageUrl)
                .build();
    }

    @Override
    public String storeOuterImage(String url) {
        String storeUrl = String.format("http://45.91.82.87:8012/image/store?url=%s", url);
        HttpRequestConfig config = HttpRequestConfig.builder()
                .url(storeUrl)
                .retry(3)
                .httpMethod(HttpMethod.GET)
                .clientType(ClientType.HTTPCLIENT)
                .build();
        try {
            JSONObject response = httpService.requestJSONObject(config);
            JSONObject data = response.getJSONObject("data");
            return data.getString("aliOssPath");
        } catch (Exception exp) {
            exp.printStackTrace();
            log.info("存储失败");
        }
        return "";
    }

    @Override
    public String resizeOssPath(String sourcePath) {
        String dir = JOURNEY.getDir();
        String targetPath = dir + "/" + sourcePath;
        oosRepository.resizeImageInOOS(sourcePath, targetPath, JOURNEY.getResizeCmd());
        return targetPath;
    }

    private String parseMidImageId(String url) {
        String[] urlParts = url.split("/");
        String mjPart = urlParts[urlParts.length - 1];
        String[] words = mjPart.split("_");
        String imageName = words[words.length - 1];
        String[] imageParts = imageName.split("\\.");
        return  imageParts[0];
    }

    @Override
    public ResponseEntity<byte[]> getOuterImage(String code) {
        String rawUrl = journeyRepository.selectRawUrlByCode(code);
        String requestUrl = String.format("http://45.91.82.87:8012/transfer?url=%s", rawUrl);
        try {
            return httpService.getRequestByOkHttp3(3, requestUrl);
        } catch (Exception exp) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<JourneyMemberIntroRespVO> getJourneyMemberIntro() {
        List<JourneyMemberIntroRespVO> memberIntros = Lists.newArrayList();
        boolean isLogin = StpUtil.isLogin();
        JourneyMemberPO userMember = isLogin ? getValidMemberRecord(StpUtil.getLoginIdAsLong()) : null;


        for (JourneyMemberType memberType : JourneyMemberType.values()) {
            boolean hasOrder = false;
            if (userMember != null) {
                JourneyMemberType userMemberType = JourneyMemberType.valueOf(userMember.getMemberType());
                if (memberType.equals(userMemberType)) {
                    hasOrder = true;
                }
            }

            JourneyMemberIntroRespVO memberIntroRespVO = JourneyMemberIntroRespVO.builder()
                    .type(memberType.name())
                    .value(memberType.getValue())
                    .title(memberType.getTitle())
                    .descriptions(memberType.getDescriptions())
                    .fastNumber(memberType.getFastNumber())
                    .price(memberType.getPrice())
                    .hasOrder(hasOrder)
                    .build();
            memberIntros.add(memberIntroRespVO);
        }
        return memberIntros;
    }

    @Override
    public boolean addJourneyMember(Long userId, JourneyMemberType memberType) {
        JourneyMemberPO journeyMember = getValidMemberRecord(userId);
        Preconditions.checkArgument(journeyMember ==  null, "您已订购会员");
        journeyMember = journeyRepository.selectMemberByUserId(userId);
        if (journeyMember == null) {
            journeyMember = new JourneyMemberPO();
        }
        Long currentTime = DateTimeUtils.nowSeconds();
        Long expiredAt = currentTime + memberType.getDuration();
        journeyMember.setUserId(userId);
        journeyMember.setMemberType(memberType.name());
        journeyMember.setExpiredAt(expiredAt);
        journeyMember.setFastTimes(memberType.getFastNumber());
        return journeyRepository.insertJourneyMember(journeyMember);
    }

    @Override
    public JourneyMemberPO getValidMemberRecord(Long userId) {
        JourneyMemberPO journeyMemberPO = journeyRepository.selectMemberByUserId(userId);
        if (journeyMemberPO != null && DateTimeUtils.nowSeconds() < journeyMemberPO.getExpiredAt()) {
            return journeyMemberPO;
        } else {
            return null;
        }
    }

    @Override
    public boolean checkJourneyMember(Long userId) {
        boolean isMember = false;
        JourneyMemberPO journeyMemberPO = journeyRepository.selectMemberByUserId(userId);
        if (journeyMemberPO != null && DateTimeUtils.nowSeconds() < journeyMemberPO.getExpiredAt()) {
            isMember = true;
        }
        return isMember;
    }

    private String hostUrl() {
        if ("prod".equals(env)) {
            return "https://www.aigccafe.com";
        } else {
            return "http://localhost:8089";
        }
    }

    private void consumeTaskPoint(UserPO userPO) {
        Long currentPoints = userPO.getPoints();
        Long points = Math.max(currentPoints - TASK_CONSUME_POINT, 0);
        userPO.setPoints(points);
        userRepository.update(userPO);
    }
}
