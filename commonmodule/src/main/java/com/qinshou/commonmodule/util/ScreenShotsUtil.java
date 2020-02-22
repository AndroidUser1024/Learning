package com.qinshou.commonmodule.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import androidx.core.widget.NestedScrollView;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ScrollView;

/**
 * Description:屏幕截图工具类
 * Created by 禽兽先生
 * Created on 2018/6/4
 */

public class ScreenShotsUtil {
    /**
     * Description:对当前 Window 进行截图
     * Date:2018/6/4
     */
    public static Bitmap shotActivity(Activity activity) {

        View view = activity.getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(),
                view.getMeasuredHeight());

        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return bitmap;
    }

    /**
     * Description:对普通 View 进行截图
     * Date:2018/6/4
     */
    public static Bitmap shotView(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        view.measure(MeasureSpec.makeMeasureSpec(view.getWidth(),
                MeasureSpec.EXACTLY), MeasureSpec.makeMeasureSpec(
                view.getHeight(), MeasureSpec.EXACTLY));
        view.layout((int) view.getX(), (int) view.getY(),
                (int) view.getX() + view.getMeasuredWidth(),
                (int) view.getY() + view.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return bitmap;
    }

    /**
     * Description:对 ScrollView 进行截图
     * Date:2018/6/4
     */
    public static Bitmap shotScrollView(ScrollView scrollView) {
        int height = 0;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            height += scrollView.getChildAt(i).getHeight();
            scrollView.getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        Bitmap bitmap = Bitmap.createBitmap(scrollView.getWidth(), height, Bitmap.Config.RGB_565);
        final Canvas canvas = new Canvas(bitmap);
        scrollView.draw(canvas);
        return bitmap;
    }

    /**
     * Description:对 NestedScrollView 进行截图
     * Date:2018/6/4
     */
    public static Bitmap shotNestedScrollView(NestedScrollView nestedScrollView) {
        int height = 0;
        for (int i = 0; i < nestedScrollView.getChildCount(); i++) {
            height += nestedScrollView.getChildAt(i).getHeight();
            nestedScrollView.getChildAt(i).setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        Bitmap bitmap = Bitmap.createBitmap(nestedScrollView.getWidth(), height, Bitmap.Config.RGB_565);
        final Canvas canvas = new Canvas(bitmap);
        nestedScrollView.draw(canvas);
        return bitmap;
    }
}
