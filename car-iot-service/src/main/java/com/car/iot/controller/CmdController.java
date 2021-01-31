package com.car.iot.controller;

import com.domain.model.EventDataPayload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("cmd")
public class CmdController {
    @PostMapping("/check")
    public void check(@RequestBody  EventDataPayload eventDataPayload){

    }
}
