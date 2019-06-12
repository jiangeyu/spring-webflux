package com.github.Storage;

import com.github.Domain.AggregateRoot;
import com.github.Domain.Mementos.BaseMemento;
import com.github.Events.Event;
import com.github.Messaging.IEventBus;
import com.github.Storage.memento.IOriginator;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:20 2019/6/10
 */
public class InMemoryEventStorage implements IEventStorage {

    private List<Event> events;
    private List<BaseMemento> mementos;

    private IEventBus eventBus;

    public InMemoryEventStorage(List<Event> events, List<BaseMemento> mementos, IEventBus eventBus) {
        this.events = events;
        this.mementos = mementos;
        this.eventBus = eventBus;
    }

    @Override
    public List<Event> getEvents(String aggregateId) {
        List<Event> list = events.stream()
                .filter(event -> event.getAggregateId().equals(aggregateId))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public void save(AggregateRoot aggregateRoot) {
        List<Event> list = aggregateRoot.getUncommittedChanges();
        AtomicInteger version = new AtomicInteger(aggregateRoot.getVersion());

        list.forEach(event -> {
            version.getAndIncrement();

            if (version.get() > 2) {
                if (version.get() % 3 == 0) {
                    IOriginator originator = (IOriginator) aggregateRoot;
                    BaseMemento memento = originator.getMemnto();
                    memento.setVersion(version.get());
                    save(aggregateRoot);
                }
            }

            event.version = version.get();
            events.add(event);
        });

    }

    @Override
    public <T extends BaseMemento> T getMemento(String aggregateId) {
        Optional<BaseMemento> optional = mementos.stream()
                .filter(m -> m.getId().equals(aggregateId))
                .findFirst();
        if (optional.isPresent()) {
            optional.get();
        }
        return null;
    }

    @Override
    public void saveMemento(BaseMemento memento) {
        mementos.add(memento);
    }
}
