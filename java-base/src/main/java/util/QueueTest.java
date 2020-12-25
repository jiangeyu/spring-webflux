package util;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午10:09 2020/12/23
 */
public class QueueTest {

    public static int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }


    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 5, 2, 9, 3);
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a > b ? -1 : ((a < b) ? 1 : 0));
        queue.addAll(list);
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int[][] envelopes1 = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};

        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

        System.out.println(maxEnvelopes(envelopes));
        System.out.println(maxEnvelopes(envelopes1));

    }

    public static int compare(int a, int b) {
        return a > b ? 1 : ((a < b) ? -1 : 0);




    }
}
