package com.qinshou.okhttphelper.util;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.type.TypeMirror;

/**
 * Author: QinHao
 * Email:qinhao@jeejio.com
 * Date: 2019/6/26 12:48
 * Description:获取泛型真实类型的工具类
 */
public class TypeUtil {

    public static Type getReturnType(Class<?> clazz, String methodName, Class... parameterTypes) {
        try {
            Method method = clazz.getMethod(methodName, parameterTypes);
            Type genericReturnType = method.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType && ((ParameterizedType) genericReturnType).getActualTypeArguments().length > 0) {
                return ((ParameterizedType) genericReturnType).getActualTypeArguments()[0];
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
