package com.car.iot.controller;

import com.car.iot.infrastructure.service.CmdService;
import com.domain.model.EventData;
import com.domain.model.EventDataPayload;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("cmd")
public class CmdController {
    @Autowired
    CmdService cmdService;
    @PostMapping("/check")
    public void check(@RequestBody  EventDataPayload eventDataPayload){
        cmdService.check(eventDataPayload);
    }

    /**
     * 开锁命令
     * @param
     */
    @PostMapping("/open")
    public void open(@RequestBody  EventDataPayload eventDataPayload){
        cmdService.open(eventDataPayload);
     }
    /**
     * 关锁命令
     * @param
     */
    @PostMapping("/shutdown")
    public void shutdown(@RequestBody  EventDataPayload eventDataPayload){
        cmdService.shutdown(eventDataPayload);
     }
    /**
     * 停止命令
     * @param
     */
    @PostMapping("/stop")
    public void stop(@RequestBody  EventDataPayload eventDataPayload){
        cmdService.stop(eventDataPayload);
     }
}
