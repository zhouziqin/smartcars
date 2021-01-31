package com.domain.model;
import net.sf.json.JSONObject;

 import lombok.Data;

import javax.persistence.*;

/**
 * 事件消息
 *
 */
@Data
@Table(name="test")
public class EventDataPayload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    Integer id;
    @Column(name="type")
    String type;
    @Column(name="data")
    String data;
    @Column(name="backup")
    String backup;
    @Column(name="time")
    Long time;



}
