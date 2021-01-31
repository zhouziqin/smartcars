package com.domain.VO;

import lombok.Data;
/**
 * 作者:zhouziqin
 * 时间: 2020-12-10 22:21
 * des: 车位状态变化上报
 */
@Data
public class CarPortStatusVO extends BaseDataVO {
    private String portCode;
    private String portStatus;
    private String plateNo;
    private String devStatus;
    private String errorCode;
}
