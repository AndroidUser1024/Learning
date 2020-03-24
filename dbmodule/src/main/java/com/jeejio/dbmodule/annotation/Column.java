package com.jeejio.dbmodule.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/3/12 17:54
 * Description:该注解用于建立成员变量与列名的对应关系
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
    enum Type {
        NULL, INTEGER, LONG, REAL, TEXT, BLOB
    }

    Type type() default Type.TEXT;

    String name() default "";

    boolean primaryKey() default false;
}