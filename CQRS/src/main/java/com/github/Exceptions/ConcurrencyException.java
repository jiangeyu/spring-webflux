package com.github.Exceptions;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:01 2019/6/10
 */
public class ConcurrencyException extends RuntimeException {

    public ConcurrencyException(String message) {
        super(message);
    }
}
