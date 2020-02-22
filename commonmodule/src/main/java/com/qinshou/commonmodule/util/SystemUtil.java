package com.qinshou.commonmodule.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import androidx.core.content.PermissionChecker;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewConfiguration;
import android.view.WindowManager;

import com.qinshou.commonmodule.util.permissionutil.PermissionUtil;

import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * Description:获取手机系统信息的工具类
 * Created by 禽兽先生
 * Created on 2017/9/1
 */

public class SystemUtil {

    /**
     * Description:获取系统语言
     * Date:2017/9/1
     */
    public static String getLanguage(Context context) {
        String language = "";
        Locale mLocale;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            mLocale = context.getResources().getConfiguration().getLocales().get(0);
        } else {
            mLocale = context.getResources().getConfiguration().locale;
        }
        language = mLocale.getLanguage() + "-" + mLocale.getCountry();
        return language;
    }

    /**
     * Description:获取屏幕宽度,不包括虚拟按键的宽度
     * Date:2017/9/1
     */
    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * Description:获取屏幕高度,不包括虚拟按键的高度
     * Date:2017/9/1
     */
    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /**
     * Description:获取屏幕真实宽度,包括虚拟按键的高度
     * Date:2017/9/1
     */
    public static int getRealScreenWidth(Context context) {
        int realWidth = 0;
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display mDisplay = mWindowManager.getDefaultDisplay();
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        Class clazz;
        try {
            clazz = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = clazz.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(mDisplay, mDisplayMetrics);
            realWidth = mDisplayMetrics.widthPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realWidth;
    }

    /**
     * Description:获取屏幕真实高度,包括虚拟按键的高度
     * Date:2017/9/1
     */
    public static int getRealScreenHeight(Context context) {
        int realHeight = 0;
        WindowManager mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display mDisplay = mWindowManager.getDefaultDisplay();
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        Class clazz;
        try {
            clazz = Class.forName("android.view.Display");
            @SuppressWarnings("unchecked")
            Method method = clazz.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(mDisplay, mDisplayMetrics);
            realHeight = mDisplayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return realHeight;
    }

    /**
     * Description:获取像素密度
     * Date:2017/9/1
     */
    public static float getDensityDpi(Context context) {
        return context.getResources().getDisplayMetrics().densityDpi;
    }

    /**
     * Description:获取与标准 dpi(160) 的比例
     * Date:2017/9/1
     */
    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    /**
     * Description:获取状态栏高度,返回像素
     * Date:2017/9/1
     */
    public static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return resourceId > 0 ? context.getResources().getDimensionPixelSize(resourceId) : 0;
    }

    /**
     * Description:获取虚拟按键栏高度
     * Date:2018/8/1
     */
    public static int getNavigationBarHeight(Context context) {
        int result = 0;
        if (hasNavBar(context)) {
            Resources res = context.getResources();
            int resourceId = res.getIdentifier("navigation_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = res.getDimensionPixelSize(resourceId);
            }
        }
        return result;
    }

    /**
     * Description:检查是否存在虚拟按键栏
     * Date:2018/8/1
     */
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static boolean hasNavBar(Context context) {
        Resources res = context.getResources();
        int resourceId = res.getIdentifier("config_showNavigationBar", "bool", "android");
        if (resourceId != 0) {
            boolean hasNav = res.getBoolean(resourceId);
            // check override flag
            String sNavBarOverride = getNavBarOverride();
            if ("1".equals(sNavBarOverride)) {
                hasNav = false;
            } else if ("0".equals(sNavBarOverride)) {
                hasNav = true;
            }
            return hasNav;
        } else { // fallback
            return !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
    }

    /**
     * 判断虚拟按键栏是否重写
     * Date:2018/8/1
     */
    private static String getNavBarOverride() {
        String sNavBarOverride = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            try {
                Class c = Class.forName("android.os.SystemProperties");
                Method m = c.getDeclaredMethod("get", String.class);
                m.setAccessible(true);
                sNavBarOverride = (String) m.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable e) {
            }
        }
        return sNavBarOverride;
    }

    /**
     * Description:获取应用程序名称
     * Date:2018/7/13
     */
    public static synchronized String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Description:获取应用版本名称
     * Date:2017/9/11
     */
    public static String getAppVersionName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            return pi.versionName;
        } catch (
                PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "没有得到应用版本名称";
    }

    /**
     * Description:获取应用版本号
     * Date:2017/9/11
     */
    public static int getAppVersionCode(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
            return pi.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * Description:获取 Android 版本号
     * Date:2017/9/11
     */
    public static String getAndroidVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * Description:获取 API 版本
     * Date:2017/9/11
     */
    public static int getSDKVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * Description:获取手机制造商
     * Date:2017/9/11
     */
    public static String getManufacturer() {
        return Build.MANUFACTURER;
    }

    /**
     * Description:获取手机型号
     * Date:2017/9/11
     */
    public static String getModel() {
        return Build.MODEL;
    }

    @SuppressLint("HardwareIds")
    public static String getDeviceId(FragmentActivity activity) {
        if (PermissionChecker.checkSelfPermission(activity, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_DENIED
                || PermissionChecker.checkSelfPermission(activity, Manifest.permission.ACCESS_WIFI_STATE) == PackageManager.PERMISSION_DENIED) {
            PermissionUtil.requestPermission(activity.getSupportFragmentManager(), null, Manifest.permission.READ_PHONE_STATE);
            PermissionUtil.requestPermission(activity.getSupportFragmentManager(), null, Manifest.permission.ACCESS_WIFI_STATE);
            return null;
        }
        try {
            //wifi mac地址
            WifiManager wifiManager = (WifiManager) activity.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            if (wifiManager == null) {
                return null;
            }
            WifiInfo wifiInfo = wifiManager.getConnectionInfo();
            if (wifiInfo == null) {
                return null;
            }
            @SuppressLint("HardwareIds") String wifiMac = wifiInfo.getMacAddress();
            if (!TextUtils.isEmpty(wifiMac)) {
                return wifiMac;
            }
            //IMEI（imei）
            TelephonyManager telephonyManager = (TelephonyManager) activity.getSystemService(Context.TELEPHONY_SERVICE);
            if (telephonyManager == null) {
                return null;
            }
            @SuppressLint("HardwareIds") String iMei = telephonyManager.getDeviceId();
            if (!TextUtils.isEmpty(iMei)) {
                return iMei;
            }
            //序列号（simSerialNumber）
            String simSerialNumber = telephonyManager.getSimSerialNumber();
            if (!TextUtils.isEmpty(simSerialNumber)) {
                return simSerialNumber;
            }
            //如果上面都没有， 则生成一个id：随机码
            return getUUID(activity);
        } catch (Exception e) {
            e.printStackTrace();
            return getUUID(activity);
        }
    }

    /**
     * 得到全局唯一UUID
     */
    private static String getUUID(Context context) {
        String uuid = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE).getString("uuid", "");
        if (TextUtils.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString();
            SharedPreferences sharedPreferences = context.getSharedPreferences(context.getApplicationInfo().processName, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("UUID", uuid);
            editor.apply();
        }
        return uuid;
    }

    /**
     * Description:获取 ip 地址
     * Date:2018/11/13
     */
    public static String getIPAddress(FragmentActivity activity) {
        if (PermissionChecker.checkSelfPermission(activity, Manifest.permission.ACCESS_NETWORK_STATE) == PackageManager.PERMISSION_DENIED
                || PermissionChecker.checkSelfPermission(activity, Manifest.permission.ACCESS_WIFI_STATE) == PackageManager.PERMISSION_DENIED) {
            PermissionUtil.requestPermission(activity.getSupportFragmentManager(), null, Manifest.permission.ACCESS_NETWORK_STATE);
            PermissionUtil.requestPermission(activity.getSupportFragmentManager(), null, Manifest.permission.ACCESS_WIFI_STATE);
            return null;
        }
        ConnectivityManager connectivityManager = ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE));
        if (connectivityManager == null) {
            return null;
        }
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null) {
            return null;
        }
        if (networkInfo.isConnected()) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                        NetworkInterface networkInterface = en.nextElement();
                        for (Enumeration<InetAddress> enumeration = networkInterface.getInetAddresses(); enumeration.hasMoreElements(); ) {
                            InetAddress inetAddress = enumeration.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            } else if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) activity.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                if (wifiManager != null) {
                    WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                    //返回 ipv4 地址
                    return intIp2String(wifiInfo.getIpAddress());
                }
            }
        }
        //否则当前无网络连接,请在设置中打开网络
        return null;
    }

    /**
     * 将得到的int类型的 IP 转换为String类型
     */
    private static String intIp2String(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/13 9:29
     * Description:判断应用是否在后台
     *
     * @param context 上下文
     * @return true 表示在后台,false 表示在前台
     */
    public static boolean isBackground(Context context) throws Exception {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        if (activityManager == null) {
            throw new Exception("ActivityManager is null");
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfoList = activityManager.getRunningAppProcesses();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcessInfoList) {
            if (runningAppProcessInfo.processName.equals(context.getPackageName())) {
                return runningAppProcessInfo.importance != ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND;
            }
        }
        throw new Exception("Your app is running?");
    }
}
