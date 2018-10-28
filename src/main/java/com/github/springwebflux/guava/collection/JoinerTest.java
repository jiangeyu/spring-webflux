package com.github.springwebflux.guava.collection;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

import java.util.Arrays;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午9:29 2018/10/28
 * @desc
 */
public class JoinerTest {

    public static void main(String[] args) {

        Joiner joiner = Joiner.on(";").skipNulls();
        String result = joiner.join(Arrays.asList("hello",null, "guava"," "));
        System.out.println(result);

        Iterable<String> iterable = Splitter.on(",").trimResults().omitEmptyStrings().split("foo,,bar,,guava");
        iterable.forEach(System.out::println);
    }
}
