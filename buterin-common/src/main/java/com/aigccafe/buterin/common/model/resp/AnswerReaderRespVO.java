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
public class AnswerReaderRespVO {
    private Long userId;

    private UserInfo userInfo;

    private Boolean approved;

    private Long agreeCnt;

    private Long disagreeCnt;

    private String content;

    private String created_time;

    private String updated_time;
}
