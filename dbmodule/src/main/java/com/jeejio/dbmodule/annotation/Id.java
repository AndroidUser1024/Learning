package com.jeejio.dbmodule.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/12 17:54
 * Description:该注解用于定义该成员变量对应的列为主键
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Id {
    boolean autoIncrement() default false;

    boolean useGeneratedKeys() default false;
}
