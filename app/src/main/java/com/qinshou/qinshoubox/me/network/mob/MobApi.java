package com.qinshou.qinshoubox.me.network.mob;


import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.networkmodule.CustomRetrofitBuilder;
import com.qinshou.networkmodule.interceptor.HttpParameterInterceptor;
import com.qinshou.networkmodule.interceptor.LogInterceptor;
import com.qinshou.qinshoubox.me.bean.ProvinceBean;
import com.qinshou.qinshoubox.me.bean.WeatherBean;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:MobApi 的网络请求类
 * Created by 禽兽先生
 * Created on 2018/4/4
 */

public class MobApi {
    private MobService mMobService;

    public static MobApi getInstance() {
        return SingleHolder.instance;
    }

    private static class SingleHolder {
        private static final MobApi instance = new MobApi();
    }

    private MobApi() {
        mMobService = new CustomRetrofitBuilder()
                .addInterceptor(new HttpParameterInterceptor.Builder()
                        .addHeaderParameter("key", "248dc56241a12")
                        .build()
                )
                .addInterceptor(new LogInterceptor(LogInterceptor.Level.BASIC, new LogInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        ShowLogUtil.logi(message);
                    }
                }))
                .build("http://apicloud.mob.com/")
                .create(MobService.class);
    }

    public void queryCityList(Observer<List<ProvinceBean>> observer) {
        mMobService.queryCityList()
                .map(new MobApiResultFunction<List<ProvinceBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void queryWeatherByCity(String province, String city, Observer<List<WeatherBean>> observer) {
        mMobService.queryWeatherByCity(province, city)
                .map(new MobApiResultFunction<List<WeatherBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void queryWeatherByIp(String ip, Observer<List<WeatherBean>> observer) {
        mMobService.queryWeatherByIp(ip)
                .map(new MobApiResultFunction<List<WeatherBean>>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
