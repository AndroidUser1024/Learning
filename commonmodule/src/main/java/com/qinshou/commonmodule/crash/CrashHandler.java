package com.qinshou.commonmodule.crash;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;


import com.qinshou.commonmodule.base.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Author: MrQinshou
 * Email:cqflqinhao@126.com
 * Date: 2020-02-11 21:02
 * Description:全局异常处理类
 */
public enum CrashHandler implements Thread.UncaughtExceptionHandler {
    SINGLETON;

    private final String TAG = "CrashHandler";
    private Context mContext;
    private Thread.UncaughtExceptionHandler mUncaughtExceptionHandler;

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        if (!handleException(throwable) && mUncaughtExceptionHandler != null) {
            // 如果用户没有处理则让系统默认的异常处理器来处理
            mUncaughtExceptionHandler.uncaughtException(thread, throwable);
        } else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Log.e(TAG, "uncaughtException : e--->", e);
            }
            // 退出程序
            BaseApplication.getInstance().exit();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-02-11 21:49
     * Description:初始化
     */
    public void init(Context context) {
        mContext = context;
        // 获取程序默认的 Exception 处理器
        mUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 将程序默认的 Exception 处理器设置为该对象
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-02-11 23:04
     * Description:自定义处理异常
     *
     * @param throwable 需要处理的异常
     * @return 是否已处理，已处理返回 true，否则返回 false
     */
    private boolean handleException(Throwable throwable) {
        throwable.printStackTrace();
        // 使用Toast来显示异常信息
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "很抱歉,程序出现异常,即将退出.", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        }.start();
        try {
            save2File(throwable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Author: MrQinshou
     * Email:cqflqinhao@126.com
     * Date:2020-02-11 23:17
     * Description:保存异常堆栈信息到文件中
     *
     * @param throwable 发生到异常
     */
    private void save2File(Throwable throwable) throws IOException {
        String dateTime = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA).format(new Date(System.currentTimeMillis()));
        File file = new File(mContext.getCacheDir()
                + File.separator
                + "log" +
                "" + File.separator
                + dateTime
                + ".log");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);
        throwable.printStackTrace(printWriter);
        printWriter.close();
    }
}
