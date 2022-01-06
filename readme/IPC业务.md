## IPC操作类

## IpcJniApi 说明

#### ipc_service_event_subscribe
```
external fun ipc_service_event_subscribe(): Int
```

**功能说明**

ipc事件监听

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### putVideoData
```
external fun putVideoData(isIFrame: Int, data: ByteArray): Int
```

**功能说明**

发送编码之后的视频数据


**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| isIFrame | 1 I帧,  0 P帧B帧 |
| data | 编码数据 |


**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### putAudioData
```
external fun putAudioData(data: ByteArray): Int
```

**功能说明**

发送音频数据 pcm格式


**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| data | 编码数据 |


**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### ipc_p2p_create
```
fun ipc_p2p_create(ipcListener: IpcListener): Int
```

**功能说明**

创建p2p通道

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| ipcListener | ipc相关回调 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_ring_buffer_create
```
external fun ipc_ring_buffer_create(): Int
```

**功能说明**

初始化通道信息

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### ipc_p2p_destroy
```
external fun ipc_p2p_destroy(): Int
```

**功能说明**

销毁通道

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### sendDoorBellSnap
```
external fun sendDoorBellSnap(data: ByteArray, snapType: Int): Int
```

**功能说明**

门铃按下时进行呼叫. 此时呼叫界面显示为附带的图片

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| data | 发送呼叫时需要附带一张图片 |
| snapType | {@link Common.NOTIFICATION_CONTENT_TYPE_E} |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### sendDoorBellCallForPress
```
external fun sendDoorBellCallForPress(data: ByteArray, snapType: Int): Int
```

**功能说明**

当门铃按下时device端发送门铃呼叫到App端和云端. 此时呼叫界面显示为本地视频画面

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| data | 发送呼叫时需要附带一张图片 |
| snapType | {@link Common.NOTIFICATION_CONTENT_TYPE_E} |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### ipc_notify_with_event
```
external fun ipc_notify_with_event(notifyType: Int, picData: ByteArray?, picType: Int): Int
```

**功能说明**

上报门铃事件到涂鸦云端和App端

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| notifyType | 门铃事件的类型 [Common.DOORBELL_NOTIFICATION_TYPE] |
| picData | 上报事件附带的图片数据 |
| picType | 图片数据格式 [Common.NOTIFICATION_CONTENT_TYPE_E] |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### sendMotionAlarmSnap
```
external fun sendMotionAlarmSnap(data: ByteArray?, snapType: Int): Int
```

**功能说明**

当报警时间发生时，发送报警图片到App端

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| data | 报警图片字节流 |
| snapType | 图片格式的类型 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_cloud_storage_init
```
external fun ipc_cloud_storage_init(): Int
```

**功能说明**

开始云存储功能. 该方法调用之后(以购买购买云存储)，设备具有云储存相关功能

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_cloud_storage_init
```
external fun ipc_cloud_storage_init(): Int
```

**功能说明**

开始云存储功能反初始化




#### ipc_cloud_storage_pause
```
external fun ipc_cloud_storage_pause()
```

**功能说明**

暂停云存储. 该方法调用后，云存储暂停，通过{@link IMediaTransManager#resumeCloudStorage()} 方法恢复云存储




#### ipc_cloud_storage_resume
```
 external fun ipc_cloud_storage_resume()
```

**功能说明**

恢复云存储.


#### ipcCloudStorageGetStoreMode
```
fun ipcCloudStorageGetStoreMode(): IPCEnum.ClOUD_STORAGE_TYPE_E
```

**功能说明**

获取云存储订单类型

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| IPCEnum.ClOUD_STORAGE_TYPE_E  |  {@link IPCEnum.ClOUD_STORAGE_TYPE_E}    |




#### ipcCloudStorageGetEventStatus
```
fun ipcCloudStorageGetEventStatus(type: IPCEnum.ClOUD_STORAGE_EVENT_TYPE_E): IPCEnum.EVENT_STATUS_E
```

**功能说明**

获取事件状态

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| IPCEnum.EVENT_STATUS_E  |  {@link IPCEnum.EVENT_STATUS_E}    |





#### ipc_ss_init
```
external fun ipc_ss_init(maxDay: Int, path: String): Int
```

**功能说明**

本地存储初始化

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| maxDay | 存储最大天数 |
| path | 存储路径 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_ss_uninit
```
external fun ipc_ss_uninit()
```

**功能说明**

本地存储反初始化




#### ipc_ss_set_write_mode
```
fun ipc_ss_set_write_mode(mode: IPCEnum.STREAM_STORAGE_WRITE_MODE_E): Int
```

**功能说明**

设置本地存储的数据类型

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| mode | IPCEnum.STREAM_STORAGE_WRITE_MODE_E |


**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_ss_start_event
```
external fun ipc_ss_start_event(): Int
```

**功能说明**
开始本地存储

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### ipc_ss_start_event
```
external fun ipc_ss_start_event(): Int
```

**功能说明**
停止本地存储

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_ss_clear
```
external fun ipc_ss_clear()
```

**功能说明**
清空sd


#### ipc_motion_init
```
external fun ipc_motion_init(
        frame_w: Int,
        frame_h: Int,
        sensitivity: Int,
        y_thd: Int,
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        tracking_enable: Int
    )
```

**功能说明**

初始化探测资源

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| frame_w | 帧宽 |
| frame_h | 帧高 |
| y_thd | y轴深度 |
| x | x轴坐标 |
| y | y轴坐标 |
| width | 宽 |
| height | 高 |
| tracking_enable | 轨迹使能 |



#### ipc_motion_release
```
external fun ipc_motion_release()
```

**功能说明**
探测资源释放


#### ipc_set_motion
```
external fun ipc_set_motion(frame_w: Int, frame_h: Int): Int
```

**功能说明**
设置运动状态

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| frame_w | 帧宽 |
| frame_h | 帧高 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### ipc_set_threshold
```
external fun ipc_set_threshold(threshold: Int): Int
```

**功能说明**
设置threshold

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| threshold | threshold数 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_set_sensitivity
```
external fun ipc_set_sensitivity(sensitivity: Int): Int
```

**功能说明**
设置sensitivity级别

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| sensitivity | sensitivity级别 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |


#### ipc_set_motion_region
```
external fun ipc_set_motion_region(x: Int, y: Int, w: Int, h: Int): Int
```

**功能说明**
设置探测边界

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| x | x轴坐标 |
| y | y轴坐标 |
| w | 宽 |
| h | 高 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



#### ipc_trans_motion
```
external fun ipc_trans_motion(pixelData: ByteBuffer, motionResult: IntArray): Int
```

**功能说明**
移动侦测

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| pixelData | 需要侦测的图像数据， 必须为YUV 格式 |
| motionResult | 移动侦测的返回结果 motionResult[0]: 侦测是否有结果(1: 有结果 0: 无结果) (motionResult[1]:motionResult[2]) 侦测结果的坐标 |

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| 0    | 成功       |
| 非0     | 失败 |



## IpcListener说明

**功能说明**
ipc相关回调类

#### audioCallBack
```
fun audioCallBack(
        audio_codec: IPCEnum.TUYA_CODEC_ID,
        audio_sample: IPCEnum.TUYA_AUDIO_SAMPLE_E,
        audio_databits: IPCEnum.TUYA_AUDIO_DATABITS_E,
        audio_channel: IPCEnum.TUYA_AUDIO_CHANNEL_E,
        data: ByteArray,
        buf_len: Int,
        pts: Int,
        timeStamp: Int
    )
```

**功能说明**
音频接收回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| audio_codec | 音频编码类型 |
| audio_sample | 音频采样率 |
| audio_databits | 音频位数 |
| audio_channel | 音频通道数 |
| data | 音频数据 |
| buf_len | 音量数据长度 |
| pts | 显示时间戳 |
| timeStamp | 时间戳 |


#### videoCallBack

```
fun videoCallBack(
        video_codec: IPCEnum.TUYA_CODEC_ID,
        video_frame_type: IPCEnum.MEIDA_RECV_VIDEO_FRAME_TYPE_E,
        data: ByteArray,
        len: Int,
        pts: Int,
        timeStamp: Int
    )
```

**功能说明**
视频接收回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| video_codec | 视频编码类型 |
| video_frame_type | 视频帧类型 |
| data | 视频数据 |
| len | 视频数据长度 |
| pts | 显示时间戳 |
| timeStamp | 时间戳 |


#### snapshotCallBack
```
fun snapshotCallBack(data: ByteArray)
```

**功能说明**
截图数据回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| data | 截图数据 |


#### onDoorBellCallStatus
```
fun onDoorBellCallStatus(status: Int)
```

**功能说明**
门铃时间回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| status | 0 接收  1 开始   2 结束 |


#### ssSdStatusChangeCallback
```
fun ssSdStatusChangeCallback(status: Int)
```

**功能说明**
本地存储状态回调

**参数说明**

| 参数名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| status | 0 未挂载  1 已挂载 |


#### SDCardRemount
```
fun SDCardRemount()
```

**功能说明**
重新挂载SDCard



#### SDCardGetStatus
```
fun SDCardGetStatus(): IPCEnum.E_SD_STATUS
```

**功能说明**
SDK获取SDCard [SDStatus]

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| IPCEnum.E_SD_STATUS    | sd挂载状态       |


#### SDCardGetCapacity
```
fun SDCardGetCapacity(): SDVolumeInfo
```

**功能说明**
获取SDCard容量

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| SDVolumeInfo   |  挂载容量实体类  |


#### SDCardMountPath
```
fun SDCardMountPath(): String
```

**功能说明**
获取SDCard路径

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| string   |  获取挂载路径  |


#### GetModeConfig
```
fun GetModeConfig(): IPCEnum.STREAM_STORAGE_WRITE_MODE_E
```

**功能说明**
SD卡文件录入的方式

**返回值**

| **返回值** | **说明**       |
| ---------- | -------------- |
| status   |  文件录入方式  |