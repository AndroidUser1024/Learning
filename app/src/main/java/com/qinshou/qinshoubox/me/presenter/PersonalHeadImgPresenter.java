package com.qinshou.qinshoubox.me.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.login.bean.UserBean;
import com.qinshou.qinshoubox.me.contract.IPersonalHeadImgContract;
import com.qinshou.qinshoubox.me.model.PersonalHeadImgModel;
import com.qinshou.qinshoubox.me.ui.fragment.PersonalHeadImgFragment;

import java.io.File;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/13 16:40
 * Description:{@link PersonalHeadImgFragment} 的 P 层
 */
public class PersonalHeadImgPresenter extends AbsPresenter<IPersonalHeadImgContract.IView, IPersonalHeadImgContract.IModel> implements IPersonalHeadImgContract.IPresenter {
    @Override
    public IPersonalHeadImgContract.IModel initModel() {
        return new PersonalHeadImgModel();
    }

    @Override
    public void setHeadImg(String userId, File file) {
        getModel().setHeadImg(userId, file, new Callback<UserBean>() {
            @Override
            public void onSuccess(UserBean data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setHeadImgSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().setHeadImgFailure(e);
            }
        });
    }
}