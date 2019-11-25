package com.qinshou.qinshoubox.demo.model;


import com.qinshou.okhttphelper.callback.Callback;
import com.qinshou.qinshoubox.demo.contract.IDemoContract;
import com.qinshou.qinshoubox.demo.view.activity.DemoActivity;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/07/11 18:26
 * Description:{@link DemoActivity} 的 M 层
 * M 层示例
 */
public class DemoModel implements IDemoContract.IModel {

    @Override
    public void demoRequest(Callback<Object> callback) {
//        OkHttpHelper.SINGLETON.newRequest(new GetMethod<Object>(), "url")
////                 添加请求头
//                .addHeader("name","value")
////                 添加参数
//                .addParameter("name","value")
//                .newCall()
////                 对请求结果进行转换,类似 RxJava 的 Function
//                .transform(new ResponseTransformer<Object, Object>() {
//                    @Override
//                    public Object transform(Object o) throws Exception {
//                        return null;
//                    }
//                })
//                .enqueue(callback);
    }
}