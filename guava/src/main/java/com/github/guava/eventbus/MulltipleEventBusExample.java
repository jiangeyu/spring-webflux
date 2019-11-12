package com.github.guava.eventbus;

import com.github.guava.eventbus.listeners.MultipleEventListeners;
import com.google.common.eventbus.EventBus;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:27 2019/11/12
 */
public class MulltipleEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new MultipleEventListeners());
        eventBus.post("simple event");
        eventBus.post(2);
    }
}
