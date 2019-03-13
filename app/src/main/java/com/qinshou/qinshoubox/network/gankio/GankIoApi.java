package com.qinshou.qinshoubox.network.gankio;


import com.qinshou.networkmodule.CustomRetrofitBuilder;
import com.qinshou.qinshoubox.homepage.bean.WelfareBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:GankIoApi 的网络请求类
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class GankIoApi {
    private GankIoService mGankIoService;

    public static GankIoApi getInstance() {
        return SingleHolder.instance;
    }

    private static class SingleHolder {
        private static final GankIoApi instance = new GankIoApi();
    }

    private GankIoApi() {
        mGankIoService = new CustomRetrofitBuilder().build("http://gank.io/api/").create(GankIoService.class);
    }

    public void getBeautyGirls(int pageSize, int page, Observer<List<WelfareBean>> observer) {
        mGankIoService.getBeautyGirls(pageSize, page)
                .map(new GankIoApiResultFunction<List<WelfareBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
