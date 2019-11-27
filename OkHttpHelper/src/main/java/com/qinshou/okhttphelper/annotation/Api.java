package com.qinshou.okhttphelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/8 9:13
 * Description:该注解用于标识 Api 类
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface Api {
    String value();
}
