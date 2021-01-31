package com;

import com.netty.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.net.InetSocketAddress;

/**
 * created by  zhouzq on 2020/11/4
 * desc
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com"})
public class Main {
    public static void main(String args[]){
        SpringApplication.run(Main.class, args);
        new Thread(new Runnable() {
            @Override
            public void run() {
                NettyServer nettyServer = new NettyServer();
                nettyServer.start(new InetSocketAddress( 8004));
            }
        }).start();
    }

}
