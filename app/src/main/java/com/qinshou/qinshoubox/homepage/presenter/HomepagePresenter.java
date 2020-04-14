package com.qinshou.qinshoubox.homepage.presenter;

import com.jeejio.networkmodule.callback.Callback;
import com.qinshou.commonmodule.base.AbsPresenter;
import com.qinshou.qinshoubox.homepage.bean.NewsBean;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.homepage.model.HomepageModel;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;

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
        getModel().getWallpaperList(new Callback<PageResultBean<WallpaperBean>>() {
            @Override
            public void onSuccess(PageResultBean<WallpaperBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getWallpaperListSuccess(data.getList());
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

    @Override
    public void getNewsList(int page, int pageSize) {
        getModel().getNewsList(page, pageSize, new Callback<PageResultBean<NewsBean>>() {
            @Override
            public void onSuccess(PageResultBean<NewsBean> data) {
                if (!isViewAttached()) {
                    return;
                }
                getView().getNewsListSuccess(data.getList());
            }

            @Override
            public void onFailure(Exception e) {

                if (!isViewAttached()) {
                    return;
                }
                getView().getNewsListFailure(e);
            }
        });
    }
}
