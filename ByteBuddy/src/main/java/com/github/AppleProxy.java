package com.github;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:26 2020/11/28
 */
public class AppleProxy implements InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(args);
    }
}
