package com.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name="carlog")
public class CarLogBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Long id;
    //车位编码
    @Column(name="port_code")
    String portCode;//节点控制器-节点号（001-001）
    //车位状态

    //车牌号
    @Column(name="plate_no")
    String plateNo;//车牌号（A12345）

    //命令ID
    @Column(name="cmd_id")
    String cmdId;//车场号+车位编码+时间戳（001-001-001-XXXXXXX）

    //命令ID
    @Column(name="cmd_type")
    String cmdype;//车场号+车位编码+时间戳（001-001-001-XXXXXXX）

    //命令ID
    @Column(name="data")
    String data;//车场号+车位编码+时间戳（001-001-001-XXXXXXX）
    //命令ID
    @Column(name="create_time")
    Date createTime;//车场号+车位编码+时间戳（001-001-001-XXXXXXX）

    @Column(name="ctrl_type")
    private String ctrlType;
}
