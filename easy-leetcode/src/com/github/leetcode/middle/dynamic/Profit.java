package com.github.leetcode.middle.dynamic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:39 2020/12/16
 */
public class Profit {

    /**
     * 一次交易
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
     * 两次交易
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
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
     * 不限制交易次数
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
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];

            }
        }
        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));

    }
}
