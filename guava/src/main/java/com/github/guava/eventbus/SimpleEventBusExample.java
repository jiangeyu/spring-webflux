package com.github.guava.eventbus;

import com.github.guava.eventbus.listeners.SimpleListener;
import com.google.common.eventbus.EventBus;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:18 2019/11/12
 */
public class SimpleEventBusExample {

    public static void main(String[] args) {
        final EventBus eventBus = new EventBus();
        eventBus.register(new SimpleListener());
        eventBus.post("simple event");
        eventBus.post("simple event11");
    }
}
