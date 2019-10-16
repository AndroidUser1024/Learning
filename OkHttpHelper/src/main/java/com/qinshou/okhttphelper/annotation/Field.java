package com.qinshou.okhttphelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/3 17:47
 * Description:该注解用于标识 post 请求的参数
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.PARAMETER)
public @interface Field {
    String name();
}
