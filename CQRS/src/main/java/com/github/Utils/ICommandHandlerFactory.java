package com.github.Utils;

import com.github.CommandHandlers.ICommandHandler;
import com.github.Events.Event;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:47 2019/6/10
 */
public interface ICommandHandlerFactory<T extends Event> {

    ICommandHandler getHandler();
}
