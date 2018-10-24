package com.github.springwebflux.guava;

import com.google.common.base.Optional;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午10:05 2018/10/24
 * @desc
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional optional = Optional.of(5);
        System.out.println(optional.get());
        System.out.println(optional.isPresent());
    }
}
