package middle.dynamic;

import java.util.Arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:47 2020/12/21
 */
public class SubSequence {


    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {


        return false;


    }


    /**
     * 最长递增子序列
     *
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            ans = Math.max(ans, dp[i]);

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 5, 3, 6, 10, 9, 10}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 4, 5}));
        System.out.println(lengthOfLIS(new int[]{1, 2, 6, 5}));
        System.out.println(lengthOfLIS(new int[]{4, 10, 4, 3, 8, 9}));

    }
}
