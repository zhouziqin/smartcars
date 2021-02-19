package com.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="carport")
public class CarPortBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    //车位编码
    @Column(name="port_code")
    String portCode;//节点控制器-节点号（001-001）
    //车位状态
    @Column(name="port_status")
    String portStatus;//空闲、占用、异常（01、02、03）
    //车牌号
    @Column(name="plate_no")
    String plateNo;//车牌号（A12345）
    //设备状态
    @Column(name="dev_status")
    String devStatus;//开、关、异常、停止（01、02、03、04）
    //设备错误代码
    @Column(name="error_code")
    String errorCode;//未知异常（0001）
    //设备类型的
    @Column(name="dev_type")
    String devType;//吊杆、摄像头、超声波、节点控制器、滑杆、地锁、电池(01、02、03、04、05)
    //故障代码
    @Column(name="dev_error_code")
    String devErrorCode;//（设备类型+故障代码）摄像头、吊杆、超声波、节点控制器(0101、0201、0301、0401)
    @Column(name="create_time")
    Date createTime;


}
