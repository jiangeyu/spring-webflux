package util;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:09 2020/12/23
 */
public class QueueTest {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 5, 2, 9, 3);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a > b ? 1 : ((a < b) ? -1 : 0));
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(list);

        System.out.println(queue);


    }

    public static int compare(int a, int b) {
        return a > b ? 1 : ((a < b) ? -1 : 0);
    }
}
