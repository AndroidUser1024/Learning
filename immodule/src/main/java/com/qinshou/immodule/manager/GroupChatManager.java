package com.qinshou.immodule.manager;

import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.db.dao.IGroupChatDao;
import com.qinshou.immodule.db.dao.impl.GroupChatDaoImpl;
import com.qinshou.immodule.listener.QSCallback;

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
//        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.getMyGroupChatList(IMClient.SINGLETON.getUserId())
//                .transform(new QSApiTransformer<List<GroupChatBean>>())
//                .enqueue(new Callback<List<GroupChatBean>>() {
//                    @Override
//                    public void onSuccess(List<GroupChatBean> data) {
//                        for (GroupChatBean groupChatBean : data) {
//                            mGroupChatDao.insertOrUpdate(groupChatBean);
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
