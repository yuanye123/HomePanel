## Zigbee操作类

## ZigbeeJniApi 说明

#### iot_reg_gw_mgr_cb
```
fun iot_reg_gw_mgr_cb(dep_tp: Int, devMgrLsitener: ZigbeeListener.DevMgrListener): Int
```

**功能说明**

设置设备zigbee状态回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| dep_tp | dp Tp |
| devMgrLsitener | zigbee回调 |

**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 0 | 成功 |
| 非0 | 失败 |



#### zigbee_svc_init
```
fun zigbee_svc_init(zigbeeModel: ZigbeeModel): Int
```

**功能说明**

zigbee业务初始化

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| zigbeeModel | zigbee信息模型 |

**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 0 | 成功 |
| 非0 | 失败 |


#### zigbee_svc_start
```
fun zigbee_svc_start(zigbeeModel: ZigbeeModel): Int
```

**功能说明**

zigbee业务启动

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| zigbeeModel | zigbee信息模型 |

**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 0 | 成功 |
| 非0 | 失败 |


#### ziggbe_send_data
```
fun ziggbe_send_data(zigbeeZ3ApsFrameMode: ZigbeeZ3ApsFrameMode): Int
```

**功能说明**

zigbee发送数据

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| zigbeeZ3ApsFrameMode | apsFrameMod信息模型 |

**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 0 | 成功 |
| 非0 | 失败 |


#### ziggbe_del_dev
```
external fun ziggbe_del_dev(dip: String): Int
```

**功能说明**

zigbee下删除子设备

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| dip | 子设备id |

**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 0 | 成功 |
| 非0 | 失败 |


#### zigbee_set_tx_radio_power
```
external fun zigbee_set_tx_radio_power(tx_power: Int): Int
```

**功能说明**

设置zigbee的tx_radio值

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| tx_power | values are between -70 and 20 |

**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 0 | 成功 |
| 非0 | 失败 |



#### zigbee_get_ncp_ver
```
external fun zigbee_get_ncp_ver():String
```

**功能说明**

获取zigbee版本号


**返回值**

| 返回值 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| string | 版本号 |


## DevMgrListener回调


#### devDelCallBack
```
fun devDelCallBack(devId: String, type: Int)
```

**功能说明**

子设备删除回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| devId | 设备Id |
| type | 设备类型 |


#### devBindCallBack
```
fun devBindCallBack(devId: String, opRet: Int)
```

**功能说明**

子设备绑定回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| devId | 设备Id |
| opRet | 操作类型 |


#### devHbCallBack
```
fun devHbCallBack(devId: String)
```

**功能说明**

删除hb回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| devId | 设备Id |



#### devUpgardeCallBack
```
fun devUpgardeCallBack(devId: String, fw: FwModel)
```

**功能说明**

子设备升级回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| devId | 设备Id |
| fw | FwMdeol |



#### devResetCallBack
```
fun devResetCallBack(devId: String, type: Int)
```

**功能说明**

子设备重置回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| devId | 设备Id |
| type | 设备类型 |


## TyZ3DevListener 回调
#### z3Join
```
fun z3Join(zigbeeZ3DESCMode: ZigbeeZ3DESCMode)
```

**功能说明**

设备加入 ZigBee 网络回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| zigbeeZ3DESCMode | ZigbeeZ3DESCMode类型 |


#### z3_leave
```
fun z3_leave(dip: String)
```

**功能说明**

设备本地离开 ZigBee 网络回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| dip | 设备Id |


#### z3_report
```
fun z3_report(zigbeeZ3ApsFrameMode: ZigbeeZ3ApsFrameMode)
```

**功能说明**

设备 ZCL 数据上报回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| zigbeeZ3ApsFrameMode | ZigbeeZ3ApsFrameMode |


#### z3_notify
```
fun z3_notify()
```

**功能说明**

Zigbee 模组启动完成通知回调


#### z3_upgrade_end
```
fun z3_upgrade_end(dip: String, rc: Int, version: Int)
```

**功能说明**

设备升级完成通知回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| dip | dip |
| rc | rc |
| version | 版本号 |