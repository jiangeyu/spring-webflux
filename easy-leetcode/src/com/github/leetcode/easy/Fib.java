package com.github.leetcode.easy;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:47 2020/12/1
 */
public class Fib {

    public static int fib(int n) {
        int pre = 1;
        int cur = 1;

        for (int i = 3; i <= n; i++) {
            int sum = cur + pre;
            pre = cur;
            cur = sum;
        }

        return cur;
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}
