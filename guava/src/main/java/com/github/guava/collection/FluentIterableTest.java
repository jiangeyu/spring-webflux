package com.github.guava.collection;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableList;

import java.util.Arrays;
import java.util.List;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 上午11:16 2018/10/29
 * @desc
 */
public class FluentIterableTest {

    public static void main(String[] args) {

        ImmutableList<String> result = FluentIterable.
                from(getList()).
                filter(str -> str.length() > 0).
                transform(String::toString).toList();
        System.out.println(result.toString());
    }

    public static List<String> getList() {
        return Arrays.asList("hello", "guava", "happy", "coding");
    }
}
