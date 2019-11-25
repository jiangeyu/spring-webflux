package com.github.guava.eventbus.internal.impl;

import com.github.guava.eventbus.internal.Bus;
import com.github.guava.eventbus.internal.MyEventContext;
import com.github.guava.eventbus.internal.MyEventExceptionHandler;

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:17 2019/11/12
 */
public class MyDispatcher {

    private final Executor executorService;

    private final MyEventExceptionHandler exceptionHandler;

    public MyDispatcher(Executor executorService, MyEventExceptionHandler exceptionHandler) {
        this.executorService = executorService;
        this.exceptionHandler = exceptionHandler;
    }

    public static final Executor SEQ_EXECUTOR_SERVICE = SeqExecutorService.INSTANCE;

    public static final Executor PRE_THREAD_EXECUTOR_SERVICE = PreThreadExecutorService.INSTANCE;


    public void dispatch(Bus bus, MyRegistry registry, Object event, String topic) {
        ConcurrentLinkedQueue<MySubscriber> subscribers = registry.scanSubscriber(topic);

        if (null == subscribers) {
            if (exceptionHandler != null) {
                exceptionHandler.handle(new IllegalArgumentException("The topic " + topic + " not bind yet"),
                        new BaseMyEventContext(bus.getBusName(), null, event));
            }

            return;
        }

        subscribers.stream().filter(mySubscriber -> mySubscriber.isDisable())
                .filter(mySubscriber -> {
                    Method method = mySubscriber.getSubscribeMethod();
                    Class<?> aClass = method.getParameterTypes()[0];
                    return aClass.isAssignableFrom(event.getClass());
                })
                .forEach(mySubscriber -> realInvokeSubscribe(mySubscriber, event, bus));
    }

    private void realInvokeSubscribe(MySubscriber mySubscriber, Object event, Bus bus) {
        Method subscribeMethod = mySubscriber.getSubscribeMethod();
        Object subscribeObject = mySubscriber.getSubscribeObject();
        executorService.execute(() -> {
            try {
                subscribeMethod.invoke(subscribeObject, event);
            } catch (Exception e) {
                if (null != exceptionHandler) {
                    exceptionHandler.handle(e, new BaseMyEventContext(bus.getBusName(), mySubscriber, event));
                }
            }

        });
    }


    public void close() {
        if (executorService instanceof ExecutorService) {
            ((ExecutorService) executorService).shutdown();
        }
    }

    static MyDispatcher seqDispatcher(MyEventExceptionHandler exceptionHandler) {
        return new MyDispatcher(SEQ_EXECUTOR_SERVICE, exceptionHandler);
    }

    static MyDispatcher perThreaDDispatcher(MyEventExceptionHandler exceptionHandler) {
        return new MyDispatcher(PRE_THREAD_EXECUTOR_SERVICE, exceptionHandler);
    }

    static MyDispatcher newDispatcher(Executor executor, MyEventExceptionHandler exceptionHandler) {
        return new MyDispatcher(executor, exceptionHandler);
    }


    private static class SeqExecutorService implements Executor {

        private final static SeqExecutorService INSTANCE = new SeqExecutorService();

        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    private static class PreThreadExecutorService implements Executor {


        private final static PreThreadExecutorService INSTANCE = new PreThreadExecutorService();

        @Override
        public void execute(Runnable command) {
            new Thread(command).start();
        }
    }


    private static class BaseMyEventContext implements MyEventContext {

        private final String eventBusName;

        private final MySubscriber subscriber;

        private final Object event;

        public BaseMyEventContext(String eventBusName, MySubscriber subscriber, Object event) {
            this.eventBusName = eventBusName;
            this.subscriber = subscriber;
            this.event = event;
        }

        @Override
        public String getSource() {
            return this.eventBusName;
        }

        @Override
        public Object getSubscriber() {
            return this.subscriber != null ? subscriber.getSubscribeObject() : null;
        }

        @Override
        public Method getSubscribe() {
            return this.subscriber != null ? subscriber.getSubscribeMethod() : null;
        }

        @Override
        public Object getEvent() {
            return this.event;
        }
    }
}
