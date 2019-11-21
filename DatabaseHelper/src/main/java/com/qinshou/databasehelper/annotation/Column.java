package com.qinshou.databasehelper.annotation;

import com.qinshou.databasehelper.enums.ColumnType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/21 17:39
 * Description:该注解用于标识列
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Column {
    String name() default "";

    ColumnType columnType() default ColumnType.TEXT;
}
