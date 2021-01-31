package com.domain.VO;

/**
 *
 * 车位编码portCode：节点控制器-节点号（001-001）
 车位状态portStatus：空闲、占用、异常（01、02、03）
 车牌号plateNo：车牌号（A12345）
 设备状态devStatus：开、关、异常、停止（01、02、03、04）
 设备错误代码errorCode：未知异常（0001）
 设备类型的devType：吊杆、摄像头、超声波、节点控制器、滑杆、地锁、电池(01、02、03、04、05)
 图片地址picUrl：http：xxxxxxxxx
 故障代码ErrorCode：（设备类型+故障代码）摄像头、吊杆、超声波、节点控制器(0101、0201、0301、0401)
 命令ID cmdId：车场号+车位编码+时间戳（001-001-001-XXXXXXX）
 预约时间段orderTime;分钟
 执行结果result：执行中、已完成、执行失败（01、02、03）
 使用类型useType：个人，商用（01、02）

 */
/**
 * 作者:zhouziqin
 * 时间: 2020-12-10 22:01
 */
public class BaseVO {
   private String type;
   private BaseDataVO data;
   private String backup;
   private String time;
}
