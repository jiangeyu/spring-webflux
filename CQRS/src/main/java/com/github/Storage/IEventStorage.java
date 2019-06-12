package com.github.Storage;

import com.github.Domain.AggregateRoot;
import com.github.Domain.Mementos.BaseMemento;
import com.github.Events.Event;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:20 2019/6/10
 */
public interface IEventStorage {

    List<Event> getEvents(String aggregateId);

    void save(AggregateRoot root);

    <T extends BaseMemento> T getMemento (String aggregateId);

    void saveMemento(BaseMemento memento);
}
