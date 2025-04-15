package com.aigccafe.buterin.common.model.resp;

import com.aigccafe.buterin.common.enumerate.TargetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStoreListRespVO {

    private TargetType targetType;

    private Long total;

    private List<ModelRespVO> modelList;

    private List<DocumentRespVO> documentList;

    private List<SdPromptRespVO> sdPromptList;

    private List<MjPromptRespVO> mjPromptList;

}
