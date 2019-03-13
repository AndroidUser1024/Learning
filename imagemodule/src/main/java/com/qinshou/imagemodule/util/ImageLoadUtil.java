package com.qinshou.imagemodule.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.qinshou.imagemodule.R;
import com.qinshou.imagemodule.callback.OnGetImageCallback;

/**
 * Description:图片加载工具类
 * Created by 禽兽先生
 * Created on 2017/10/12
 */

public class ImageLoadUtil {
    private RequestOptions mRequestOptions;

    /**
     * Description:获取单例
     * Date:2017/10/12
     */
    public static ImageLoadUtil getInstance() {
        return SingleHolder.singleton;
    }

    private static class SingleHolder {
        private static final ImageLoadUtil singleton = new ImageLoadUtil();
    }

    private ImageLoadUtil() {
        mRequestOptions = RequestOptions.placeholderOf(R.drawable.icon_loading)
                .error(R.drawable.icon_load_error);
    }

    /**
     * Description:设置占位图
     * Date:2018/5/4
     */
    public ImageLoadUtil setPlaceholder(int placeholderId) {
        mRequestOptions = mRequestOptions.placeholder(placeholderId);
        return this;
    }

    /**
     * Description:设置占位图
     * Date:2018/5/4
     */
    public ImageLoadUtil setPlaceholder(Drawable drawable) {
        mRequestOptions = mRequestOptions.placeholder(drawable);
        return this;
    }

    /**
     * Description:设置加载错误图
     * Date:2018/5/4
     */
    public ImageLoadUtil setError(int errorId) {
        mRequestOptions = mRequestOptions.error(errorId);
        return this;
    }

    /**
     * Description:设置加载错误图
     * Date:2018/5/4
     */
    public ImageLoadUtil setError(Drawable drawable) {
        mRequestOptions = mRequestOptions.error(drawable);
        return this;
    }

    /**
     * Description:加载 jpg 格式的图片
     * Date:2017/10/12
     */
    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(mRequestOptions)
                .into(imageView);
    }

    /**
     * Description:加载 jpg 格式的图片
     * Date:2017/10/12
     */
    public void loadImage(Context context, Object model, ImageView imageView) {
        Glide.with(context)
                .load(model)
                .apply(mRequestOptions)
                .into(imageView);
    }

    /**
     * Description:异步获取图片
     * Date:2018/3/9
     */
    public void getImage(Context context, String url, final OnGetImageCallback onGetImageCallback) {
        Glide.with(context).load(url).apply(mRequestOptions).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                onGetImageCallback.onSuccess(BitmapUtil.drawable2Bitmap(resource));
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                onGetImageCallback.onSuccess(BitmapUtil.drawable2Bitmap(errorDrawable));
            }
        });
    }

    public void getImage(Context context, Object model, final OnGetImageCallback onGetImageCallback) {
        Glide.with(context).load(model).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                onGetImageCallback.onSuccess(BitmapUtil.drawable2Bitmap(resource));
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                onGetImageCallback.onSuccess(BitmapUtil.drawable2Bitmap(errorDrawable));
            }
        });
    }
}
