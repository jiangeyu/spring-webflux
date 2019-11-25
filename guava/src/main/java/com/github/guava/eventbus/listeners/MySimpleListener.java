package com.github.guava.eventbus.listeners;

import com.github.guava.eventbus.internal.MySubscribe;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:21 2019/11/12
 */
public class MySimpleListener {

    @MySubscribe
    public void test1(String event) {
        System.out.println(event);
    }

    @MySubscribe(topic = "zhouchen")
    public void test2(Integer x) {
        System.out.println("test2 ===" + x );
    }
}
