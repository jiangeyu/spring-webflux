package com.github.guava.primitives;

import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:24 2020/12/23
 */
public class IntsTest {

    @Test
    public void create() {
        List<Integer> list = Ints.asList(1,2,4);
        List<Integer> list1 = Ints.asList();
        List<Integer> list2 = Arrays.asList();
        List<Integer> list3 = Collections.EMPTY_LIST;
        System.out.println(list.size());
        System.out.println(list1.size());
        System.out.println(list3.size());
        System.out.println(Ints.join(",",1,2,3,4));
    }
}
