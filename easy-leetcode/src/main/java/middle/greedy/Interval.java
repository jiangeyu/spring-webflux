package middle.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description: 区间调度
 * @Date: Created in 上午10:19 2020/12/31
 */
public class Interval {

    public static int eraseOverlapIntervals(int[][] intervals) {
        int length = intervals.length;
        if (length <= 1) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 0; i < length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            count++;
            end = intervals[i][1];
        }
        return length - count;
    }

    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * <p>
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     *
     * @param nums
     * @param k
     * @return
     */

    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] preSum = new int[n + 1];
        int count = 0;
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (preSum[j] - nums[j-1] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2},{2,3}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}}));
        System.out.println(subarraySum(new int[]{1, 1, 1, 2}, 2));
//        System.out.println(subarraySum(new int[]{0, 1, 1, 1, 2}, 2));
        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
    }

}
