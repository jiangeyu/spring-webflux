package com.github.Exceptions;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:41 2019/6/10
 */
public class UnregisteredDomainEventException extends Exception {
    public UnregisteredDomainEventException(String message) {
        super(message);
    }
}
