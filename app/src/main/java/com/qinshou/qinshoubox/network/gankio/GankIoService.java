package com.qinshou.qinshoubox.network.gankio;

import com.qinshou.qinshoubox.homepage.bean.GankIoApiResult;
import com.qinshou.qinshoubox.homepage.bean.WelfareBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Description:GankIoApi 的所有接口
 * Date:2018/4/9
 */
public interface GankIoService {
    @GET("data/福利/{pageSize}/{page}")
    Observable<GankIoApiResult<List<WelfareBean>>> getBeautyGirls(@Path("pageSize") int pageSize, @Path("page") int page);
}