package com.aigccafe.buterin.common.model;

import com.aigccafe.buterin.common.util.DateTimeUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity<K> implements Serializable {
    /**
     * 主键
     */
    private K id;

    /**
     * 创建时间
     */
    private Long createdAt;

    /**
     * 修改时间
     */
    private Long updatedAt;

    /**
     * 是否已删除
     */
    private Byte isDeleted;

    public String getUpdatedTime() {
        if (updatedAt == null) {
            return null;
        }
        return DateTimeUtils.formatDatetime(updatedAt * 1000);
    }

    public String getCreatedTime() {
        if (createdAt == null) {
            return null;
        }
        return DateTimeUtils.formatDatetime(createdAt * 1000);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this, SerializerFeature.PrettyFormat);
    }
}