package com.common;
import io.netty.channel.ChannelHandlerContext;

/**
 * created by  zhouzq on 2020/7/24
 * desc
 */
public class ExpiryDeviceMap {
    public static ExpiryMap<String,String> ACTIVE_MAP = new ExpiryMap();
    public static ExpiryMap<String,ChannelHandlerContext> CHANNEL_MAP = new ExpiryMap();
    public static ExpiryMap<String,String> WARN_MMP = new ExpiryMap();
    public static int socketTimeOut = 300 ; //秒
    public static int socketChannelMapTimeOut = 300000 ; //毫秒
    //超过1分钟认为没有消息投递
    public static int defalue_expire = 60000; //毫秒
    public static String getValue(String key){
        String value = ACTIVE_MAP.get(key);
        return value;
    }
    /**
     *
     * @param key
     * @param value
     */
    public static void pushValue(String key ,String value){
        ACTIVE_MAP.put(key,value,defalue_expire);
    }
}
