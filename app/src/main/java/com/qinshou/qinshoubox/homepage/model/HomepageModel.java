package com.qinshou.qinshoubox.homepage.model;

import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.homepage.bean.NewsBean;
import com.qinshou.qinshoubox.homepage.bean.PageResultBean;
import com.qinshou.qinshoubox.homepage.bean.WallpaperBean;
import com.qinshou.qinshoubox.homepage.contract.IHomepageContract;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxNewsApi;
import com.qinshou.qinshoubox.network.OkHttpHelperForQSBoxWallpaperApi;
import com.qinshou.qinshoubox.network.QSBoxWallpaperApi;
import com.qinshou.qinshoubox.transformer.QSApiTransformer;
import com.qinshou.qinshoubox.homepage.ui.fragment.HomepageFragment;

import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/10/16 17:18
 * Description:{@link HomepageFragment} 的 M 层
 */
public class HomepageModel implements IHomepageContract.IModel {
    @Override
    public void getWallpaperList(Callback<PageResultBean<WallpaperBean>> callback) {
        OkHttpHelperForQSBoxWallpaperApi.SINGLETON.getWallpaperList(1, 5)
                .transform(new QSApiTransformer<PageResultBean<WallpaperBean>>())
                .enqueue(callback);
    }

    @Override
    public void getNewsList(int page, int pageSize, Callback<PageResultBean<NewsBean>> callback) {
        OkHttpHelperForQSBoxNewsApi.SINGLETON.getList(page, pageSize)
                .transform(new QSApiTransformer<PageResultBean<NewsBean>>())
                .enqueue(callback);
    }
}
