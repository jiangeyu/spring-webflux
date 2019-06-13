package com.github.Storage;

import com.github.Commands.Command;
import com.github.Exceptions.UnregisteredDomainCommandException;
import com.github.Utils.Converter;
import org.aspectj.bridge.ICommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:09 2019/6/10
 */
public class Bus implements ICommandSender {


    public Map<ICommandSender, List<ICommandSender> > handlerMap = new HashMap;


    public void registerHandler(List<ICommandSender> list) {

        for(ICommandSender iCommandSender:list) {
            if(handlerMap.containsKey(ICommandSender.class)) {
                handlerMap.get(iCommandSender).add(iCommandSender);
            } else {
                List<ICommandSender> iCommandSenders = new ArrayList<>();
                iCommandSenders.add(iCommandSender);
                handlerMap.put(iCommandSender, iCommandSenders);
            }
        }
    }

    @Override
    public void send(Command command) {
        List<ICommandSender> list = new ArrayList<>();
        if(list.contains(command)) {
            list.get(0).send(command);
        } else {
            throw new UnregisteredDomainCommandException("");
        }

    }


}
