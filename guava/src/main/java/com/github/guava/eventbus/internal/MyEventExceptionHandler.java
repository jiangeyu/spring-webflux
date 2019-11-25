package com.github.guava.eventbus.internal;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:33 2019/11/12
 */
public interface MyEventExceptionHandler {

    void handle(Throwable cause, MyEventContext context);

}
