package com.netty.server;


import com.common.ExpiryDeviceMap;
import com.dao.model.Device;
import com.dao.model.EventDataPayload;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * created by  zhouzq on 2020/7/15
 * desc
 */
@Slf4j
public class NettyServerHandler extends ChannelInboundHandlerAdapter {


    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception { log.info("Channel active......");
    }

    /**
     * 客户端发消息会触发
     */
    @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            log.info("服务器收到消息: {},{}", msg);

            log.info("服务器收到消息: {}", msg.toString());
            JSONObject json = JSONObject.fromObject(msg);
            messageHandleDisptch(json,ctx);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        ctx.flush();
    }
    public void messageHandleDisptch(  JSONObject json,ChannelHandlerContext ctx){
        EventDataPayload eventDataPayload = (EventDataPayload) JSONObject.toBean(json,EventDataPayload.class);
        ExpiryDeviceMap.CHANNEL_MAP.put(eventDataPayload.getId(),ctx,ExpiryDeviceMap.socketChannelMapTimeOut);
        if(eventDataPayload.getEventType().equals("10")){
            //init
        }else if(eventDataPayload.getEventType().equals("11")){
            //heart
            ExpiryDeviceMap.ACTIVE_MAP.put(eventDataPayload.getId(),json.toString());

        }else if(eventDataPayload.getEventType().equals("12")){
         /*  DeviceMapper deviceMapper = SpringUtils.getBean("deviceMapper");
           Device device =  getDevice(eventDataPayload);
           log.info("insert device:"+device);
           deviceMapper.insert(device);*/
            //event
        }else if(eventDataPayload.getEventType().equals("13")){
            ExpiryDeviceMap.WARN_MMP.put(eventDataPayload.getId(),json.toString());
            //alarm

        }else if(eventDataPayload.getEventType().equals("20")){
            //bind

        }
    }
    private Device getDevice(EventDataPayload eventDataPayload){
        Device device = new Device();
        device.setDeviceCode(eventDataPayload.getId());
        return  device;

    }
    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }
}
