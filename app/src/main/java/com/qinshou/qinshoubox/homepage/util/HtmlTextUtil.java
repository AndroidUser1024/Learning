package com.qinshou.qinshoubox.homepage.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LevelListDrawable;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.qinshou.imagemodule.callback.IOnGetImageCallback;
import com.qinshou.imagemodule.util.ImageLoadUtil;

/**
 * Description:处理 Html 文本
 * Created by 禽兽先生
 * Created on 2017/12/6
 */

public class HtmlTextUtil {
    public static CharSequence getHtmlText(String content) {
        Spanned mSpanned;
        //将文本转化为 Html 格式
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mSpanned = Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT, null, null);
        } else {
            mSpanned = Html.fromHtml(content, null, null);
        }
        return new SpannableStringBuilder(mSpanned);
    }

    public static CharSequence getHtmlText(String content, Html.ImageGetter mImageGetter) {
        Spanned mSpanned;
        //从 HTML 字符串中得到可显示的样式文本,并在 NetworkImageGetter 中异步加载文本中的图片,自适应图片宽高
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mSpanned = Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT, mImageGetter, null);
        } else {
            mSpanned = Html.fromHtml(content, mImageGetter, null);
        }
        return new SpannableStringBuilder(mSpanned);
    }

    public static CharSequence getHtmlText(String content, Html.ImageGetter mImageGetter, ClickableSpan clickableSpan) {
        Spanned mSpanned;
        //从 HTML 字符串中得到可显示的样式文本,并在 NetworkImageGetter 中异步加载文本中的图片,自适应图片宽高
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            mSpanned = Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT, mImageGetter, null);
        } else {
            mSpanned = Html.fromHtml(content, mImageGetter, null);
        }
        SpannableStringBuilder mSpannableStringBuilder = new SpannableStringBuilder(mSpanned);
        //得到文本中的所有超链接
        URLSpan[] urlSpans = mSpannableStringBuilder.getSpans(0, mSpanned.length(), URLSpan.class);
        for (URLSpan urlSpan : urlSpans) {
            int start = mSpannableStringBuilder.getSpanStart(urlSpan);
            int end = mSpannableStringBuilder.getSpanEnd(urlSpan);
            int flags = mSpannableStringBuilder.getSpanFlags(urlSpan);
            //自定义所有超链接的点击事件和超链接的文本颜色
            mSpannableStringBuilder.setSpan(clickableSpan, start, end, flags);
        }
        return new SpannableStringBuilder(mSpanned);
    }

    /**
     * Description:Html 中加载图片标签的加载器,异步加载图片,加载完后刷新 TextView
     * Date:2017/12/7
     */
    public static class NetworkImageGetter implements Html.ImageGetter {
        private Context context;
        private TextView textView;

        NetworkImageGetter(Context context, TextView textView) {
            this.context = context;
            this.textView = textView;
        }

        @Override
        public Drawable getDrawable(String source) {
            final LevelListDrawable drawable = new LevelListDrawable();
            ImageLoadUtil.getInstance().getImage(context, source, new IOnGetImageCallback() {
                @Override
                public void onSuccess(Bitmap bitmap) {
                    //Bitmap 转为 BitmapDrawable
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                    drawable.addLevel(1, 1, bitmapDrawable);
                    //计算 TextView 控件宽与图片的宽的比例
                    double scale = ((double) textView.getWidth() / (double) bitmap.getWidth());
                    //图片宽缩放为控件宽
                    int width = textView.getWidth();
                    //图片高等比例缩放为控件高
                    int height = (int) (bitmap.getHeight() * scale);
                    drawable.setBounds(0, 0, width, height);
                    drawable.setLevel(1);
                    CharSequence text = textView.getText();
                    textView.setText(text);
                    //加载完图片后需刷新
                    textView.refreshDrawableState();
                }

                @Override
                public void onFailure(String error, Bitmap errorBitmap) {

                }
            });
            return drawable;
        }
    }

    /**
     * Description:Html 文本中超链接的点击监听器
     * Date:2017/12/7
     */
    public static class BaseClickableSpan extends ClickableSpan {
        private Context context;
        private String url;

        BaseClickableSpan(Context context, String url) {
            this.context = context;
            this.url = url;
        }


        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(Color.RED);
            ds.setUnderlineText(true);
        }

        @Override
        public void onClick(View widget) {
            Toast.makeText(context, "点击了超链接", Toast.LENGTH_SHORT).show();
        }
    }
}
