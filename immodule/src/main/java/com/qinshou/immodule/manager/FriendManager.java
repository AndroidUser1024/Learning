package com.qinshou.immodule.manager;

import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.immodule.db.dao.IFriendDao;
import com.qinshou.immodule.db.dao.impl.FriendDaoImpl;
import com.qinshou.immodule.listener.QSCallback;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/28 14:18
 * Description:好友管理者
 */
public class FriendManager {
    /**
     * 用户 Dao
     */
    private IFriendDao mFriendDao;

    public FriendManager() {
        mFriendDao = new FriendDaoImpl();
    }

    public int insertOrUpdate(FriendBean friendBean) {
        return mFriendDao.insertOrUpdate(friendBean);
    }

    public FriendBean getFriend(int id) {
        return mFriendDao.getById(id);
    }

    public void getFriendList(final QSCallback<List<FriendBean>> qsCallback) {
//        OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(IMClient.SINGLETON.getUserId())
//                .transform(new QSApiTransformer<List<FriendBean>>())
//                .enqueue(new Callback<List<FriendBean>>() {
//                    @Override
//                    public void onSuccess(List<FriendBean> data) {
//                        for (FriendBean friendBean : data) {
//                            mFriendDao.insertOrUpdate(friendBean);
//                        }
//                        qsCallback.onSuccess(data);
//                    }
//
//                    @Override
//                    public void onFailure(Exception e) {
//                        qsCallback.onFailure(e);
//                    }
//                });
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
