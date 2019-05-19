package com.github;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:39 2019/5/17
 */
public class HelloWorld {

    public void test() throws IllegalAccessException, InstantiationException {

        Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.<MethodDescription>named("toString"))
                .intercept(FixedValue.value("hello world"))
                .make()
                .load(getClass().getClassLoader())
                .getLoaded();

        System.out.println(dynamicType.newInstance().toString());

    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        HelloWorld h = new HelloWorld();
        h.test();
    }
}
