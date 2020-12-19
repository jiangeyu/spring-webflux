package com.github.leetcode.middle.dynamic;

import java.util.Arrays;

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

    // 凑整数为amount的币数

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        if (dp[amount] != Integer.MAX_VALUE)
            return dp[amount];
        return -1;
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

        return dp[n] > Integer.MAX_VALUE ? dp[n] % 1000000007 : dp[n];
    }

    /**
     * @param {number[]} nums
     * @return {boolean}
     * 背包问题：看数组中是否存在加起来为sum/2的数.
     * 背包容量（V） = sum/2
     * 每一个物品只能装一次,如果出现背包中重量等于sum/2则为true else false
     * dp[i]表示能否填满容量为i的背包
     * 状态转移方程为 dp[i] = dp[i-1] || nums[i]+dp[i-nums[j]]
     * 举例:v = sum/2 = 11   nums = [1,5,11,5]  1是true 0 是false
     * 0  1  2  3  4  5  6  7  8  9  10  11
     * nums[0] 0  1  0  0  0  0  0  0  0  0   0   0
     * nums[1] 0  1  0  0  0  1  1  0  0  0   0   0
     * nums[2] 0  1  0  0  0  1  1  0  0  0   0   1
     * nums[3] 0  1  0  0  0  1  1  0  0  0   0   1
     * <p>
     * 所以返回true，因为背包中nums[i]的状态都是由上一行决定的因此可以将二维转化为1维数组从尾部开始
     */

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (!(sum % 2 == 0)) {
            return false;
        }
        sum = sum / 2;
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }

        }
        return dp[sum];

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

    /**
     * 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     *
     * 输入: amount = 5, coins = [1, 2, 5]
     * 输出: 4
     * 解释: 有四种方式可以凑成总金额:
     * 5=5
     * 5=2+2+1
     * 5=2+1+1+1
     * 5=1+1+1+1+1
     *
     * @param amount
     * @param coins
     * @return
     */

    public static int change(int amount, int[] coins) {
        int dp[] = new int[amount+1];
        // 设置起始状态
        dp[0] = 1;

        for (int coin : coins) {
            // 记录每添加一种面额的零钱，总金额j的变化
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    // 在上一钟零钱状态的基础上增大
                    // 例如对于总额5，当只有面额为1的零钱时，只有一种可能 5x1
                    // 当加了面额为2的零钱时，除了原来的那一种可能外
                    // 还加上了组合了两块钱的情况，而总额为5是在总额为3的基础上加上两块钱来的
                    // 所以就加上此时总额为3的所有组合情况
                    dp[j] = dp[j] + dp[j - coin];
                }
            }
        }
        return dp[amount];
    }

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */

    public static int maxSubArray(int[] nums) {
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int sum = Integer.MIN_VALUE;
//        int[][] dp = new int[nums.length][nums.length + 1];
//        dp[0][0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            dp[i][i] = nums[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                dp[i][j] = dp[i][j - 1] + nums[j];
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                sum = Math.max(sum, dp[i][j]);
//            }
//        }
//        return sum;

        /**
         * nums[i]为结尾的「最大子数组和」为dp[i]
         *
         */
//        if (nums.length == 1) {
//            return nums[0];
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int res = Integer.MIN_VALUE;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            res = Math.max(res, dp[i]);
//        }
//        return res;


        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
//        int sum = 0;
//        for (int num : nums) {
//            if (sum > 0) {
//                sum += num;
//            }
//            else {
//                sum = num;
//            }
//            res = Math.max(res, sum);
//        }
//        return res;

    }


    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {


        return false;


    }

    public static void main(String[] args) {
//
//        System.out.println(waysToChange(900750));
//        System.out.println(change(900750));
//        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
//        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
//        int[] coins = new int[]{1, 2, 5};
//        System.out.println(coinChange(coins, 15));
//
//        int[] coins2 = new int[]{2};
//        System.out.println(coinChange(coins2, 3));
//
//        int[] coins3 = new int[]{1};
//        System.out.println(coinChange(coins3, 0));
//
//        int[] coins4 = new int[]{1};
//        System.out.println(coinChange(coins4, 1));
//
//        int[] coins5 = new int[]{2};
//        System.out.println(coinChange(coins5, 1));
//        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maxSubArray(new int[]{4, -1, 2, 1}));
//        System.out.println(maxSubArray(new int[]{1}));
//        System.out.println(maxSubArray(new int[]{-2, 1}));
//        System.out.println(maxSubArray(new int[]{-2, -1}));
        System.out.println(maxSubArray(new int[]{1, 1, 3, -1}));
        System.out.println(change(5, new int[]{1, 2, 5}));

    }
}
