package com.github.Utils;

import com.github.CommandHandlers.ICommandHandler;
import com.github.Commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:55 2019/6/10
 */
public class StructureMapCommandHandlerFactory implements ICommandHandlerFactory {


    @Override
    public ICommandHandler getHandler() {
        return null;
    }


    private List<Object> getHandlerTypes() {

        Command.class.getSuperclass();

        return new ArrayList<>();


    }
}
