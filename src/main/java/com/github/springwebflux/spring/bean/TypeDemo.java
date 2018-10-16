package com.github.springwebflux.spring.bean;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午6:45 2018/10/16
 * @desc
 */
public class TypeDemo<T> {

    // GenericArrayType：组件类型为类型变量的数组
    public T[] a;
    // GenericArrayType：组件类型为参数化类型的数组
    public List<?>[] b;
    // ParameterizedType：参数化类型
    // List<? extends Object>携带的"? extends Object"
    // 即通配符表达式，也就是WildcardType
    public List<? extends Object> c;
    // Class：普通类型
    public List d;
    // 类型变量
    public T e;


    public  void wildcardType() throws Exception{
        Field field = TypeDemo.class.getDeclaredField("c");
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Arrays.asList(actualTypeArguments).forEach(arg -> System.out.println(arg.getClass()));
        }
    }


    public static void main(String[] args) throws Exception {
        TypeDemo<Integer> typeDemo =  new TypeDemo<>();
        typeDemo.wildcardType();
    }
}
