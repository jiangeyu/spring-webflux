package com.github.springwebflux.guava.collection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.jvnet.hk2.component.MultiMap;

/**
 * @author: <a href="mailto:lingxiao@2dfire.com">凌霄</a>
 * @time: Created in 下午8:56 2018/10/30
 * @desc
 */
public class MultimapsTest {

    public static void main(String[] args) {

        MultiMap<String, Integer> multiMap = new MultiMap<>();
        multiMap.add("test", 2);
        multiMap.add("test", 3);
        System.out.println(multiMap.toString());


        ArrayListMultimap<String, Integer> listMultimap = ArrayListMultimap.create();
        listMultimap.put("guava", 1);
        listMultimap.put("guava", 2);
        listMultimap.put("guava", 1);
        System.out.println(listMultimap.toString());
        System.out.println(listMultimap.get("guava").toString());

        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "guava");
//        biMap.put("2", "guava");
        biMap.forcePut("2", "guava");
        System.out.println(biMap.inverse());


    }
}
