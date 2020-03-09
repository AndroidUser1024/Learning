package com.qinshou.commonmodule.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/9 15:49
 * Description:网络状态工具类
 */
public enum NetworkStateHelper {
    SINGLETON;
    private Context mContext;
    private List<Callback> mCallbackList = new ArrayList<>();
    private ConnectivityManager.NetworkCallback mNetworkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(Network network) {
            super.onAvailable(network);
            doCallback(getNetworkState());
        }

        @Override
        public void onLost(Network network) {
            super.onLost(network);
            doCallback(getNetworkState());
        }
    };
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            doCallback(getNetworkState());
        }
    };

    public enum State {
        /**
         * 当前网络状态为不可用
         */
        NONE,
        /**
         * 当前网络状态为未知状态
         */
        UNKNOWN,
        /**
         * 当前网络状态为 WIFI
         */
        WIFI,
        /**
         * 当前网络状态为 GPRS 4G 网络
         */
        GPRS_4G,
        /**
         * 当前网络状态为 GPRS 3G 网络
         */
        GPRS_3G,
        /**
         * 当前网络状态为 GPRS 2G 网络
         */
        GPRS_2G;

    }

    public interface Callback {
        /**
         * 网络状态发生变化
         *
         * @param state 当前网络状态
         */
        void onNetworkStateChanged(State state);
    }

    public void startMonitor(Context context) {
        mContext = context;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // API 大于 26 时
            connectivityManager.registerDefaultNetworkCallback(mNetworkCallback);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // API 大于 21 时
            connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().build(), mNetworkCallback);
        } else {
            // 低版本
            IntentFilter intentFilter = new IntentFilter();
            // 监听网络变化的广播
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            context.registerReceiver(mBroadcastReceiver, intentFilter);
        }
    }

    public void stopMonitor() {
        mCallbackList.clear();
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            connectivityManager.unregisterNetworkCallback(mNetworkCallback);
        } else {
            mContext.unregisterReceiver(mBroadcastReceiver);
        }
    }

    public void addCallback(Callback callback) {
        mCallbackList.add(callback);
    }

    public void removeCallback(Callback callback) {
        mCallbackList.remove(callback);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/9 16:14
     * Description:获取当前网络状态
     */
    private State getNetworkState() {
        // 获取 NetworkInfo 对象
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return State.NONE;
        }
        int type = networkInfo.getType();
        if (type == ConnectivityManager.TYPE_WIFI) {
            return State.WIFI;
        }
        if (type == ConnectivityManager.TYPE_MOBILE) {
            int subtype = networkInfo.getSubtype();
            return getNetworkClass(subtype);
        }
        return State.NONE;
    }


    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/9 16:13
     * Description:判断是否是 3G 网
     * 联通的 3G 为 UMTS 或 HSDPA,电信的 3G 为 EVDO
     */
    private State getNetworkClass(int subtype) {
        switch (subtype) {
            case TelephonyManager.NETWORK_TYPE_GPRS:
            case TelephonyManager.NETWORK_TYPE_GSM:
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_CDMA:
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_IDEN:
                return State.GPRS_2G;
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_EVDO_0:
            case TelephonyManager.NETWORK_TYPE_EVDO_A:
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_EVDO_B:
            case TelephonyManager.NETWORK_TYPE_EHRPD:
            case TelephonyManager.NETWORK_TYPE_HSPAP:
            case TelephonyManager.NETWORK_TYPE_TD_SCDMA:
                return State.GPRS_3G;
            case TelephonyManager.NETWORK_TYPE_LTE:
            case TelephonyManager.NETWORK_TYPE_IWLAN:
            case 19: // TelephonyManager.NETWORK_TYPE_LTE_CA,该枚举被源码隐藏,所以写成固定值
                return State.GPRS_4G;
            default:
                return State.UNKNOWN;
        }
    }

    private void doCallback(State state) {
        for (Callback callback : mCallbackList) {
            callback.onNetworkStateChanged(state);
        }
    }
}
