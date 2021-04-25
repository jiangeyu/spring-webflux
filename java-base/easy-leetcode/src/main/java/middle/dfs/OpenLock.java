package middle.dfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:51 2021/1/13
 */
public class OpenLock {

    /**
     * 752
     * <p>
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * <p>
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * <p>
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * <p>
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>();
        for (String dead : deadends) {
            deadSet.add(dead);
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        Set<String> visited = new HashSet<>();
        visited.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int j = 0; j < sz; j++) {
                String curr = queue.poll();

                if (deadSet.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return step;
                }
                for (int i = 0; i < 4; i++) {
                    String up = plusOne(curr, i);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(curr, i);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    public static String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"8888"}, "0009"));
        System.out.println(openLock(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"));

    }


}
