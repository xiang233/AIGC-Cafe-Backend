package com.aigccafe.buterin.service;

import com.aigccafe.buterin.common.enumerate.JourneyMemberType;
import com.aigccafe.buterin.common.model.journey.JourneyMemberPO;
import com.aigccafe.buterin.common.model.req.ChangeReqVO;
import com.aigccafe.buterin.common.model.req.ImagineReqVO;
import com.aigccafe.buterin.common.model.req.SessionReqVO;
import com.aigccafe.buterin.common.model.resp.ImagineRespVO;
import com.aigccafe.buterin.common.model.resp.JourneyMemberIntroRespVO;
import com.aigccafe.buterin.common.model.resp.JourneyTaskRespVO;
import com.aigccafe.buterin.common.model.resp.SessionRespVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JourneyService {

    Long updateSession(SessionReqVO sessionReqVO);

    boolean deleteSession(Long sessionId);

    List<SessionRespVO> getSessionList(Long userId, Integer offset, Integer number);

    ImagineRespVO submitImagine(ImagineReqVO imagineReqVO);

    ImagineRespVO submitChange(ChangeReqVO changeReqVO);

    JourneyTaskRespVO getJourneyTask(Long id);

    List<JourneyTaskRespVO> getJourneyTaskList(Long sessionId, Integer offset, Integer number);

    ResponseEntity<byte[]> getOuterImage(String code);

    List<JourneyMemberIntroRespVO> getJourneyMemberIntro();

    boolean addJourneyMember(Long userId, JourneyMemberType memberType);

    JourneyMemberPO getValidMemberRecord(Long userId);

    boolean checkJourneyMember(Long userId);

    String storeOuterImage(String url);

    String resizeOssPath(String sourcePath);
}
