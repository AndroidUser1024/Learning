package com.qinshou.qinshoubox.me.presenter;


import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.constant.IConstant;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IDataSettingContract;
import com.qinshou.qinshoubox.me.model.DataSettingModel;
import com.qinshou.qinshoubox.me.ui.fragment.DataSettingFragment;
import com.qinshou.qinshoubox.util.userstatusmanager.UserStatusManager;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/09/19 15:56
 * Description:{@link DataSettingFragment} 的 P 层
 */
public class DataSettingPresenter extends AbsPresenter<IDataSettingContract.IView, IDataSettingContract.IModel> implements IDataSettingContract.IPresenter {
    @Override
    public IDataSettingContract.IModel initModel() {
        return new DataSettingModel();
    }

    @Override
    public void logout(String username) {
        getModel().logout(username, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
            }

            @Override
            public void onFailure(Exception e) {
            }
        });
    }
}