package com.github.Storage;

import com.github.Events.Event;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:19 2019/6/10
 */
public interface IEventPublisher {

    void publish(Event event);
}
