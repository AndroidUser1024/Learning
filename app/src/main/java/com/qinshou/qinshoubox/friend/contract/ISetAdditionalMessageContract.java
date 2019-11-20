package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.SetAdditionalMessageFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/12 10:01
 * Description:{@link SetAdditionalMessageFragment} 的契约类
 */
public interface ISetAdditionalMessageContract {
    interface IModel extends IBaseModel {
        void addFriend(int fromUserId, int toUserId, String remark, String additionalMessage, int source, Callback<Object> callback);
    }

    interface IView extends IBaseView {
        void addFriendSuccess();

        void addFriendFailure(Exception e);
    }

    interface IPresenter {

        void addFriend(int fromUserId, int toUserId, String remark, String additionalMessage, int source);
    }
}