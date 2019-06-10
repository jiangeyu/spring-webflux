package com.github.Messaging;

import com.github.Commands.Command;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:57 2019/6/10
 */
public interface ICommandBus<T extends Command> {

    void send(T command);
}
