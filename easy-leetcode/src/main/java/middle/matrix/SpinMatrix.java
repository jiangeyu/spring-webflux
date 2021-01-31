package middle.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:42 2021/1/16
 */
public class SpinMatrix {

    /**
     * 59
     * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        int c = 1, j = 0;
        while (c <= n * n) {
            for (int i = j; i < n - j; i++) {
                arr[j][i] = c++;
            }
            for (int i = j + 1; i < n - j; i++) {
                arr[i][n - j - 1] = c++;
            }
            for (int i = n - j - 2; i >= j; i--) {
                arr[n - j - 1][i] = c++;
            }
            for (int i = n - j - 2; i > j; i--) {
                arr[i][j] = c++;
            }
            j++;
        }
        return arr;
    }

//    if(matrix.empty() || matrix[0].empty()) return {};
//    vector<int> res;
//    int m = matrix.size(), n = matrix[0].size();
//    // 确定上下左右四条边的位置
//    int up = 0, down = m - 1, left = 0, right = n - 1;
//        while (true)
//    {
//        for (int i = left; i <= right; i++) res.push_back(matrix[up][i]);
//        if (++up > down) break;
//        for (int i = up; i <= down; i++) res.push_back(matrix[i][right]);
//        if (--right < left) break;
//        for (int i = right; i >= left; i--) res.push_back(matrix[down][i]);
//        if (--down < up) break;
//        for (int i = down; i >= up; i--) res.push_back(matrix[i][left]);
//        if (++left > right) break;
//    }
//        return res;

    /**
     * 54. 螺旋矩阵
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1, left = 0, right = n - 1;
        List<Integer> list = new ArrayList<>();
        while (true) {
            for (int i = left; i <= right; i++) list.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i <= down; i++) list.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) list.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i >= up; i--) list.add(matrix[i][left]);
            if (++left > right) break;
        }
        return list;
    }

    /**
     * 48
     *
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            int start = i;
            int end = len - i - 1;
            for (int j = 0; j < end - start; j++) {
                int temp = matrix[start][start + j];
                matrix[start][start + j] = matrix[end - j][start];
                matrix[end - j][start] = matrix[end][end - j];
                matrix[end][end - j] = matrix[start + j][end];
                matrix[start + j][end] = temp;
            }
        }
    }

    /**
     * 179
     * 给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。
     * <p>
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * 输入：nums = [10,2]
     * 输出："210"
     *
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .map(i -> i.toString(i))
                .sorted((s1, s2) -> {
                    String sum1 = s1 + s2;
                    String sum2 = s2 + s1;

                    for (int i = 0; i < sum1.length(); i++) {
                        if (sum1.charAt(i) != sum2.charAt(i)) {
                            return sum2.charAt(i) - sum1.charAt(i);
                        }
                    }
                    return 0;
                })
                .reduce(String::concat)
                .filter(s -> !s.startsWith("0"))
                .orElse("0");
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < n - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * 120. 三角形最小路径和
     * <p>
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 加1可以不用初始化最后一层
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
//        System.out.println(merge(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
//        System.out.println(merge(new int[][]{{1, 4}, {0, 4}}));
        System.out.println(merge(new int[][]{{1, 4}, {4, 5}}));
    }
}
