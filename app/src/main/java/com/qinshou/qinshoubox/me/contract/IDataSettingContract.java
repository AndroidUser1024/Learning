package com.qinshou.qinshoubox.me.contract;


import com.qinshou.commonmodule.base.IBaseModel;
import com.qinshou.commonmodule.base.IBaseView;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.me.bean.UserBean;
import com.qinshou.qinshoubox.me.ui.fragment.DataSettingFragment;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/19 15:56
 * Description:{@link DataSettingFragment} 的契约类
 */
public interface IDataSettingContract {
    interface IModel extends IBaseModel {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/18 18:54
         * Description:退出登录
         *
         * @param username 登录
         * @param callback 回调接口
         */
        void logout(String username, Callback<UserBean> callback);
    }

    interface IView extends IBaseView {
    }

    interface IPresenter {
        /**
         * Author: QinHao
         * Email:qinhao@jeejio.com
         * Date:2019/11/18 18:54
         * Description:退出登录
         *
         * @param username 登录
         */
        void logout(String username);
    }
}