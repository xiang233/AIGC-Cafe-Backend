package com.aigccafe.buterin.common.model.req;

import com.aigccafe.buterin.common.enumerate.DocumentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class DocumentReqVO {

    private Long id;

    private DocumentType documentType;

    private String documentName;

    private String profile;

    private String coverPath;
}
