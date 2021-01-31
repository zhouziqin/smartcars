package com.dao.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * created by  zhouzq on 2020/7/27
 * desc
 */
@Table(name = "device")
@Data
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "device_info")
    private String deviceInfo;
    @Column(name = "device_code")
    private String deviceCode;
    @Column(name = "create_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "status")
    private int status;

}
