package com.qinshou.commonmodule.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description:用来控制成员变量在数据库中的列名称的注解类
 * Date:2018/4/10
 */
//表示该 Annotation 可以修饰成员变量。
@Target(ElementType.FIELD)
//Annotation 将被记录在 .class 文件中，运行 Java 程序时 JVM 也可获取 Annotation 信息，程序可以通过反射获得 Annotation 信息。
@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseField {
    enum TYPE{
        NULL,INTEGER,REAL,TEXT, BLOB
    }
    TYPE type() default TYPE.TEXT;

    String columnName();
}
