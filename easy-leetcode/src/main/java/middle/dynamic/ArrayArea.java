package middle.dynamic;

/**
 * @Author: <a href='mailto:'>jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午12:16 2021/1/13
 */
public class ArrayArea {
    public static int maximalSquare(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        if(n < 1) return 0;
        int[][] dp = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}

        }));
    }
}
