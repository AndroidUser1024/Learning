package com.qinshou.qinshoubox.friend.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.qinshoubox.me.bean.GroupChatBean;
import com.qinshou.qinshoubox.me.bean.UserBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的契约类
 */
public interface IFriendContract {
    interface IModel extends IBaseModel {
        void getFriendList(int fromUserId, Callback<List<UserBean>> callback);

        void getMyGroupChatList(int userId, Callback<List<GroupChatBean>> callback);
    }

    interface IView extends IBaseView {
        void getFriendListSuccess(List<UserBean> userBeanList);

        void getFriendListFailure(Exception e);

        void getMyGroupChatListSuccess(List<GroupChatBean> groupChatBeanList);

        void getMyGroupChatListFailure(Exception e);
    }

    interface IPresenter {
        void getFriendList(int fromUserId);

        void getMyGroupChatList(int userId);
    }
}