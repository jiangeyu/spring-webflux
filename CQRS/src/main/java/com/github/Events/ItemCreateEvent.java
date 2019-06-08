package com.github.Events;

import lombok.Data;

import java.util.Date;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:22 2019/6/8
 */
@Data
public class ItemCreateEvent extends Event {

    public String title;
    public Date from;
    public Date to;
    public String description;

    public ItemCreateEvent(String title, Date from, Date to, String description) {
        this.title = title;
        this.from = from;
        this.to = to;
        this.description = description;
    }
}
