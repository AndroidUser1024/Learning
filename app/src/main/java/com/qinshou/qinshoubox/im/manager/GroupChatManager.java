package com.qinshou.qinshoubox.im.manager;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
import com.qinshou.qinshoubox.im.db.dao.IGroupChatDao;
import com.qinshou.qinshoubox.im.db.dao.impl.GroupChatDaoImpl;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxGroupChatApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/26 14:07
 * Description:群聊管理者
 */
public class GroupChatManager {
    /**
     * 用户 Dao
     */
    private IGroupChatDao mGroupChatDao;

    public GroupChatManager() {
        mGroupChatDao = new GroupChatDaoImpl();
    }

    public int insertOrUpdate(GroupChatBean groupChatBean) {
        return mGroupChatDao.insertOrUpdate(groupChatBean);
    }

    public GroupChatBean getById(int id) {
        return mGroupChatDao.getById(id);
    }

    public void getGroupChatList(final QSCallback<List<GroupChatBean>> qsCallback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMyGroupChatList(UserStatusManager.SINGLETON.getUserBean().getId())
                .transform(new QSApiTransformer<List<GroupChatBean>>())
                .enqueue(new Callback<List<GroupChatBean>>() {
                    @Override
                    public void onSuccess(List<GroupChatBean> data) {
                        for (GroupChatBean groupChatBean : data) {
                            mGroupChatDao.insertOrUpdate(groupChatBean);
                        }
                        qsCallback.onSuccess(data);
                    }

                    @Override
                    public void onFailure(Exception e) {
                        qsCallback.onFailure(e);
                    }
                });
    }
}
