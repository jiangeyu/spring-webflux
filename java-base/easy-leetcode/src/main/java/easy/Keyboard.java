package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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


    /**
     * 224. 基本计算器
     * <p>
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * <p>
     * s = "(1+(4+5+2)-3)+(6+8)"
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        // sign 代表正负
        int sign = 1, res = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int cur = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(++i) - '0';
                }
                res = res + sign * cur;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(res);
                res = 0;
                stack.push(sign);
                sign = 1;
            } else if (ch == ')') {
                res = stack.pop() * res + stack.pop();
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "com/github/leetcode"));
//        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));

//        System.out.println(reversePairs(new int[] {1,3,2,3,1}));
//        System.out.println(reversePairs(new int[] {2,4,3,5,1}));
        System.out.println(reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
