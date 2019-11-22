package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ICreateGroupChatContract;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.qinshoubox.me.bean.GroupChatBean;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxGroupChatApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/19 17:27
 * Description:{@link CreateGroupChatFragment} 的 M 层
 */
public class CreateGroupChatModel implements ICreateGroupChatContract.IModel {

    @Override
    public void getFriendList(int fromUserId, Callback<List<UserBean>> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.getFriendList(fromUserId)
                .transform(new QSApiTransformer<List<UserBean>>())
                .enqueue(callback);
    }

    @Override
    public void createGroupChat(int ownerId, List<Integer> memberIdList, String nickname, String headImg, Callback<GroupChatBean> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.create(ownerId, memberIdList, nickname, headImg)
                .transform(new QSApiTransformer<GroupChatBean>())
                .enqueue(callback);
    }
}