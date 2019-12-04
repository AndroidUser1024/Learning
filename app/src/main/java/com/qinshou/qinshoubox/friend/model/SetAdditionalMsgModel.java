package com.qinshou.qinshoubox.friend.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMsgContract;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMsgFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMsgFragment} 的 M 层
 */
public class SetAdditionalMsgModel implements ISetAdditionalMsgContract.IModel {
    @Override
    public void addFriend(String fromUserId, String toUserId, String remark, String additionalMsg, int source, Callback<Object> callback) {
        OkHttpHelperForQSBoxFriendApi.SINGLETON.add(fromUserId, toUserId, remark, additionalMsg, source)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }
}