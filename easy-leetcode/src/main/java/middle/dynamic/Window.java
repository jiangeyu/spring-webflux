package middle.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:47 2020/12/20
 */
public class Window {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。
     * 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        for (Character c : t.toCharArray()) {
            need.compute(c, (k, v) -> need.get(k) == null ? 1 : need.get(k) + 1);
        }
        int left = 0, right = 0;
        int start = 0;
        int length = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.compute(c, (k, v) -> window.get(c) == null ? 1 : window.get(c) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < length) {
                    start = left;
                    length = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return length == Integer.MAX_VALUE ? "" : s.substring(start, start + length);
    }

    /**
     * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
     * <p>
     * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
     * <p>
     * 输入: s1 = "ab" s2 = "eidbaooo"
     * 输出: True
     * 解释: s2 包含 s1 的排列之一 ("ba").
     * <p>
     * 输入: s1= "ab" s2 = "eidboaoo"
     * 输出: False
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int minLength = s1.length();
        for (Character c : s1.toCharArray()) {
            need.compute(c, (k, v) -> need.get(k) == null ? 1 : need.get(k) + 1);
        }
        int left = 0, right = 0;
        int length = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.compute(c, (k, v) -> window.get(c) == null ? 1 : window.get(c) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < length) {
                    length = right - left;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return length == minLength;
    }

    /**
     * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
     * <p>
     * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
     * <p>
     * 输入:
     * s: "cbaebabacd" p: "abc"
     * <p>
     * 输出:
     * [0, 6]
     * <p>
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
     * <p>
     * <p>
     * 输入:
     * s: "abab" p: "ab"
     * <p>
     * 输出:
     * [0, 1, 2]
     * <p>
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int minLength = p.length();
        for (Character c : p.toCharArray()) {
            need.compute(c, (k, v) -> need.get(k) == null ? 1 : need.get(k) + 1);
        }
        int left = 0, right = 0;
        int length = Integer.MAX_VALUE;
        int valid = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.compute(c, (k, v) -> window.get(c) == null ? 1 : window.get(c) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                length = right - left;
                if (length == minLength) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return result;
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int right = 0;
        int left = 0;
        int res = 0;
        int length = s.length();
        while (right < length) {
            char c = s.charAt(right);
            right++;
            window.compute(c, (k, v) -> window.get(c) == null ? 1 : window.get(c) + 1);
            while (window.get(c) != null && window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
//        Map<Character, Integer> map = new HashMap<>();
//        map.compute('c', (k, v) -> map.get(k) == null ? 1 : map.get(k) + 1);
//        map.compute('c', (k, v) -> map.get(k) + 1);
//        System.out.println(map.get('c'));
//        System.out.println(checkInclusion("ab", "eidbaooo"));
//        System.out.println(checkInclusion("ab", "eidboaoo"));


//        System.out.println(minWindow("BANCADOBECODE", "ABC"));
//        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
    }
}
