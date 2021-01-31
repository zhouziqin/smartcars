package com.car.iot.config;
import com.domain.model.EventData;
import com.domain.model.EventDataPayload;
import com.mapper.EventDataPayloadMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 作者:zhouziqin
 * 时间: 2020-12-10 23:11
 */
@Component
public class MqttDispatcher {
    @Autowired
    EventDataPayloadMapper eventDataPayloadMapper;
    @Autowired
    MqttPushClient mqttPushClient;
    private static String topic = "";
    /**
     * 这里执行业务
     * @param data
     */
    public void execute(String topic,String data){
        //JSONObject jsonObject;
        try{
           JSONObject jsonObject =  JSONObject.fromObject(data);
           JSONObject dataJson =jsonObject.getJSONObject("data");
           String type  =jsonObject.getString("type");
           String backup  =jsonObject.getString("backup");
           String time  =jsonObject.getString("time");
            EventDataPayload eventDataPayLoad = (EventDataPayload) JSONObject.toBean(jsonObject,EventDataPayload.class);
           EventData eventData= (EventData) JSONObject.toBean(dataJson, EventData.class);
            eventDataPayloadMapper.insert(eventDataPayLoad);

       if(type.equals("001")){
           mqttPushClient.publish(topic,"test");
       }else if(type.equals("002")){

       }else if(type.equals("003")){

       }else if(type.equals("004")){

       }else if(type.equals("005")){

       }else if(type.equals("006")){

       }else if(type.equals("007")){

       }else if(type.equals("008")){

       }else if(type.equals("009")){

       }else if(type.equals("010")){

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
