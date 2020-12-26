package middle.dynamic;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:59 2020/12/26
 */
public class QiQiu {

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

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{3, 1, 5, 8}));
    }

}
