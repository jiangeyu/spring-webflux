package com.github.guava.base;

import com.google.common.base.Optional;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:17 2019/10/28
 */
public class OptionalTest {



    public static void main(String[] args) {

        Optional optional = Optional.of(5);

        System.out.println(optional.get());

        System.out.println(optional.isPresent());

        optional = Optional.absent();

        System.out.println(optional.isPresent());

        Integer a = null;

        Optional<Integer> optional1 = Optional.fromNullable(a);
        System.out.println(optional1.get());
    }


}
