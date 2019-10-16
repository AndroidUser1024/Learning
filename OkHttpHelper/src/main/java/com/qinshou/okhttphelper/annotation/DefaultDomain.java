package com.qinshou.okhttphelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/3 15:51
 * Description:该注解用于标识默认域名
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface DefaultDomain {
}
