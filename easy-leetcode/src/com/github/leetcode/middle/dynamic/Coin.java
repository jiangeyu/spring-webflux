package com.github.leetcode.middle.dynamic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:26 2020/12/1
 */
public class Coin {

    public static int waysToChange(int n) {
        int[] coins = new int[]{25, 10, 5, 1};
        int length = coins.length;
        //若只使用前i个物品，当背包容量为j时，有dp[i][j]种方法可以装满背包。
        int[][] dp = new int[900750][900750];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[length][n];

    }

    public static int change(int n) {

        int[] coins = new int[]{25, 10, 5, 1};

        int length = coins.length;
        int[] dp = new int[n + 1];
        dp[0] = 1; // base case
        for (int i = 0; i < length; i++)
            for (int j = 1; j <= n; j++)
                if (j - coins[i] >= 0)
                    dp[j] = dp[j] + dp[j - coins[i]];

        return dp[n];
    }

    public static boolean canJump(int[] num) {
        int n = num.length;
        int further = 0;
        for (int i = 0; i < n - 1; i++) {
            further = Math.max(further, i + num[i]);
            System.out.println(further);
            if (further <= i) {
                return false;
            }
        }
        return further >= n - 1;
    }


    public static void main(String[] args) {
//
//        System.out.println(waysToChange(900750));
//        System.out.println(change(900750));
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
