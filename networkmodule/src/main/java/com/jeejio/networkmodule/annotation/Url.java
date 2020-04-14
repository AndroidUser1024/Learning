package com.jeejio.networkmodule.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2020/1/3 9:15
 * Description:该注解用于标识完整的 url
 * 如果有参数使用该注解修饰,则不会使用 baseUrl 及 get 或 post 的 value 拼接成的 url,而是使用该参数的值作为请求 url
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Url {
}
