package com.car.controller;

import com.car.infrastructure.service.TestService;
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
}
