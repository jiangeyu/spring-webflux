package com.github.guava.functional;


import com.github.springwebflux.guava.collection.Book;
import com.github.springwebflux.guava.utiles.JoinStringFunction;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.apache.commons.lang.StringUtils;

import java.util.HashSet;
import java.util.Map;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午3:16 2018/10/26
 * @desc
 */
public class FunctionTest {

    public static void main(String[] args) {

        Function<String, Integer> lengthFunction = s -> s.length();

        Predicate<String> stringPredicate = input -> StringUtils.isNotEmpty(input);

        HashSet strings = Sets.newHashSet();
        strings.add("pjx");
        strings.add("lx");
        strings.add("xsd");


        Multiset<Integer> multiset = HashMultiset
                .create(Iterables.transform(Iterables.filter(strings, stringPredicate), lengthFunction));
        System.out.println(multiset.toString());

        Map<String, Book> map = Maps.newHashMap();
        map.put("lx", new Book());

        Function<String, Book> lookup = Functions.forMap(map);

        System.out.println(lookup.apply("lx"));

        Function<Book, String> stateFunction = (Function<Book, String>) new JoinStringFunction();

        Function<String, String> function = Functions.compose(stateFunction, lookup);


    }
}
