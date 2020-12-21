package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:47 2020/12/1
 */
public class Fib {

    public static int fib2(int n) {
        if (n < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(n);
        return helper(map, n);
    }

    public static int helper(Map<Integer, Integer> map, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int sum = helper(map, n - 1) + helper(map, n - 2);
        map.put(n, sum);
        return map.get(n);
    }

    public static int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

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
        System.out.println(fib2(7));
        System.out.println(fib3(7));
    }
}
