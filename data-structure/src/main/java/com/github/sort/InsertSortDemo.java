package com.github.sort;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午7:36 2019/5/30
 */
public class InsertSortDemo {

    public static int[] insert(int[] a) {

        for (int out = 1; out < a.length; out++) {

            int tmp = a[out];
            int in = out;
            while ((in > 0) && a[in - 1] >= tmp) {
                a[in] = a[in - 1];
                --in;
            }

            a[in] = tmp;

        }

        return a;
    }

    public static void main(String[] args) {
        int[] a = {1, 9, 8, 2, 6};
        int[] b = insert(a);
        for (int n = 0; n < b.length; n++) {
            System.out.println(b[n]);
        }
        System.out.println("------");
        for (int i : b) {
            System.out.println(i);
        }
        System.out.println("-----");
        Arrays.stream(b).forEach(System.out::println);

        IntStream.of(a).forEach(System.out::println);

        char p = '+';
        char m = '-';
        System.out.println(p+m);

    }
}
