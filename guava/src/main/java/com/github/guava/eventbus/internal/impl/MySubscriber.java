package com.github.guava.eventbus.internal.impl;

import java.lang.reflect.Method;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:08 2019/11/12
 */
public class MySubscriber {

    private final Object subscribeObject;

    private final Method subscribeMethod;

    private boolean disable = false;

    public MySubscriber(Object subscribeObject, Method subscribeMethod) {
        this.subscribeObject = subscribeObject;
        this.subscribeMethod = subscribeMethod;
    }


    public Object getSubscribeObject()
    {
        return subscribeObject;
    }

    public Method getSubscribeMethod()
    {
        return subscribeMethod;
    }

    public boolean isDisable()
    {
        return disable;
    }

    public void setDisable(boolean disable)
    {
        this.disable = disable;
    }
}
