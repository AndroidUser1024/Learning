package com.qinshou.qinshoubox.friend.contract;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.FriendFragment;
import com.qinshou.immodule.bean.GroupChatBean;
import com.qinshou.immodule.bean.UserBean;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/18 19:18
 * Description:{@link FriendFragment} 的契约类
 */
public interface IFriendContract {
    interface IModel extends IBaseModel {
        void getMyGroupChatList(Callback<List<GroupChatBean>> callback);

        void getFriendList(Callback<List<UserBean>> callback);
    }

    interface IView extends IBaseView {
        void getMyGroupChatListSuccess(List<GroupChatBean> groupChatBeanList);

        void getMyGroupChatListFailure(Exception e);

        void getFriendListSuccess(List<UserBean> userBeanList);

        void getFriendListFailure(Exception e);
    }

    interface IPresenter {
        void getMyGroupChatList();

        void getFriendList();
    }
}