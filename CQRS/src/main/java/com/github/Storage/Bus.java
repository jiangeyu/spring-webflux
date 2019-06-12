package com.github.Storage;

import com.github.Commands.Command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:09 2019/6/10
 */
public class Bus implements ICommandSender {


    public Map<Command, List<Command> > handlerMap = new HashMap;


    public void registerHandler();

    @Override
    public void send(Command command) {

    }
}
