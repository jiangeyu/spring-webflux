package com.github.Events;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:24 2019/6/8
 */
public class ItemDeletedEvent extends Event {

    public ItemDeletedEvent(String aggrgateId) {
        this.aggregateId = aggrgateId;
    }
}
