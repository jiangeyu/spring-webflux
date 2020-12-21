package com.github.leetcode.middle.dynamic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:03 2020/12/19
 */
public class SubArray {

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

    }


    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {


        return false;


    }

}
