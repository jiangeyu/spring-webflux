package com.github.EventHandlers;

import com.github.Events.Event;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:34 2019/6/10
 */
public interface IEventHandler<T extends Event> {

    void handler(T event);
}
