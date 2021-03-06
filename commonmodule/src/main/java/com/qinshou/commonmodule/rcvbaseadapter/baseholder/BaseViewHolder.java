package com.qinshou.commonmodule.rcvbaseadapter.baseholder;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Description:RecyclerView 的 ViewHolder 的基类,可以封装各种通用的方法
 * 比如 View 的背景设置,是否选中的状态设置
 * TextView 的文字设置,字体大小设置,字体颜色设置
 * ImageView 的图片设置,当然,如果一般是网络加载的话,需要获得 ImageView 自己异步加载,也可以在该类中内置 Glide 等第三方库异步加载网络图片
 * 设置 OnClickListener,OnLongClickListener 等
 * Created by 禽兽先生
 * Created on 2017/11/22
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {
    private Context mContext;
    private View mItemView;
    private SparseArray<View> mViewSparseArray;

    public BaseViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.mItemView = itemView;
        this.mViewSparseArray = new SparseArray<View>();
    }

    public View getItemView() {
        return mItemView;
    }

    public <T extends View> T findViewById(int viewId) {
        View view = mViewSparseArray.get(viewId);
        if (view == null) {
            view = mItemView.findViewById(viewId);
            mViewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    public TextView getTextView(int textViewId) {
        TextView textView = (TextView) mViewSparseArray.get(textViewId);
        if (textView == null) {
            textView = mItemView.findViewById(textViewId);
            mViewSparseArray.put(textViewId, textView);
        }
        return textView;
    }

    public ImageView getImageView(int imageViewId) {
        ImageView imageView = (ImageView) mViewSparseArray.get(imageViewId);
        if (imageView == null) {
            imageView = mItemView.findViewById(imageViewId);
            mViewSparseArray.put(imageViewId, imageView);
        }
        return imageView;
    }

    /**
     * Description:设置控件是否可见
     * Date:2018/3/9
     */
    public BaseViewHolder setVisibility(int viewId, int visibility) {
        View mView = findViewById(viewId);
        if (mView != null) {
            mView.setVisibility(visibility);
        }
        return this;
    }

    /**
     * Description:设置 TextView 文本
     * Date:2018/3/9
     */
    public BaseViewHolder setTvText(int viewId, CharSequence text) {
        TextView mTextView = findViewById(viewId);
        if (mTextView != null) {
            mTextView.setText(text);
        }
        return this;
    }

    /**
     * Description:设置 TextView 文本
     * Date:2018/3/9
     */
    public BaseViewHolder setTvText(int viewId, @StringRes int resId) {
        TextView mTextView = findViewById(viewId);
        if (mTextView != null) {
            mTextView.setText(mContext.getResources().getString(resId));
        }
        return this;
    }

    /**
     * Description:设置 Button 文本
     * Date:2018/3/9
     */
    public BaseViewHolder setBtnText(int viewId, CharSequence text) {
        Button mButton = findViewById(viewId);
        if (mButton != null) {
            mButton.setText(text);
        }
        return this;
    }

    /**
     * Description:设置 Button 文本
     * Date:2018/3/9
     */
    public BaseViewHolder setBtnText(int viewId, @StringRes int resId) {
        Button mButton = findViewById(viewId);
        if (mButton != null) {
            mButton.setText(mContext.getResources().getString(resId));
        }
        return this;
    }

    /**
     * Description:设置 ImageView 图片
     * Date:2018/3/9
     */
    public BaseViewHolder setIvImage(int viewId, Bitmap bitmap) {
        ImageView mImageView = findViewById(viewId);
        if (mImageView != null) {
            mImageView.setImageBitmap(bitmap);
        }
        return this;
    }

    /**
     * Description:设置 ImageView 图片
     * Date:2018/3/9
     */
    public BaseViewHolder setIvImage(int viewId, @DrawableRes int resId) {
        ImageView mImageView = findViewById(viewId);
        if (mImageView != null) {
            mImageView.setImageResource(resId);
        }
        return this;
    }

    /**
     * Description:设置 View 的点击事件监听器
     * Date:2018/3/9
     */
    public BaseViewHolder setOnClickListener(int viewId, View.OnClickListener onClickListener) {
        View mView = findViewById(viewId);
        if (mView != null) {
            mView.setOnClickListener(onClickListener);
        }
        return this;
    }

    /**
     * Description:设置 View 的 selected 状态
     * Date:2018/3/9
     */
    public BaseViewHolder setSelected(int viewId, boolean selected) {
        View mView = findViewById(viewId);
        if (mView != null) {
            mView.setSelected(selected);
        }
        return this;
    }

    /**
     * Description:设置 View 的背景色
     * Date:2018/3/9
     */
    public BaseViewHolder setBackgroundColor(int viewId, @ColorInt int color) {
        View mView = findViewById(viewId);
        if (mView != null) {
            mView.setBackgroundColor(color);
        }
        return this;
    }

    /**
     * Description:设置 View 的背景
     * Date:2018/3/9
     */
    public BaseViewHolder setBackgroundResource(int viewId, @DrawableRes int resId) {
        View mView = findViewById(viewId);
        if (mView != null) {
            mView.setBackgroundResource(resId);
        }
        return this;
    }
}