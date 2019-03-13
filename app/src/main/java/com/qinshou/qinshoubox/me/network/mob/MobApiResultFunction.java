package com.qinshou.qinshoubox.me.network.mob;


import android.text.TextUtils;

import com.qinshou.qinshoubox.me.bean.MobApiResultBean;

import io.reactivex.functions.Function;

/**
 * Description:易源 Api 返回数据的统一处理类,只关注真实数据,不需要错误吗和错误信息
 * Created by 禽兽先生
 * Created on 2018/1/6
 */

public class MobApiResultFunction<T> implements Function<MobApiResultBean<T>, T> {

    @Override
    public T apply(MobApiResultBean<T> tMobApiResult) throws Exception {
        if (!TextUtils.equals("success", tMobApiResult.getMsg()) && tMobApiResult.getRetCode() == 200) {
            throw new Exception("错误码：" + tMobApiResult.getRetCode() + "，msg：" + tMobApiResult.getMsg());
        }
        return tMobApiResult.getResult();
    }
}