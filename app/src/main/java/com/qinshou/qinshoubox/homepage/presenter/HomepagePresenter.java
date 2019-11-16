package com.qinshou.qinshoubox.homepage.presenter;

import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.homepage.model.HomepageModel;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 17:19
 * Description:{@link HomepageFragment} 的 P 层
 */
public class HomepagePresenter extends AbsPresenter<IHomepageContract.IView, IHomepageContract.IModel> implements IHomepageContract.IPresenter {

    @Override
    public IHomepageContract.IModel initModel() {
        return new HomepageModel();
    }

    @Override
    public void getWallpaperList() {
        getModel().getWallpaperList(new Callback<List<WallpaperBean>>() {
            @Override
            public void onSuccess(List<WallpaperBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getWallpaperListSuccess(data);
            }

            @Override
            public void onFailure(Exception e) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getWallpaperListFailure(e);
            }
        });
    }
}
