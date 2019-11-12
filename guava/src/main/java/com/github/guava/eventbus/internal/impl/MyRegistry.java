package com.github.guava.eventbus.internal.impl;

import com.github.guava.eventbus.internal.MySubscribe;
import com.google.common.collect.Lists;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午4:06 2019/11/12
 */
public class MyRegistry {

   private final ConcurrentHashMap<String, ConcurrentLinkedQueue<MySubscriber>> subscriberContainer = new ConcurrentHashMap<>();


    public void bind(Object subscribe) {
       List<Method> subscribeMethods =  getSubscribeMethod(subscribe);
       subscribeMethods.forEach(method -> tierSubscriber(subscribe, method));

    }

    public void unbind(Object subscribe) {
        subscriberContainer.forEach((key, queue) -> queue.forEach(mySubscriber -> {
            if(mySubscriber.getSubscribeObject() == subscribe) {
                mySubscriber.setDisable(true);
            }
        }));

    }

    public ConcurrentLinkedQueue<MySubscriber> scanSubscriber(final String topic) {
        return subscriberContainer.get(topic);
    }

    private void tierSubscriber(Object subscriber, Method method) {
        final MySubscribe mySubscribe = method.getDeclaredAnnotation(MySubscribe.class);
        String topic = mySubscribe.topic();
        subscriberContainer.computeIfAbsent(topic, key -> new ConcurrentLinkedQueue<>());
        subscriberContainer.get(topic).add(new MySubscriber(subscriber, method));
    }


    private List<Method> getSubscribeMethod(Object subscriber ) {
        final List<Method> list = Lists.newArrayList();
        Class<?> temp = subscriber.getClass();
        while (temp != null) {
            Method[] decleareMethods = temp.getDeclaredMethods();
            Arrays.stream(decleareMethods)
                    .filter(method -> method.isAnnotationPresent(MySubscribe.class) && method.getParameterCount() ==1 && method.getModifiers() == Modifier.PUBLIC)
                    .forEach(list::add);
        }
        return list;
    }
}
