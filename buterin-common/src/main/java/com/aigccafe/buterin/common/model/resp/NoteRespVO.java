package com.aigccafe.buterin.common.model.resp;

import com.aigccafe.buterin.common.model.user.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class NoteRespVO {

    private Long id;

    private String title;

    private String brief;

    private UserInfo authorInfo;

    private String content;

    private String tags;
}
