package com.qinshou.qinshoubox.me.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IChatContract;
import com.qinshou.qinshoubox.me.ui.activity.ChatActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的 M 层
 */
public class ChatModel implements IChatContract.IModel {
    @Override
    public void getUserInfo(String username, Callback<UserBean> jmCallback) {
    }
}