package com.qinshou.qinshoubox;

import android.text.format.Time;
import android.util.Log;

import com.qinshou.commonmodule.base.BaseApplication;
import com.qinshou.commonmodule.crash.CrashHandler;
import com.qinshou.commonmodule.util.SharedPreferencesHelper;
import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.networkmodule.OkHttpHelper;
import com.qinshou.networkmodule.interceptor.LogInterceptor;
import com.qinshou.qinshoubox.im.IMClient;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/4/10
 */

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
//        //初始化友盟推送
//        PushHelper.init(this, IConstant.UMENG_KEY, IConstant.UMENG_SECRET);
//        //初始化第三方分享
//        ShareUtil.init(this);
        // 初始化共享参数帮助者类
        SharedPreferencesHelper.SINGLETON.init(this);
        // 初始化全局异常处理者类
        CrashHandler.SINGLETON.init(this);
        IMClient.SINGLETON.init(this);
        com.qinshou.im.IMClient.SINGLETON.init(this);
        OkHttpHelper.SINGLETON.recreateOkHttpClient(new OkHttpClient().newBuilder()
                .addInterceptor(new LogInterceptor(LogInterceptor.Level.BODY, new LogInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.i("daolema", "message--->" + message);
                    }
                }))
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .sslSocketFactory(getSSLContext().getSocketFactory())
                .hostnameVerifier(getHostnameVerifier())
                .build());
    }

    private SSLContext getSSLContext() {
        SSLContext sslContext = null;
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            InputStream is = getAssets().open("qinshouboxserver.cer");
            keyStore.setCertificateEntry("qinshouboxserver", certificateFactory.generateCertificate(is));
            if (is != null) {
                is.close();
            }
            sslContext = SSLContext.getInstance("SSL");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            // 初始化双向客户端 keyStore
            KeyStore clientKeyStore = KeyStore.getInstance("BKS");
            clientKeyStore.load(getAssets().open("qinshouboxclient.bks"), "qinshouboxclient".toCharArray());
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(clientKeyStore, "qinshouboxclient".toCharArray());
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslContext;
    }
//    /**
//     * Author: QinHao
//     * Email:qinhao@jeejio.com
//     * Date:2019/11/25 11:24
//     * Description:获取 SSL 证书验证
//     */
//    private SSLContext getSSLContext() {
//        SSLContext sslContext = null;
//        try {
//            sslContext = SSLContext.getInstance("SSL");
//
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            InputStream inputStream = getAssets().open("qinshouboxserver.cer");
//
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(null,null);
//            keyStore.setCertificateEntry("qinshouboxserver", certificateFactory.generateCertificate(inputStream));
//            if (inputStream != null) {
//                inputStream.close();
//            }
//
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(keyStore);
//
//            // 初始化双向客户端 keyStore
//            KeyStore clientKeyStore = KeyStore.getInstance("BKS");
//            clientKeyStore.load(getAssets().open("qinshouboxclient.bks"), "qinshouboxclient".toCharArray());
//            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            keyManagerFactory.init(clientKeyStore, "qinshouboxclient".toCharArray());
//            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sslContext;
//    }

    //获取HostnameVerifier
    public static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String s, SSLSession sslSession) {
                ShowLogUtil.logi("s--->" + s);
                return true;
            }
        };
        return hostnameVerifier;
    }

}
