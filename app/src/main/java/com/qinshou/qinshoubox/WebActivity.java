package com.qinshou.qinshoubox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.qinshou.commonmodule.widget.RefreshLayout;
import com.qinshou.imagemodule.PhotoViewActivity;
import com.qinshou.qinshoubox.base.QSActivity;
import com.qinshou.qinshoubox.homepage.bean.EventBean;

import java.util.ArrayList;


public class WebActivity extends QSActivity<WebPresenter> implements IWebContract.IView {
    private static final String URL = "url";
    private WebView webView;
    private ProgressBar pbLoadProgress;
    private RefreshLayout mRefreshLayout;


    @Override
    public int getLayoutId() {
        return R.layout.activity_web;
    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface", "AddJavascriptInterface"})
    @Override
    public void initView() {
//        final RelativeLayout rootView = findViewByID(R.id.root_view);
//        rootView.post(new Runnable() {
//            @Override
//            public void run() {
//                StatusBarUtil.appendStatusBarPadding(rootView, rootView.getMeasuredHeight());
//            }
//        });
        mRefreshLayout = findViewByID(R.id.refresh_layout);
        mRefreshLayout.canLoadMore(false);
//        mRefreshLayout.setRefreshHeader(new ClassicsHeader(getContext()));
//
        webView = findViewByID(R.id.web_view);
        pbLoadProgress = findViewByID(R.id.pb_load_progress);
        WebSettings webSettings = webView.getSettings();
        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片

        webSettings.setJavaScriptEnabled(true);    //如果访问的页面中要与Javascript交互，则 WebView 必须设置支持 JavaScript
        //添加 JS 脚本,使能监听网页中的图片点击事件
        webView.addJavascriptInterface(new JsCallJavaObj() {
            @Override
            @JavascriptInterface
            public void showBigImage(String url) {
                ArrayList<String> imageList = new ArrayList<>();
                imageList.add(url);
                startActivity(PhotoViewActivity.getJumpIntent(getContext(), imageList));
            }
        }, "jsCallJavaObj");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                setWebImageClick(view);
                mRefreshLayout.stopRefreshAndLoadMore();
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                pbLoadProgress.setVisibility(newProgress == 100 ? View.GONE : View.VISIBLE);
                pbLoadProgress.setProgress(newProgress);
            }
        });
    }

    @Override
    public void setListener() {
        mRefreshLayout.setOnRefreshListener(new RefreshLayout.IOnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                webView.reload();
            }
        });
    }

    @Override
    public void initData() {
        String url = getIntent().getStringExtra(URL);
        webView.loadUrl(url);
    }

    @Override
    public void handleEvent(EventBean<Object> eventBean) {

    }

    /**
     * Description:点击网页中的图片时会调用该方法中的 js 脚本,主要是 showBigImage() 这个方法
     * Date:2018/4/19
     */
    private void setWebImageClick(WebView webView) {
        String jsCode = "javascript:(function(){"
                //这里开始是 Js 代码块
                + "var imgs=document.getElementsByTagName(\"img\");"
                + "for(var i=0;i<imgs.length;i++){"
                + "imgs[i].onclick=function(){"
                + "window.jsCallJavaObj.showBigImage(this.src);"
                + "}"
                + "}"
                //Js 代码结束
                + "})()";
        webView.loadUrl(jsCode);
    }

    /**
     * Description:该接口中的方法名一定要与 js 脚本中的方法名一致
     * Date:2018/4/19
     */
    private interface JsCallJavaObj {
        void showBigImage(String url);
    }

    public static Intent getJumpIntent(Context context, String url) {
        Intent mIntent = new Intent(context, WebActivity.class);
        mIntent.putExtra(URL, url);
        return mIntent;
    }
}
