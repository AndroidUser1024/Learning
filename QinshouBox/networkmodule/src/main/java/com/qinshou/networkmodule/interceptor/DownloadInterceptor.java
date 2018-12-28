package com.qinshou.networkmodule.interceptor;

import android.support.annotation.NonNull;

import com.qinshou.networkmodule.listener.OnDownloadListener;
import com.qinshou.networkmodule.response.DownloadResponseBody;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Description:使用实例
 * Date:2018/11/28
 * public void downloadFile(String url, OnDownloadListener downloadListener, Observer<InputStream> observer) {
 * Observable<InputStream> observable = new CustomRetrofitBuilder()
 * .addInterceptor(new DownloadInterceptor(downloadListener))
 * .build(baseUrl)
 * .create(Service.class)
 * .downloadFile(url)
 * .map(new Function<ResponseBody, InputStream>() {
 *
 * @Override public InputStream apply(ResponseBody responseBody) throws Exception {
 * return responseBody.byteStream();
 * }
 * })
 * .subscribeOn(Schedulers.io())
 * .unsubscribeOn(Schedulers.io())
 * .observeOn(Schedulers.computation())
 * .doOnNext(new Consumer<InputStream>() {
 * @Override public void accept(InputStream inputStream) throws Exception {
 * FileUtil.writeFile(inputStream, FileUtil.getSDCardPath()
 * + File.separator + "Demo"
 * + File.separator + "Starry_Night_Over_the_Rhone.jpg");
 * }
 * })
 * .observeOn(AndroidSchedulers.mainThread());
 * if (observer != null) {
 * observable.subscribe(observer);
 * } else {
 * observable.subscribe();
 * }
 * }
 * <p>
 * <p>
 * <p>
 * <p>
 * 下载接口
 * @Headers("Accept-Encoding:identity")
 * @Streaming //大文件时要加不然会OOM
 * @GET Observable<ResponseBody> downloadFile(@Url String fileUrl);
 */
public class DownloadInterceptor implements Interceptor {
    private OnDownloadListener mOnDownloadListener;

    public DownloadInterceptor(OnDownloadListener onDownloadListener) {
        this.mOnDownloadListener = onDownloadListener;
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        ResponseBody responseBody = response.body();
        if (responseBody == null) {
            return response;
        }
        return response.newBuilder().body(new DownloadResponseBody(responseBody, mOnDownloadListener)).build();
    }
}