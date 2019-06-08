package com.github.Events;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:16 2019/6/8
 */
public interface IHandle<T extends Event> {

    void handle(T e);
}
