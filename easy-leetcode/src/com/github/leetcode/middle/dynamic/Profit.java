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
        /**
         当k大于等于数组长度一半时, 问题退化为贪心问题此时采用 买卖股票的最佳时机 II
         的贪心方法解决可以大幅提升时间性能, 对于其他的k, 可以采用 买卖股票的最佳时机 III
         的方法来解决, 在III中定义了两次买入和卖出时最大收益的变量, 在这里就是k租这样的
         变量, 即问题IV是对问题III的推广, t[i][0]和t[i][1]分别表示第i比交易买入和卖出时
         各自的最大收益
         **/
        if (k < 1) return 0;
        if (k >= prices.length / 2) return greedy(prices);
        int[][] t = new int[k][2];
        for (int i = 0; i < k; ++i)
            t[i][0] = Integer.MIN_VALUE;
        for (int p : prices) {
            t[0][0] = Math.max(t[0][0], -p);
            t[0][1] = Math.max(t[0][1], t[0][0] + p);
            for (int i = 1; i < k; ++i) {
                t[i][0] = Math.max(t[i][0], t[i - 1][1] - p);
                t[i][1] = Math.max(t[i][1], t[i][0] + p);
            }
        }
        return t[k - 1][1];
    }

    private static int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
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
//        System.out.println(maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
//        System.out.println(maxProfitN(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfitN_p(new int[]{7, 1, 5, 3, 6, 4}));
//        System.out.println(maxProfitNWithCool(new int[]{7, 1, 5, 3, 6, 4}));
//
//        System.out.println(maxProfitK(2, new int[]{2, 4, 1}));
//        System.out.println(maxProfitK(2, new int[]{3, 2, 6, 5, 0, 3}));
//        System.out.println(maxProfitK(1, new int[]{1,2}));
//        System.out.println(maxProfitK(2, new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfitK(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        System.out.println(maxProfitK(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(maxProfitK(2, new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
    }
}
