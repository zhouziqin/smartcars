package com.service;
import com.common.ExpiryDeviceMap;
import com.dao.model.EventDataPayload;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * created by  zhouzq on 2020/7/18
 * desc
 */
@Service
@Slf4j
public class DeviceImpl {

    /**
     * {
     *
     * “id”:”C00001”,
     *
     * “eventType”:”20”,
     *
     * “eventInfo”:
     *
     * {
     *
     * “plateInfo”:[“aaaa”, “bbbb”]
     *
     * },
     *
     * “extendInfo”:””,
     *
     * “happendTime”:””
     * @param deviceCoe
     * @param plateList
     */
    public void bindPlatNo(String deviceCoe, List<String> plateList) {

        ChannelHandlerContext ctx =  ExpiryDeviceMap.CHANNEL_MAP.get(deviceCoe);
        EventDataPayload eventDataPayload = new EventDataPayload();
        eventDataPayload.setId(deviceCoe);
        eventDataPayload.setEventType("20");
        JSONObject platObject  = new JSONObject();
        platObject.put("plateInfo",JSONArray.fromObject(plateList) );
       JSONObject jsonObject =  JSONObject.fromObject(eventDataPayload);
       jsonObject.put("eventInfo",platObject);

        log.info("ChannelHandlerContext:"+ctx+",eventDataPayload:"+jsonObject);
        ctx.writeAndFlush(jsonObject.toString());
    }
}
