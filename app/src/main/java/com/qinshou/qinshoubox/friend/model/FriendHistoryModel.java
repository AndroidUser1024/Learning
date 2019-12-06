package com.qinshou.qinshoubox.friend.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.friend.contract.IFriendHistoryContract;
import com.qinshou.qinshoubox.friend.view.fragment.FriendHistoryFragment;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.im.IMClient;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxFriendApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/08/21 14:03
 * Description:{@link FriendHistoryFragment} 的 M 层
 */
public class FriendHistoryModel implements IFriendHistoryContract.IModel {
    @Override
    public void getFriendHistory(int page, int pageSize, Callback<List<FriendHistoryBean>> callback) {
        IMClient.SINGLETON.getFriendManager().getHistory(page, pageSize, callback);
    }
}