package com.netty.client;

import com.dao.model.EventDataPayload;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

/**
 * created by  zhouzq on 2020/7/15
 * desc
 */
@Slf4j
public class NettyClient {

    public void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap()
                .group(group)
                //该参数的作用就是禁止使用Nagle算法，使用于小数据即时传输
                .option(ChannelOption.TCP_NODELAY, true)
                .channel(NioSocketChannel.class)
                .handler(new NettyClientInitializer());

        try {
            ChannelFuture future = bootstrap.connect("58.87.124.205", 8004).sync();
            log.info("客户端成功....");
            EventDataPayload eventDataPayload = new EventDataPayload();
            eventDataPayload.setEventType("12");
            eventDataPayload.setEventInfo("sdf");
            eventDataPayload.setId("123");
            //发送消息
            System.out.println(JSONObject.fromObject(eventDataPayload));
            future.channel().writeAndFlush(JSONObject.fromObject(eventDataPayload).toString());
            // 等待连接被关闭
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }
}
