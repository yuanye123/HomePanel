## AVS语音操作类

## AvsJniApi 说明


#### tuya_avs_init
```
fun tuya_avs_init(context: Context, storePath: String, avsListener: AvsListener): Int
```

**功能说明**

avs功能初始化

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| context | 上下文 |
| storePath | 存储路径 |
| avsListener | avs相关回调，具体参考AvsListener说明 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | avs初始化成功       |
| 非0     | avs初始化失败 |


#### avs_stop
```
external fun avs_stop(): Int
```

**功能说明**

avs功能停止

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |

#### native_setMicrophoneMute
```
external fun native_setMicrophoneMute(on: Boolean): Int
```
**功能说明**

设置mic采集开关

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| on | true采集打开，false集采关闭 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |

#### native_isMicrophoneMute
```
external fun native_isMicrophoneMute(): Boolean
```

**功能说明**

获取mic采集状态

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| true   | mic打开      |
| false     | mic关闭 |

#### native_setSpeakerphoneOn
```
external fun native_setSpeakerphoneOn(on: Boolean): Int
```

**功能说明**

设置音频播放开关

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| on | true播放打开，false播放关闭 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |

#### native_isSpeakerphoneOn
```
external fun native_isSpeakerphoneOn(): Boolean
```

**功能说明**

获取音频播放状态

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| true   | 播放打开      |
| false     | 播放关闭 |


#### native_setSpeakerphoneOn
```
external fun native_setSpeakerphoneOn(on: Boolean): Int
```

**功能说明**

设置蓝牙播放状态开关

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| on | true播放打开，false播放关闭 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### native_isBluetoothOn
```
external fun native_isBluetoothOn(): Boolean
```

**功能说明**

获取蓝牙播放状态

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| true   | 播放打开      |
| false     | 播放关闭 |


#### native_setVolume
```
external fun native_setVolume(index: Int): Int
```

**功能说明**

设置音量大小

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| index | 0-100 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### native_getVolume
```
external fun native_getVolume(): Int
```
**功能说明**

获取音量大小

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0-100   | 音量值      |


#### native_wakeupToggle
```
external fun native_wakeupToggle(): Int
```
**功能说明**

唤醒模式切换

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |

#### native_playPrev
```
external fun native_playPrev(): Int
```
**功能说明**

向前播放

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### native_playNext
```
external fun native_playNext(): Int
```
**功能说明**

向后播放

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### native_feedPcm_asr
```
external fun native_feedPcm_asr(asr: ByteArray): Int
```

**功能说明**

发送音频采集数据

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| asr | 16K采样率 16bit 单通道 pcm格式 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### native_feedPcm_asr
```
external fun native_feedPcm_asr(asr: ByteArray): Int
```

**功能说明**

发送音频采集数据

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| asr | 16K采样率 16bit 单通道 pcm格式 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### native_feedPcm_silent
```
external fun native_feedPcm_silent(silent: ByteArray): Int
```

**功能说明**

发送回声消除静音数据

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| silent | 16K采样率 16bit 单通道 pcm格式 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### native_feedPcm_aec
```
external fun native_feedPcm_aec(aec: ByteArray): Int
```

**功能说明**

发送回声消除ACE数据

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| aec | 16K采样率 16bit 单通道 pcm格式 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### avs_dnd_ctrl
```
external fun avs_dnd_ctrl(open: Boolean): Int
```

**功能说明**

设置勿扰模式开关

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| open | true开/false关 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### avs_report_init_state
```
external fun avs_report_init_state(): Int
```

**功能说明**

上网联网状态

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### handleAvsServer
```
fun handleAvsServer(context: Context)
```

**功能说明**

启动avs服务

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| open | true开/false关 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### avs_set_timezone
```
external fun avs_set_timezone(timeZone: String): Int
```

**功能说明**

设置时区

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| timeZone | 时区|

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### avs_net_status_sync
```
external fun avs_net_status_sync(conn: Boolean): Int
```

**功能说明**

同步设备网络连接状态

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| conn | ture连接，false未连接|

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### avs_dnd_get
```
external fun avs_dnd_get(): Boolean
```

**功能说明**

获取免扰模式是否打开

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| true    | 打开       |
| false     | 关闭 |


#### avs_get_cloud_params
```
external fun avs_get_cloud_params(): Int
```

**功能说明**

获取云端参数接口

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### unbind
```
fun unbind(context: Context)
```

**功能说明**

设备解绑之后调用


## AvsListener 说明
#### onUIStatusChange
```
fun onUIStatusChange(status: DataEnum.TUYA_AVS_STAT_TYPE_E)
```

**功能说明**

avs处理事件回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| status | TUYA_AVS_STAT_TYPE_E事件 |


## TUYA_AVS_STAT_TYPE_E类说明

**功能说明**

avs事件

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| TUYA_AVS_STAT_TYPE_IDLE |       avs idle status     |
| TUYA_AVS_STAT_TYPE_UNBIND |     avs unbind status  |
| TUYA_AVS_STAT_TYPE_BINDED | avs binded status |
| TUYA_AVS_STAT_TYPE_BINDING | avs unbind status |
| TUYA_AVS_STAT_TYPE_LISTENING | avs listen start status |
| TUYA_AVS_STAT_TYPE_LISTEN_END | avs listen end status |
| TUYA_AVS_STAT_TYPE_THINKING | avs think start status |
| TUYA_AVS_STAT_TYPE_SPEAKING | avs speak start status |
| TUYA_AVS_STAT_TYPE_SPEAK_END | avs speak end status |
| TUYA_AVS_STAT_TYPE_MIC_ON_TO_OFF | avs mic off status |
| TUYA_AVS_STAT_TYPE_MIC_OFF_TO_ON | avs mic on status |
| TUYA_AVS_STAT_TYPE_NOTIFY | avs notification status |
| TUYA_AVS_STAT_TYPE_NOTIFY_MIC_OFF | avs notification status when mic if off |
| TUYA_AVS_STAT_TYPE_ALERT | avs alert status |
| TUYA_AVS_STAT_TYPE_NOTIFY_ALERT | avs notify & alert status |
| TUYA_AVS_STAT_TYPE_ALERT_MIC_OFF | avs alert status when mic is off |
| TUYA_AVS_STAT_TYPE_BT_SCAN | avs bt scan status |
| TUYA_AVS_STAT_TYPE_BT_SCAN_EXIT | avs bt scan exit status |
| TUYA_AVS_STAT_TYPE_BT_CONNECTED | avs bt connected status |
| TUYA_AVS_STAT_TYPE_BT_DISCONNECT | avs bt disconnect status |
| TUYA_AVS_STAT_TYPE_ALERT_NOTIFY | avs alert & notify status |
| TUYA_AVS_STAT_TYPE_MUSIC_START | avs music start status |
| TUYA_AVS_STAT_TYPE_MUSIC_STOP | avs music stop status |
| TUYA_AVS_STAT_TYPE_VOLUME_CHG | avs volume change status |
| TUYA_AVS_STAT_TYPE_MUSIC_START | avs music start status |
| TUYA_AVS_STAT_TYPE_DISTRUB | avs distrub status |
| TUYA_AVS_STAT_TYPE_BOOTUP | avs bootup status |
| TUYA_AVS_STAT_TYPE_SYSTEM_ERROR | avs system error status |
| TUYA_AVS_STAT_TYPE_SERVICE_ERROR | avs service error status |
| TUYA_AVS_STAT_TYPE_NETWORK_ERROR | avs network error status |
| TUYA_AVS_STAT_TYPE_TIMEZONE_CHG | avs time zone change status |