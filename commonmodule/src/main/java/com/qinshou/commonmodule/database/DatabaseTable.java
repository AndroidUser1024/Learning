package com.qinshou.commonmodule.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: 用来实体类在数据库中的表名的注解类
 * Date:2018/4/10
 */
//表示该 Annotation 可以修饰类、接口（包括注解类型的接口）、枚举。
@Target(ElementType.TYPE)
//Annotation 将被记录在 .class 文件中，运行 Java 程序时 JVM 也可获取 Annotation 信息，程序可以通过反射获得 Annotation 信息。
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseTable {
    String tableName();
}
