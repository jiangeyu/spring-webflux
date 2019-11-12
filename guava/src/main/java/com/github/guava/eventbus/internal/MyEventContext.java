package com.github.guava.eventbus.internal;

import java.lang.reflect.Method;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:23 2019/11/12
 */
public interface MyEventContext {

    String getSource();

    Object getSubscriber();

    Method getSubscribe();

    Object getEvent();
}
