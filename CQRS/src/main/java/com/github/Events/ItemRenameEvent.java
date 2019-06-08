package com.github.Events;

import lombok.Data;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:30 2019/6/8
 */
@Data
public class ItemRenameEvent extends Event {

    public String title;

    public ItemRenameEvent(String aggrateId, String title) {
        this.aggregateId = aggrateId;
        this.title = title;
    }
}
