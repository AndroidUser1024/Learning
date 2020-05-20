package com.qinshou.qinshoubox.me.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.qinshou.qinshoubox.me.bean.klotski.CaoCao1;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao2;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao3;
import com.qinshou.qinshoubox.me.bean.klotski.CaoCao4;
import com.qinshou.qinshoubox.me.bean.klotski.GuanYu1;
import com.qinshou.qinshoubox.me.bean.klotski.GuanYu2;
import com.qinshou.qinshoubox.me.bean.klotski.HuangZhong1;
import com.qinshou.qinshoubox.me.bean.klotski.HuangZhong2;
import com.qinshou.qinshoubox.me.bean.klotski.KlotskiBean;
import com.qinshou.qinshoubox.me.bean.klotski.MaChao1;
import com.qinshou.qinshoubox.me.bean.klotski.MaChao2;
import com.qinshou.qinshoubox.me.bean.klotski.Null;
import com.qinshou.qinshoubox.me.bean.klotski.ShiBing;
import com.qinshou.qinshoubox.me.bean.klotski.ZhangFei1;
import com.qinshou.qinshoubox.me.bean.klotski.ZhangFei2;
import com.qinshou.qinshoubox.me.bean.klotski.ZhaoYun1;
import com.qinshou.qinshoubox.me.bean.klotski.ZhaoYun2;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/5/19 17:21
 * Description:华容道控件
 */
public class KlotskiView extends View {
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    //    private KlotskiBean[][] mKlotskiBeanArray = new KlotskiBean[][]{
//            new KlotskiBean[]{KlotskiBean.ZHAO_YUN, KlotskiBean.CAO_CAO, KlotskiBean.CAO_CAO, KlotskiBean.HUANG_ZHONG}
//            , new KlotskiBean[]{KlotskiBean.ZHAO_YUN, KlotskiBean.CAO_CAO, KlotskiBean.CAO_CAO, KlotskiBean.HUANG_ZHONG}
//            , new KlotskiBean[]{KlotskiBean.ZHANG_FEI, KlotskiBean.GUAN_YU, KlotskiBean.GUAN_YU, KlotskiBean.MA_CHAO}
//            , new KlotskiBean[]{KlotskiBean.ZHANG_FEI, KlotskiBean.BING, KlotskiBean.BING, KlotskiBean.MA_CHAO}
//            , new KlotskiBean[]{KlotskiBean.BING, KlotskiBean.NULL, KlotskiBean.NULL, KlotskiBean.BING}
//    };
    private KlotskiBean[][] mKlotskiBeanArray = new KlotskiBean[][]{
            new KlotskiBean[]{new ShiBing(getContext()), new CaoCao1(getContext()), new CaoCao2(getContext()), new ShiBing(getContext())}
            , new KlotskiBean[]{new ShiBing(getContext()), new CaoCao3(getContext()), new CaoCao4(getContext()), new ShiBing(getContext())}
            , new KlotskiBean[]{new Null(), new GuanYu1(getContext()), new GuanYu2(getContext()), new Null()}
            , new KlotskiBean[]{new ZhangFei1(getContext()), new ZhaoYun1(getContext()), new HuangZhong1(getContext()), new MaChao1(getContext())}
            , new KlotskiBean[]{new ZhangFei2(getContext()), new ZhaoYun2(getContext()), new HuangZhong2(getContext()), new MaChao2(getContext())}
    };
    private boolean mSuccess = false;

    public KlotskiView(Context context) {
        this(context, null);
    }

    public KlotskiView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KlotskiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int min = Math.min(getContext().getResources().getDisplayMetrics().widthPixels, getContext().getResources().getDisplayMetrics().heightPixels);
        int width = min;
        int height = min / 4 * 5;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mKlotskiBeanArray.length; x++) {
            int top = getHeight() / mKlotskiBeanArray.length * x;
            int bottom = getHeight() / mKlotskiBeanArray.length * (x + 1);
            for (int y = 0; y < mKlotskiBeanArray[x].length; y++) {
                int left = getWidth() / mKlotskiBeanArray[y].length * y;
//                int right = getWidth() / mKlotskiBeanArray[y].length * (y + 1);
//                mRect.set(left, top, right, bottom);
//                mPaint.setColor(mKlotskiBeanArray[x][y].getColor());
//                canvas.drawRect(mRect, mPaint);
                if (mKlotskiBeanArray[x][y].getBitmap() != null) {
                    canvas.drawBitmap(mKlotskiBeanArray[x][y].getBitmap(), left, top, mPaint);
                }
            }
        }
    }

    private float mDownX, mDownY;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mSuccess) {
            return true;
        }
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
                if (mKlotskiBeanArray[x][y] == null) {
                    break;
                }
                if (Math.abs(event.getX() - mDownX) > Math.abs(event.getY() - mDownY)) {
                    if (event.getX() - mDownX > 0) {
                        // 右滑
                        swapRight(x, y);
                    } else {
                        // 左滑
                        swapLeft(x, y);
                    }
                } else {
                    if (event.getY() - mDownY > 0) {
                        // 下滑
                        swapBottom(x, y);
                    } else {
                        // 上滑
                        swapTop(x, y);
                    }
                }
                mDownX = 0;
                mDownY = 0;
                if (mSuccess = success()) {
                    Toast.makeText(getContext(), "恭喜成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;
    }

    private void swapLeft(int x, int y) {
        if (y == 0) {
            return;
        }
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        if (touchKlotskiBean.getWidth() == 2) {
            if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                swapLeft(x, y - 1);
            } else if (y < mKlotskiBeanArray[x].length - 1
                    && mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                again = true;
            }
        }
        if (touchKlotskiBean.getHeight() == 1) {
            if (mKlotskiBeanArray[x][y - 1].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x][y - 1].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            if (x == 0) {
                if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x + 1][y];
                mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
            } else if (x == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x - 1][y];
                mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
            } else {
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x - 1][y];
                    mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x + 1][y];
                    mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            swapLeft(x, y + 1);
        }
        invalidate();
    }

    private void swapRight(int x, int y) {
        if (y == mKlotskiBeanArray[x].length - 1) {
            return;
        }
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        if (touchKlotskiBean.getWidth() == 2) {
            if (y > 0 && mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                again = true;
            } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                swapRight(x, y + 1);
            }
        }
        if (touchKlotskiBean.getHeight() == 1) {
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            if (x == 0) {
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
            } else if (x == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
            } else {
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                    mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                    mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            swapRight(x, y - 1);
        }
        invalidate();
    }

    private void swapTop(int x, int y) {
        if (x == 0) {
            return;
        }
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                swapTop(x - 1, y);
            } else if (x < mKlotskiBeanArray.length - 1 &&
                    mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                again = true;
            }
        }
        if (touchKlotskiBean.getWidth() == 1) {
            if (mKlotskiBeanArray[x - 1][y].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getWidth() == 2) {
            if (mKlotskiBeanArray[x - 1][y].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            if (y == 0) {
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
            } else if (y == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
            } else {
                if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                    mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                    mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            swapTop(x + 1, y);
        }
        invalidate();
    }

    private void swapBottom(int x, int y) {
        if (x == mKlotskiBeanArray.length - 1) {
            return;
        }
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        if (touchKlotskiBean.getHeight() == 2) {
            if (x > 0
                    && mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                again = true;
            } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                swapBottom(x + 1, y);
            }
        }
        if (touchKlotskiBean.getWidth() == 1) {
            if (mKlotskiBeanArray[x + 1][y].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getWidth() == 2) {
            if (mKlotskiBeanArray[x + 1][y].getType() != KlotskiBean.Type.NULL) {
                return;
            }
            if (y == 0) {
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
            } else if (y == mKlotskiBeanArray.length - 1) {
                if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return;
                }
                mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
            } else {
                if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                    mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return;
                    }
                    mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                    mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            swapBottom(x - 1, y);
        }
        invalidate();
    }

    private boolean success() {
        return mKlotskiBeanArray[4][1].getType() == KlotskiBean.Type.CAO_CAO && mKlotskiBeanArray[4][2].getType() == KlotskiBean.Type.CAO_CAO;
    }

    public void startGame() {
        mKlotskiBeanArray = new KlotskiBean[][]{
                new KlotskiBean[]{new ShiBing(getContext()), KlotskiBean.CAO_CAO, KlotskiBean.CAO_CAO, new ShiBing(getContext())}
                , new KlotskiBean[]{new ShiBing(getContext()), KlotskiBean.CAO_CAO, KlotskiBean.CAO_CAO, new ShiBing(getContext())}
                , new KlotskiBean[]{KlotskiBean.NULL, KlotskiBean.GUAN_YU, KlotskiBean.GUAN_YU, KlotskiBean.NULL}
                , new KlotskiBean[]{KlotskiBean.ZHANG_FEI, KlotskiBean.ZHAO_YUN, KlotskiBean.HUANG_ZHONG, KlotskiBean.MA_CHAO}
                , new KlotskiBean[]{KlotskiBean.ZHANG_FEI, KlotskiBean.ZHAO_YUN, KlotskiBean.HUANG_ZHONG, KlotskiBean.MA_CHAO}
        };
        mSuccess = false;
        invalidate();
    }
}
