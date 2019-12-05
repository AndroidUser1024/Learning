package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ICreateGroupChatContract;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.immodule.bean.FriendBean;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.listener.QSCallback;
import com.qinshou.qinshoubox.im.IMClient;
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
    public void getFriendList(int fromUserId, QSCallback<List<FriendBean>> qsCallback) {
//        IMClient.SINGLETON.getFriendManager().getFriendList(qsCallback);
    }

    @Override
    public void createGroupChat(int ownerId, List<Integer> memberIdList, String nickname, String headImg, Callback<GroupChatBean> callback) {
        OkHttpHelperForQSBoxGroupChatApi.SINGLETON.create(ownerId, memberIdList, nickname, headImg)
                .transform(new QSApiTransformer<GroupChatBean>())
                .enqueue(callback);
    }
}