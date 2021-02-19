package com.car.iot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者:zhouziqin
 * 时间: 2020-12-10 22:17
 */
@Configuration
@ConfigurationProperties(MqttConfiguration.PREFIX)
public class MqttConfiguration {
    /**
     * 订阅的
     */
    public final static String SUB_TOPIC = "sub_topic";
    /**
     * 发布
     */
    public final static String PUB_TOPIC = "pub_topic";
    @Autowired
    private MqttPushClient mqttPushClient;

    public static final String PREFIX = "mqtt";
    private String host;
    private String clientid;
    private String username;
    private String password;
    private String topic;
    private int timeout;
    private int keepalive;

    public String getClientid() {
        return clientid;
    }

    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getKeepalive() {
        return keepalive;
    }

    public void setKeepalive(int keepalive) {
        this.keepalive = keepalive;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    @Bean
    public MqttPushClient getMqttPushClient() {
        System.out.println("start collection ");
        mqttPushClient.connect(host, clientid, username, password, timeout, keepalive);
        mqttPushClient.subscribe(SUB_TOPIC);
        return mqttPushClient;
    }
}
