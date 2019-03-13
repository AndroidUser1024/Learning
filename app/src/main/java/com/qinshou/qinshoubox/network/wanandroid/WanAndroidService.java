package com.qinshou.qinshoubox.network.wanandroid;

import com.qinshou.qinshoubox.homepage.bean.ArticleListBean;
import com.qinshou.qinshoubox.homepage.bean.WanAndroidApiResult;
import com.qinshou.qinshoubox.knowledgesystem.bean.CommonWebSiteBean;
import com.qinshou.qinshoubox.knowledgesystem.bean.HotSearchWordsBean;
import com.qinshou.qinshoubox.knowledgesystem.bean.KnowledgeSystemBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Description:WanAndroidApi 的所有接口
 * Date:2018/4/9
 */
public interface WanAndroidService {
    @GET("article/list/{page}/json")
    Observable<WanAndroidApiResult<ArticleListBean>> getHomepage(@Path("page") int page);

    @GET("tree/json")
    Observable<WanAndroidApiResult<List<KnowledgeSystemBean>>> getKnowledgeSystem();

    @GET("hotkey/json")
    Observable<WanAndroidApiResult<List<HotSearchWordsBean>>> getHotSearchWords();

    @GET("friend/json")
    Observable<WanAndroidApiResult<List<CommonWebSiteBean>>> getCommonWebSite();

    @FormUrlEncoded
    @POST("article/query/{page}/json")
    Observable<WanAndroidApiResult<ArticleListBean>> search(@Path("page") int page, @Field("k") String searchKeyWords);

    @FormUrlEncoded
    @POST("lg/collect/{id}/json")
    Observable<String> addCollection(@Path("id") int id, @Field("id") int postId);

    @FormUrlEncoded
    @POST("lg/uncollect/{id}/json")
    Observable<String> cancelCollection(@Path("id") int id, @Field("id") int postId);

    @GET("lg/collect/list/{page}/json")
    Observable<WanAndroidApiResult<ArticleListBean>> getMyCollection(@Path("page") int page);
}