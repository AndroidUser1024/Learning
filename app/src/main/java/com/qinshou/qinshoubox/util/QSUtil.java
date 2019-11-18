package com.qinshou.qinshoubox.util;

import android.os.Environment;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 10:58
 * Description:本项目的工具类
 */
public class QSUtil {
    public static String getPicturePath() {
        return Environment.getExternalStorageDirectory()
                + File.separator
                + "QinshouBox"
                + File.separator
                + "Picture"
                + File.separator;
    }
}
