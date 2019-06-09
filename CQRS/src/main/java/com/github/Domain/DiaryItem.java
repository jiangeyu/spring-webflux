package com.github.Domain;

import com.github.Events.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:59 2019/6/8
 */
public class DiaryItem extends AggregateRoot
        implements IHandle<ItemCreateEvent>,
        IHandle<ItemRenameEvent>,
        IHandle<ItemFromChangeEvent>,
        IHandle<ItemToChangeEvent,
                IHandle<ItemDescriptionChangeEvent> {
    @Override
    public void handle(ItemCreateEvent e) {

    }
}
