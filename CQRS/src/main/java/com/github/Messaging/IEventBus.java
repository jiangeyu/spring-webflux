package com.github.Messaging;

import com.github.Events.Event;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:56 2019/6/10
 */
public interface IEventBus<T extends Event> {

    void publish(T event);
}
