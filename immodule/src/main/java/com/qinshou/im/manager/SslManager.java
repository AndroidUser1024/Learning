package com.qinshou.im.manager;

import android.content.Context;
import android.util.Log;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManagerFactory;

import io.netty.handler.ssl.SslHandler;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/22 14:18
 * Description:类描述
 */
public class SslManager {
    private static final String TAG = SslManager.class.getSimpleName();

    public static SslHandler getSslHandler(Context context) {
        SSLEngine sslEngine = getSSLContext(context).createSSLEngine();
        sslEngine.setUseClientMode(true);
        // false 为单向认证，true 为双向认证
        sslEngine.setNeedClientAuth(true);
        SslHandler sslHandler = new SslHandler(sslEngine);
        return sslHandler;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/11/25 11:24
     * Description:获取 SSL 证书验证
     */
    private static SSLContext getSSLContext(Context context) {
        SSLContext sslContext = null;
        try {
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            KeyStore keyStore = KeyStore.getInstance("BKS");
            String keyStorePass = "qinshouboxclient";
            InputStream inputStream = context.getAssets().open("qinshouboxclient.bks");
            keyStore.load(inputStream, keyStorePass.toCharArray());
            keyManagerFactory.init(keyStore, keyStorePass.toCharArray());

            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
            inputStream = context.getAssets().open("qinshouboxclient.bks");
            keyStore = KeyStore.getInstance("BKS");
            keyStorePass = "qinshouboxclient";
            keyStore.load(inputStream, keyStorePass.toCharArray());
            trustManagerFactory.init(keyStore);

            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
//            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
//            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
//            keyStore.load(null);
////            InputStream is = context.getAssets().open("qinshouboxserver.bks");
////            keyStore.setCertificateEntry("qinshouboxserver", certificateFactory.generateCertificate(is));
//            InputStream is = context.getAssets().open("qinshouboxserver.cer");
//            keyStore.setCertificateEntry("qinshouboxserver", certificateFactory.generateCertificate(is));
//            if (is != null) {
//                is.close();
//            }
//            sslContext = SSLContext.getInstance("SSLv3");
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
//            trustManagerFactory.init(keyStore);
//
//            // 初始化双向客户端 keyStore
//            KeyStore clientKeyStore = KeyStore.getInstance("BKS");
//            clientKeyStore.load(context.getAssets().open("qinshouboxclient.bks"), "qinshouboxclient".toCharArray());
//            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
//            keyManagerFactory.init(clientKeyStore, "qinshouboxclient".toCharArray());
//            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sslContext;
    }
}
