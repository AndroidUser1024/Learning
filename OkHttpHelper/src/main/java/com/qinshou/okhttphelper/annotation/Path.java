package com.qinshou.okhttphelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/5 22:19
 * Description:该注解用于标识 get 请求的 url 中可替换的部分
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.PARAMETER)
public @interface Path {
    String value();
}
