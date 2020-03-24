package com.qinshou.qinshoubox.friend.model;


import com.qinshou.qinshoubox.friend.contract.IAddFriendContract;
import com.qinshou.qinshoubox.friend.view.fragment.AddFriendFragment;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.im.bean.UserDetailBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:25
 * Description:{@link AddFriendFragment} 的 M 层
 */
public class AddFriendModel implements IAddFriendContract.IModel {
    @Override
    public void getUserDetail(String keyword, QSCallback<UserDetailBean> qsCallback) {
        IMClient.SINGLETON.getUserManager().getUser(keyword, qsCallback);
    }
}