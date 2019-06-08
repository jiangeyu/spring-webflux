package com.github.Events;

import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:28 2019/6/8
 */
@Data
public class ItemToChangeEvent extends Event{

    public Date to;

    public ItemToChangeEvent(String aggregateId, Date to) {
        this.aggregateId = aggregateId;
        this.to = to;
    }
}
