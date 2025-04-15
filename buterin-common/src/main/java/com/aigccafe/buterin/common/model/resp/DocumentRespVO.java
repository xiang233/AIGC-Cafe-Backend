package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class DocumentRespVO {

    private Long id;

    private Long userId;

    private String userName;

    private String avatarUrl;

    private String documentType;

    private String documentName;

    private String profile;

    private String coverImageUrl;
}
