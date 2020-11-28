package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:44 2020/11/28
 */
public class Keyboard {

    public static int calculateTime(String keyboard, String word) {
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i), i);
        }
        int sum = Math.abs(map.get(word.charAt(0)) - map.get(keyboard.charAt(0)));
        for (int j = 1; j < word.length(); j++) {
            int step = map.get(word.charAt(j)) - map.get(word.charAt(j - 1));
            sum += Math.abs(step);
        }
        return sum;
    }

    public static int calculateTime2(String keyboard, String word) {
        int start = keyboard.indexOf(word.charAt(0));

        for (int j = 1; j < word.length() - 1; j++) {
            int step = Math.abs(word.charAt(j + 1) - word.charAt(j));
            start += Math.abs(step);
        }
        return start;
    }

    public static int reversePairs(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (new Long(nums[i]) > new Long(nums[j]) * 2) {
                    sum += 1;
                }
            }
        }

        return sum;

    }

    public static void main(String[] args) {
        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));

//        System.out.println(reversePairs(new int[] {1,3,2,3,1}));
//        System.out.println(reversePairs(new int[] {2,4,3,5,1}));
        System.out.println(reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
