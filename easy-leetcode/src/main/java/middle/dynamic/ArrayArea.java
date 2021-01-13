package middle.dynamic;

import java.util.Stack;

/**
 * @Author: <a href='mailto:'>jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午12:16 2021/1/13
 */
public class ArrayArea {

    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     *
     * @param matrix
     * @return
     */
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

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     *
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     *
     *
     * @param heights
     * @return
     */
    public  static int largestRectangleArea(int[] heights) {
        // 这里为了代码简便，在柱体数组的头和尾加了两个高度为 0 的柱体。
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Stack<Integer> stack = new Stack<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }
    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    public static int largestRectangleArea1(int[] heights) {
        int area = 0, n = heights.length;
        // 遍历每个柱子，以当前柱子的高度作为矩形的高 h，
        // 从当前柱子向左右遍历，找到矩形的宽度 w。
        for (int i = 0; i < n; i++) {
            int w = 1, h = heights[i], j = i;
            while (--j >= 0 && heights[j] >= h) {
                w++;
            }
            j = i;
            while (++j < n && heights[j] >= h) {
                w++;
            }
            area = Math.max(area, w * h);
        }

        return area;
    }

    /**
     * 85. 最大矩形
     *
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int col = matrix.length;
        int row = matrix[0].length;
        int[] heights = new int[row];
        int ans = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }




    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}

        }));
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }
}
