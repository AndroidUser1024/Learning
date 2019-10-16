package com.qinshou.commonmodule.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qinshou.commonmodule.R;


/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/8/21 9:31
 * Description:标题栏
 */
public class TitleBar extends FrameLayout {

    /**
     * 左边 TextView
     */
    private TextView mTvLeft;
    /**
     * 左边 ImageView
     */
    private ImageView mIvLeft;
    /**
     * 右边 TextView
     */
    private TextView mTvRight;
    /**
     * 右边 ImageView
     */
    private ImageView mIvRight;
    /**
     * 标题 TextView
     */
    private TextView mTvTitle;

    public TitleBar(@NonNull Context context) {
        this(context, null);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_title_bar, this);
        RelativeLayout rlRoot = findViewById(R.id.rl_root);
        mTvLeft = view.findViewById(R.id.tv_left);
        mIvLeft = view.findViewById(R.id.iv_left);
        mTvRight = view.findViewById(R.id.tv_right);
        mIvRight = view.findViewById(R.id.iv_right);
        mTvTitle = view.findViewById(R.id.tv_title);
        // 获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);

        rlRoot.setPadding((int) typedArray.getDimension(R.styleable.TitleBar_paddingLeft, 0)
                , (int) typedArray.getDimension(R.styleable.TitleBar_paddingTop, 0)
                , (int) typedArray.getDimension(R.styleable.TitleBar_paddingRight, 0)
                , (int) typedArray.getDimension(R.styleable.TitleBar_paddingBottom, 0)
        );

        // 左边 TextView 文字
        mTvLeft.setText(typedArray.getString(R.styleable.TitleBar_leftText));
        // 左边 TextView 文字大小
        float leftTextSize = typedArray.getDimension(R.styleable.TitleBar_leftTextSize, 14 * context.getResources().getDisplayMetrics().density);
        leftTextSize /= context.getResources().getDisplayMetrics().density;
        mTvLeft.setTextSize(leftTextSize);
        // 左边 TextView 文字颜色
        mTvLeft.setTextColor(typedArray.getColor(R.styleable.TitleBar_leftTextColor, 0xFF333333));
        // 左边文字内边距,单独设置的内边距优先级高于统一设置的
        mTvLeft.setPadding((int) typedArray.getDimension(R.styleable.TitleBar_leftTextPaddingLeft, typedArray.getDimension(R.styleable.TitleBar_leftTextPadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_leftTextPaddingTop, typedArray.getDimension(R.styleable.TitleBar_leftTextPadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_leftTextPaddingRight, typedArray.getDimension(R.styleable.TitleBar_leftTextPadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_leftTextPaddingBottom, typedArray.getDimension(R.styleable.TitleBar_leftTextPadding, 0))
        );
        // 左边 ImageView 的图片资源
        mIvLeft.setImageResource(typedArray.getResourceId(R.styleable.TitleBar_leftImageResource, 0));
        // 左边图片内边距,单独设置的内边距优先级高于统一设置的
        mIvLeft.setPadding((int) typedArray.getDimension(R.styleable.TitleBar_leftImagePaddingLeft, typedArray.getDimension(R.styleable.TitleBar_leftImagePadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_leftImagePaddingTop, typedArray.getDimension(R.styleable.TitleBar_leftImagePadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_leftImagePaddingRight, typedArray.getDimension(R.styleable.TitleBar_leftImagePadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_leftImagePaddingBottom, typedArray.getDimension(R.styleable.TitleBar_leftImagePadding, 0))
        );

        // 右边 TextView 文字
        mTvRight.setText(typedArray.getString(R.styleable.TitleBar_rightText));
        // 右边 TextView 文字大小
        float rightTextSize = typedArray.getDimension(R.styleable.TitleBar_rightTextSize, 14 * context.getResources().getDisplayMetrics().density);
        rightTextSize /= context.getResources().getDisplayMetrics().density;
        mTvRight.setTextSize(rightTextSize);
        // 右边 TextView 文字颜色
        mTvRight.setTextColor(typedArray.getColor(R.styleable.TitleBar_rightTextColor, 0xFF333333));
        // 右边文字内边距,单独设置的内边距优先级高于统一设置的
        mTvRight.setPadding((int) typedArray.getDimension(R.styleable.TitleBar_rightTextPaddingLeft, typedArray.getDimension(R.styleable.TitleBar_rightTextPadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_rightTextPaddingTop, typedArray.getDimension(R.styleable.TitleBar_rightTextPadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_rightTextPaddingRight, typedArray.getDimension(R.styleable.TitleBar_rightTextPadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_rightTextPaddingBottom, typedArray.getDimension(R.styleable.TitleBar_rightTextPadding, 0))
        );
        // 右边 ImageView 的图片资源
        mIvRight.setImageResource(typedArray.getResourceId(R.styleable.TitleBar_rightImageResource, 0));
        // 右边图片内边距,单独设置的内边距优先级高于统一设置的
        mIvRight.setPadding((int) typedArray.getDimension(R.styleable.TitleBar_rightImagePaddingLeft, typedArray.getDimension(R.styleable.TitleBar_rightImagePadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_rightImagePaddingTop, typedArray.getDimension(R.styleable.TitleBar_rightImagePadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_rightImagePaddingRight, typedArray.getDimension(R.styleable.TitleBar_rightImagePadding, 0))
                , (int) typedArray.getDimension(R.styleable.TitleBar_rightImagePaddingBottom, typedArray.getDimension(R.styleable.TitleBar_rightImagePadding, 0))
        );

        // 标题文字
        mTvTitle.setText(typedArray.getString(R.styleable.TitleBar_titleText));
        // 标题文字大小
        float titleTextSize = typedArray.getDimension(R.styleable.TitleBar_titleTextSize, 18 * context.getResources().getDisplayMetrics().density);
        titleTextSize /= context.getResources().getDisplayMetrics().density;
        mTvTitle.setTextSize(titleTextSize);
        // 标题文字颜色
        mTvTitle.setTextColor(typedArray.getColor(R.styleable.TitleBar_titleTextColor, 0xFF333333));
        typedArray.recycle();
    }

    public TextView getTvLeft() {
        return mTvLeft;
    }

    public ImageView getIvLeft() {
        return mIvLeft;
    }

    public TextView getTvRight() {
        return mTvRight;
    }

    public ImageView getIvRight() {
        return mIvRight;
    }

    public TextView getTvTitle() {
        return mTvTitle;
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:41
     * Description:设置左边 TextView 文字
     *
     * @param text 文字
     */
    public void setLeftText(String text) {
        mTvLeft.setText(text);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:42
     * Description:设置左边 TextView 文字
     *
     * @param resId 文字资源
     */
    public void setLeftText(@StringRes int resId) {
        mTvLeft.setText(resId);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:42
     * Description:设置左边 TextView 文字大小
     *
     * @param textSize 文字大小
     */
    public void setLeftTextSize(float textSize) {
        mTvLeft.setTextSize(textSize);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:42
     * Description:设置左边 TextView 文字颜色
     *
     * @param textColor 文字颜色
     */
    public void setLeftTextColor(@ColorInt int textColor) {
        mTvLeft.setTextColor(textColor);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:42
     * Description:设置左边 ImageView 图片资源
     *
     * @param resId 图片资源
     */
    public void setLeftImageResource(@DrawableRes int resId) {
        mIvLeft.setImageResource(resId);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:43
     * Description:设置右边 TextView 文字
     *
     * @param text 文字
     */
    public void setRightText(String text) {
        mTvRight.setText(text);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:43
     * Description:设置右边 TextView 文字
     *
     * @param resId 文字资源
     */
    public void setRightText(@StringRes int resId) {
        mTvRight.setText(resId);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:43
     * Description:设置右边 TextView 文字大小
     *
     * @param textSize 文字大小
     */
    public void setRightTextSize(float textSize) {
        mTvRight.setTextSize(textSize);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:43
     * Description:设置右边 TextView 文字颜色
     *
     * @param textColor 文字颜色
     */
    public void setRightTextColor(@ColorInt int textColor) {
        mTvRight.setTextColor(textColor);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:43
     * Description:设置右边 ImageView 图片资源
     *
     * @param resId 图片资源
     */
    public void setRightImageResource(@DrawableRes int resId) {
        mIvRight.setImageResource(resId);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:44
     * Description:设置标题文字
     *
     * @param text 标题文字
     */
    public void setTitleText(String text) {
        mTvTitle.setText(text);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:44
     * Description:设置标题文字
     *
     * @param resId 标题文字资源
     */
    public void setTitleText(@StringRes int resId) {
        mTvTitle.setText(resId);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:44
     * Description:设置标题文字大小
     *
     * @param textSize 标题文字大小
     */
    public void setTitleTextSize(float textSize) {
        mTvTitle.setTextSize(textSize);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:44
     * Description:设置标题文字颜色
     *
     * @param textColor 标题文字颜色
     */
    public void setTitleTextColor(@ColorInt int textColor) {
        mTvTitle.setTextColor(textColor);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:50
     * Description:设置左边文字的点击事件监听器
     *
     * @param onClickListener 点击事件监听器
     */
    public void setLeftTextOnClickListener(OnClickListener onClickListener) {
        mTvLeft.setOnClickListener(onClickListener);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:50
     * Description:设置左边图片的点击事件监听器
     *
     * @param onClickListener 点击事件监听器
     */
    public void setLeftImageOnClickListener(OnClickListener onClickListener) {
        mIvLeft.setOnClickListener(onClickListener);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:50
     * Description:设置右边文字的点击事件监听器
     *
     * @param onClickListener 点击事件监听器
     */
    public void setRightTextOnClickListener(OnClickListener onClickListener) {
        mTvRight.setOnClickListener(onClickListener);
    }

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2019/8/21 10:50
     * Description:设置右边图片的点击事件监听器
     *
     * @param onClickListener 点击事件监听器
     */
    public void setRightImageOnClickListener(OnClickListener onClickListener) {
        mIvRight.setOnClickListener(onClickListener);
    }
}
