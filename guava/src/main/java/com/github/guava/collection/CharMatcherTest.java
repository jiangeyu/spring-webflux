package com.github.guava.collection;

import com.google.common.base.CharMatcher;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午9:39 2018/10/28
 * @desc
 */
public class CharMatcherTest {

    public static void main(String[] args) {
        String raw =  " hello world ";
        System.out.println(raw);
        String nonControl = CharMatcher.whitespace().trimAndCollapseFrom(raw, ' ');
        System.out.println(nonControl);
    }
}
