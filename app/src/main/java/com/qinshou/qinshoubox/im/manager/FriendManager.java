package com.qinshou.qinshoubox.im.manager;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.cache.FriendDatabaseCache;
import com.qinshou.qinshoubox.im.cache.FriendDoubleCache;
import com.qinshou.qinshoubox.im.cache.MemoryCache;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.listener.IOnFriendStatusListener;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.listener.FailureRunnable;
import com.qinshou.qinshoubox.listener.SuccessRunnable;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxUserApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/28 14:18
 * Description:好友管理者
 */
public class FriendManager extends AbsManager<String, FriendBean> {

    public FriendManager(DatabaseHelper databaseHelper, String userId) {
//        super(userId, new MemoryCache<String, FriendBean>());
//        super(userId, new FriendDatabaseCache(databaseHelper));
        super(userId, new FriendDoubleCache(new MemoryCache<String, FriendBean>(), new FriendDatabaseCache(databaseHelper)));
        IMClient.SINGLETON.addOnFriendStatusListener(new IOnFriendStatusListener() {
            @Override
            public void add(String fromUserId, String additionalMsg, boolean newFriend) {

            }

            @Override
            public void agreeAdd(String fromUserId) {
                // 更新缓存
                updateCache(fromUserId);
            }

            @Override
            public void refuseAdd(String fromUserId) {

            }

            @Override
            public void delete(String fromUserId) {

            }

            @Override
            public void online(String fromUserId) {

            }

            @Override
            public void offline(String fromUserId) {

            }
        });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/6 17:50
     * Description:更新缓存
     *
     * @param id 用户 id
     */
    private void updateCache(String id) {
        // 更新缓存
        OkHttpHelperForQSBoxUserApi.SINGLETON.getUserDetail(getUserId(), id)
                .transform(new QSApiTransformer<UserDetailBean>())
                .enqueue(new Callback<UserDetailBean>() {
                    @Override
                    public void onSuccess(UserDetailBean data) {
                        FriendBean friendBean = new FriendBean();
                        friendBean.setId(data.getId());
                        friendBean.setNickname(data.getNickname());
                        friendBean.setHeadImg(data.getHeadImg());
                        friendBean.setHeadImgSmall(data.getHeadImgSmall());
                        friendBean.setSignature(data.getSignature());
                        friendBean.setRemark(data.getRemark());
                        friendBean.setTop(data.getTop());
                        friendBean.setDoNotDisturb(data.getDoNotDisturb());
                        friendBean.setBlackList(data.getBlackList());

                        getCache().put(friendBean.getId(), friendBean);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/6 15:37
     * Description:获取好友
     *
     * @param id 用户 id
     */
    public FriendBean getById(String id) {
        FriendBean friendBean = getCache().get(id);
        if (friendBean == null) {
            ShowLogUtil.logi("从网络拿");
        }
        return friendBean;
    }

    public void getList(final Callback<List<FriendBean>> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(getUserId())
                .transform(new QSApiTransformer<List<FriendBean>>())
                .enqueue(new Callback<List<FriendBean>>() {
                    @Override
                    public void onSuccess(final List<FriendBean> data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                for (FriendBean friendBean : data) {
                                    // 存到缓存
                                    getCache().put(friendBean.getId(), friendBean);
                                }
                                getHandler().post(new SuccessRunnable<List<FriendBean>>(callback, data));
                            }
                        });

                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(callback, e));
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
        OkHttpHelperForQSBoxFriendApi.SINGLETON.add(getUserId(), toUserId, remark, additionalMsg, source)
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
    public void agreeAddFriend(final String toUserId, String remark, final QSCallback<Object> qsCallback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.agreeAdd(getUserId(), toUserId, remark)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        qsCallback.onSuccess(data);
                        // 更新缓存
                        updateCache(toUserId);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
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
        OkHttpHelperForQSBoxFriendApi.SINGLETON.delete(getUserId(), toUserId)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }

    public void setRemark(final String toUserId, final String remark, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(getUserId(), toUserId, remark, null, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setRemark(remark);
                                getCache().put(friendBean.getId(), friendBean);

                                getHandler().post(new SuccessRunnable<>(callback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(callback, e));
                    }
                });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/6 17:55
     * Description:设置置顶
     *
     * @param toUserId 目标用户的 id
     * @param top      是否置顶,0 是非置顶,1 是置顶
     */
    public void setTop(final String toUserId, final int top, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(getUserId(), toUserId, null, top, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setTop(top);
                                getCache().put(friendBean.getId(), friendBean);

                                getHandler().post(new SuccessRunnable<>(callback, data));
                            }
                        });

                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(callback, e));
                    }
                });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/6 17:56
     * Description:设置免打扰
     *
     * @param toUserId     目标用户的 id
     * @param doNotDisturb 是否免打扰,0 是非免打扰,1 是免打扰
     */
    public void setDoNotDisturb(final String toUserId, final int doNotDisturb, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(getUserId(), toUserId, null, null, doNotDisturb, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setDoNotDisturb(doNotDisturb);
                                getCache().put(friendBean.getId(), friendBean);

                                getHandler().post(new SuccessRunnable<>(callback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(callback, e));
                    }
                });
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/6 17:56
     * Description:设置加入黑名单
     *
     * @param toUserId  目标用户的 id
     * @param blackList 是否加入黑名单,0 是不加入,1 是加入
     */
    public void setBlackList(final String toUserId, final int blackList, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(getUserId(), toUserId, null, null, null, blackList)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setBlackList(blackList);
                                getCache().put(friendBean.getId(), friendBean);

                                getHandler().post(new SuccessRunnable<>(callback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(callback, e));
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
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getHistory(getUserId(), page, pageSize)
                .transform(new QSApiTransformer<List<FriendHistoryBean>>())
                .enqueue(callback);
    }
}
