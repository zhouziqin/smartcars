package com.car.iot.config;
import com.car.iot.infrastructure.service.CmdService;
import com.domain.model.EventData;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 作者:zhouziqin
 * 时间: 2020-12-10 23:11
 */
@Component
public class MqttDispatcher {

    CmdService cmdService;
     /**
     * 这里执行业务
     * @param data
     */
    public void execute(String topic,String data){
        System.out.println("topic:"+topic + ",data:"+data);
        try{
           JSONObject jsonObject =  JSONObject.fromObject(data);
            String type  =jsonObject.getString("type");
            String backup  =jsonObject.getString("backup");
            String time  =jsonObject.getString("time");
            JSONObject dataJson =null;
            EventData eventData= null;
            JSONArray dataArray = null;
            List<EventData> eventDataList = null;
            if(type.equals("002")){
                dataArray = jsonObject.getJSONArray("data");
                eventDataList = JSONArray.toList(dataArray,new EventData(),new JsonConfig());
            }else{
                dataJson =jsonObject.getJSONObject("data");
                eventData= (EventData) JSONObject.toBean(dataJson, EventData.class);
            }


            if(type.equals("001")){
                cmdService.upCarStatusChange(eventData,jsonObject);
              }else if(type.equals("002")){
                cmdService.upAllCarStatusChange(eventDataList,jsonObject);
               }else if(type.equals("003")){
                cmdService.upErrorMsg(eventData,jsonObject);
               } else if(type.equals("008")){
                cmdService.plateInfo(eventData,jsonObject);

               }else if(type.equals("009")){
                cmdService.ctrlRe(eventData,jsonObject);

               }
     }catch (Exception e){}
        System.out.println(data);

     /*   JSONObject jsonObject =  JSONObject.fromObject(data);

       String type = jsonObject.get("type").toString();
       if(type.equals("001")){

       }*/

    }
    public void initData(){

    }

}
