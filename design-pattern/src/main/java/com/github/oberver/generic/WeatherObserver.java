package com.github.oberver.generic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午10:10 2019/6/7
 */
public interface WeatherObserver<S extends Observable<S, O, A>, O extends WeatherObserver<S, O, A>, A> {

    void update(S subject, A weather);
}
