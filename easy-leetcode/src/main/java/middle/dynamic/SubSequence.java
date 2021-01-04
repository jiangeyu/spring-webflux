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

    public static int lengthOfLIS11(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         **/
        int maxL = 0;
        int[] dp = new int[nums.length];
        for (int num : nums) {
            // 二分法查找, 也可以调用库函数如binary_search
            int lo = 0, hi = maxL;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < num)
                    lo = mid + 1;
                else
                    hi = mid;
            }
            dp[lo] = num;
            if (lo == maxL)
                maxL++;
        }
        return maxL;
    }

    /**
     * 最长公共子序列
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];

    }

    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *
     * @param s
     * @param t
     * @return
     */
    public static int minDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j < n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(
                            Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1
                    );
                }
            }
        }

        return dp[m][n];

    }

    /**
     * 最长回文串
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        for (int i = 0; i < n - 1; i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i + 1);
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;

        }
        return res;
    }

    public static String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abc", "ace"));
//        System.out.println(longestCommonSubsequence("abcde", "ace"));
//        System.out.println(minDistance("abcde", "ace"));
//        System.out.println(minDistance("horse", "ros"));
//        System.out.println(minDistance("intention", "execution"));
//        System.out.println(minDistance("distance", "springbok"));
        System.out.println(longestPalindrome("asddg"));


    }
}
