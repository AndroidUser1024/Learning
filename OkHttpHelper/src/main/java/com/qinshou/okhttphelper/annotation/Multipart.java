package com.qinshou.okhttphelper.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/7/5 15:18
 * Description:该注解用于标识发送文件的 post 请求
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface Multipart {
}
