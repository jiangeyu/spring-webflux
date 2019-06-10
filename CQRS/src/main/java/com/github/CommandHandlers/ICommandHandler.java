package com.github.CommandHandlers;

import com.github.Commands.Command;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:49 2019/6/10
 */
public interface ICommandHandler<T extends Command> {

    void execute(T command);
}
