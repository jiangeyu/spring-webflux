package com.github.Messaging;

import com.github.EventHandlers.IEventHandler;
import com.github.Events.Event;
import com.github.Utils.IEventHandlerFactory;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:43 2019/6/10
 */
public class EventBus implements IEventBus {

    private IEventHandlerFactory eventHandlerFactory;

    @Override
    public void publish(Event event) {
        List<IEventHandler> list = eventHandlerFactory.getHandlers();
        list.forEach(handler -> handler.handler(event));

    }
}
