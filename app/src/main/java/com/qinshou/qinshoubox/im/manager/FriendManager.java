package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;
import com.qinshou.qinshoubox.listener.SuccessRunnable;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/28 14:18
 * Description:好友管理者
 */
public class FriendManager {
    private IFriendDao mFriendDao;
    private String mUserId;
    /**
     * 线程池,线程数量不定,适合执行大量耗时较少的任务
     */
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    /**
     * 将回调切换到主线程的 Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public FriendManager(DatabaseHelper databaseHelper, String userId) {
        mFriendDao = databaseHelper.getDao(IFriendDao.class);
        mUserId = userId;
    }

    public FriendBean selectById(String id) {
        return mFriendDao.selectById(id);
    }

    public void getList(final Callback<List<FriendBean>> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(mUserId)
                .transform(new QSApiTransformer<List<FriendBean>>())
                .enqueue(new Callback<List<FriendBean>>() {
                    @Override
                    public void onSuccess(final List<FriendBean> data) {
                        mExecutorService.submit(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; data != null && i < data.size(); i++) {
                                    mFriendDao.insert(data.get(i));
                                }
                                mHandler.post(new SuccessRunnable<List<FriendBean>>(callback, data));
                            }
                        });

                    }

                    @Override
                    public void onFailure(Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    public void setRemark(final int toUserId, String remark, final QSCallback<Object> qsCallback) {
//        OkHttpHelperForQSBoxFriendApi.SINGLETON.setRemark(IMClient.SINGLETON.getUserId(), toUserId, remark)
//                .transform(new QSApiTransformer<Object>())
//                .enqueue(new Callback<Object>() {
//                    @Override
//                    public void onSuccess(Object data) {
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
    }

    public void setTop(final int toUserId, final int top, final QSCallback<FriendBean> qsCallback) {
//        OkHttpHelperForQSBoxFriendApi.SINGLETON.setTop(IMClient.SINGLETON.getUserId(), toUserId, top)
//                .transform(new QSApiTransformer<FriendBean>())
//                .enqueue(new Callback<FriendBean>() {
//                    @Override
//                    public void onSuccess(FriendBean data) {
//                        FriendBean friendBean = getFriend(toUserId);
//                        friendBean.setTop(top);
//                        insertOrUpdate(friendBean);
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
    }

    public void setDoNotDisturb(final int toUserId, final int doNotDisturb, final QSCallback<FriendBean> qsCallback) {
//        OkHttpHelperForQSBoxFriendApi.SINGLETON.setDoNotDisturb(IMClient.SINGLETON.getUserId(), toUserId, doNotDisturb)
//                .transform(new QSApiTransformer<FriendBean>())
//                .enqueue(new Callback<FriendBean>() {
//                    @Override
//                    public void onSuccess(FriendBean data) {
//                        FriendBean friendBean = getFriend(toUserId);
//                        friendBean.setDoNotDisturb(doNotDisturb);
//                        insertOrUpdate(friendBean);
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
    }

    public void setBlackList(final int toUserId, final int blackList, final QSCallback<FriendBean> qsCallback) {
//        OkHttpHelperForQSBoxFriendApi.SINGLETON.setBlackList(IMClient.SINGLETON.getUserId(), toUserId, blackList)
//                .transform(new QSApiTransformer<FriendBean>())
//                .enqueue(new Callback<FriendBean>() {
//                    @Override
//                    public void onSuccess(FriendBean data) {
//                        FriendBean friendBean = getFriend(toUserId);
//                        friendBean.setBlackList(blackList);
//                        insertOrUpdate(friendBean);
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
    }
}
