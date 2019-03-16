package com.github.springwebflux.guava.utiles;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Map;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午9:29 2018/10/28
 * @desc
 */
public class JoinerTest {

    public static void main(String[] args) {

        Joiner joiner = Joiner.on(";").skipNulls();
        String result = joiner.join(Arrays.asList("hello", null, "guava", " "));
        System.out.println(result);

        Iterable<String> iterable = Splitter.on(",").trimResults().omitEmptyStrings().split("foo,,bar,,guava");
        iterable.forEach(System.out::println);


        String expectedString = "hello = guava&happy = coding";
        Map<String, String> map = Maps.newHashMap();
        map.put("hello", "guava");
        map.put("happy", "coding");
        result = Joiner.on('&').withKeyValueSeparator("=").join(map);
        System.out.println(result);

        Map<String, String> testMap = map;
        Splitter.MapSplitter mapSplitter = Splitter.on("&").withKeyValueSeparator("=");
        Map<String, String> splitMap = mapSplitter.split(expectedString);
        System.out.println(splitMap);
        System.out.println(splitMap == testMap);

        String append = Strings.padEnd("guava", 6, 'x');
        System.out.println(append);




    }
}
