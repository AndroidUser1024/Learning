package com.qinshou.im.manager;


import android.content.Context;

import javax.net.ssl.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;

public class ContextSSLFactory {

    private SSLContext mSslContextServer;

    private SSLContext mSslContextClient;


    public ContextSSLFactory(Context context) {
//        SSLContext sslContext = null;
        SSLContext sslContext2 = null;
        try {
//            sslContext = SSLContext.getInstance("SSLv3");
            sslContext2 = SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e1) {
            e1.printStackTrace();
        }
        try {
//            if (getKeyManagersServer(context) != null && getTrustManagersServer(context) != null) {
//                sslContext.init(getKeyManagersServer(context), getTrustManagersServer(context), null);
//            }
            if (getKeyManagersClient(context) != null && getTrustManagersClient(context) != null) {
                sslContext2.init(getKeyManagersClient(context), getTrustManagersClient(context), null);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
//        sslContext.createSSLEngine().getSupportedCipherSuites();
        sslContext2.createSSLEngine().getSupportedCipherSuites();
//        mSslContextServer = sslContext;
        mSslContextClient = sslContext2;
    }

    public SSLContext getSslContext() {
        return mSslContextServer;
    }

    public SSLContext getSslContext2() {
        return mSslContextClient;
    }

    private TrustManager[] getTrustManagersServer(Context context) {
        InputStream is = null;
        KeyStore ks = null;
        TrustManagerFactory keyFac = null;

        TrustManager[] kms = null;
        try {
            // 获得KeyManagerFactory对象. 初始化位默认算法
            keyFac = TrustManagerFactory.getInstance("SunX509");
//            is = new FileInputStream((new ClassPathResource("qinshouboxserver.jks")).getFile());
            is = context.getAssets().open("qinshouboxserver.jks");
            System.out.println("is--->" + is.available());
            ks = KeyStore.getInstance("JKS");
            String keyStorePass = "qinshouboxserver";
            ks.load(is, keyStorePass.toCharArray());
            keyFac.init(ks);
            kms = keyFac.getTrustManagers();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return kms;
    }

    private static TrustManager[] getTrustManagersClient(Context context) {
        InputStream is = null;
        KeyStore ks = null;
        TrustManagerFactory keyFac = null;

        TrustManager[] kms = null;
        try {
            // 获得KeyManagerFactory对象. 初始化位默认算法
            keyFac = TrustManagerFactory.getInstance("BKS");
//            is = new FileInputStream((new ClassPathResource("qinshouboxclient.jks")).getFile());
            is = context.getAssets().open("qinshouboxclient.jks");
            System.out.println("is--->" + is.available());
            ks = KeyStore.getInstance("JKS");
            String keyStorePass = "qinshouboxclient";
            ks.load(is, keyStorePass.toCharArray());
            keyFac.init(ks);
            kms = keyFac.getTrustManagers();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return kms;
    }

    private static KeyManager[] getKeyManagersServer(Context context) {
        InputStream is = null;
        KeyStore ks = null;
        KeyManagerFactory keyFac = null;

        KeyManager[] kms = null;
        try {
            // 获得KeyManagerFactory对象. 初始化位默认算法
            keyFac = KeyManagerFactory.getInstance("SunX509");
//            is = new FileInputStream((new ClassPathResource("qinshouboxserver.jks")).getFile());
            is = context.getAssets().open("qinshouboxserver.jks");
            System.out.println("is--->" + is.available());
            ks = KeyStore.getInstance("JKS");
            String keyStorePass = "qinshouboxserver";
            ks.load(is, keyStorePass.toCharArray());
            keyFac.init(ks, keyStorePass.toCharArray());
            kms = keyFac.getKeyManagers();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return kms;
    }

    private static KeyManager[] getKeyManagersClient(Context context) {
        InputStream is = null;
        KeyStore ks = null;
        KeyManagerFactory keyFac = null;

        KeyManager[] kms = null;
        try {
            // 获得KeyManagerFactory对象. 初始化位默认算法
            keyFac = KeyManagerFactory.getInstance("BKS");
//            is = new FileInputStream((new ClassPathResource("qinshouboxclient.jks")).getFile());
            is = context.getAssets().open("qinshouboxclient.jks");
            System.out.println("is--->" + is.available());
            ks = KeyStore.getInstance("JKS");
            String keyStorePass = "qinshouboxclient";
            ks.load(is, keyStorePass.toCharArray());
            keyFac.init(ks, keyStorePass.toCharArray());
            kms = keyFac.getKeyManagers();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return kms;
    }
}  