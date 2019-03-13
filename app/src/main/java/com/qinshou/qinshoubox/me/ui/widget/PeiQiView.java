package com.qinshou.qinshoubox.me.ui.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Description:类描述
 * Author: QinHao
 * Date: 2019/2/28 17:27
 */
public class PeiQiView extends View {
    private Paint mPaint;
    private Path mPath;
    private Path mAnimatePath;
    private PathMeasure mPathMeasure;
    private float[] pos, tan;
    private float mProgress;
    private boolean mDrawNoseOver;
    private boolean mDrawHeadOver;
    private boolean mDrawEarOver;
    private boolean mDrawEyeOver;
    private boolean mDrawMouthOver;
    private boolean mDrawCheekOver;
    private boolean mDrawBodyOver;
    private boolean mDrawArmOver;
    private boolean mDrawPalmOver;
    private boolean mDrawLegOver;
    private boolean mDrawFootOver;
    private boolean mDrawTailOver;

    private long drawNoseDuration = 1500;
    private long drawHeadDuration = 2000;
    private long drawEarDuration = 1500;
    private long drawEyeDuration = 1000;
    private long drawMouthDuration = 1000;
    private long drawCheekDuration = 1000;
    private long drawBodyDuration = 2000;
    private long drawArmDuration = 1000;
    private long drawPalmDuration = 500;
    private long drawLegDuration = 1000;
    private long drawFootDuration = 500;
    private long drawTailDuration = 1000;
    private AnimatorSet mAnimatorSet;

    public PeiQiView(Context context) {
        this(context, null);
    }

    public PeiQiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PeiQiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPath = new Path();
        mAnimatePath = new Path();
        mPathMeasure = new PathMeasure();
        pos = new float[2];
        tan = new float[2];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float noseCenterX = (float) getWidth() / 5 * 3;
        float noseCenterY = (float) getHeight() / 3 * 1;

        //画鼻子
        canvas.save();
        canvas.scale(0.8f, 1f, noseCenterX, noseCenterY);
        canvas.rotate(-15, noseCenterX, noseCenterY);
        //画鼻子
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFFFA4C0"));
        mPath.reset();
        mPath.addCircle(noseCenterX, noseCenterY, 100, Path.Direction.CW);
        if (mDrawNoseOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //画鼻孔
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFFF6F43"));
        //画第一个鼻孔
        mPath.reset();
        mPath.addCircle(noseCenterX - 40, noseCenterY, 20, Path.Direction.CW);
        if (mDrawNoseOver) {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //画第二个鼻孔
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFFF6F43"));
        mPath.reset();
        mPath.addCircle(noseCenterX + 40, noseCenterY, 20, Path.Direction.CW);
        if (mDrawNoseOver) {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(mPath, mPaint);
            canvas.restore();
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            canvas.restore();
            return;
        }

        //画头
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        mPath.reset();
        mPath.moveTo(noseCenterX, noseCenterY - 100);
        mPath.cubicTo(noseCenterX - 900, noseCenterY - 150, noseCenterX - 300, noseCenterY + 600, noseCenterX - 150, noseCenterY + 150);
        mPath.quadTo(noseCenterX - 100, noseCenterY + 150, noseCenterX, noseCenterY + 100);
        if (mDrawHeadOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }
        mPathMeasure.setPath(mPath, false);
        float length = mPathMeasure.getLength();
        //记录第一只耳朵的起点和终点坐标
        mPathMeasure.getPosTan(length * 0.28f, pos, tan);
        float firstEarStartX = pos[0];
        float firstEarStartY = pos[1];
        mPathMeasure.getPosTan(length * 0.22f, pos, tan);
        float firstEarEndX = pos[0];
        float firstEarEndY = pos[1];
        //记录第二只耳朵的起点和终点坐标
        mPathMeasure.getPosTan(length * 0.20f, pos, tan);
        float secondEarStartX = pos[0];
        float secondEarStartY = pos[1];
        mPathMeasure.getPosTan(length * 0.14f, pos, tan);
        float secondEarEndX = pos[0];
        float secondEarEndY = pos[1];
        //记录身体的起点和终点坐标
        mPathMeasure.getPosTan(length * 0.60f, pos, tan);
        float bodyStartX = pos[0];
        float bodyStartY = pos[1];
        mPathMeasure.getPosTan(length * 0.80f, pos, tan);
        float bodyEndX = pos[0];
        float bodyEndY = pos[1];

        //画耳朵
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        //画第一只耳朵
        mPath.reset();
        mPath.moveTo(firstEarStartX, firstEarStartY);
        mPath.cubicTo(firstEarStartX - 50, firstEarStartY - 200, firstEarEndX, firstEarEndY - 200, firstEarEndX, firstEarEndY);
        if (mDrawEarOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //画第二只耳朵
        mPath.reset();
        mPath.moveTo(secondEarStartX, secondEarStartY);
        mPath.cubicTo(secondEarStartX - 50, secondEarStartY - 200, secondEarEndX, secondEarEndY - 200, secondEarEndX, secondEarEndY);
        if (mDrawEarOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }

        //画眼睛
        //画第一只眼睛
        //眼眶
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        mPath.reset();
        mPath.addCircle(firstEarEndX, firstEarEndY + 100, 40, Path.Direction.CW);
        if (mDrawEyeOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //瞳孔
        resetPaint();
        mPaint.setColor(Color.parseColor("#FF000000"));
        mPath.reset();
        mPath.addCircle(firstEarEndX, firstEarEndY + 100, 10, Path.Direction.CW);
        if (mDrawEyeOver) {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //画第二只眼睛
        //眼眶
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        mPath.reset();
        mPath.addCircle(secondEarEndX, secondEarEndY + 80, 40, Path.Direction.CW);
        if (mDrawEyeOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //瞳孔
        resetPaint();
        mPaint.setColor(Color.parseColor("#FF000000"));
        mPath.reset();
        mPath.addCircle(secondEarEndX, secondEarEndY + 80, 10, Path.Direction.CW);
        if (mDrawEyeOver) {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }

        //画嘴巴
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE78E7C"));
        mPath.reset();
        mPath.moveTo(firstEarEndX - 40, firstEarEndY + 300);
        mPath.cubicTo(firstEarEndX - 40, firstEarEndY + 350, secondEarEndX + 20, secondEarEndY + 350, secondEarEndX - 20, secondEarEndY + 270);
        if (mDrawMouthOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }

        //画腮红
        canvas.save();
        canvas.scale(0.8f, 1f, firstEarEndX - 100, firstEarEndY + 220);
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        mPath.reset();
        mPath.addCircle(firstEarEndX - 100, firstEarEndY + 220, 50, Path.Direction.CW);
        if (mDrawCheekOver) {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawPath(mPath, mPaint);
            canvas.restore();
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            canvas.restore();
            return;
        }

        //画身体
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE78E7C"));
        mPath.reset();
        mPath.moveTo(bodyStartX, bodyStartY);
        mPath.quadTo(bodyStartX - 60, bodyStartY + 150, bodyStartX - 50, bodyStartY + 300);
        mPath.lineTo(bodyEndX + 50, bodyEndY + 300);
        mPath.quadTo(bodyEndX + 60, bodyEndY + 150, bodyEndX, bodyEndY);
        if (mDrawBodyOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }
        //记录胳膊和腿的起点坐标
        mPathMeasure.setPath(mPath, false);
        length = mPathMeasure.getLength();
        //左胳膊起点坐标
        mPathMeasure.getPosTan(length * 0.15f, pos, tan);
        float leftArmStartX = pos[0];
        float leftArmStartY = pos[1];
        //右胳膊起点坐标
        mPathMeasure.getPosTan(length * 0.85f, pos, tan);
        float rightArmStartX = pos[0];
        float rightArmStartY = pos[1];
        //左腿起点坐标
        mPathMeasure.getPosTan(length * 0.45f, pos, tan);
        float leftLegStartX = pos[0];
        float leftLegStartY = pos[1];
        //右腿起点坐标
        mPathMeasure.getPosTan(length * 0.55f, pos, tan);
        float rightLegStartX = pos[0];
        float rightLegStartY = pos[1];
        //尾巴起点坐标
        mPathMeasure.getPosTan(length * 0.25f, pos, tan);
        float tailStartX = pos[0];
        float tailStartY = pos[1];

        //画胳膊
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        //画左胳膊
        mPath.reset();
        mPath.moveTo(leftArmStartX, leftArmStartY);
        mPath.quadTo(leftArmStartX - 50, leftArmStartY, leftArmStartX - 100, leftArmStartY + 30);
        if (mDrawArmOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //画右胳膊
        mPath.reset();
        mPath.moveTo(rightArmStartX, rightArmStartY);
        mPath.quadTo(rightArmStartX + 50, rightArmStartY, rightArmStartX + 100, rightArmStartY + 30);
        if (mDrawArmOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }
        //画左手手掌
        mPath.reset();
        mPath.moveTo(leftArmStartX - 100, leftArmStartY + 30 - 30);
        mPath.quadTo(leftArmStartX - 50, leftArmStartY + 30 - 15, leftArmStartX - 100, leftArmStartY + 30 + 30);
        if (mDrawPalmOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
        //画右手手掌
        mPath.reset();
        mPath.moveTo(rightArmStartX + 100, rightArmStartY + 30 - 30);
        mPath.quadTo(rightArmStartX + 50, rightArmStartY + 30 - 15, rightArmStartX + 100, rightArmStartY + 30 + 30);
        if (mDrawPalmOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
            return;
        }

        //画左腿
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        if (mDrawLegOver) {
            canvas.drawLine(leftLegStartX, leftLegStartY, leftLegStartX, leftLegStartY + 100, mPaint);
        } else {
            canvas.drawLine(leftLegStartX, leftLegStartY, leftLegStartX, leftLegStartY + 100 * mProgress, mPaint);
        }
        //画右腿
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        if (mDrawLegOver) {
            canvas.drawLine(rightLegStartX, rightLegStartY, rightLegStartX, rightLegStartY + 100, mPaint);
        } else {
            canvas.drawLine(rightLegStartX, rightLegStartY, rightLegStartX, rightLegStartY + 100 * mProgress, mPaint);
            return;
        }
        //画左脚脚掌
        resetPaint();
        mPaint.setColor(Color.parseColor("#FF000000"));
        mPaint.setStrokeWidth(15f);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        if (mDrawFootOver) {
            canvas.drawLine(leftLegStartX, leftLegStartY + 100, leftLegStartX + 20, leftLegStartY + 100, mPaint);
        } else {
            canvas.drawLine(leftLegStartX, leftLegStartY + 100, leftLegStartX + 20 * mProgress, leftLegStartY + 100, mPaint);
        }
        //画右脚脚掌
        resetPaint();
        mPaint.setColor(Color.parseColor("#FF000000"));
        mPaint.setStrokeWidth(15f);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        if (mDrawFootOver) {
            canvas.drawLine(rightLegStartX, rightLegStartY + 100, rightLegStartX + 20, rightLegStartY + 100, mPaint);
        } else {
            canvas.drawLine(rightLegStartX, rightLegStartY + 100, rightLegStartX + 20 * mProgress, rightLegStartY + 100, mPaint);
            return;
        }

        //画最后的尾巴
        resetPaint();
        mPaint.setColor(Color.parseColor("#FFE8B5C5"));
        mPath.reset();
        mPath.moveTo(tailStartX, tailStartY);
        mPath.cubicTo(tailStartX - (tailStartX - 50) / 2, tailStartY + 30, tailStartX - (tailStartX - 50) / 2, tailStartY - 20 - 30, tailStartX - (tailStartX - 50) / 2 + 30, tailStartY - 20);
        mPath.cubicTo(tailStartX - (tailStartX - 50) / 2 + 30, tailStartY - 20 + 30, 50, tailStartY + 20 + 30, 50, tailStartY + 20);
        if (mDrawTailOver) {
            canvas.drawPath(mPath, mPaint);
        } else {
            mAnimatePath.reset();
            mPathMeasure.setPath(mPath, false);
            mPathMeasure.getSegment(0, mPathMeasure.getLength() * mProgress, mAnimatePath, true);
            canvas.drawPath(mAnimatePath, mPaint);
        }
    }

    private void resetPaint() {
        if (mPaint == null) {
            mPaint = new Paint();
        }
        mPaint.setStrokeWidth(3f);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setStyle(Paint.Style.STROKE);
    }

    public void drawPeiQi() {
        mDrawNoseOver = false;
        mDrawHeadOver = false;
        mDrawEarOver = false;
        mDrawEyeOver = false;
        mDrawMouthOver = false;
        mDrawCheekOver = false;
        mDrawBodyOver = false;
        mDrawArmOver = false;
        mDrawPalmOver = false;
        mDrawLegOver = false;
        mDrawFootOver = false;
        mDrawTailOver = false;
        if (mAnimatorSet == null) {
            mAnimatorSet = new AnimatorSet();
        }
        mAnimatorSet.cancel();
        ValueAnimator drawNoseAnimator = ValueAnimator.ofFloat(0, 1);
        drawNoseAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawNoseOver = (mProgress == 1);
                invalidate();
            }
        });
        drawNoseAnimator.setDuration(drawNoseDuration);
        ValueAnimator drawHeadAnimator = ValueAnimator.ofFloat(0, 1);
        drawHeadAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawHeadOver = (mProgress == 1);
                invalidate();
            }
        });
        drawHeadAnimator.setDuration(drawHeadDuration);
        ValueAnimator drawEarAnimator = ValueAnimator.ofFloat(0, 1);
        drawEarAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawEarOver = (mProgress == 1);
                invalidate();
            }
        });
        drawEarAnimator.setDuration(drawEarDuration);
        ValueAnimator drawEyeAnimator = ValueAnimator.ofFloat(0, 1);
        drawEyeAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawEyeOver = (mProgress == 1);
                invalidate();
            }
        });
        drawEyeAnimator.setDuration(drawEyeDuration);
        ValueAnimator drawMouthAnimator = ValueAnimator.ofFloat(0, 1);
        drawMouthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawMouthOver = (mProgress == 1);
                invalidate();
            }
        });
        drawMouthAnimator.setDuration(drawMouthDuration);
        ValueAnimator drawCheekAnimator = ValueAnimator.ofFloat(0, 1);
        drawCheekAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawCheekOver = (mProgress == 1);
                invalidate();
            }
        });
        drawCheekAnimator.setDuration(drawCheekDuration);
        ValueAnimator drawBodyAnimator = ValueAnimator.ofFloat(0, 1);
        drawBodyAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawBodyOver = (mProgress == 1);
                invalidate();
            }
        });
        drawBodyAnimator.setDuration(drawBodyDuration);
        ValueAnimator drawArmAnimator = ValueAnimator.ofFloat(0, 1);
        drawArmAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawArmOver = (mProgress == 1);
                invalidate();
            }
        });
        drawArmAnimator.setDuration(drawArmDuration);
        ValueAnimator drawPalmAnimator = ValueAnimator.ofFloat(0, 1);
        drawPalmAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawPalmOver = (mProgress == 1);
                invalidate();
            }
        });
        drawPalmAnimator.setDuration(drawPalmDuration);
        ValueAnimator drawLegAnimator = ValueAnimator.ofFloat(0, 1);
        drawLegAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawLegOver = (mProgress == 1);
                invalidate();
            }
        });
        drawLegAnimator.setDuration(drawLegDuration);
        ValueAnimator drawFootAnimator = ValueAnimator.ofFloat(0, 1);
        drawFootAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawFootOver = (mProgress == 1);
                invalidate();
            }
        });
        drawFootAnimator.setDuration(drawFootDuration);
        ValueAnimator drawTailAnimator = ValueAnimator.ofFloat(0, 1);
        drawTailAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress = (float) animation.getAnimatedValue();
                mDrawTailOver = (mProgress == 1);
                invalidate();
            }
        });
        drawTailAnimator.setDuration(drawTailDuration);
        mAnimatorSet.play(drawNoseAnimator);
        mAnimatorSet.play(drawHeadAnimator).after(drawNoseAnimator);
        mAnimatorSet.play(drawEarAnimator).after(drawHeadAnimator);
        mAnimatorSet.play(drawEyeAnimator).after(drawEarAnimator);
        mAnimatorSet.play(drawMouthAnimator).after(drawEyeAnimator);
        mAnimatorSet.play(drawCheekAnimator).after(drawMouthAnimator);
        mAnimatorSet.play(drawBodyAnimator).after(drawCheekAnimator);
        mAnimatorSet.play(drawArmAnimator).after(drawBodyAnimator);
        mAnimatorSet.play(drawPalmAnimator).after(drawArmAnimator);
        mAnimatorSet.play(drawLegAnimator).after(drawPalmAnimator);
        mAnimatorSet.play(drawFootAnimator).after(drawLegAnimator);
        mAnimatorSet.play(drawTailAnimator).after(drawFootAnimator);
        mAnimatorSet.start();
    }
}
