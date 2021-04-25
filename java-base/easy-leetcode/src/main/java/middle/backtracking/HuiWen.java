package middle.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description: 回文串相关
 * @Date: Created in 上午11:09 2020/12/26
 */
public class HuiWen {

    /**
     * dp[i][i]  对于s[i...j] 最长回文子串是dp[i][j]
     *
     * @param s
     * @return
     */
    public static int longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        int ans = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return "";
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }
        int ans = Integer.MIN_VALUE;
        int start = 0;
        int length = 0;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
                ans = Math.max(ans, dp[i][j]);
                start = i;
                length = ans;
            }
        }
        return "";

    }

    /**
     * 给你一个字符串 s ，每一次操作你都可以在字符串的任意位置插入任意字符。
     * <p>
     * 请你返回让 s 成为回文串的 最少操作次数 。
     * <p>
     * dp[i][j]  对于s[i...j]  最小需要进行dp[i][j]次插入才能变成回文串
     *
     * @param s
     * @return
     */
    public static int minInsertions(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];

    }


    /**
     * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
     * <p>
     * 返回 s 所有可能的分割方案。
     * <p>
     * 示例:
     * <p>
     * 输入: "aab"
     * 输出:
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> list = new ArrayList<>();
        dfs(s,0, new ArrayList<>(), list);
        return list;
    }

    private static void dfs(String s, int start, ArrayList<String> path, List<List<String>> list) {
        if (start == s.length()) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String s1 = s.substring(start, i + 1);
            if (!isPalindrome(s1)) {
                continue;
            }
            path.add(s1);
            dfs(s,i + 1, path, list);
            path.remove(path.size() - 1);
        }
    }

    private static boolean isPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(longestPalindromeSubseq("bbbab"));
        System.out.println(minInsertions("babbab"));
        System.out.println(minInsertions("abba"));
        System.out.println(minInsertions("mbadm"));
        System.out.println(minInsertions("leetcode"));
        System.out.println(minInsertions("zzazz"));
        System.out.println(minInsertions("no"));
        System.out.println(partition("aab"));
    }
}
