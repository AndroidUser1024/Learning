package com.qinshou.imagemodule.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.qinshou.imagemodule.R;
import com.qinshou.imagemodule.callback.Callback;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/3 19:16
 * Description:图片加载工具类
 */
public enum ImageLoadUtil {
    SINGLETON;

    private final String TAG = "ImageLoadUtil";
    private RequestOptions mRequestOptions;

    ImageLoadUtil() {
        mRequestOptions = RequestOptions.placeholderOf(R.drawable.icon_loading)
                .error(R.drawable.icon_load_error);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/3/16 9:33
     * Description:预检查 context
     */
    private boolean checkContext(Context context) {
        if (context == null) {
            return false;
        }
        if (context instanceof Activity && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && ((Activity) context).isDestroyed()) {
            Log.i(TAG, "context is illegal argument");
            return false;
        }
        return true;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:31
     * Description:设置加载占位图,在 Application 初始时设置
     *
     * @param placeholderId 占位图资源 id
     */
    public ImageLoadUtil setPlaceholder(int placeholderId) {
        mRequestOptions = mRequestOptions.placeholder(placeholderId);
        return this;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:31
     * Description:设置加载占位图,在 Application 初始时设置
     *
     * @param drawable 占位图
     */
    public ImageLoadUtil setPlaceholder(Drawable drawable) {
        mRequestOptions = mRequestOptions.placeholder(drawable);
        return this;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:31
     * Description:设置加载错误图,在 Application 初始时设置
     *
     * @param errorId 错误图的资源 id
     */
    public ImageLoadUtil setError(int errorId) {
        mRequestOptions = mRequestOptions.error(errorId);
        return this;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:31
     * Description:设置加载错误图,在 Application 初始时设置
     *
     * @param drawable 错误图
     */
    public ImageLoadUtil setError(Drawable drawable) {
        mRequestOptions = mRequestOptions.error(drawable);
        return this;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:29
     * Description:加载图片
     *
     * @param context   上下文
     * @param model     图片来源,可以是 url,资源 id,文件地址等
     * @param imageView 显示图片的 ImageView
     */
    public void loadImage(Context context, Object model, ImageView imageView) {
        loadImage(context, model, imageView, mRequestOptions, null);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:29
     * Description:异步获取图片
     *
     * @param context  上下文
     * @param model    图片来源,可以是 url,资源 id,文件地址等
     * @param callback 回调接口
     */
    public void getImage(Context context, Object model, final Callback callback) {
        if (!checkContext(context)) {
            return;
        }
        if (callback == null) {
            return;
        }
        Glide.with(context).load(model).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                callback.onSuccess(resource);
            }

            @Override
            public void onLoadFailed(@Nullable Drawable errorDrawable) {
                super.onLoadFailed(errorDrawable);
                callback.onSuccess(errorDrawable);
            }
        });
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:29
     * Description:加载圆形图片
     *
     * @param context   上下文
     * @param model     图片来源,可以是 url,资源 id,文件地址等
     * @param imageView 显示图片的 ImageView
     */
    public void loadCircleImage(Context context, Object model, ImageView imageView) {
        loadImage(context, model, imageView, mRequestOptions.clone().circleCrop(), null);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/10/22 15:29
     * Description:加载图片
     *
     * @param context        上下文
     * @param model          图片来源,可以是 url,资源 id,文件地址等
     * @param imageView      显示图片的 ImageView
     * @param requestOptions 特殊处理的选项
     */
    public void loadImage(Context context, Object model, ImageView imageView, RequestOptions requestOptions) {
        loadImage(context, model, imageView, requestOptions, null);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/1/2 11:49
     * Description:加载图片
     *
     * @param context        上下文
     * @param model          图片来源,可以是 url,资源 id,文件地址等
     * @param imageView      显示图片的 ImageView
     * @param requestOptions 特殊处理的选项
     */
    public void loadImage(Context context, Object model, ImageView imageView, RequestOptions requestOptions, RequestBuilder<Drawable> thumbnail) {
        if (!checkContext(context)) {
            return;
        }
        Glide.with(context)
                .load(model)
                .apply(requestOptions)
                .thumbnail(thumbnail)
                .into(imageView);
    }
}