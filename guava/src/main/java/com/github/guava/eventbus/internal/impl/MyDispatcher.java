package com.github.guava.eventbus.internal.impl;

import com.github.guava.eventbus.internal.MyEventContext;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:17 2019/11/12
 */
public class MyDispatcher {


    private static class SeqExecutorService implements Executor {

        private final static SeqExecutorService INSTANCE =  new SeqExecutorService();
        @Override
        public void execute(Runnable command) {
            command.run();
        }
    }

    private static class PreThreadExecutorService implements Executor {


        private final static PreThreadExecutorService INSTANCE =  new PreThreadExecutorService();

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
            return this.subscriber != null ? subscriber.getSubscribeMethod():null;
        }

        @Override
        public Object getEvent() {
            return this.event;
        }
    }
}
