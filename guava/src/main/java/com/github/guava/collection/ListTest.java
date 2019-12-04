package com.github.guava.collection;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午3:33 2019/12/3
 */
public class ListTest {


    public static void main(String[] args) {


        List<Person> people = Lists.newArrayList();

        Person p1 = new Person();
        List<String> list1 = Lists.newArrayList();
        list1.add("aa");
        list1.add("bb");
        p1.setList(list1);

        people.add(p1);

        List<Person> people1 = Lists.newArrayList();
        people1.addAll(people);

        List list2 = Lists.newArrayList();
        list2.add(list1);
        people1.get(0).setList(list2);
        list1.clear();

        System.out.println(people1.get(0).getList().size());



    }
}
