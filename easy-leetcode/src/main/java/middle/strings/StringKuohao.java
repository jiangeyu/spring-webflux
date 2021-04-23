package middle.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:49 2021/1/27
 */
public class StringKuohao {

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, "", 0, 0, n);

        return res;
    }

    //count1统计“(”的个数，count2统计“)”的个数
    public static void generate(List<String> res, String ans, int count1, int count2, int n) {

        if (count1 > n || count2 > n) return;

        if (count1 == n && count2 == n) res.add(ans);


        if (count1 >= count2) {
            String ans1 = new String(ans);
            generate(res, ans + "(", count1 + 1, count2, n);
            generate(res, ans1 + ")", count1, count2 + 1, n);

        }
    }

    /**
     * 6. Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * @param s
     * @param numRows
     * @return
     */

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        char[] chars = new char[s.length()];
        int colLen = 2 * numRows - 2;  //每列的长度
        if (colLen == 0) colLen = 1;
        int n = s.length();
        int index;
        int minCol = n / colLen;   //共有多少完整列
        int ci = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < minCol + 1; j++) {
                index = j * colLen + i;
                if (index < s.length()) {
                    chars[ci++] = s.charAt(index);
                }
                if (i != 0 && i != numRows - 1) {
                    index = j * colLen + i + 2 * (numRows - i - 1);
                    if (index < s.length())
                        chars[ci++] = s.charAt(index);
                }
            }
        }
        return String.valueOf(chars);
    }

    /**
     * 13. 罗马数字转整数
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int n = s.length();
        int roman_int = 0;
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'I':
                    roman_int = roman_int + 1;
                    break;
                case 'V':
                    roman_int = roman_int + 5;
                    break;
                case 'X':
                    roman_int = roman_int + 10;
                    break;
                case 'L':
                    roman_int = roman_int + 50;
                    break;
                case 'C':
                    roman_int = roman_int + 100;
                    break;
                case 'D':
                    roman_int = roman_int + 500;
                    break;
                case 'M':
                    roman_int = roman_int + 1000;
                    break;
                default:
                    System.out.println("default");
                    break;
            }

            if (i != 0) {
                if (((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i - 1) == 'I'))
                    roman_int = roman_int - 1 * 2;
                if (((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i - 1) == 'X'))
                    roman_int = roman_int - 10 * 2;
                if (((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i - 1) == 'C'))
                    roman_int = roman_int - 100 * 2;
            }
        }
        return roman_int;
    }

    /**
     * 38. 外观数列
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 2; i <= n; i++) {
            s = toConver(s);
        }
        return s;
    }

    String toConver(String s) {
        int len = s.length();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        char c = s.charAt(0);
        int i = 0;
        while (i < len) {
            if (c == s.charAt(i)) {
                n++;
                i++;
            } else {
                sb.append(n).append(c);
                n = 1;
                c = s.charAt(i);
                i++;
            }
        }
        sb.append(n).append(c);
        return sb.toString();
    }

    /**
     * 415. 字符串相加
     * <p>
     * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
     *
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) {
                carry += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j--) - '0';
            }
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }

    /**
     * 557. 反转字符串中的单词 III
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < strs.length; i++) {
            buffer.append(new StringBuffer(strs[i]).reverse().toString());
            buffer.append(" ");
        }
        return buffer.toString().trim();
    }

//    public String reverseWords(String s) {
//        String[] words = s.trim().split(" +");
//        Collections.reverse(Arrays.asList(words));
//        return String.join(" ", words);
//    }


    /**
     * 14. 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        //公共前缀比所有字符串都短，随便选一个先
        String s = strs[0];
        for (String string : strs) {
            while (!string.startsWith(s)) {
                if (s.length() == 0) {
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }


    /**
     * 20. 有效的括号
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop()) return false;
        }
        return stack.isEmpty();
    }

    /**
     * 67. 二进制求和
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        for (int i = a.length() - 1, j = b.length() - 1, t = 0;
             i >= 0 || j >= 0 || t > 0;
             i--, j--) {
            if (i >= 0) t += (a.charAt(i) - '0');
            if (j >= 0) t += (b.charAt(j) - '0');
            res.insert(0, t % 2);
            t >>= 1;
        }
        return res.toString();
    }

    /**
     * 17. 电话号码的字母组合
     *
     * @param digits
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        List<String> digitsCharList = getChar(digits.charAt(0));
        if (digits.length() == 1) {
            return digitsCharList;
        }

        List<String> last = letterCombinations(digits.substring(1));
        for (String digitStr : digitsCharList) {
            for (int i = 0; i < last.size(); i++) {
                result.add(digitStr + last.get(i));
            }
        }

        return result;
    }

    public static List<String> getChar(char c) {
        switch (c) {
            case '2':
                return Arrays.asList("a", "b", "c");
            case '3':
                return Arrays.asList("d", "e", "f");
            case '4':
                return Arrays.asList("g", "h", "i");
            case '5':
                return Arrays.asList("j", "k", "l");
            case '6':
                return Arrays.asList("m", "n", "o");
            case '7':
                return Arrays.asList("p", "q", "r", "s");
            case '8':
                return Arrays.asList("t", "u", "v");
            case '9':
                return Arrays.asList("w", "x", "y", "z");
            default:
                return new ArrayList();
        }
    }

//    public String reverseWords(String s) {
//        return Arrays.stream(s.split(" "))
//                .map(String::trim)
//                .filter(word -> !word.isEmpty())
//                .reduce((word1, word2) -> word2 + " " + word1)
//                .orElse("");
//    }


    /**
     * 402. 移掉K位数字
     * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
     * <p>
     * 注意:
     * <p>
     * num 的长度小于 10002 且 ≥ k。
     * num 不会包含任何前导零。
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) {
                idx = j;
            }
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') {
                s.delete(0, 1);
            }
        }
        return s.toString();
    }

    /**
     * 97. 交错字符串
     * <p>
     * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
     * <p>
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * 提示：a + b 意味着字符串 a 和 b 连接。
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if ((n1 + n2) != n3) {
            return false;
        }
        // dp[i][j] 表示s1[0..i-1] s2[0...j-1] 能否组成s3[0...i+j-1]
        boolean[][] dp = new boolean[n1][n2];
        dp[0][0] = true;
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int j = 1; j <= n2; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        for (int i = 1; i < n1; ++i) {
            for (int j = 1; j < n2; ++j) {
                dp[i][j] = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n1][n2];
    }

    /**
     * 32. 最长有效括号
     * <p>
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int length = s.length();
        if (length <= 1) {
            return 0;
        }

        //dp[i]表示以i结束的最长的有效括号长度
        int[] dp = new int[length];
        Arrays.fill(dp, 0);
        int ans = Integer.MIN_VALUE;


        for (int i = 1; i < length; i++) {
            int left = i - dp[i - 1] - 1;
            if (s.charAt(i) == ')' && left >= 0 && s.charAt(left) == '(') {
                dp[i] = dp[i - 1] + 2;

                if (left > 1) {
                    dp[i] = dp[i] + dp[left - 1];
                }
            }

            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(convert("PAYPALISHIRING", 3));
        StringBuilder s = new StringBuilder("012345");
        System.out.println(s.delete(0, 2));
        List<String> result = letterCombinations("234");
        System.out.println(letterCombinations("23"));
        System.out.println("abc".startsWith("ab3"));
    }

}
