package com.qinshou.commonmodule.background;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/4/7 9:12
 * Description:使用注解来设置背景的帮助类
 */
public enum BackgroundManager {
    SINGLETON;

    /**
     * Author: QinHao
     * Email:qinhao@jeejio.com
     * Date:2020/4/7 14:24
     * Description:调用该方法来初始化指定类中使用了 Background 注解的控件的背景
     */
    public void init(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            // 先判断该成员变量是不是 View 的子类
            if (field.getType().isInstance(View.class)) {
                continue;
            }
            // 获取 Background 注解
            Annotation[] annotationArray = field.getAnnotations();
            List<Background> backgroundList = new ArrayList<>();
            for (Annotation annotation : annotationArray) {
                // Background 注解允许重复作用在同一个属性上
                if (annotation.annotationType() == Backgrounds.class) {
                    backgroundList.addAll(Arrays.asList(((Backgrounds) annotation).value()));
                }
                if (annotation.annotationType() == Background.class) {
                    backgroundList.add((Background) annotation);
                }
            }
            // 没有使用 Background 则跳过
            if (backgroundList.size() == 0) {
                continue;
            }
            // 获取 setBackground 方法
            Method setBackground;
            try {
                // 获取父类的 setBackground 方法
                setBackground = field.getType().getMethod("setBackground", Drawable.class);
            } catch (NoSuchMethodException e) {
                continue;
            }
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            // 没有对应控件状态的默认背景,这个需要放在最后
            GradientDrawable defaultBackground = null;
            StateListDrawable stateListDrawable = new StateListDrawable();
            for (Background background : backgroundList) {
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(background.solid());
                gradientDrawable.setStroke(background.strokeWidth()
                        , background.strokeColor()
                        , background.strokeDashWidth()
                        , background.strokeDashGap());
                gradientDrawable.setCornerRadii(new float[]{
                        background.topLeftRadius() == 0 ? background.radius() : background.topLeftRadius(),
                        background.topLeftRadius() == 0 ? background.radius() : background.topLeftRadius(),
                        background.topRightRadius() == 0 ? background.radius() : background.topRightRadius(),
                        background.topRightRadius() == 0 ? background.radius() : background.topRightRadius(),
                        background.bottomLeftRadius() == 0 ? background.radius() : background.bottomLeftRadius(),
                        background.bottomLeftRadius() == 0 ? background.radius() : background.bottomLeftRadius(),
                        background.bottomRightRadius() == 0 ? background.radius() : background.bottomRightRadius(),
                        background.bottomRightRadius() == 0 ? background.radius() : background.bottomRightRadius()
                });
                if (background.state().length == 0) {
                    // 没有对应控件状态的默认背景,这个需要放在最后
                    defaultBackground = gradientDrawable;
                } else {
                    for (State state : background.state()) {
                        // 添加控件对应状态的对应背景
                        stateListDrawable.addState(new int[]{state.getValue()}, gradientDrawable);
                    }
                }
            }
            if (defaultBackground != null) {
                stateListDrawable.addState(new int[]{}, defaultBackground);
            }
            try {
                setBackground.invoke(field.get(object), stateListDrawable);
            } catch (Exception ignored) {
            }
        }
    }
}
