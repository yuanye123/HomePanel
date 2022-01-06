package com.tuya.myapplication;

import android.Manifest;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.tuya.api.BtJniApi;
import com.tuya.api.GwJniApi;
import com.tuya.api.HomeJniApi;
import com.tuya.api.IotJniApi;
import com.tuya.api.LogJniApi;
import com.tuya.listener.GwListener;
import com.tuya.listener.HomeListener;
import com.tuya.listener.IotListener;
import com.tuya.model.CtrlDevDpBean;
import com.tuya.model.DPEvent;
import com.tuya.model.DataEnum;
import com.tuya.model.DevAbilityRuleBean;
import com.tuya.model.DevBriefInfo;
import com.tuya.model.GwProdInfoBean;
import com.tuya.model.HomeCtrlDevBriefBean;
import com.tuya.model.UserModel;
import com.tuya.model.WfGwProdInfoBean;

import java.io.File;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Enumeration;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private final int PERMISSION_CODE = 123;

    //根据项目自行配置
    private final static String pid = "";
    private final static String uid = "";
    private final static String key = "";

    private String[] requiredPermissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.BLUETOOTH};

    //sdk存储路径
    private String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        path = getFilesDir().getPath();
        if (!EasyPermissions.hasPermissions(this, requiredPermissions)) {
            EasyPermissions.requestPermissions(this, "需要授予权限以使用设备", PERMISSION_CODE, requiredPermissions);
        } else {
            initSDK();
        }
    }

    private void initSDK() {
        LogJniApi.INSTANCE.setLogListener(new LogJniApi.LogListener() {
            @Override
            public void logCallBack(String msg) {

            }
        });

        LogJniApi.INSTANCE.init();

        Log.d(TAG, "sdk version is " + IotJniApi.INSTANCE.iot_get_sdk_info());

        int ret;
        if (BtJniApi.INSTANCE.get_ty_bt_mod() == 1) {
            ret = BtJniApi.INSTANCE.adapt_reg_bt_intf();
            Log.d(TAG, "adapt_reg_bt_intf ++1111+++++++++++" + ret);
        }

        ret = IotJniApi.INSTANCE.intf_init();
        Log.d(TAG, "intf_init ret ++++++++++++++" + ret);

        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }
        ret = IotJniApi.INSTANCE.iot_init(path);
        Log.d(TAG, "iot ret ++++++++++++++" + ret);

        if (ret != 0) {
            Log.d(TAG, "IotJniApi.INSTANCE.iot_init error is " + ret);
            return;
        }

        IotJniApi.INSTANCE.iot_sdk_mqc_prot_reg(new IotListener.IotMqProtListener() {
            @Override
            public void iotMqPortCallbackWith903(String parString) {
                Log.d(TAG, "iotMqPortCallbackWith903 is " + parString);
            }

            @Override
            public void iotMqPortCallbackWith401(String parString) {
                Log.d(TAG, "iotMqPortCallbackWith401 is " + parString);
            }

            @Override
            public void iotMqPortCallbackWith2(String parString) {
                Log.d(TAG, "iotMqPortCallbackWith2 is " + parString);
            }
        });

        //设置日志等级
        LogJniApi.INSTANCE.setLogLevel(4);

        if (IotJniApi.INSTANCE.get_wifi_gw() == 1) {
            //无限配网
            ret = IotJniApi.INSTANCE.iot_set_wf_gw_prod_info(new WfGwProdInfoBean(uid, key, "", ""));
        } else {
            //有线配网
            ret = IotJniApi.INSTANCE.iot_set_gw_prod_info(new GwProdInfoBean(uid, key));
        }
        if (ret != 0) {
            Log.d(TAG, "IotJniApi.INSTANCE.iot_set_gw_prod_info error is " + ret);
            return;
        }

        IotJniApi.INSTANCE.iot_app_cbs_init(() -> "localPath");

        IotJniApi.INSTANCE.iot_enable_blemesh_compatible();

        ret = GwJniApi.INSTANCE.iot_sdk_pre_init();
        if (ret != 0) {
            Log.d(TAG, "IotJniApi.INSTANCE.iot_sdk_pre_init error is " + ret);
            return;
        }

        HomeJniApi.INSTANCE.initHomeEx(path, 32, 32, new HomeListener.HomeControlAllInfoSyncListener() {
            @Override
            public void homeControlAllInfoSync(DataEnum.TY_INFO_SYNC_TP_E sync) {
                //同步事件更新，需要重新获取列表
                if (sync == DataEnum.TY_INFO_SYNC_TP_E.TY_SYNC_TP_SCENE) {

                }
            }
        });

        HomeJniApi.INSTANCE.homeCtrlSubscribeDevOnline(new HomeListener.HomeCtrlDevOnlineListener() {
            @Override
            public void homeCtrlSubscribeDevOnline(String devId, boolean status) {
                Log.d(TAG, "homeCtrlSubscribeDevOnline devId is " + devId + " status is " + status);
            }
        });


        HomeJniApi.INSTANCE.homeCtrlSubscribeDevShortCut(new HomeListener.HomeCtrlDevShortcutListener() {
            @Override
            public void homeCtrlDevShortcut(String devId, int dpType, Object dpValue) {
                Log.d(TAG, "homeCtrlDevShortcut devId is " + devId + " dpType is " + dpType);
            }
        });

        HomeJniApi.INSTANCE.homeCtrlSubscribeDpNameUpdate(new HomeListener.HomeCtrlSubscribeDpNameListener() {
            @Override
            public void homeCtrlSubscribeDpName(String devId, String dpCode, String dpName) {

            }
        });

        ret = GwJniApi.INSTANCE.user_svc_init(new GwListener.GwInfraListener() {
            @Override
            public boolean isOffline() {
                return false;
            }

            @Override
            public String onGetIP() {
                //返回当前设备的ip
                NetworkInfo info = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                if (info != null && info.isConnected()) {
                    if (info.getType() == ConnectivityManager.TYPE_ETHERNET) {
                        // 以太网络
                        return getLocalIp();
                    } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                        //  无线网络
                        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        if (wifiManager != null) {
                            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                            String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());
                            return ipAddress;
                        }
                    }
                }
                return "0.0.0.0";
            }

            @Override
            public void upgradeFileDownloadFinished(boolean success) {

            }

            @Override
            public void onUpgradeDownloadUpdate(int progress) {

            }

            @Override
            public void onUpgradeDownloadStart() {

            }

            @Override
            public void onUpgradeInfo(String version) {
                Log.d(TAG, "onUpgradeInfo ++++++ type is " + version);
            }

            @Override
            public void gwActiveStatusCallBack(DataEnum.GW_STATUS_E status) {
                Log.d(TAG, "gwActiveStatusCallBack ++++++ type is " + status);
            }

            @Override
            public void gwResetCallBack(DataEnum.GW_RESET_TYPE_E type) {
                Log.d(TAG, "gwResetCallBack ++++++ type is " + type.getValue());
                System.exit(0);
            }

            @Override
            public void gwRebootCallBack() {
                Log.d(TAG, "gwRebootCallBack ++++++");
            }

            @Override
            public void gwActiveUrlCallBack(String url) {
                Log.d(TAG, "gwActiveUrlCallBack ++++++ url is " + url);
            }
        });
        if (ret != 0) {
            Log.d(TAG, "IotJniApi.INSTANCE.user_svc_init error is " + ret);
            return;
        }

        UserModel[] userModels = {new UserModel(1, "1")};
        GwJniApi.INSTANCE.gen_gw_attr(Arrays.asList(userModels));

//        //如果是中控设备需要用到
//        GwJniApi.INSTANCE.oem_set();

        if (IotJniApi.INSTANCE.get_wifi_gw() == 1) {
            if (GwJniApi.INSTANCE.gw_supprot_wired_wifi() == 1) {
                ret = GwJniApi.INSTANCE.iot_wired_wf_sdk_init(DataEnum.IOT_GW_NET_TYPE_T.IOT_GW_NET_WIRED_WIFI, DataEnum.GW_WF_CFG_MTHD_SEL.GWCM_OLD, DataEnum.GW_WF_START_MODE.WF_START_AP_ONLY, pid, "1.0.0");
                if (ret != 0) {
                    Log.d(TAG, "GwJniApi.INSTANCE.iot_wired_wf_sdk_init error is " + ret);
                    return;
                }
            } else {
                ret = GwJniApi.INSTANCE.iot_wf_sdk_init(DataEnum.GW_WF_CFG_MTHD_SEL.GWCM_SPCL_MODE, DataEnum.GW_WF_START_MODE.WF_START_AP_ONLY, pid, "1.0.0");
                if (ret != 0) {
                    Log.d(TAG, "GwJniApi.INSTANCE.iot_wf_sdk_init error is " + ret);
                    return;
                }
            }
        } else {
            ret = GwJniApi.INSTANCE.iot_sdk_init(pid, "1.0.0");
            if (ret != 0) {
                Log.d(TAG, "GwJniApi.INSTANCE.iot_sdk_init error is " + ret);
                return;
            }
        }

        GwJniApi.INSTANCE.iot_sdk_reg_net_stat_cb(new GwListener.GwNwkStatusLsitener() {
            @Override
            public void getNwkStatCallBack(int status) {
                Log.d(TAG, "getNwkStatCallBack status is " + status);
            }

            @Override
            public void getWifiNwkStatCallBack(int status) {
                Log.d(TAG, "getWifiNwkStatCallBack status is " + status);
            }
        });

        GwJniApi.INSTANCE.user_svc_start();

        ret = IotJniApi.INSTANCE.iot_reg_dp_cb(DataEnum.DP_DEV_TYPE_T.DP_GW, DataEnum.GW_PERMIT_DEV_TP_T.GP_DEV_ZB, new IotListener.IotDpListener() {
            @Override
            public void gwDpCallBack(DPEvent[] events) {
                Log.d(TAG, "gwDpCallBack +++++");
            }
        });
        if (ret != 0) {
            Log.d(TAG, "IotJniApi.INSTANCE.iot_reg_dp_cb error is " + ret);
            return;
        }


        findViewById(R.id.button_0).setOnClickListener(v -> {
            //获取设备列表
            DevBriefInfo[] devBriefInfoList = HomeJniApi.INSTANCE.getDevBriefInfoList();

            Log.d(TAG, "devBriefInfoList size is " + devBriefInfoList.length);

            //遍历设备列表
            for (int i = 0; i < devBriefInfoList.length; i++) {
                Log.d(TAG, "devBriefInfo id is " + devBriefInfoList[i].getId() + " name is " + devBriefInfoList[i].getName() + " category is " + devBriefInfoList[i].getCategory());
                testOneDeviceDp(devBriefInfoList[i]);
            }
            //释放设备列表
            HomeJniApi.INSTANCE.freeDevBriefInfoList(devBriefInfoList);
//
//            SceneBean[] sceneBeans = HomeJniApi.INSTANCE.getSceneInfoList();
//
//            HomeJniApi.INSTANCE.freeSceneInfoList(sceneBeans);
//
//            RoomInfoBean[] roomInfoBeans = HomeJniApi.INSTANCE.getRoomInfoList();
//            Log.d(TAG, "roomInfoBeans size is " + roomInfoBeans.length);
//
//            HomeJniApi.INSTANCE.freeRoomList(roomInfoBeans);
        });
    }

    private void testOneDeviceDp(DevBriefInfo devBriefInfo) {
        //处理插排类别的设备
        if (devBriefInfo.getCategory().equals(DataEnum.Companion.getTY_HOME_CTRL_CATEGORY_SOCKETS())) {
            testLightDp(devBriefInfo.getId());
        }
    }

    private void testLightDp(String devId) {
        //打开当前设备
        long devInfo = HomeJniApi.INSTANCE.openHomeCtrlDev(devId, new HomeListener.HomeCtrlDevListener() {
            @Override
            public void homeDtrlDevReport(CtrlDevDpBean ctrlDevDpBean) {

            }

            @Override
            public void homeCtrlDpNameUpdate(String devId, String dpCode, String dpName) {

            }

            @Override
            public void homeCtrlDevOnline(String devId, int onlineStat) {

            }
        });
        if (devInfo == 0) {
            //open 设备失败返回
            return;
        }
        Log.d(TAG, "openHomeCtrlDev home_ctrl_get_dev_brief devInfo is " + devInfo);

        //获取当前设备的信息
        HomeCtrlDevBriefBean homeCtrlDevBrief = HomeJniApi.INSTANCE.getHomeCtrlDevBrief(devInfo);
        Log.d(TAG, "homeCtrlDevBrief devId is " + homeCtrlDevBrief.getId() + " dev_name is " + homeCtrlDevBrief.getName()
                + " category is " + homeCtrlDevBrief.getCategory() + " online is " + homeCtrlDevBrief.getOnline_stat());

        //获取当前设备的所有dp集合
        CtrlDevDpBean[] ctrlDevDpBeans = HomeJniApi.INSTANCE.getHomeCtrlDevAllDp(devInfo);
        if (ctrlDevDpBeans == null) {
            Log.d(TAG, "ctrlDevDpBeans is null ++++++++++++++");
            HomeJniApi.INSTANCE.closeHomeCtrlDev((int) devInfo);
            return;
        } else {
            Log.d(TAG, "ctrlDevDpBeans size is " + ctrlDevDpBeans.length);
        }

        //获取设备的指定dp
        CtrlDevDpBean ctrlDevDpBean = HomeJniApi.INSTANCE.getHomeCtrlDevDpValue(devInfo, DataEnum.Companion.HOME_CTRL_SWITCH_SWITCH_INDEX(1));
        Log.d(TAG, "ctrlDevDpBean id is " + ctrlDevDpBean.getDp_id());

        //设置设备的指定dp值
        HomeJniApi.INSTANCE.setHomeCtrlDevDpValue(devInfo, DataEnum.Companion.HOME_CTRL_SWITCH_SWITCH_INDEX(1), 0, ctrlDevDpBean);

        //同步场景
        HomeJniApi.INSTANCE.sceneSync();

        //获取当前场景状态
        HomeJniApi.INSTANCE.sceneTriggle(DataEnum.Companion.getTY_HOME_CTRL_CATEGORY_SOCKETS());

//        发送快捷开关
        HomeJniApi.INSTANCE.sendShortcutSwitch(DataEnum.Companion.getTY_HOME_CTRL_CATEGORY_SOCKETS(), false);

        //同步设备/房间
        HomeJniApi.INSTANCE.ctrlCenterSync();
//获取dp点对应的名称
        HomeJniApi.INSTANCE.getHomeCtrlDpNameList(devInfo);
        //获取快捷开关列表
        HomeJniApi.INSTANCE.getShortcutSwitchList();

        //设置设备能力
        DevAbilityRuleBean devAbilityRuleBean = new DevAbilityRuleBean();
        DevAbilityRuleBean.DevShowRuleBean devShowRuleBean = new DevAbilityRuleBean.DevShowRuleBean();
        devShowRuleBean.setShortcut_sw(DevAbilityRuleBean.TY_DEV_RULE_E.TY_DEV_RULE_DISABLE.getValue());
        devShowRuleBean.setDp_type("standard");
        devShowRuleBean.setCategory_arr("kg");
        devAbilityRuleBean.setShow_rule(devShowRuleBean);
        devAbilityRuleBean.setMedia(DevAbilityRuleBean.TY_DEV_RULE_E.TY_DEV_RULE_DISABLE.getValue());
        HomeJniApi.INSTANCE.setCtrlCentrlDevAbility(devAbilityRuleBean);

        //获取设备能力
        HomeJniApi.INSTANCE.getCtrlCentrlDevAbility();
        //添加品类能力支持
        HomeJniApi.INSTANCE.addCtrlCentrlDevCategoryAbility(DataEnum.Companion.getTY_HOME_CTRL_CATEGORY_SOCKETS());

        //关闭指定设备
        HomeJniApi.INSTANCE.closeHomeCtrlDev(devInfo);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
        if (requestCode == PERMISSION_CODE) {
            initSDK();
        }
    }

    private static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    private static String getLocalIp() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException ex) {
            Log.e(TAG, ex.getMessage());
        }
        return "0.0.0.0";
    }
}