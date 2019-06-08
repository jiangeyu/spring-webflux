package com.github.Events;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:28 2019/6/8
 */
public class ItemFromChangeEvent extends Event{

    public Date from;

    public ItemFromChangeEvent(String aggregateId, Date from) {
        this.aggregateId = aggregateId;
        this.from = from;
    }
}
