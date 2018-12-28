package com.qinshou.qinshoubox.me.network.mob;

import com.qinshou.qinshoubox.me.bean.MobApiResultBean;
import com.qinshou.qinshoubox.me.bean.ProvinceBean;
import com.qinshou.qinshoubox.me.bean.WeatherBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Description:MobApi 的所有接口
 * Date:2018/4/9
 */
public interface MobService {
    @GET("/v1/weather/citys")
    Observable<MobApiResultBean<List<ProvinceBean>>> queryCityList();

    @GET("/v1/weather/query")
    Observable<MobApiResultBean<List<WeatherBean>>> queryWeatherByCity(@Query("province") String province, @Query("city") String city);

    @GET("/v1/weather/ip")
    Observable<MobApiResultBean<List<WeatherBean>>> queryWeatherByIp(@Query("ip") String ip);
}