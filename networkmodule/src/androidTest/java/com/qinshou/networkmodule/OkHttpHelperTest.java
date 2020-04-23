package com.qinshou.networkmodule;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.qinshou.networkmodule.bean.PageResultBean;
import com.qinshou.networkmodule.bean.QinshouResultBean;
import com.qinshou.networkmodule.bean.WallpaperBean;
import com.qinshou.networkmodule.call.AbsCall;
import com.qinshou.networkmodule.call.ResponseTransformer;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.networkmodule.callback.IDownloadCallback;
import com.qinshou.networkmodule.network.TestApi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/23 14:19
 * Description:类描述
 */
@RunWith(AndroidJUnit4.class)
public class OkHttpHelperTest {
    private static final String TAG = "OkHttpHelperTest";
    private Context mContext;
    private CountDownLatch mCountDownLatch = new CountDownLatch(1);

    @Before
    public void init() {
        mContext = ApplicationProvider.getApplicationContext();
    }

    @Test
    public void testGet() throws InterruptedException {
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .get("test1", "test1")
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testDownload() throws InterruptedException {
        String url = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312143927981075.mp4";
        String fileName = "tmp1.mp4";
        File file = new File(mContext.getCacheDir() + File.separator + fileName);
// 创建新文件
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .download(url, file)
                .enqueue(new Callback<File>() {
                    @Override
                    public void onSuccess(File data) {
                        Log.i(TAG, "onSuccess" + " : " + data.getAbsolutePath());
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testDownload2() throws InterruptedException {
        String url = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312143927981075.mp4";
        String fileName = "tmp2.mp4";
        File file = new File(mContext.getCacheDir() + File.separator + fileName);
        // 创建新文件
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .download(url, file, new IDownloadCallback() {
                    @Override
                    public void onStart(long length) {
                        Log.i(TAG, "onStart" + " : " + "length--->" + length);
                    }

                    @Override
                    public void onProgress(int progress) {
                        Log.i(TAG, "onProgress" + " : " + "progress--->" + progress);
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.i(TAG, "onSuccess" + " : " + "file--->" + file.getAbsolutePath());
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + "e--->" + e.getMessage());
                    }
                })
                .enqueue(new Callback<File>() {
                    @Override
                    public void onSuccess(File data) {
                        Log.i(TAG, "onSuccess" + " : " + data.getAbsolutePath());
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testDownload3() throws InterruptedException {
        String url = "http://vfx.mtime.cn/Video/2019/03/12/mp4/190312143927981075.mp4";
        String fileName = "tmp3.mp4";
        File file = new File(mContext.getCacheDir() + File.separator + fileName);
// 创建新文件
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final AbsCall<File> call = OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .download(url, file.length(), file, new IDownloadCallback() {
                    @Override
                    public void onStart(long length) {
                        Log.i(TAG, "onStart" + " : " + "length--->" + length);
                    }

                    @Override
                    public void onProgress(int progress) {
                        Log.i(TAG, "onProgress" + " : " + "progress--->" + progress);
                    }

                    @Override
                    public void onSuccess(File file) {
                        Log.i(TAG, "onSuccess" + " : " + "file--->" + file.getAbsolutePath());
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + "e--->" + e.getMessage());
                    }
                });
        call.enqueue(new Callback<File>() {
            @Override
            public void onSuccess(File data) {
                Log.i(TAG, "onSuccess" + " : " + data.getAbsolutePath());
                mCountDownLatch.countDown();
            }

            @Override
            public void onFailure(Exception e) {
                Log.i(TAG, "onFailure" + " : " + e.getMessage());
                mCountDownLatch.countDown();
            }
        });
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                call.cancel();
                mCountDownLatch.countDown();
            }
        }, 5000);
        mCountDownLatch.await();
    }

    @Test
    public void testPost() throws InterruptedException {
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .post("test1", "test1")
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testPostJson() throws InterruptedException {
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .postJson("test1", "test1")
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testPostUpload() throws InterruptedException {
        File file = new File("");
        if (!file.exists()) {
            return;
        }
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .postUpload(file)
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testGetWallpaperList() throws InterruptedException {
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .getWallpaperList(1, 5)
                .enqueue(new Callback<QinshouResultBean<PageResultBean<WallpaperBean>>>() {
                    @Override
                    public void onSuccess(QinshouResultBean<PageResultBean<WallpaperBean>> data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }

    @Test
    public void testGetWallpaperList2() throws InterruptedException {
        OkHttpHelper.SINGLETON.getCaller(TestApi.class)
                .getWallpaperList(1, 5)
                .transform(new ResponseTransformer<QinshouResultBean<PageResultBean<WallpaperBean>>, PageResultBean<WallpaperBean>>() {
                    @Override
                    public PageResultBean<WallpaperBean> transform(QinshouResultBean<PageResultBean<WallpaperBean>> pageResultBeanQinshouResultBean) throws Exception {
                        if (pageResultBeanQinshouResultBean.getSuccess() == 0) {
                            throw new Exception(pageResultBeanQinshouResultBean.getFailureInfo());
                        }
                        return pageResultBeanQinshouResultBean.getData();
                    }
                })
                .enqueue(new Callback<PageResultBean<WallpaperBean>>() {
                    @Override
                    public void onSuccess(PageResultBean<WallpaperBean> data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        mCountDownLatch.await();
    }
}
