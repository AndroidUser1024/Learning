package com.qinshou.qinshoubox.me.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.activity.ChatActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/06/20 10:26
 * Description:{@link ChatActivity} 的契约类
 */
public interface IChatContract {
    interface IModel extends IBaseModel {
        void getUserInfo(String username, Callback<UserBean> jmCallback);
    }

    interface IView extends IBaseView {
        void getUserInfoSuccess(UserBean userBean);

        void getUserInfoFailure(Exception e);
    }

    interface IPresenter {
        void getUserInfo(String username);
    }
}