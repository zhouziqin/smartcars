package com.domain.model;
import net.sf.json.JSONObject;

 import lombok.Data;

import javax.persistence.*;

/**
 * 事件消息
 *
 */
@Data
public class EventDataPayload {

     String type;
     CmdBean data;
     String backup;
     Long time;

}
