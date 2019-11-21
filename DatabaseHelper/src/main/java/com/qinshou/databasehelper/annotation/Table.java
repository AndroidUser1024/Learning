package com.qinshou.databasehelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/11/21 16:51
 * Description:该注解用于标识表
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Table {
    String name() default "";
}
