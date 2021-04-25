package middle.dynamic;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:59 2020/12/26
 */
public class QiQiu {

    /**
     * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
     * <p>
     * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
     * <p>
     * 求所能获得硬币的最大数量。
     * <p>
     * 说明:
     * <p>
     * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
     * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
     *
     * @param nums
     * @return
     */

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        points[0] = points[n + 1] = 1;

        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    /**
     * @param points
     * @return
     */
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int n = points.length;
        if (n == 0) {
            return 0;
        }
        int count = 1;
        int start = points[0][1];
        for (int[] interval : points) {
            if (interval[0] > start) {
                count++;
                start = interval[1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
        System.out.println(findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        System.out.println(findMinArrowShots(new int[][]{{1, 2}}));
    }
}


