package com.controller;

import com.common.ExpiryDeviceMap;
import com.common.JsonResult;
import com.controller.vo.BindPlateNo;
import com.dao.model.EventDataPayload;
import com.service.DeviceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * created by  zhouzq on 2020/7/10
 * desc
 */
@Controller
@Slf4j
@RequestMapping("/event")
public class EventController {

    @Autowired
    DeviceImpl deviceImpl;
    @GetMapping("/test")
    public @ResponseBody String get(){
        return "123";
    }
    @PostMapping("/push")
    @ApiOperation(value = "推送消息")
    public @ResponseBody
    JsonResult pushEvent(EventDataPayload payload){
        log.info(payload.toString());
        return JsonResult.success();
    }
    @GetMapping("/getWarnDevice")
    @ApiOperation(value = "获取故障机器")
    public @ResponseBody JsonResult getWarnDevice(String deviceCoe){
        if(StringUtils.isEmpty(deviceCoe)){
            return JsonResult.success(  JSONObject.fromObject(ExpiryDeviceMap.WARN_MMP ));
        }else{
            return JsonResult.success(  ExpiryDeviceMap.WARN_MMP.get(deviceCoe));

        }
    }
    @GetMapping("/getActive")
    @ApiOperation(value = "获取活跃的机器")
    public @ResponseBody JsonResult getActiveDevice(String deviceCoe){
        if(StringUtils.isEmpty(deviceCoe)){
            return JsonResult.success(  JSONObject.fromObject(ExpiryDeviceMap.ACTIVE_MAP ));
        }else{
            return JsonResult.success(  ExpiryDeviceMap.ACTIVE_MAP.get(deviceCoe));
        }

    }

    @ApiOperation(value = "绑定设备")
    @GetMapping("/bindPlatNo")
    public @ResponseBody JsonResult bindPlatNo(BindPlateNo bindPlateNo){
        log.info("绑定设备:"+bindPlateNo.getId()+","+bindPlateNo.getPlateNoList());
        deviceImpl.bindPlatNo(bindPlateNo.getId(),bindPlateNo.getPlateNoList());
        return JsonResult.success();
    }
    @ApiOperation(value = "接受日志")
    @PostMapping("/log")
    public @ResponseBody JsonResult log(String info){
        log.info("日志:"+info);
        return JsonResult.success();
    }
}
