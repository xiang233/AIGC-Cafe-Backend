package com.aigccafe.buterin.common.model.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class JourneyMemberIntroRespVO {

    private String type;

    private String value;

    private String title;

    private List<String> descriptions;

    private Integer fastNumber;

    private Double price;

    private Boolean hasOrder;
}
