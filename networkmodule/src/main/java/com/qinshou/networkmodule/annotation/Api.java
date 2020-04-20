package com.qinshou.networkmodule.annotation;

import com.qinshou.networkmodule.enums.LogLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/5 11:29
 * Description:该注解用于标识 url
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Api {
    String value() default "";

    LogLevel logLevel() default LogLevel.BASIC;
}
