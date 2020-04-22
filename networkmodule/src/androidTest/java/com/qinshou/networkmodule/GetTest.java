package com.qinshou.networkmodule;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.qinshou.networkmodule.bean.NewsBean;
import com.qinshou.networkmodule.bean.PageResultBean;
import com.qinshou.networkmodule.bean.QinshouResultBean;
import com.qinshou.networkmodule.call.ResponseTransformer;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.networkmodule.network.QSBoxNewsApi;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/22 15:30
 * Description:类描述
 */
@RunWith(AndroidJUnit4.class)
public class GetTest {
    private static final String TAG = "GetTest";
    private CountDownLatch mCountDownLatch = new CountDownLatch(1);
    @Test
    public void testNewsGetList() {
        OkHttpHelper.SINGLETON.getCaller(QSBoxNewsApi.class)
                .getList(0, 10)
                .transform(new ResponseTransformer<QinshouResultBean<PageResultBean<NewsBean>>, PageResultBean<NewsBean>>() {
                    @Override
                    public PageResultBean<NewsBean> transform(QinshouResultBean<PageResultBean<NewsBean>> pageResultBeanQinshouResultBean) throws Exception {
                        if (pageResultBeanQinshouResultBean.getSuccess() != 1) {
                            throw new Exception(pageResultBeanQinshouResultBean.getFailureInfo());
                        }
                        return pageResultBeanQinshouResultBean.getData();
                    }
                })
                .enqueue(new Callback<PageResultBean<NewsBean>>() {
                    @Override
                    public void onSuccess(PageResultBean<NewsBean> data) {
                        Log.i(TAG, "onSuccess" + " : " + data);
                        mCountDownLatch.countDown();
                    }

                    @Override
                    public void onFailure(Exception e) {
                        Log.i(TAG, "onFailure" + " : " + e.getMessage());
                        mCountDownLatch.countDown();
                    }
                });
        try {
            mCountDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
