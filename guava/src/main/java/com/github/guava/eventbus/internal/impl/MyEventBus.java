package com.github.guava.eventbus.internal.impl;


import com.github.guava.eventbus.internal.Bus;
import com.github.guava.eventbus.internal.MyEventExceptionHandler;

import java.util.concurrent.Executor;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:53 2019/11/12
 */
public class MyEventBus implements Bus {


    private final MyRegistry registry = new MyRegistry();
    private String busName;

    private final static String DEFAULT_BUS_NAME = "default";

    private final static String DEFAULT_TOPIC = "default-topic";

    private final MyDispatcher dispatcher;

    public MyEventBus() {
        this(DEFAULT_BUS_NAME, null, MyDispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public MyEventBus(String busName) {
        this(busName, null, MyDispatcher.SEQ_EXECUTOR_SERVICE);
    }

    public MyEventBus(MyDispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public MyEventBus(MyEventExceptionHandler exceptionHandler) {
        this(DEFAULT_BUS_NAME, exceptionHandler, MyDispatcher.SEQ_EXECUTOR_SERVICE);
    }

    MyEventBus(String busName, MyEventExceptionHandler exceptionHandler, Executor executor) {
        this.busName = busName;
        this.dispatcher = MyDispatcher.newDispatcher(executor,exceptionHandler);
    }

    @Override
    public void register(Object subscriber) {
        this.registry.bind(subscriber);
    }

    @Override
    public void unregister(Object subscriber) {
        this.registry.unbind(subscriber);
    }

    @Override
    public void post(Object event) {
        System.out.println(event);
        this.post(event, DEFAULT_TOPIC);
    }

    @Override
    public void post(Object event, String topic) {
        this.dispatcher.dispatch(this, registry, event, topic);
    }

    @Override
    public void close() {
        this.dispatcher.close();
    }

    @Override
    public String getBusName() {
        return null;
    }
}
