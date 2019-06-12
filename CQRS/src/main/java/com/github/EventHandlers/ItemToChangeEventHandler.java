package com.github.EventHandlers;

import com.github.Events.ItemToChangeEvent;
import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:28 2019/6/8
 */
@Data
public class ItemToChangeEventHandler implements IEventHandler<ItemToChangeEvent>{

    public Date to;



    @Override
    public void handler(ItemToChangeEvent event) {

    }
}
