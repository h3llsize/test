package org.bst.avito.service.utils;

import java.lang.reflect.ParameterizedType;

public class GenericInfo {
    public static Class<?> getGenericType(Class<?> clazz) {
        return (Class<?>) ((ParameterizedType) clazz.getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }
}
