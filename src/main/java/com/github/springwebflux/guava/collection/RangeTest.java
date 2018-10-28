package com.github.springwebflux.guava.collection;

import com.google.common.collect.Range;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午9:50 2018/10/28
 * @desc
 */
public class RangeTest {

    public static void main(String[] args) {

        Range range = Range.closed("left", "right");
        System.out.println(range.lowerEndpoint());
    }
}
