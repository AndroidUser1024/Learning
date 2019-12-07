package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ICreateGroupChatContract;
import com.qinshou.qinshoubox.friend.view.fragment.CreateGroupChatFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.listener.QSCallback;
import com.qinshou.qinshoubox.im.bean.FriendBean;
import com.qinshou.qinshoubox.im.bean.GroupChatBean;
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
    public void getFriendList(Callback<List<FriendBean>> callback) {
        IMClient.SINGLETON.getFriendManager().getList(callback);
    }

    @Override
    public void createGroupChat( List<String> memberIdList, String nickname, String headImg, Callback<GroupChatBean> callback) {
        IMClient.SINGLETON.getGroupChatManager().create( memberIdList, nickname, headImg, callback);
    }
}