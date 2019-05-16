package com.github.springwebflux.spring.bean;

import com.google.common.collect.Maps;
import org.springframework.core.ResolvableType;

import java.util.Map;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午5:18 2018/10/14
 * @desc
 */
public class ResolvableTypeTest {

    /**
     * ResolvableType，可解决的数据类型。它为java语言中的所有类型提供了相同的数据结构，其内部封装了一个java.lang.reflect.Type类型的对象。
     */

    private Map<String,Integer> map = Maps.newHashMap();


    public static void main(String[] args) throws NoSuchFieldException {

        ResolvableTypeTest resolvableTypeTest = new ResolvableTypeTest();
        resolvableTypeTest.map.put("test", 2);
        resolvableTypeTest.test();
    }

    public void test() throws NoSuchFieldException {
        ResolvableType resolvableType = ResolvableType.forField(getClass().getDeclaredField("map"));
        System.out.println(resolvableType.getInterfaces().toString());
        System.out.println(resolvableType.asMap());
        System.out.println(resolvableType.getGeneric(0));
        System.out.println(resolvableType.getGeneric(1));
        System.out.println(resolvableType.resolveGeneric( 0,0));
        System.out.println(resolvableType.getComponentType().toString());
        System.out.println(resolvableType.hashCode());
    }
}
