package com.car.iot.infrastructure.service;

import com.car.iot.config.MqttConfiguration;
import com.car.iot.config.MqttPushClient;
import com.domain.model.CarLogBean;
import com.domain.model.CarPortBean;
import com.domain.model.EventData;
import com.domain.model.EventDataPayload;
import com.mapper.CarLogMapper;
import com.mapper.CarPortMapper;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * cmdType :'1.控制，2.反馈,3上报'
 */
@Component
public class CmdService {
    @Autowired
    CarPortMapper carportMapper;
    @Autowired
    CarLogMapper carLogMapper;
    @Autowired
    MqttPushClient mqttPushClient;
    /**
     * 车位状态变化上报
     * @param eventData
     */
    public void upCarStatusChange(EventData eventData,JSONObject jsonObject){
        saveCarPoart(eventData,jsonObject);
    }
    public void saveCarPoart(EventData eventData,JSONObject jsonObject){
        CarPortBean carPortBean = new CarPortBean();
        carPortBean.setPortCode(eventData.getPortCode());
        carPortBean =  carportMapper.selectOne(carPortBean);
        BeanUtils.copyProperties(eventData,carPortBean);
        if(carPortBean.getId()!=null && carPortBean.getId()!=0){
            carportMapper.updateByPrimaryKeySelective(carPortBean);
        }else{
            carportMapper.insert(carPortBean);
        }
        saveCarLog(eventData,"2",jsonObject);
    }
    public void saveCarLog(EventData data,String cmdType,JSONObject jsonObject){
        CarLogBean carLogBean = new CarLogBean();
        BeanUtils.copyProperties(data,carLogBean);
        carLogBean.setData(JSONObject.fromObject(data).toString());
        carLogBean.setCmdype(cmdType);
        carLogBean.setCtrlType(jsonObject.getString("type"));
        carLogMapper.insert(carLogBean);

    }

    /**
     * 获取整个车厂车位状态（check命令反馈）
     * @param eventDataList
     */
    public void upAllCarStatusChange(List<EventData> eventDataList,JSONObject jsonObject){
        eventDataList.stream().forEach(eventData -> {
            saveCarPoart(eventData,jsonObject);
        });
    }
    /**
     * 摄像头图片上报(oss文件系统接口)
     * @param eventData
     */
    public void upCarmeraPic(EventData eventData,JSONObject jsonObject){

    }

    /**
     * 故障信息上报
     * @param eventData
     */
    public void upErrorMsg(EventData eventData,JSONObject jsonObject){
        CarPortBean carPortBean = new CarPortBean();
        carPortBean.setPortCode(eventData.getPortCode());
        carPortBean =  carportMapper.selectOne(carPortBean);
        carPortBean.setPortStatus(eventData.getPortStatus());
        carPortBean.setErrorCode(eventData.getErrorCode());
        carportMapper.updateByPrimaryKeySelective(carPortBean);
        saveCarLog(eventData,"3",  jsonObject);


    }
    public void saveCarLog( EventDataPayload eventDataPayload,String cmdType){
        CarLogBean carLogBean = new CarLogBean();
        carLogBean.setCmdId(eventDataPayload.getData().getCmdId());
        carLogBean.setPortCode(eventDataPayload.getData().getPortCode());
        carLogBean.setCmdype(cmdType);
        carLogBean.setCtrlType(eventDataPayload.getType());
        carLogBean.setData(JSONObject.fromObject(eventDataPayload).toString());
        carLogMapper.insert(carLogBean);

    }
    /**
     * Check命令
     * @param
     */
    public void check( EventDataPayload eventDataPayload){
        mqttPushClient.publish(MqttConfiguration.SUB_TOPIC,eventDataPayload);
        saveCarLog(eventDataPayload,"1");
    }
    /**
     * 开锁命令
     * @param
     */
    public void open( EventDataPayload eventDataPayload){
        mqttPushClient.publish(MqttConfiguration.SUB_TOPIC,eventDataPayload);
        saveCarLog(eventDataPayload,"1");
    }
    /**
     * 关锁命令
     * @param
     */
    public void shutdown( EventDataPayload eventDataPayload){
        mqttPushClient.publish(MqttConfiguration.SUB_TOPIC,eventDataPayload);
        saveCarLog(eventDataPayload,"1");
    }
    /**
     * 停止命令
     * @param
     */
    public void stop( EventDataPayload eventDataPayload){
        mqttPushClient.publish(MqttConfiguration.SUB_TOPIC,eventDataPayload);

        saveCarLog(eventDataPayload,"1");
    }
    /**
     * 用户牌照信息（摄像头、预定等）
     * @param eventData
     */
    public void plateInfo(EventData eventData,JSONObject jsonObject){

    }

    /**
     * 009控制反馈  设备状态devStatus：开、关、异常、停止（01、02、03、04）
     * @param eventData
     */
    public void ctrlRe(EventData eventData,JSONObject jsonObject){
        CarLogBean carLogBean = new CarLogBean();
        carLogBean.setCmdId(eventData.getCmdId());
        carLogBean.setCmdype("1");
        carLogBean =   carLogMapper.selectOne(carLogBean);
        //车位
        CarPortBean carPortBean = new CarPortBean();
        carPortBean.setPortCode(carLogBean.getPortCode());
        carPortBean = carportMapper.selectOne(carPortBean);

        if(eventData.getCmdResult().equals("执行中")){

        }else if(eventData.getCmdResult().equals("已完成") && carLogBean.getCtrlType().equals("005")){  //开
            carPortBean.setDevStatus("01");
        }else if(eventData.getCmdResult().equals("已完成") && carLogBean.getCtrlType().equals("006")){  //关
            carPortBean.setDevStatus("02");
        }
        else if(eventData.getCmdResult().equals("已完成") && carLogBean.getCtrlType().equals("007")){  //停止
            carPortBean.setDevStatus("04");
        }
        else if(eventData.getCmdResult().equals("执行失败")){
            carPortBean.setDevStatus("03");
        }
        carportMapper.updateByPrimaryKeySelective(carPortBean);

       saveCarLog(eventData,"2",jsonObject);


    }

}
