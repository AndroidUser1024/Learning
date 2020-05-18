package com.qinshou.qinshoubox;

import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/6/11 10:03
 * Description:{@link MainActivity} 的契约类
 */
public interface IMainContract {
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
    }
}
