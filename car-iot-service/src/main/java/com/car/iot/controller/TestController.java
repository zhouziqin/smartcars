package com.car.iot.controller;

 import com.car.iot.config.MqttPushClient;
 import com.car.iot.infrastructure.service.TestService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @Autowired
    TestService testService;
    @GetMapping("/test")
    public void testController(){
        System.out.print("test");
        testService.test();

    }
    @Autowired
    MqttPushClient mqttPushClient;
    @GetMapping("/test2")

    public String testController2(String msg){
        System.out.print("123123");
        mqttPushClient.publish("testtopic",msg);
        testService.test();
        return "";
    }
}
