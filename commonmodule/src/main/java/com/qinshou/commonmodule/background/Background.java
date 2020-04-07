package com.qinshou.commonmodule.background;

import androidx.annotation.ColorInt;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/6 16:24
 * Description:使用注解来设置背景,减少 drawable.xml 文件
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Repeatable(value = Backgrounds.class)
public @interface Background {
    /**
     * 该背景对应的控件状态,{@link State}
     */
    State[] state() default {};

    /**
     * 填充色
     */
    @ColorInt int solid() default 0x00000000;

    /**
     * 边框宽度
     */
    int strokeWidth() default 0;

    /**
     * 边框颜色
     */
    @ColorInt int strokeColor() default 0x00000000;

    /**
     * 虚线宽度
     */
    int strokeDashWidth() default 0;

    /**
     * 虚线间隔
     */
    int strokeDashGap() default 0;

    /**
     * 圆角度数
     */
    int radius() default 0;

    /**
     * 左上角圆角度数
     */
    int topLeftRadius() default 0;

    /**
     * 右上角圆角度数
     */
    int topRightRadius() default 0;

    /**
     * 左下角圆角度数
     */
    int bottomLeftRadius() default 0;

    /**
     * 右上角圆角度数
     */
    int bottomRightRadius() default 0;
}