package com.github.guava.eventbus;

import com.github.guava.eventbus.internal.impl.MyEventBus;
import com.github.guava.eventbus.listeners.MySimpleListener;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:23 2019/11/12
 */
public class MyEventBusExample {

    public static void main(String[] args) {
        MyEventBus myEventBus = new MyEventBus((cause, context) -> {
            cause.printStackTrace();
            System.out.println(context.getSource());
            System.out.println(context.getSubscribe());
            System.out.println(context.getEvent());
            System.out.println(context.getSubscriber());
        });

        myEventBus.register(new MySimpleListener());

        myEventBus.post("ssss");
        myEventBus.post(124, "zhouchen");
    }
}
