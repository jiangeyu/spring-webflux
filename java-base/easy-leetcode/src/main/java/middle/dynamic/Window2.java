package middle.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:11 2021/3/21
 */
public class Window2 {
    public static int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int size = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int result = Integer.MIN_VALUE;
        while (right < size) {
            char tmp = s.charAt(right);
            right++;
            if (map.get(tmp) == null) {
                map.put(tmp, 1);
            } else {
                map.put(tmp, map.get(tmp) + 1);
            }
            while (map.get(tmp) != null && map.get(tmp) > 1) {
                char d = s.charAt(left);
                left++;
                map.put(d, map.get(d) - 1);
            }
            result = Math.max(result, right - left);

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("asfff"));
    }
}
