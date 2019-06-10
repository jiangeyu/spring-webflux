package com.github.Messaging;

import com.github.CommandHandlers.ICommandHandler;
import com.github.Commands.Command;
import com.github.Exceptions.UnregisteredDomainCommandException;
import com.github.Utils.ICommandHandlerFactory;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:06 2019/6/10
 */
public class CommandBus implements ICommandBus{

    private ICommandHandlerFactory commandHandlerFactory;

    @Override
    public void send(Command command) {

        ICommandHandler commandHandler = commandHandlerFactory.getHandler();

        if(commandHandler != null) {
            commandHandler.execute(command);
        } else {
            throw new UnregisteredDomainCommandException("");
        }

    }
}
