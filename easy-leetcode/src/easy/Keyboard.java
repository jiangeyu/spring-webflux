package easy;

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

        for (int j = 1; j < word.length()-1; j++) {
            int step = Math.abs(word.charAt(j + 1) - word.charAt(j));
            start += Math.abs(step);
        }
        return start;
    }

    public static void main(String[] args) {
        System.out.println(calculateTime("pqrstuvwxyzabcdefghijklmno", "leetcode"));
        System.out.println(calculateTime("abcdefghijklmnopqrstuvwxyz", "cba"));
    }
}
