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

import com.qinshou.commonmodule.util.ShowLogUtil;
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
    private int mCount;
    private IOnCountCallback mOnCountCallback;

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
                if (mKlotskiBeanArray[x][y].getType() == KlotskiBean.Type.NULL) {
                    break;
                }
                boolean moveResult;
                if (Math.abs(event.getX() - mDownX) > Math.abs(event.getY() - mDownY)) {
                    if (event.getX() - mDownX > 0) {
                        // 右滑
                        moveResult = move2Right(x, y);
                    } else {
                        // 左滑
                        moveResult = move2Left(x, y);
                    }
                } else {
                    if (event.getY() - mDownY > 0) {
                        // 下滑
                        moveResult = move2Bottom(x, y);
                    } else {
                        // 上滑
                        moveResult = move2Top(x, y);
                    }
                }
                mDownX = 0;
                mDownY = 0;
                if (mOnCountCallback != null && moveResult) {
                    mOnCountCallback.onCount(++mCount);
                }
                if (mSuccess = success()) {
                    Toast.makeText(getContext(), "恭喜成功", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到左边
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Left(int x, int y) {
        if (y == 0) {
            return false;
        }
        // 记录这一方块在做完交换后,是否还有另一方块需要移动
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        // 向左移动时,如果宽度为 2,还需要移动相关联的那一个方块
        if (touchKlotskiBean.getWidth() == 2) {
            if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在左边,则先移动关联方块,再移动这一块
                return move2Left(x, y - 1);
            } else if (y < mKlotskiBeanArray[x].length - 1
                    && mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在右边,则将标志位置为 true,在这一块移动完之后再移动关联方块
                again = true;
            }
        }
        if (touchKlotskiBean.getHeight() == 1) {
            // 高度为 1 时,判断是否可以交换后直接交换
            if (mKlotskiBeanArray[x][y - 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getHeight() == 2) {
            // 高度为 2 时,判断完这一块是否可以交换后,还需要判断关联方块是否可以交换
            if (mKlotskiBeanArray[x][y - 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (x == 0) {
                // 触摸的方块在最上方,直接判断下方方块就好
                if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x + 1][y];
                mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
            } else if (x == mKlotskiBeanArray.length - 1) {
                // 触摸的方块在最下方,直接判断上方方块就好
                if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x - 1][y];
                mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
            } else {
                // 触摸的方块在中间,需要先判读关联方块在上还是在下
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x - 1][y];
                    mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y - 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x + 1][y];
                    mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            move2Left(x, y + 1);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到右边
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Right(int x, int y) {
        if (y == mKlotskiBeanArray[x].length - 1) {
            return false;
        }
        // 记录这一方块在做完交换后,是否还有另一方块需要移动
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        // 向右移动时,如果宽度为 2,还需要移动相关联的那一个方块
        if (touchKlotskiBean.getWidth() == 2) {
            if (y > 0 && mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在左边,则将标志位置为 true,在这一块移动完之后再移动关联方块
                again = true;
            } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在右边,则先移动关联方块,再移动这一块
                return move2Right(x, y + 1);
            }
        }
        if (touchKlotskiBean.getHeight() == 1) {
            // 高度为 1 时,判断是否可以交换后直接交换
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getHeight() == 2) {
            // 高度为 2 时,判断完这一块是否可以交换后,还需要判断关联方块是否可以交换
            if (mKlotskiBeanArray[x][y + 1].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (x == 0) {
                // 触摸的方块在最上方,直接判断下方方块就好
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
            } else if (x == mKlotskiBeanArray.length - 1) {
                // 触摸的方块在最下方,直接判断上方方块就好
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
            } else {
                // 触摸的方块在中间,需要先判读关联方块在上还是在下
                if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x - 1][y];
                    mKlotskiBeanArray[x - 1][y] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x][y + 1] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x + 1][y];
                    mKlotskiBeanArray[x + 1][y] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            move2Right(x, y - 1);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到上面
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Top(int x, int y) {
        if (x == 0) {
            return false;
        }
        // 记录这一方块在做完交换后,是否还有另一方块需要移动
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        // 向上移动时,如果高度为 2,还需要移动相关联的那一个方块
        if (touchKlotskiBean.getHeight() == 2) {
            if (mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在上方,则先移动关联方块,再移动这一块
                return move2Top(x - 1, y);
            } else if (x < mKlotskiBeanArray.length - 1 &&
                    mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在下方,则将标志位置为 true,在这一块移动完之后再移动关联方块
                again = true;
            }
        }
        if (touchKlotskiBean.getWidth() == 1) {
            // 宽度为 1 时,判断是否可以交换后直接交换
            if (mKlotskiBeanArray[x - 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getWidth() == 2) {
            // 宽度为 2 时,判断完这一块是否可以交换后,还需要判断关联方块是否可以交换
            if (mKlotskiBeanArray[x - 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (y == 0) {
                if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                // 触摸的方块在最左边,直接判断右边方块就好
                mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
            } else if (y == mKlotskiBeanArray.length - 1) {
                // 触摸的方块在最右边,直接判断左边方块就好
                if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
            } else {
                // 触摸的方块在中间,需要先判读关联方块在左还是在右
                if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                    mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x - 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x - 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x - 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                    mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            move2Top(x + 1, y);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:08
     * Description:移动到下面
     *
     * @param x 触摸的方块在棋盘中的 x 坐标,非绘制坐标
     * @param y 触摸的方块在棋盘中的 y 坐标,非绘制坐标
     */
    private boolean move2Bottom(int x, int y) {
        if (x == mKlotskiBeanArray.length - 1) {
            return false;
        }
        // 记录这一方块在做完交换后,是否还有另一方块需要移动
        boolean again = false;
        KlotskiBean touchKlotskiBean = mKlotskiBeanArray[x][y];
        // 向下移动时,如果高度为 2,还需要移动相关联的那一个方块
        if (touchKlotskiBean.getHeight() == 2) {
            if (x > 0
                    && mKlotskiBeanArray[x - 1][y].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在上方,则将标志位置为 true,在这一块移动完之后再移动关联方块
                again = true;
            } else if (mKlotskiBeanArray[x + 1][y].getType() == touchKlotskiBean.getType()) {
                // 如果相关联的方块是在下方,则先移动关联方块,再移动这一块
                return move2Bottom(x + 1, y);
            }
        }
        if (touchKlotskiBean.getWidth() == 1) {
            // 宽度为 1 时,判断是否可以交换后直接交换
            if (mKlotskiBeanArray[x + 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
            mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
        } else if (touchKlotskiBean.getWidth() == 2) {
            // 宽度为 2 时,判断完这一块是否可以交换后,还需要判断关联方块是否可以交换
            if (mKlotskiBeanArray[x + 1][y].getType() != KlotskiBean.Type.NULL) {
                return false;
            }
            if (y == 0) {
                // 触摸的方块在最左边,直接判断右边方块就好
                if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
            } else if (y == mKlotskiBeanArray.length - 1) {
                // 触摸的方块在最右边,直接判断左边方块就好
                if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                    return false;
                }
                mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
            } else {
                // 触摸的方块在中间,需要先判读关联方块在左还是在右
                if (mKlotskiBeanArray[x][y - 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y - 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y - 1] = mKlotskiBeanArray[x][y - 1];
                    mKlotskiBeanArray[x][y - 1] = KlotskiBean.NULL;
                } else if (mKlotskiBeanArray[x][y + 1].getType() == touchKlotskiBean.getType()) {
                    if (mKlotskiBeanArray[x + 1][y + 1].getType() != KlotskiBean.Type.NULL) {
                        return false;
                    }
                    mKlotskiBeanArray[x + 1][y] = touchKlotskiBean;
                    mKlotskiBeanArray[x][y] = KlotskiBean.NULL;
                    mKlotskiBeanArray[x + 1][y + 1] = mKlotskiBeanArray[x][y + 1];
                    mKlotskiBeanArray[x][y + 1] = KlotskiBean.NULL;
                }
            }
        }
        if (again) {
            move2Bottom(x - 1, y);
        }
        invalidate();
        return true;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:30
     * Description:判断是否成功,曹操在棋盘最下面的中间时,即为解密成功
     *
     * @return 是否解密成功
     */
    private boolean success() {
        return mKlotskiBeanArray[4][1].getType() == KlotskiBean.Type.CAO_CAO && mKlotskiBeanArray[4][2].getType() == KlotskiBean.Type.CAO_CAO;
    }

    /**
     * Author: QinHao
     * Email:cqflqinhao@126.com
     * Date:2020/5/20 18:30
     * Description:开始游戏
     */
    public void startGame() {
        mKlotskiBeanArray = new KlotskiBean[][]{
                new KlotskiBean[]{new ShiBing(getContext()), new CaoCao1(getContext()), new CaoCao2(getContext()), new ShiBing(getContext())}
                , new KlotskiBean[]{new ShiBing(getContext()), new CaoCao3(getContext()), new CaoCao4(getContext()), new ShiBing(getContext())}
                , new KlotskiBean[]{new Null(), new GuanYu1(getContext()), new GuanYu2(getContext()), new Null()}
                , new KlotskiBean[]{new ZhangFei1(getContext()), new ZhaoYun1(getContext()), new HuangZhong1(getContext()), new MaChao1(getContext())}
                , new KlotskiBean[]{new ZhangFei2(getContext()), new ZhaoYun2(getContext()), new HuangZhong2(getContext()), new MaChao2(getContext())}
        };
        mSuccess = false;
        invalidate();
    }

    public void setOnCountCallback(IOnCountCallback onCountCallback) {
        mOnCountCallback = onCountCallback;
    }

    public interface IOnCountCallback {
        void onCount(int count);
    }
}
