package com.qinshou.commonmodule.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

/**
 * Description:
 * Created by 禽兽先生
 * Created on 2018/11/19
 */
public class BackgroundUtil {
    private Builder mBuilder;

    public BackgroundUtil(Builder builder) {
        mBuilder = builder;
    }

    public void setBackGround() {
        mBuilder.mView.setBackground(mBuilder.mDrawable);
    }

    public static abstract class Builder {
        View mView;
        Drawable mDrawable;

        public Builder(View view, Drawable drawable) {
            mView = view;
            mDrawable = drawable;
        }
    }

    /**
     * Description:单一状态的背景的建造者
     * Date:2018/11/20
     */
    public static class BackgroundBuilder extends Builder {
        //该构造方法是给多状态的背景的建造者用的，多状态时调用 getDrawable() 获取背景图片
        //如果使用该构造方法再调用 create() 那是会抛出 NullPointException 的
        public BackgroundBuilder() {
            super(null, new GradientDrawable());
        }

        //该构造方法是给单一状态的背景的建造者用的
        public BackgroundBuilder(View view) {
            super(view, new GradientDrawable());
        }

        /**
         * Description:设置背景颜色
         * Date:2018/11/20
         */
        public BackgroundBuilder setSolid(int color) {
            ((GradientDrawable) mDrawable).setColor(color);
            return this;
        }

        /**
         * Description:设置边框
         * Date:2018/11/20
         *
         * @param width 边框宽度，直接传入 dp 即可，内部会转为 px
         * @param color 边框颜色
         */
        public BackgroundBuilder setStroke(int width, int color) {
            return setStroke(width, color, 0, 0);
        }

        /**
         * Description:设置边框
         * Date:2018/11/20
         *
         * @param width     边框宽度，直接传入 dp 即可，内部会转为 px
         * @param color     边框颜色
         * @param dashWidth 边框为虚线时每一段的宽度
         * @param dashGap   边框为虚线时每一段的间隔
         */
        public BackgroundBuilder setStroke(int width, int color, float dashWidth, float dashGap) {
            ((GradientDrawable) mDrawable).setStroke(DisplayUtil.dp2px(mView.getContext(), width), color, dashWidth, dashGap);
            return this;
        }

        /**
         * Description:设置圆角，四个圆角同一半径
         * Date:2018/11/20
         */
        public BackgroundBuilder setCorner(float radius) {
            return setCorner(radius, radius, radius, radius);
        }

        /**
         * Description:设置圆角
         * Date:2018/11/20
         *
         * @param f1 左上角圆角半径
         * @param f2 右上角圆角半径
         * @param f3 右下角圆角半径
         * @param f4 左下角圆角半径
         */
        public BackgroundBuilder setCorner(float f1, float f2, float f3, float f4) {
            //1、2 控制左上角圆角，3、4 控制右上角圆角，5、6 控制右下角圆角，7、8 控制左下角圆角
            ((GradientDrawable) mDrawable).setCornerRadii(new float[]{f1, f1, f2, f2, f3, f3, f4, f4});
            return this;
        }

        public BackgroundUtil create() {
            return new BackgroundUtil(this);
        }

        /**
         * Description:获取图片
         * Date:2018/11/20
         */
        public Drawable getDrawable() {
            return mDrawable;
        }
    }

    /**
     * Description:多状态的背景的建造者
     * Date:2018/11/20
     */
    public static class StateBackgroundBuilder extends Builder {
        public enum State {
            ENABLED(android.R.attr.state_enabled), NOT_ENABLED(-android.R.attr.state_enabled), CHECKED(android.R.attr.state_checked), NOT_CHECKED(-android.R.attr.state_checked), FOCUSED(android.R.attr.state_focused), NOT_FOCUSED(-android.R.attr.state_focused), PRESSED(android.R.attr.state_pressed), NOT_PRESSED(-android.R.attr.state_pressed), SELECTED(android.R.attr.state_selected), NOT_SELECTED(-android.R.attr.state_selected);

            State(int value) {
                this.value = value;
            }

            private int value;

            public int getValue() {
                return value;
            }
        }

        public StateBackgroundBuilder(View view) {
            super(view, new StateListDrawable());
        }

        /**
         * Description:添加某种状态的背景，Drawable 可以通过 BackgroundBuilder 获取
         * Date:2018/11/20
         */
        public StateBackgroundBuilder addState(Drawable drawable, State... state) {
            int[] intArray = new int[state.length];
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = state[i].getValue();
            }
            ((StateListDrawable) mDrawable).addState(intArray, drawable);
            return this;
        }

        public BackgroundUtil create() {
            return new BackgroundUtil(this);
        }
    }


}
