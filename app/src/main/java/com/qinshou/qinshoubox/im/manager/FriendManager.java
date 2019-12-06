package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;
import com.qinshou.qinshoubox.listener.SuccessRunnable;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

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

    public FriendBean getById(String id) {
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 11:50
     * Description:添加好友
     *
     * @param toUserId      待添加的好友的 id
     * @param remark        备注
     * @param additionalMsg 附加验证信息
     * @param source        添加来源
     */
    public void addFriend(String toUserId, String remark, String additionalMsg, int source, Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.add(mUserId, toUserId, remark, additionalMsg, source)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 11:50
     * Description:同意添加好友
     *
     * @param toUserId 待同意添加的好友的 id
     * @param remark   备注
     */
    public void agreeAddFriend(String toUserId, String remark, Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.agreeAdd(mUserId, toUserId, remark)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 11:50
     * Description:删除好友
     *
     * @param toUserId 待删除的好友的 id
     */
    public void deleteFriend(String toUserId, Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.delete(mUserId, toUserId)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    public void setRemark(final String toUserId, final String remark, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, remark, null, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        FriendBean friendBean = getById(toUserId);
                        friendBean.setRemark(remark);
                        mFriendDao.insert(friendBean);
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    public void setTop(final String toUserId, final int top, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, null, top, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        FriendBean friendBean = getById(toUserId);
                        friendBean.setTop(top);
                        mFriendDao.insert(friendBean);
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    public void setDoNotDisturb(final String toUserId, final int doNotDisturb, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, null, null, doNotDisturb, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        FriendBean friendBean = getById(toUserId);
                        friendBean.setDoNotDisturb(doNotDisturb);
                        mFriendDao.insert(friendBean);
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    public void setBlackList(final String toUserId, final int blackList, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, null, null, null, blackList)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        FriendBean friendBean = getById(toUserId);
                        friendBean.setBlackList(blackList);
                        mFriendDao.insert(friendBean);
                        callback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 14:54
     * Description:获取好友申请历史
     *
     * @param page     分页加载当前页码
     * @param pageSize 分页加载每一页的条数
     */
    public void getHistory(int page, int pageSize, Callback<List<FriendHistoryBean>> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getHistory(mUserId, page, pageSize)
                .transform(new QSApiTransformer<List<FriendHistoryBean>>())
                .enqueue(callback);
    }
}
