package com.qinshou.qinshoubox.network;

import com.qinshou.okhttphelper.annotation.Api;
import com.qinshou.okhttphelper.annotation.Field;
import com.qinshou.okhttphelper.annotation.Json;
import com.qinshou.okhttphelper.annotation.Post;
import com.qinshou.okhttphelper.call.Call;
import com.qinshou.qinshoubox.constant.IUrlConstant;
import com.qinshou.qinshoubox.friend.bean.FriendHistoryBean;
import com.qinshou.qinshoubox.homepage.bean.QinshouResultBean;
import com.qinshou.qinshoubox.im.bean.FriendBean;

import java.util.List;

/**
 * Description:类描述
 * Author: MrQinshou
 * Date: 19-11-25 下午10:20
 */

@Api(IUrlConstant.DEFAULT_HOST + "/friend")
public interface QSBoxFriendApi {

    @Json
    @Post("/add")
    Call<QinshouResultBean<Object>> add(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId
            , @Field(name = "remark") String remark
            , @Field(name = "additionalMsg") String additionalMsg
            , @Field(name = "source") int source);

    @Json
    @Post("/agreeAdd")
    Call<QinshouResultBean<Object>> agreeAdd(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId
            , @Field(name = "remark") String remark);

    @Json
    @Post("/getHistory")
    Call<QinshouResultBean<List<FriendHistoryBean>>> getHistory(@Field(name = "page") int page
            , @Field(name = "pageSize") int pageSize
            , @Field(name = "id") String id);

    @Json
    @Post("/getList")
    Call<QinshouResultBean<List<FriendBean>>> getList(@Field(name = "id") String id);

    @Json
    @Post("/delete")
    Call<QinshouResultBean<Object>> delete(@Field(name = "fromUserId") String fromUserId
            , @Field(name = "toUserId") String toUserId);
}
