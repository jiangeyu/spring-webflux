package com.github.oberver.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:14 2019/6/7
 */
public abstract class Observable<S extends Observable<S, O, A>, O extends WeatherObserver<S, O, A>, A> {

    private List<O> observers;

    public Observable() {
        this.observers = new ArrayList<O>();
    }

    public void addObserver(O observer) {
        this.observers.add(observer);
    }

    public void removeObserver(O observer) {
        this.observers.remove(observer);
    }

    public List<O> getObservers() {
        return this.observers;
    }


    @SuppressWarnings("unchecked")
    public void notifyObservers(A weatherType) {
        getObservers().forEach(observer ->
                observer.update((S) this, weatherType)
        );
    }
}
