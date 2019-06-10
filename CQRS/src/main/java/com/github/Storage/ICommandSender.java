package com.github.Storage;

import com.github.Commands.Command;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:18 2019/6/10
 */
public interface ICommandSender<T extends Command> {

    void send(T command);
}
