package com.qinshou.qinshoubox.friend.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.contract.ISetAdditionalMessageContract;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMessageFragment;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMessageFragment} 的 M 层
 */
public class SetAdditionalMessageModel implements ISetAdditionalMessageContract.IModel {
    @Override
    public void addFriend(int fromUserId, int toUserId, String remark, String additionalMessage, int source, Callback<Object> callback) {
        OkHttpHelperForQSBoxApi.SINGLETON.addFriend(fromUserId, toUserId, remark, additionalMessage, source)
                .transform(new QSApiTransformer<Object>())
                .enqueue(callback);
    }
}