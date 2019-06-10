package com.github.Exceptions;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:34 2019/6/10
 */
public class UnregisteredDomainCommandException extends RuntimeException {

    public UnregisteredDomainCommandException(String message) {
        super(message);
    }
}
