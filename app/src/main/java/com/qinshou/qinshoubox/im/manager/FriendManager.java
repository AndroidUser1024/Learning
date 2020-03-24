package com.qinshou.qinshoubox.im.manager;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.ConversationBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.FriendStatusBean;
import com.qinshou.qinshoubox.im.bean.MessageBean;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.cache.FriendDatabaseCache;
import com.qinshou.qinshoubox.im.cache.FriendDoubleCache;
import com.qinshou.qinshoubox.im.cache.MemoryCache;
import com.qinshou.qinshoubox.im.enums.FriendRelStatus;
import com.qinshou.qinshoubox.im.enums.FriendStatus;
import com.qinshou.qinshoubox.im.enums.MessageType;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.listener.FailureRunnable;
import com.qinshou.qinshoubox.listener.SuccessRunnable;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/28 14:18
 * Description:好友管理者
 */
public class FriendManager extends AbsManager<String, UserDetailBean> {
    private boolean mLoaded = false;

    public FriendManager() {
        super(new FriendDoubleCache(new MemoryCache<>(), new FriendDatabaseCache()));
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 11:50
     * Description:同步获取添加好友列表
     */
    public void getList() {
        getExecutorService().submit(new Runnable() {
            @Override
            public void run() {
                try {
                    String userId = IMClient.SINGLETON.getUserDetailBean().getId();
                    List<UserDetailBean> userDetailBeanList = OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(userId)
                            .transform(new QSApiTransformer<List<UserDetailBean>>())
                            .execute();
                    for (UserDetailBean userDetailBean : userDetailBeanList) {
                        // 存到缓存
                        getCache().put(userDetailBean.getId(), userDetailBean);
                    }
                } catch (Exception e) {
                    getList();
                    return;
                }
                mLoaded = true;
            }
        });
    }

    public void getList(final QSCallback<List<UserDetailBean>> qsCallback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!mLoaded) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (getCache().getValues() == null) {
                    getHandler().post(new SuccessRunnable<>(qsCallback, new ArrayList<>()));
                } else {
                    getHandler().post(new SuccessRunnable<>(qsCallback, new ArrayList<>(getCache().getValues())));
                }
            }
        }).start();
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/1/6 15:37
     * Description:获取好友
     *
     * @param id 用户 id
     */
    public UserDetailBean getById(String id) {
        UserDetailBean userDetailBean = getCache().get(id);
        if (userDetailBean == null) {
            ShowLogUtil.logi("从网络拿");
        }
        return userDetailBean;
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
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.add(userId, toUserId, remark, additionalMsg, source)
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
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.agreeAdd(userId, toUserId, remark)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                UserDetailBean userDetailBean = getCache().get(toUserId);
                                if (userDetailBean == null) {
                                    userDetailBean = new UserDetailBean();
                                }
                                userDetailBean.setId(toUserId);
                                userDetailBean.setStatus(FriendRelStatus.BOTH.getValue());
                                userDetailBean.setRemark(remark);
                                // 存到缓存
                                getCache().put(userDetailBean.getId(), userDetailBean);
                                getHandler().post(new SuccessRunnable<>(qsCallback, data));

                                FriendStatusBean friendStatusBean = new FriendStatusBean();
                                friendStatusBean.setStatus(FriendStatus.AGREE_ADD.getValue());
                                // 创建已经是好友的提示信息的系统消息
                                MessageBean messageBean = MessageBean.createChatSystemMessage(toUserId, userId, friendStatusBean);
                                IMClient.SINGLETON.handleMessage(messageBean);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
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
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.delete(userId, toUserId)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        // 移除缓存
                        getCache().remove(toUserId);

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

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 11:50
     * Description:设置备注
     *
     * @param toUserId 目标好友的 id
     * @param remark   目标好友的新备注
     */
    public void setRemark(final String toUserId, final String remark, final QSCallback<Object> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(userId, toUserId, remark, null, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                UserDetailBean userDetailBean = getById(toUserId);
                                userDetailBean.setRemark(remark);
                                getCache().put(userDetailBean.getId(), userDetailBean);

                                getHandler().post(new SuccessRunnable<>(qsCallback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(qsCallback, e));
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
    public void setTop(final String toUserId, final int top, final QSCallback<Object> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(userId, toUserId, null, top, null, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                UserDetailBean userDetailBean = getById(toUserId);
                                userDetailBean.setTop(top);
                                getCache().put(userDetailBean.getId(), userDetailBean);

                                getHandler().post(new SuccessRunnable<>(qsCallback, data));
                            }
                        });

                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(qsCallback, e));
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
    public void setDoNotDisturb(final String toUserId, final int doNotDisturb, final QSCallback<Object> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(userId, toUserId, null, null, doNotDisturb, null)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                UserDetailBean userDetailBean = getById(toUserId);
                                userDetailBean.setDoNotDisturb(doNotDisturb);
                                getCache().put(userDetailBean.getId(), userDetailBean);

                                getHandler().post(new SuccessRunnable<>(qsCallback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(qsCallback, e));
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
    public void setBlackList(final String toUserId, final int blackList, final QSCallback<Object> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setInfo(userId, toUserId, null, null, null, blackList)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(final Object data) {
                        getExecutorService().submit(new Runnable() {
                            @Override
                            public void run() {
                                // 更新缓存
                                UserDetailBean userDetailBean = getById(toUserId);
                                userDetailBean.setBlackList(blackList);
                                getCache().put(userDetailBean.getId(), userDetailBean);

                                getHandler().post(new SuccessRunnable<>(qsCallback, data));
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<>(qsCallback, e));
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
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getHistory(userId, page, pageSize)
                .transform(new QSApiTransformer<List<FriendHistoryBean>>())
                .enqueue(callback);
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2019/12/6 14:54
     * Description:获取单个好友信息
     *
     * @param toUserId 待查询的好友的 id
     */
    public void getInfo(String toUserId, QSCallback<UserDetailBean> qsCallback) {
        String userId = IMClient.SINGLETON.getUserDetailBean().getId();
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getInfo(userId, toUserId)
                .transform(new QSApiTransformer<UserDetailBean>())
                .enqueue(new Callback<UserDetailBean>() {
                    @Override
                    public void onSuccess(UserDetailBean data) {
                        // 存到缓存
                        getCache().put(data.getId(), data);
                        getHandler().post(new SuccessRunnable<UserDetailBean>(qsCallback, data));
                    }

                    @Override
                    public void onFailure(Exception e) {
                        getHandler().post(new FailureRunnable<UserDetailBean>(qsCallback, e));
                    }
                });
    }
}
