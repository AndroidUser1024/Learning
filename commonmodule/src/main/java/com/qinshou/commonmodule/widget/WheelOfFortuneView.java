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
import androidx.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description:命运之轮，即抽奖轮盘
 * Created by 禽兽先生
 * Created on 2019/1/7
 */
public class WheelOfFortuneView extends View {
    private static final String TAG = "WheelOfFortuneView";
    private int mWidth; //控件宽，为屏幕宽和高的较小值
    private int mHeight;    //控件高，为屏幕宽和高的较小值
    private Paint mPaint;   //画笔
    private TextPaint mTextPaint;   //绘制文字的画笔
    private RectF mRectF;   //扇形绘制区域
    private Path mPath; //路径
    private PathMeasure mPathMeasure;   //路径测量的对象
    private Rect mTextBounds;   //文字绘制区域
    private float[] pos = new float[2]; //记录路径中某个点的坐标数组
    private float[] tan = new float[2];
    private float mRotateDegrees = 0;   //旋转角度
    private GestureDetector mGestureDetector;   //手势监听器，其实也就监听了一个单击事件

    private List<Prize> mPrizeList = new ArrayList<>();
    private String centerText = "GO";  //轮盘中心的文字
    private IOnPrizeDrawListener mOnPrizeDrawListener;

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
            //单击事件的触发范围在 Go 按钮的范围内才响应抽奖事件
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

        mTextPaint = new TextPaint();
        mTextPaint.setAntiAlias(true);

        mRectF = new RectF();
        mPath = new Path();
        mPathMeasure = new PathMeasure();
        mTextBounds = new Rect();

        mGestureDetector = new GestureDetector(getContext(), mOnGestureListener);
        mPrizeList.add(new Prize("一等奖", Color.RED));
        mPrizeList.add(new Prize("二等奖", Color.YELLOW));
        mPrizeList.add(new Prize("三等奖", Color.BLUE));
        mPrizeList.add(new Prize("谢谢你", Color.GREEN));
        mPrizeList.add(new Prize("一等奖", Color.RED));
        mPrizeList.add(new Prize("二等奖", Color.YELLOW));
        mPrizeList.add(new Prize("三等奖", Color.BLUE));
        mPrizeList.add(new Prize("谢谢你", Color.GREEN));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = mHeight = Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels);
        setMeasuredDimension(mWidth, mHeight);

        //绘制扇形的区域
        mRectF.set(0, 0, mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //保存画布状态，在绘制完扇形和文字后恢复
        canvas.save();
        //点击抽奖后开始旋转
        canvas.rotate(mRotateDegrees, (mRectF.right - mRectF.left) / 2, (mRectF.bottom - mRectF.top) / 2);

        for (int i = 0; i < mPrizeList.size(); i++) {
            //绘制扇形
            mPaint.setColor(mPrizeList.get(i).getBackgroundColor());
            //计算每个扇形开始的角度，Android 中在绘制扇形时从顺时针 90 度开始绘制，所以起始角度要减 90
            float startAngle = (float) 360 / (float) mPrizeList.size() * i - 90;
            float sweepAngle = (float) 360 / (float) mPrizeList.size();
            canvas.drawArc(mRectF, startAngle, sweepAngle, true, mPaint);

            //处理文字，因为想竖着绘制文字，一个字一个字的话
            String text = mPrizeList.get(i).getText();
            text = new StringBuilder(text).reverse().toString();
            for (int j = 0; j < text.length(); j++) {
                //重置 path，首先获取扇形的弧形部分的路径
                mPath.reset();
                mPath.addArc(mRectF, startAngle, sweepAngle);
                //获取扇形路径的起点
                mPathMeasure.setPath(mPath, false);
                mPathMeasure.getPosTan(0, pos, tan);
                //重置 path，连接圆心和扇形路径的起点
                mPath.reset();
                mPath.moveTo(mWidth / 2, mHeight / 2);
                mPath.lineTo(pos[0], pos[1]);
                //为了好看一点只在扇形的中间部分绘制文字，两头各留 1/4 的空间，获取中间一段的第 j 个等分点的坐标
                mPathMeasure.setPath(mPath, false);
                float distance = (mPathMeasure.getLength() / 2) / (text.length() - 1) * j
                        + mPathMeasure.getLength() / 4;
                mPathMeasure.getPosTan(distance, pos, tan);
                float x1 = pos[0];
                float y1 = pos[1];

                //同上，只是这里连接圆心和扇形路径的中点
                //重置 path，首先获取扇形的弧形部分的路径
                mPath.reset();
                mPath.addArc(mRectF, startAngle, sweepAngle);
                //获取扇形路径的起点
                mPathMeasure.setPath(mPath, false);
                mPathMeasure.getPosTan(mPathMeasure.getLength(), pos, tan);
                //重置 path，连接圆心和扇形路径的起点
                mPath.reset();
                mPath.moveTo(mWidth / 2, mHeight / 2);
                mPath.lineTo(pos[0], pos[1]);
                //为了好看一点只在扇形的中间部分绘制文字，两头各留 1/4 的空间，获取中间一段的第 j 个等分点的坐标
                mPathMeasure.setPath(mPath, false);
                mPathMeasure.getPosTan(distance, pos, tan);
                float x2 = pos[0];
                float y2 = pos[1];

                //重置 path，连接获取的两个第 j 个等分点，作为绘制文字的path
                mPath.reset();
                mPath.moveTo(x1, y1);
                mPath.lineTo(x2, y2);
                //修改文字画笔的颜色，字体大小等属性
                mPathMeasure.setPath(mPath, false);
                //这里 drawPath() 是为了看看文字到底是沿着哪条 path 绘制的，实际运行后要注释掉
//                mPaint.setColor(Color.BLACK);
//                mPaint.setStrokeWidth(5f);
//                mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//                canvas.drawPath(mPath, mPaint);
                //TextSize 会影响下面测量文字整体的方法 getTextBounds()，所以要在 getTextBounds() 方法前调用
                mTextPaint.setTextSize(sp2px(getContext(), 20f));
                mTextPaint.setColor(Color.BLACK);
                mTextPaint.setTypeface(Typeface.DEFAULT);
                mTextPaint.getTextBounds(text, j, j + 1, mTextBounds);
                //沿着 path 绘制文字，并且将文字绘制在路径中间，即居中绘制
                canvas.drawTextOnPath(text.substring(j, j + 1), mPath, mPathMeasure.getLength() / 2 - mTextBounds.width() / 2, 0, mTextPaint);
            }
        }
        //轮盘中心的白色圆、开始抽奖的按钮和文字不用旋转，所以在这里恢复画布状态
        canvas.restore();

        //绘制以轮盘圆心为圆心，以轮盘半径的 1/10 为半径的白色圆
        int radius = mWidth / 10;
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, mPaint);

        //绘制以轮盘圆心为圆心，以白色圆半径再减去 5dp 为半径的红色圆
        radius = mWidth / 10 - dp2px(getContext(), 5f);
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, mPaint);

        //在红色圆上绘制一个箭头
        mPath.reset();
        mPaint.setColor(Color.RED);
        mPath.moveTo(mWidth / 2 - (float) (Math.sin(Math.PI / 12) * radius)
                , mHeight / 2 - (float) (Math.cos(Math.PI / 12) * radius));
        mPath.lineTo(mWidth / 2
                , mHeight / 2 - radius * 2f);
        mPath.lineTo(mWidth / 2 + (float) (Math.sin(Math.PI / 12) * radius)
                , mHeight / 2 - (float) (Math.cos(Math.PI / 12) * radius));
        canvas.drawPath(mPath, mPaint);

        //在红色圆中绘制文字，默认为 Go
        mTextPaint.setTextSize(sp2px(getContext(), 40f));
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
        mTextPaint.getTextBounds(centerText, 0, centerText.length(), mTextBounds);
        canvas.drawText(centerText, mWidth / 2 - mTextBounds.width() / 2, mHeight / 2 + mTextBounds.height() / 2, mTextPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    private void startPrizeDraw() {
        //抽奖结果的下标
        final int random = new Random().nextInt(mPrizeList.size() - 1);
        //计算出抽奖结果所在扇形的开始度数
        float endRotateDegrees = 360 - 360 / mPrizeList.size() * random;
        //再减去扇形扫过度数的一半，让其最后旋转到抽奖结果所在扇形的中间
        endRotateDegrees -= 360 / mPrizeList.size() / 2;
        //多旋转几圈
        endRotateDegrees += 360 * 5;
        //以 endRotateDegrees 开始动画，在动画监听中更新 mRotateDegrees 的值并让其重绘
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
                if (mOnPrizeDrawListener != null) {
                    mOnPrizeDrawListener.onPrizeDrawResult(mPrizeList.get(random));
                }
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

    /**
     * Description:奖品内部类
     * Date:2019/1/11
     */
    public static class Prize {
        private String text;    //奖品名
        private int backgroundColor;    //对应扇形的背景色

        public Prize() {
        }

        public Prize(String text, int backgroundColor) {
            this.text = text;
            this.backgroundColor = backgroundColor;
        }

        public String getText() {
            return text;
        }


        public int getBackgroundColor() {
            return backgroundColor;
        }
    }

    /**
     * Description:抽奖结果回调接口
     * Date:2019/1/11
     */
    public interface IOnPrizeDrawListener {
        void onPrizeDrawResult(Prize prize);
    }

    public void setPrizeList(List<Prize> prizeList) {
        this.mPrizeList = prizeList;
        invalidate();
    }

    public void setCenterText(String centerText) {
        this.centerText = centerText;
    }

    public void setOnPrizeDrawListener(IOnPrizeDrawListener onPrizeDrawListener) {
        mOnPrizeDrawListener = onPrizeDrawListener;
    }
}
