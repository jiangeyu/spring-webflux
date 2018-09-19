package com.github.springwebflux.aop;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午11:20 2018/9/19
 * @desc
 */
public interface TargetInterface {

    void advice();

    void advice(String msg);
}
