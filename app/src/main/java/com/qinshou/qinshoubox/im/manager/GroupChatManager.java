package com.qinshou.qinshoubox.im.manager;

import android.os.Handler;
import android.os.Looper;

import com.qinshou.qinshoubox.conversation.bean.GroupChatDetailBean;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
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

    public void create(List<String> toUserIdList, String nickname, String headImg, Callback<GroupChatBean> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.create(mUserId, toUserIdList, nickname, headImg)
                .transform(new QSApiTransformer<GroupChatBean>())
                .enqueue(callback);
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

    public void getDetail(String groupChatId, final Callback<GroupChatDetailBean> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getDetail(groupChatId, mUserId)
                .transform(new QSApiTransformer<GroupChatDetailBean>())
                .enqueue(callback);
    }

    public void getMemberList(String groupChatId, final Callback<List<UserDetailBean>> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMemberList(groupChatId, mUserId)
                .transform(new QSApiTransformer<List<UserDetailBean>>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/2 20:12
     * Description:添加群成员
     *
     * @param groupChatId 待添加的群成员的 Id 集合
     */
    public void addMember(String groupChatId, List<String> toUserIdList, final Callback<Object> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.addMember(groupChatId, mUserId, toUserIdList)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/2 20:12
     * Description:删除群成员
     *
     * @param groupChatId 待删除的群成员的 Id 集合
     */
    public void deleteMember(String groupChatId, List<String> toUserIdList, final Callback<Object> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.deleteMember(groupChatId, mUserId, toUserIdList)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    public GroupChatBean getById(String groupChatId) {
        return mGroupChatDao.selectById(groupChatId);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/9 14:12
     * Description:设置群昵称
     *
     * @param groupChatId 群 id
     * @param nickname    群昵称
     */
    public void setNickname(String groupChatId, String nickname, Callback<Object> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.setNickname(groupChatId, mUserId, nickname)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/9 15:18
     * Description:设置置顶
     *
     * @param groupChatId                 群 id
     * @param nicknameInGroupChat         在本群中的昵称
     * @param top                         0 表示不置顶,1 表示置顶
     * @param doNotDisturb                0 表示不置顶,1 表示置顶
     * @param showGroupChatMemberNickname 0 表示不置顶,1 表示置顶
     */
    public void setInfo(String groupChatId
            , String nicknameInGroupChat
            , Integer top, Integer doNotDisturb
            , Integer showGroupChatMemberNickname
            , Callback<Object> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.setInfo(groupChatId, mUserId, nicknameInGroupChat, top, doNotDisturb, showGroupChatMemberNickname)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/9 15:55
     * Description:退出群聊
     *
     * @param groupChatId 群 id
     */
    public void exit(String groupChatId, Callback<Object> callBack) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.exit(groupChatId, mUserId)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callBack);
    }
}
