package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatDao;
import com.qinshou.qinshoubox.listener.SuccessRunnable;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxGroupChatApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/26 14:07
 * Description:群聊管理者
 */
public class GroupChatManager {
    private IGroupChatDao mGroupChatDao;
    private String mUserId;
    /**
     * 线程池,线程数量不定,适合执行大量耗时较少的任务
     */
    private ExecutorService mExecutorService = Executors.newCachedThreadPool();
    /**
     * 将回调切换到主线程的 Handler
     */
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public GroupChatManager(DatabaseHelper databaseHelper, String userId) {
        mGroupChatDao = databaseHelper.getDao(IGroupChatDao.class);
        mUserId = userId;
    }

    public void getGroupChatList(final Callback<List<GroupChatBean>> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMyGroupChatList(mUserId)
                .transform(new QSApiTransformer<List<GroupChatBean>>())
                .enqueue(new Callback<List<GroupChatBean>>() {
                    @Override
                    public void onSuccess(final List<GroupChatBean> data) {
                        mExecutorService.submit(new Runnable() {
                            @Override
                            public void run() {
                                for (GroupChatBean groupChatBean : data) {
                                    mGroupChatDao.insert(groupChatBean);
                                }
                                mHandler.post(new SuccessRunnable<List<GroupChatBean>>(callback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        callback.onFailure(e);
                    }
                });
    }

    public void getGroupChat(int groupChatId, final QSCallback<GroupChatBean> qsCallback) {
//        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getGroupChat(groupChatId, IMClient.SINGLETON.getUserId())
//                .transform(new QSApiTransformer<GroupChatBean>())
//                .enqueue(new Callback<GroupChatBean>() {
//                    @Override
//                    public void onSuccess(GroupChatBean data) {
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
    }

//    public void getMemberList(int groupChatId, final QSCallback<List<UserBean>> qsCallback) {
//        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMemberList(groupChatId, IMClient.SINGLETON.getUserId())
//                .transform(new QSApiTransformer<List<UserBean>>())
//                .enqueue(new Callback<List<UserBean>>() {
//                    @Override
//                    public void onSuccess(List<UserBean> data) {
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
//    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/2 20:12
     * Description:添加群成员
     *
     * @param groupChatId 待添加的群成员的 Id 集合
     */
    public void addMember(int groupChatId, List<Integer> toUserIdList, final QSCallback<Object> qsCallback) {
//        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.addMember(groupChatId, IMClient.SINGLETON.getUserId(), toUserIdList)
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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/2 20:12
     * Description:删除群成员
     *
     * @param groupChatId 待删除的群成员的 Id 集合
     */
    public void deleteMember(int groupChatId, List<Integer> toUserIdList, final QSCallback<Object> qsCallback) {
//        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.deleteMember(groupChatId, IMClient.SINGLETON.getUserId(), toUserIdList)
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
}
