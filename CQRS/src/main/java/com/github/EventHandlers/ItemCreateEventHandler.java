package com.github.EventHandlers;

import com.github.Events.Event;
import com.github.Events.ItemCreateEvent;
import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:22 2019/6/8
 */
@Data
public class ItemCreateEventHandler implements IEventHandler<ItemCreateEvent> {



    @Override
    public void handler(ItemCreateEvent event) {

    }
}
