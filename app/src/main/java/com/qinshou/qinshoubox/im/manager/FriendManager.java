package com.qinshou.qinshoubox.im.manager;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.db.dao.IFriendDao;
import com.qinshou.qinshoubox.im.db.dao.impl.FriendDaoImpl;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

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

    public FriendBean getUser(int id) {
        return mFriendDao.getById(id);
    }

    public void getFriendList(final QSCallback<List<FriendBean>> qsCallback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.getList(IMClient.SINGLETON.getUserId())
                .transform(new QSApiTransformer<List<FriendBean>>())
                .enqueue(new Callback<List<FriendBean>>() {
                    @Override
                    public void onSuccess(List<FriendBean> data) {
                        for (FriendBean friendBean : data) {
                            mFriendDao.insertOrUpdate(friendBean);
                        }
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }

    public void setRemark(int toUserId, String remark, final QSCallback<Object> qsCallback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.setRemark(IMClient.SINGLETON.getUserId(), toUserId, remark)
                .transform(new QSApiTransformer<Object>())
                .enqueue(new Callback<Object>() {
                    @Override
                    public void onSuccess(Object data) {
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }
}
