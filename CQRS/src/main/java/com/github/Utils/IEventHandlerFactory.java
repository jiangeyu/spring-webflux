package com.github.Utils;

import com.github.EventHandlers.IEventHandler;
import com.github.Events.Event;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:45 2019/6/10
 */
public interface IEventHandlerFactory<T extends Event> {

    List<IEventHandler> getHandlers();
}
