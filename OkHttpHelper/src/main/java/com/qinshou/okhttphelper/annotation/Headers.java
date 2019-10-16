package com.qinshou.okhttphelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/10 14:46
 * Description:该注解用于标识需要 http 请求需要添加的 header
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Headers {
    Header[] value();
}
