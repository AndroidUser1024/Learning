package com.qinshou.commonmodule.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2019/1/7
 */
public class WheelOfFortuneView extends View {
    private static final String TAG = "WheelOfFortuneView";
    private int mWidth;
    private int mHeight;
    private Paint mPaint;
    private TextPaint mTextPaint;
    private RectF mRectF;
    private Path mPath;
    private PathMeasure mPathMeasure;
    private Rect mTextBounds;
    private float[] pos = new float[2];
    private float[] tan = new float[2];
    private float mRotateDegrees = 0;
    private GestureDetector mGestureDetector;

    private String centerText;
    private List<Prize> mPrizeList = new ArrayList<>();

    private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            //return true 才会响应后续事件，如 onSingleTapUp、onFling 等
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            int goButtonRadius = mWidth / 10 - dp2px(getContext(), 5f);
            if (e.getX() > mWidth / 2 - goButtonRadius
                    && e.getX() < mWidth / 2 + goButtonRadius
                    && e.getY() > mHeight / 2 - goButtonRadius
                    && e.getY() < mHeight / 2 + goButtonRadius) {
                startPrizeDraw();
            }
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            Log.i(TAG, "onFling");
            return false;
        }
    };

    public WheelOfFortuneView(Context context) {
        this(context, null);
    }

    public WheelOfFortuneView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WheelOfFortuneView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5f);
        mPaint.setColor(Color.BLACK);

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);

        mRectF = new RectF();
        mPath = new Path();
        mPathMeasure = new PathMeasure();
        mTextBounds = new Rect();

        centerText = "GO";
        mGestureDetector = new GestureDetector(getContext(), mOnGestureListener);
        mPrizeList.add(new Prize("一等奖", Color.RED));
        mPrizeList.add(new Prize("二等奖", Color.YELLOW));
        mPrizeList.add(new Prize("三等奖", Color.BLUE));
        mPrizeList.add(new Prize("一等奖", Color.RED));
        mPrizeList.add(new Prize("二等奖", Color.YELLOW));
        mPrizeList.add(new Prize("三等奖", Color.BLUE));
        mPrizeList.add(new Prize("一等奖", Color.RED));
        mPrizeList.add(new Prize("二等奖", Color.YELLOW));
        mPrizeList.add(new Prize("三等奖", Color.BLUE));
        mPrizeList.add(new Prize("二等奖", Color.YELLOW));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = mHeight = Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels);
        setMeasuredDimension(mWidth, mHeight);

        mRectF.set(0, 0, mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        //点击抽奖后
        canvas.rotate(mRotateDegrees, (mRectF.right - mRectF.left) / 2, (mRectF.bottom - mRectF.top) / 2);
        for (int i = 0; i < mPrizeList.size(); i++) {
            mPaint.setStrokeWidth(5f);
            mPaint.setColor(mPrizeList.get(i).getBackgroundColor());
            canvas.drawArc(mRectF, 360 / mPrizeList.size() * i - 90, 360 / mPrizeList.size(), true, mPaint);

            mPath.reset();
            mPath.addArc(mRectF, 360 / mPrizeList.size() * i - 90, 360 / mPrizeList.size());
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getPosTan(mPathMeasure.getLength() / 2, pos, tan);

            mPath.reset();
            mPath.moveTo((mRectF.right - mRectF.left) / 2, (mRectF.bottom - mRectF.top) / 2);
            mPath.lineTo(pos[0], pos[1]);
            mPaint.setColor(Color.BLACK);
            mPaint.setStrokeWidth(10f);
            mPathMeasure.setPath(mPath, false);

            String text = mPrizeList.get(i).getText();
            text = new StringBuilder(text).reverse().toString();
            for (int j = 0; j < text.length(); j++) {
                canvas.save();
                mPathMeasure.getPosTan(mPathMeasure.getLength() / (text.length() - 1 + 4) * (j + 2), pos, tan);
                canvas.rotate(90, pos[0], pos[1]);

                mTextPaint.getTextBounds(text, j, j + 1, mTextBounds);
                mTextPaint.setTextSize(sp2px(getContext(), 20f));
                mTextPaint.setColor(Color.BLACK);
                mTextPaint.setTypeface(Typeface.DEFAULT);
                canvas.drawTextOnPath(text.substring(j, j + 1), mPath, mPathMeasure.getLength() / (text.length() - 1 + 4) * (j + 2) - mTextBounds.width() / 2, 0, mTextPaint);
                canvas.restore();
            }
        }
        canvas.restore();

        int radius = mWidth / 10;
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, mPaint);

        radius = mWidth / 10 - dp2px(getContext(), 5f);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, mPaint);

        mPath.reset();
        mPaint.setColor(Color.RED);
        mPath.moveTo(mWidth / 2 - (float) (Math.sin(Math.PI / 12) * radius)
                , mHeight / 2 - (float) (Math.cos(Math.PI / 12) * radius));
        mPath.lineTo(mWidth / 2
                , mHeight / 2 - radius * 2f);
        mPath.lineTo(mWidth / 2 + (float) (Math.sin(Math.PI / 12) * radius)
                , mHeight / 2 - (float) (Math.cos(Math.PI / 12) * radius));
        canvas.drawPath(mPath, mPaint);

        mTextPaint.setTextSize(sp2px(getContext(), 40f));
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.getTextBounds(centerText, 0, centerText.length(), mTextBounds);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        canvas.drawText(centerText, mWidth / 2 - mTextBounds.width() / 2, mHeight / 2 + mTextBounds.height() / 2, mTextPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private void startPrizeDraw() {
        final int random = new Random().nextInt(mPrizeList.size() - 1);
        float endRotateDegrees = 360 / mPrizeList.size() * (mPrizeList.size() - random);
        endRotateDegrees -= 360 / mPrizeList.size() / 2;
        endRotateDegrees += 360 * 5;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, endRotateDegrees);
        valueAnimator.setDuration(3 * 1000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mRotateDegrees = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                mRotateDegrees = 0;
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(getContext(), "恭喜你抽中了" + mPrizeList.get(random).getText(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();
    }

    private static int dp2px(Context context, float dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5f);
    }

    private static int sp2px(Context context, float spValue) {
        float scaleDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scaleDensity + 0.5f);
    }

    public static class Prize {
        private String text;
        private int backgroundColor;

        public Prize() {
        }

        public Prize(String text, int backgroundColor) {
            this.text = text;
            this.backgroundColor = backgroundColor;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public int getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }
}
