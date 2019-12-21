package com.github.guava;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:23 2019/10/28
 */
public class OptionalTest {

    @Test
    public void get() {
        List<Optional<Integer>> list = new ArrayList<>();
        for (int index = 10; index > 0; --index) {
            Integer t;
            if (0 == index % 2) {
                t = index;
            } else {
                t = null;
            }
            list.add(Optional.fromNullable(t));
        }
        Iterable<Integer> it = Optional.presentInstances(list);
        it.forEach(integer -> System.err.println(integer));
    }


    @Test
    public void testByte() {
        byte type = 2;


        System.out.println("2".equals(String.valueOf(type)));
    }
}
