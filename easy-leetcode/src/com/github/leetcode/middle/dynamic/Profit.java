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
        return 0;

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
        System.out.println(maxProfit_p(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitN(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitN_p(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfitNWithCool(new int[]{7, 1, 5, 3, 6, 4}));

    }
}
