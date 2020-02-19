package com.qinshou.pushmodule.utils;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.qinshou.pushmodule.listener.OnGetPushListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

import org.android.agoo.huawei.HuaWeiRegister;
import org.android.agoo.xiaomi.MiPushRegistar;

/**
 * Description:友盟推送初始化工具类
 * Created by 禽兽先生
 * Created on 2018/11/7
 */
public class PushHelper {

    private static final String TAG = "PushHelper";

    private static PushAgent sPushAgent;

    public static void init(Context context, String appKey, String pushSecret) {
        PushHelper.init(context, appKey, null, UMConfigure.DEVICE_TYPE_PHONE, pushSecret);
    }

    public static void init(Context context, String appKey, String channel, int deviceType, String pushSecret) {
        UMConfigure.init(context, appKey, channel, deviceType, pushSecret);
        sPushAgent = PushAgent.getInstance(context);
        // 注册推送服务，每次调用 register 方法都会回调该接口
        sPushAgent.register(new IUmengRegisterCallback() {

            @Override
            public void onSuccess(String deviceToken) {
                // 注册成功会返回device token
                Log.d(TAG, "deviceToken--->" + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d(TAG, "s--->" + s + ",s1--->" + s1);
            }
        });
    }

    /**
     * Description:初始化小米推送辅助渠道
     * Date:2018/11/30
     */
    public static void initMIUI(final Context context, final String appId, final String appKey) {
        MiPushRegistar.register(context, appId, appKey);
    }

    /**
     * Description:初始化华为推送辅助渠道
     * Date:2018/11/30
     */
    public static void initEMUI(final Application application) {
        HuaWeiRegister.register(application);
    }

    /**
     * Description:设置消息监听
     * Date:2018/12/3
     */
    public static void setOnGetPushListener(final OnGetPushListener onGetPushListener) {
        setOnGetPushListener(onGetPushListener, true);
    }

    /**
     * Description:设置消息监听
     * Date:2018/12/3
     *
     * @param notification 是否在通知栏显示推送
     */
    public static void setOnGetPushListener(final OnGetPushListener onGetPushListener, final boolean notification) {
        UmengMessageHandler messageHandler = new UmengMessageHandler() {
            /**
             * 通知的回调方法
             *
             * @param context
             * @param msg
             */
            @Override
            public void dealWithNotificationMessage(Context context, UMessage msg) {
                Log.d(TAG, "msg--->" + msg.getRaw().toString());
                if (notification) {
                    // 调用super则会走通知展示流程，不调用super则不展示通知
                    super.dealWithNotificationMessage(context, msg);
                }
                if (onGetPushListener != null) {
                    onGetPushListener.getPush(msg.getRaw().toString());
                }
            }
        };
        sPushAgent.setMessageHandler(messageHandler);
    }
}
