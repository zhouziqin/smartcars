package com.netty.client;

/**
 * created by  zhouzq on 2020/7/15
 * desc
 */

public class ClientApplication {

    public static void main(String[] args) {
         //启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start();
    }
}
