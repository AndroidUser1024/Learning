package com.qinshou.commonmodule.util;

import android.content.Context;

public class DisplayUtil {

    /**
     * Description:将 px 转化为 dp
     * Date:2017/9/22
     */
    public static int px2dp(Context context, float pxValue) {
        float density = context.getResources().getDisplayMetrics().density;//得到设备的密度
        return (int) (pxValue / density + 0.5f);
    }

    /**
     * Description:将 dp 转化为 px
     * Date:2017/9/22
     */
    public static int dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }

    /**
     * Description:将 px 转化为 sp
     * Date:2017/9/22
     */
    public static int px2sp(Context context, float pxValue) {
        float scaleDensity = context.getResources().getDisplayMetrics().scaledDensity;//缩放密度
        return (int) (pxValue / scaleDensity + 0.5f);
    }

    /**
     * Description:将 sp 转化为 px
     * Date:2017/9/22
     */
    public static int sp2px(Context context, float spValue) {
        float scaleDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scaleDensity + 0.5f);
    }
}