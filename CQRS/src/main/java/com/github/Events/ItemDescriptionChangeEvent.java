package com.github.Events;

import lombok.Data;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:27 2019/6/8
 */
@Data
public class ItemDescriptionChangeEvent extends Event {

    public String description;

    public ItemDescriptionChangeEvent(String aggregateId,String description) {
        this.aggregateId = aggregateId;
        this.description = description;
    }
}
