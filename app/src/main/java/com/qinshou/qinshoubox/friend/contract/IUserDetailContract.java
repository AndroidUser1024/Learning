package com.qinshou.qinshoubox.friend.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.friend.view.fragment.UserDetailFragment;
import com.qinshou.qinshoubox.me.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/11 20:08
 * Description:{@link UserDetailFragment} 的契约类
 */
public interface IUserDetailContract {
    interface IModel extends IBaseModel {
        void getUserDetail(int userId, String keyword, Callback<UserBean> callback);
    }

    interface IView extends IBaseView {
        void showFriendUI(UserBean userBean);

        void showNotFriendUI(UserBean userBean);

        void showWaitAcceptUI(UserBean userBean);

        void getUserDetailFailure(Exception e);
    }

    interface IPresenter {
        void getUserDetail(int userId, String keyword);
    }
}