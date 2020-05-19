package com.qinshou.qinshoubox.me.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.qinshou.commonmodule.util.ShowLogUtil;
import com.qinshou.qinshoubox.me.bean.KlotskiBean;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/19 17:21
 * Description:华容道控件
 */
public class KlotskiView extends View {
    /**
     * 控件宽，为屏幕宽和高的较小值
     */
    private int mWidth;
    /**
     * 控件高，为屏幕宽和高的较小值
     */
    private int mHeight;
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    /**
     * 手势监听器
     */
    private GestureDetector mGestureDetector;
    private KlotskiBean[][] mKlotskiBeanArray = new KlotskiBean[][]{
            new KlotskiBean[]{KlotskiBean.ZHAO_YUN, KlotskiBean.CAO_CAO, KlotskiBean.CAO_CAO, KlotskiBean.HUANG_ZHONG}
            , new KlotskiBean[]{KlotskiBean.ZHAO_YUN, KlotskiBean.CAO_CAO, KlotskiBean.CAO_CAO, KlotskiBean.HUANG_ZHONG}
            , new KlotskiBean[]{KlotskiBean.ZHANG_FEI, KlotskiBean.GUAN_YU, KlotskiBean.GUAN_YU, KlotskiBean.MA_CHAO}
            , new KlotskiBean[]{KlotskiBean.ZHANG_FEI, KlotskiBean.BING, KlotskiBean.BING, KlotskiBean.MA_CHAO}
            , new KlotskiBean[]{KlotskiBean.BING, null, null, KlotskiBean.BING}

    };
    private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
        private KlotskiBean mTouchKlotskiBean;

        @Override
        public boolean onDown(MotionEvent e) {
            //return true 才会响应后续事件，如 onSingleTapUp、onFling 等
            int x = (int) e.getY() / (getHeight() / mKlotskiBeanArray.length);
            int y = (int) e.getX() / (getWidth() / mKlotskiBeanArray[x].length);
            mTouchKlotskiBean = mKlotskiBeanArray[x][y];
            ShowLogUtil.logi(mTouchKlotskiBean.getText());
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(e1.getX() - e2.getX()) > Math.abs(e1.getY() - e2.getY())) {
                // 左右滑
                ShowLogUtil.logi("左右滑");
            } else {
                // 上下滑
                ShowLogUtil.logi("上下滑");
            }
//
//            KlotskiBean left = mKlotskiBeanArray[i][j - 1];
//            KlotskiBean right = mKlotskiBeanArray[i][j + 1];
//            KlotskiBean top = mKlotskiBeanArray[i - 1][j];
//            KlotskiBean bottom = mKlotskiBeanArray[i + 1][j];
//            ShowLogUtil.logi("onScroll" + " : "
//                    + "e1.getX()--->" + e1.getX() + ",e1.getY()--->" + e1.getY()
//                    + ",e2.getX()--->" + e2.getX() + ",e2.getY()--->" + e2.getY()
//                    + ",distanceX--->" + distanceX
//                    + ",distanceY--->" + distanceY
//            );
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
    };

    public KlotskiView(Context context) {
        this(context, null);
    }

    public KlotskiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KlotskiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setAntiAlias(true);
        mGestureDetector = new GestureDetector(getContext(), mOnGestureListener);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = mHeight = Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels);
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mKlotskiBeanArray.length; x++) {
            int top = getHeight() / mKlotskiBeanArray.length * x;
            int bottom = getHeight() / mKlotskiBeanArray.length * (x + 1);
            for (int y = 0; y < mKlotskiBeanArray[x].length; y++) {
                if (mKlotskiBeanArray[x][y] == null) {
                    continue;
                }
                int left = getWidth() / mKlotskiBeanArray[y].length * y;
                int right = getWidth() / mKlotskiBeanArray[y].length * (y + 1);
                mRect.set(left, top, right, bottom);
                mPaint.setColor(mKlotskiBeanArray[x][y].getColor());
                canvas.drawRect(mRect, mPaint);
            }
        }
    }

    private float mDownX, mDownY;
    private KlotskiBean mTouchKlotskiBean;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                int x = (int) mDownY / (getHeight() / mKlotskiBeanArray.length);
                int y = (int) mDownX / (getWidth() / mKlotskiBeanArray[x].length);
                KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
                if (touchKlotskiBean == null) {
                    break;
                }
                if (Math.abs(event.getX() - mDownX) > Math.abs(event.getY() - mDownY)) {
                    if (event.getX() - mDownX > 0) {
                        // 右滑
                        ShowLogUtil.logi("右滑");
                        swapRight(x, y, touchKlotskiBean);
                    } else {
                        // 左滑
                        ShowLogUtil.logi("左滑");
                        swapLeft(x, y, touchKlotskiBean);
                    }
                } else {
                    if (event.getY() - mDownY > 0) {
                        // 下滑
                        ShowLogUtil.logi("下滑");
                    } else {
                        // 上滑
                        ShowLogUtil.logi("上滑");
                    }
                }
                mDownX = 0;
                mDownY = 0;
                break;
        }
        return true;
    }

    private void swapLeft(int x, int y, KlotskiBean touchKlotskiBean) {
        if (y == 0) {
            return;
        }
        if (touchKlotskiBean.getWidth() == 1) {
            if (mKlotskiBeanArray[x][y - 1] != null) {
                return;
            }
            mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = null;
        }
        invalidate();
    }

    private void swapRight(int x, int y, KlotskiBean touchKlotskiBean) {
        if (y == mKlotskiBeanArray[x].length) {
            return;
        }

    }
}
