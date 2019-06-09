package com.github.Domain;

import com.github.Events.Event;
import lombok.Data;

import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:33 2019/6/8
 */
@Data
public abstract class AggregateRoot implements IEventProvider {

    private List<Event> changes;

    public String id;
    public int version;
    public int EventVersion;

    public void markChangesAsCommitted() {
        changes.clear();
    }

    @Override
    public void loadFromHistory(List<Event> list) {
list.forEach(event -> );
    }

    protected  void applyChange(Event event) {
        applyChange(event, true);
    }

    protected  void applyChange(Event event, boolean isNew) {
        this.han;
    }

    @Override
    public List<Event> getUncommittedChanges() {
        return null;
    }
}
