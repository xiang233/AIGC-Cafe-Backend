package com.aigccafe.buterin.repository.impl;

import com.aigccafe.buterin.common.model.log.WebLogBO;
import com.aigccafe.buterin.common.model.log.WebLogPO;
import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.aigccafe.buterin.repository.LogRepository;
import com.aigccafe.buterin.repository.mapper.WebLogPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LogRepositoryImpl implements LogRepository {

    @Autowired
    private WebLogPOMapper webLogPOMapper;

    public int insert(WebLogBO webLogBO) {
        WebLogPO webLogPO = WebLogBO.castToPO(webLogBO);
        webLogPO.setCreatedAt(DateTimeUtils.nowSeconds());
        webLogPO.setUpdatedAt(DateTimeUtils.nowSeconds());
        webLogPO.setIsDeleted(false);
        return webLogPOMapper.insert(webLogPO);
    }
}
