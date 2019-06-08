package com.github.Events;

import lombok.Data;

import java.util.UUID;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:14 2019/6/8
 */
@Data
public class Event implements IEvent {

    public int version;
    public String aggregateId;
    public String id;

    @Override
    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
