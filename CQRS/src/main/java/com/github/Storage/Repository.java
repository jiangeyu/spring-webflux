package com.github.Storage;

import com.github.Domain.AggregateRoot;
import com.github.Domain.DiaryItem;
import com.github.Domain.Mementos.BaseMemento;
import com.github.Events.Event;
import com.github.Exceptions.ConcurrencyException;
import com.github.Storage.memento.IOriginator;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:21 2019/6/10
 */
public class Repository implements IRepository{

    private IEventStorage storage;
    private static Object locl = new Object();

    public Repository(IEventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void save(AggregateRoot aggregateRoot, int expectedVersion) {
        if(aggregateRoot.getUncommittedChanges().size() >0) {
            AggregateRoot item = new DiaryItem();
            if(expectedVersion != -1) {
                item = getById(aggregateRoot.getId());
                if(item.version != expectedVersion) {
                    throw new ConcurrencyException("");
                }

                storage.save(aggregateRoot);
            }
        }
    }

    @Override
    public AggregateRoot getById(String id) {
        List<Event> eventList;
        BaseMemento memento = storage.getMemento(id);
        if(memento != null) {
            eventList = storage.getEvents(id).stream()
                    .filter(e -> e.version >= memento.getVersion())
                    .collect(Collectors.toList());
        } else {
            eventList = storage.getEvents(id);
        }
        IOriginator o =  null;
        if(memento !=  null)  {
            o.setMemento(memento);
        }


        return o;
    }
}
