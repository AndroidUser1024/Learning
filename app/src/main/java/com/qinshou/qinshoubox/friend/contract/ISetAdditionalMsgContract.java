package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMsgFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMsgFragment} 的契约类
 */
public interface ISetAdditionalMsgContract {
    interface IModel extends IBaseModel {
        void addFriend(String fromUserId, String toUserId, String remark, String additionalMsg, int source, Callback<Object> callback);
    }

    interface IView extends IBaseView {
        void addFriendSuccess();

        void addFriendFailure(Exception e);
    }

    interface IPresenter {
        void addFriend(String fromUserId, String toUserId, String remark, String additionalMsg, int source);
    }
}