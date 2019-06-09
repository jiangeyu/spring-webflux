package com.github.Domain;

import com.github.Events.Event;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:13 2019/6/8
 */
public interface IEventProvider {

    void loadFromHistory(List<Event> list);

    List<Event> getUncommittedChanges();
}
