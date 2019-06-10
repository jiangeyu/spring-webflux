package com.github.EventHandlers;

import com.github.Events.Event;
import com.github.Events.ItemCreateEvent;
import com.github.Events.ItemRenameEvent;
import lombok.Data;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:30 2019/6/8
 */
@Data
public class ItemRenameEventHandler implements IEventHandler<ItemRenameEvent> {



    @Override
    public void handler(ItemRenameEvent event) {

    }
}
