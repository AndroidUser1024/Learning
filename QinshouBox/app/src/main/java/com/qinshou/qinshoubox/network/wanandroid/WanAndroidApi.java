package com.qinshou.qinshoubox.network.wanandroid;


import com.qinshou.networkmodule.CustomRetrofitBuilder;
import com.qinshou.networkmodule.interceptor.GetCookieInterceptor;
import com.qinshou.networkmodule.interceptor.SetCookieInterceptor;
import com.qinshou.qinshoubox.App;
import com.qinshou.qinshoubox.homepage.bean.ArticleListBean;
import com.qinshou.qinshoubox.knowledgesystem.bean.CommonWebSiteBean;
import com.qinshou.qinshoubox.knowledgesystem.bean.HotSearchWordsBean;
import com.qinshou.qinshoubox.knowledgesystem.bean.KnowledgeSystemBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:WanAndroidApi 的网络请求类
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class WanAndroidApi {
    private WanAndroidService mWanAndroidService;

    public static WanAndroidApi getInstance() {
        return SingleHolder.instance;
    }

    private static class SingleHolder {

        private static final WanAndroidApi instance = new WanAndroidApi();
    }

    private WanAndroidApi() {
        mWanAndroidService = new CustomRetrofitBuilder()
                .addInterceptor(new GetCookieInterceptor(App.getInstance()))
                .addInterceptor(new SetCookieInterceptor(App.getInstance()))
                .build("http://www.wanandroid.com/")
                .create(WanAndroidService.class);
    }

    /**
     * Description:获取首页文章
     * Date:2018/4/16
     */
    public void getHomepage(int page, Observer<ArticleListBean> observer) {
        mWanAndroidService.getHomepage(page)
                .map(new WanAndroidApiResultFunction<ArticleListBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:获取知识体系结构
     * Date:2018/4/16
     */
    public void getKnowledgeSystem(Observer<List<KnowledgeSystemBean>> observer) {
        mWanAndroidService.getKnowledgeSystem()
                .map(new WanAndroidApiResultFunction<List<KnowledgeSystemBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:获取热门搜索词
     * Date:2018/4/16
     */
    public void getHotSearchWords(Observer<List<HotSearchWordsBean>> observer) {
        mWanAndroidService.getHotSearchWords()
                .map(new WanAndroidApiResultFunction<List<HotSearchWordsBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:获取常用网站
     * Date:2018/4/16
     */
    public void getCommonWebSite(Observer<List<CommonWebSiteBean>> observer) {
        mWanAndroidService.getCommonWebSite()
                .map(new WanAndroidApiResultFunction<List<CommonWebSiteBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:搜索
     * Date:2018/4/19
     */
    public void search(int page, String searchKeyWords, Observer<ArticleListBean> observer) {
        mWanAndroidService.search(page, searchKeyWords)
                .map(new WanAndroidApiResultFunction<ArticleListBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:添加收藏
     * Date:2018/4/19
     */
    public void addCollection(int id, Observer<String> observer) {
        mWanAndroidService.addCollection(id, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:取消收藏
     * Date:2018/4/19
     */
    public void cancelCollection(int id, Observer<String> observer) {
        mWanAndroidService.cancelCollection(id, id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Description:我的收藏
     * Date:2018/4/19
     */
    public void getMyCollection(int page, Observer<ArticleListBean> observer) {
        mWanAndroidService.getMyCollection(page)
                .map(new WanAndroidApiResultFunction<ArticleListBean>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
