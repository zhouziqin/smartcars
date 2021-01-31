package com.domain.model;

import lombok.Data;

@Data
public class EventData {
    //车位编码
    String portCode;//节点控制器-节点号（001-001）
    //车位状态
    String portStatus;//空闲、占用、异常（01、02、03）
    //车牌号
    String plateNo;//车牌号（A12345）
    //设备状态
    String devStatus;//开、关、异常、停止（01、02、03、04）
    //设备错误代码
    String errorCode;//未知异常（0001）
    //设备类型的
    String devType;//吊杆、摄像头、超声波、节点控制器、滑杆、地锁、电池(01、02、03、04、05)
    //图片地址
    String picUrl;//http：xxxxxxxxx
    //故障代码
    String ErrorCode;//（设备类型+故障代码）摄像头、吊杆、超声波、节点控制器(0101、0201、0301、0401)
    //命令ID
    String cmdId;//车场号+车位编码+时间戳（001-001-001-XXXXXXX）
    //预约时间段
    String orderTime;//分钟
    //执行结果
    String result;//执行中、已完成、执行失败（01、02、03）
    //使用类型
    String useType;//个人，商用（01、02）

}
