package com.github.leetcode.middle.dynamic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:39 2020/12/16
 */
public class Profit {

    /**
     * 一次交易
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int profit = Integer.MIN_VALUE;
        int minPrice = prices[0];
        for (int i = 1; i < length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        return profit;
    }

    /**
     * 一次交易
     *
     * @param prices
     * @return
     */
    public static int maxProfit_p(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);

        }
        return dp_i_0;
    }

    /**
     * 两次交易
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int dp_i10 = 0;
        int dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        int dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);

        }

        return dp_i20;

    }

    /**
     * 不限制交易次数
     *
     * @param prices
     * @return
     */
    public static int maxProfitN(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];

            }
        }
        return profit;
    }

    /**
     * 不限制交易次数
     *
     * @param prices
     * @return
     */
    public static int maxProfitN_p(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);

        }
        return dp_i_0;
    }

    /**
     * k次交易
     *
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfitK(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
            int dp_i_0 = 0;
            int dp_i_1 = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int tmp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
                dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);

            }
            return dp_i_0;
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int jk = k; jk >= 0; jk--) {
                if (i == 0 || jk == 0) {
                    dp[0][jk][0] = 0;
                    dp[0][jk][1] = Integer.MIN_VALUE;
                } else {
                    dp[i][jk][0] = Math.max(dp[i - 1][jk][0], dp[i - 1][jk][1] + prices[i]);
                    dp[i][jk][1] = Math.max(dp[i - 1][jk][1], dp[i - 1][jk - 1][0] - prices[i]);
                }

            }
        }
        return dp[n - 1][k][0];
    }

    /**
     * 有冷静期
     *
     * @param prices
     * @return
     */
    public static int maxProfitNWithCool(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;

        }
        return dp_i_0;
    }

    /**
     * 有冷静期
     *
     * @param prices
     * @return
     */
    public static int maxProfitNWithFee(int[] prices, int fee) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);

        }
        return dp_i_0;
    }

    public static void main(String[] args) {
//        System.out.println(maxProfit_p(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
//        System.out.println(maxProfitN(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfitN_p(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfitNWithCool(new int[]{7, 1, 5, 3, 6, 4}));
//
//        System.out.println(maxProfitK(2, new int[]{2, 4, 1}));
//        System.out.println(maxProfitK(2, new int[]{3, 2, 6, 5, 0, 3}));
//        System.out.println(maxProfitK(1, new int[]{1,2}));
//        System.out.println(maxProfitK(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfitK(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }
}
