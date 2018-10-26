package com.github.springwebflux.guava.function;


import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午3:16 2018/10/26
 * @desc
 */
public class FunctionTest {

    public static void main(String[] args) {

        Function<String, Integer> lengthFunction = s -> s.length();

        Predicate<String> stringPredicate = input -> StringUtils.isEmpty(input);

        HashSet strings = new HashSet();


        Multiset<Integer> multiset = HashMultiset.create(Iterables.transform(Iterables.filter(strings, stringPredicate), lengthFunction));



    }
}
