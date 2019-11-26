package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.im.bean.UserBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的契约类
 */
public interface IUserDetailContract {
    interface IModel extends IBaseModel {
        void getUserDetail(String keyword, QSCallback<UserBean> qsCallback);

        void agreeAddFriend(int fromUserId, int toUserId, String remark, Callback<UserBean> callback);

        void deleteFriend(int toUserId, Callback<Object> callback);
    }

    interface IView extends IBaseView {
        void showFriendUI(UserBean userBean);

        void showNotFriendUI(UserBean userBean);

        void showWaitAcceptUI(UserBean userBean);

        void getUserDetailFailure(Exception e);

        void agreeAddFriendSuccess(UserBean userBean);

        void agreeAddFriendFailure(Exception e);

        void deleteFriendSuccess();

        void deleteFriendFailure(Exception e);
    }

    interface IPresenter {
        void getUserDetail(String keyword);

        void agreeAddFriend(int fromUserId, int toUserId, String remark);

        void deleteFriend(int toUserId);
    }
}