package com.qinshou.qinshoubox.im.manager;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.cache.FriendDatabaseCache;
import com.qinshou.qinshoubox.im.cache.FriendDoubleCache;
import com.qinshou.qinshoubox.im.cache.MemoryCache;
import com.qinshou.qinshoubox.im.db.DatabaseHelper;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.listener.FailureRunnable;
import com.qinshou.qinshoubox.listener.SuccessRunnable;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/28 14:18
 * Description:好友管理者
 */
public class FriendManager extends AbsManager<String, FriendBean> {
    private String mUserId;

    public FriendManager(DatabaseHelper databaseHelper, String userId) {
//        super(userId, new MemoryCache<String, FriendBean>());
//        super(userId, new FriendDatabaseCache(databaseHelper));
        super(userId, new FriendDoubleCache(new MemoryCache<String, FriendBean>(), new FriendDatabaseCache(databaseHelper)));
        mUserId = userId;
    }

    public FriendBean getById(String id) {
        FriendBean friendBean = getCache().get(id);
        if (friendBean == null) {
            ShowLogUtil.logi("从网络拿");
        }
        return friendBean;
    }

    public void getList(final Callback<List<FriendBean>> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(mUserId)
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
    public void agreeAddFriend(final String toUserId, String remark, final QSCallback<Object> qsCallback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.agreeAdd(mUserId, toUserId, remark)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        Map<String, Object> extend = new HashMap<>();
                        extend.put("status", FriendStatus.AGREE_ADD.getValue());
                        // 创建已经是好友的提示信息的系统消息
                        MessageBean messageBean = MessageBean.createChatSystemMessage(toUserId, mUserId, extend);
                        IMClient.SINGLETON.handleMessage(messageBean);
                        qsCallback.onSuccess(data);
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
    public void deleteFriend(final String toUserId, final QSCallback<Object> qsCallback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.delete(mUserId, toUserId)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        ConversationManager conversationManager = IMClient.SINGLETON.getConversationManager();
                        ConversationBean conversationBean = conversationManager.selectByTypeAndToUserId(MessageType.CHAT.getValue(), toUserId);
                        if (conversationBean != null) {
                            conversationManager.deleteById(conversationBean.getId());
                        }

                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
    }

    public void setRemark(final String toUserId, final String remark, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, remark, null, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setRemark(remark);
                                // 更新缓存
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

    public void setTop(final String toUserId, final int top, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, null, top, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setTop(top);
                                // 更新缓存
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

    public void setDoNotDisturb(final String toUserId, final int doNotDisturb, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, null, null, doNotDisturb, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setDoNotDisturb(doNotDisturb);
                                // 更新缓存
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

    public void setBlackList(final String toUserId, final int blackList, final Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(mUserId, toUserId, null, null, null, blackList)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                FriendBean friendBean = getById(toUserId);
                                friendBean.setBlackList(blackList);
                                // 更新缓存
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
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getHistory(mUserId, page, pageSize)
                .transform(new QSApiTransformer<List<FriendHistoryBean>>())
                .enqueue(callback);
    }
}
