package com.common;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * created by  zhouzq on 2020/11/4
 * desc
 */
public class BaseVO implements Serializable {
    public BaseVO() {
    }

    public BaseVO(Object source) {
        BeanUtils.copyProperties(source, this);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}