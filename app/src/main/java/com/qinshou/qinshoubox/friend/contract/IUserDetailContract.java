package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.bean.UserDetailBean;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.im.listener.QSCallback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的契约类
 */
public interface IUserDetailContract {
    interface IModel extends IBaseModel {
        void getUserDetail(String keyword, Callback<UserDetailBean> callback);

        void agreeAddFriend(String fromUserId, String toUserId, String remark, Callback<Object> callback);

        void deleteFriend(String toUserId, Callback<Object> callback);

        void setRemark(String toUserId, String remark, Callback<Object> callback);
    }

    interface IView extends IBaseView {
        void getUserDetailSuccess(UserDetailBean userDetailBean);

        void getUserDetailFailure(Exception e);

        void agreeAddFriendSuccess();

        void agreeAddFriendFailure(Exception e);

        void deleteFriendSuccess();

        void deleteFriendFailure(Exception e);

        void setRemarkSuccess();

        void setRemarkFailure(Exception e);
    }

    interface IPresenter {
        void getUserDetail(String keyword);

        void agreeAddFriend(String fromUserId, String toUserId, String remark);

        void deleteFriend(String toUserId);

        void setRemark(String toUserId, String remark);
    }
}