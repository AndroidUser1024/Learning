package com.qinshou.qinshoubox.me.contract;

import com.qinshou.commonmodule.base.IBaseContract;
import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.immodule.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.fragment.LoginOrRegisterFragment;

/**
 * Description:{@link LoginOrRegisterFragment} 界面的契约类
 * Author: QinHao
 * Date: 2019/5/5 17:17
 */
public interface ILoginOrRegisterContract extends IBaseContract {
    interface IView extends IBaseView {
        void loginSuccess(UserBean userBean);

        void loginFailure(Exception e);

        void registerSuccess(UserBean userBean);

        void registerFailure(Exception e);
    }

    interface IModel extends IBaseModel {
        void login(String username, String password, Callback<UserBean> callback);

        void register(String username, String password, Callback<UserBean> callback);
    }

    interface IPresenter {
        void login(String username, String password);

        void register(String username, String password);
    }
}
