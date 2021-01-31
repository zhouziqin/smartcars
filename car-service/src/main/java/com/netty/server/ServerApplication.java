package com.netty.server;

import java.net.InetSocketAddress;

/**
 * created by  zhouzq on 2020/7/15
 * desc
 */
public class ServerApplication {
    public static void main(String[] args) {
         //启动服务端
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));
    }
}
