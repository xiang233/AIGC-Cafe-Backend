package com.aigccafe.buterin.common.model.resp;

import com.aigccafe.buterin.common.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionReaderRespVO {

    private Long userId;

    private UserInfo userInfo;

    private String title;

    private String tags;

    private Long viewCnt;

    private Long answerCnt;

    private Long supportCnt;

    private Long unSupportCnt;

    private String content;

    private String status;

    private String created_time;

    private String updated_time;
}
