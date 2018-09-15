package com.github.springwebflux.reactor;

import reactor.core.publisher.Flux;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午6:03 2018/9/15
 * @desc
 */
public class ReactorTest {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        Flux.fromArray(array);
    }
}
