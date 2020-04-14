package com.qinshou.qinshoubox.login.contract;

import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.IBaseContract;
import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.login.view.fragment.LoginOrRegisterFragment;

/**
 * Description:{@link LoginOrRegisterFragment} 界面的契约类
 * Author: QinHao
 * Date: 2019/5/5 17:17
 */
public interface ILoginOrRegisterContract extends IBaseContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:42
         * Description:登录
         *
         * @param username 用户名
         * @param password 密码
         */
        void login(String username, String password, Callback<UserBean> callback);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:42
         * Description:注册
         *
         * @param username 用户名
         * @param password 密码
         */
        void register(String username, String password, Callback<UserBean> callback);
    }

    interface IView extends IBaseView {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:42
         * Description:登录成功
         *
         * @param userBean 用户信息
         */
        void loginSuccess(UserBean userBean);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:42
         * Description:登录失败
         *
         * @param e 错误信息
         */
        void loginFailure(Exception e);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:42
         * Description:注册成功
         *
         * @param userBean 用户信息
         */
        void registerSuccess(UserBean userBean);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:42
         * Description:注册失败
         *
         * @param e 错误信息
         */
        void registerFailure(Exception e);

    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:44
         * Description:登录
         *
         * @param username 用户名
         * @param password 密码
         */
        void login(String username, String password);

        /**
         * Author: QinHao
         * Email:cqflqinhao@126.com
         * Date:2020/1/10 17:44
         * Description:注册
         *
         * @param username 用户名
         * @param password 密码
         */
        void register(String username, String password);
    }
}
