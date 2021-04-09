package middle.dynamic;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午5:47 2020/12/21
 */
public class SubSequence {


    /**
     * 316
     * <p>
     * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次
     * 。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
     *
     * @param s
     * @return
     */
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (stack.contains(c))
                continue;
            while (!stack.isEmpty() && stack.peek() > c && s.indexOf(stack.peek(), i) != -1) {
                stack.pop();
            }
            stack.push(c);
        }
        char chars[] = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            chars[i] = stack.get(i);
        }
        return new String(chars);

    }


    /**
     * 392. 判断子序列
     * <p>
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     */
    public boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int i = 0, j = 0;
        while (i < chars1.length && j < chars2.length) {
            if (chars1[i] == chars2[j]) {
                i++;
            }
            j++;

        }
        return i == chars1.length;

    }


    /**
     * 最长递增子序列 300
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
     * 718
     * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
     * <p>
     * 最长公共子数组
     *
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * 编辑距离  72
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
     * 128
     * <p>
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxLen = 1;
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                maxLen++;
                result = Math.max(result, maxLen);
            } else if (nums[i - 1] == nums[i]) {
                continue;
            } else {
                maxLen = 1;
            }
        }
        return result;
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


    /**
     * 33. 搜索旋转排序数组
     * <p>
     * 升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
     * <p>
     * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[left] <= target && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 剑指 Offer 67. 把字符串转换成整数
     *
     *
     * @param str
     * @return
     */
    public int strToInt(String str) {
        boolean isNegative = false;
        int i = 0;
        int j = 0;
        long res = 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        //判断首位
        char[] ch = str.toCharArray();
        //首位有三种情况，+ - 或者数字
        if (ch[0] != '-' && ch[0] != '+' && !Character.isDigit(ch[0])) return 0;
        if (ch[0] == '-') {
            isNegative = true;
            i++;
        } else if (ch[0] == '+') {
            i++;
        }
        while (i < str.length() && Character.isDigit(ch[i])) {
            res = res * 10 + (ch[i++] - '0');
            if (res > Integer.MAX_VALUE && isNegative == false) return Integer.MAX_VALUE;
            if (res > Integer.MAX_VALUE && isNegative == true) return Integer.MIN_VALUE;
        }
        return isNegative == false ? (int) res : (int) -res;
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonSubsequence("abc", "ace"));
//        System.out.println(longestCommonSubsequence("abcde", "ace"));
//        System.out.println(minDistance("abcde", "ace"));
//        System.out.println(minDistance("horse", "ros"));
//        System.out.println(minDistance("intention", "execution"));
//        System.out.println(minDistance("distance", "springbok"));
        System.out.println(longestPalindrome("asddg"));
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{1, 2, 0, 1}));
        System.out.println(longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
        System.out.println(removeDuplicateLetters("bcabc"));


    }
}
