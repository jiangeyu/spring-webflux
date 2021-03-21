package middle.arrays;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午8:39 2021/3/15
 */
public class Matrix {

    /**
     * 240. 搜索二维矩阵 II
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }

    /**
     * 162. 寻找峰值
     * 峰值元素是指其值大于左右相邻值的元素。
     * <p>
     * 给你一个输入数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设 nums[-1] = nums[n] = -∞ 。
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {  // 左边高，说明左边有峰值，可能mid就是
                right = mid;             // mid在下一次查找中还要考虑在内
            } else {
                left = mid + 1;   // 右边高，说明在mid右边有峰值，所以mid一定不是
            }                         // mid已经不是了，排除掉
        }
        return left;
    }


    /**
     * 79. 单词搜索
     * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean search(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)) return false;
        board[i][j] += 256;
        boolean result = search(board, word, i - 1, j, k + 1) || search(board, word, i + 1, j, k + 1)
                || search(board, word, i, j - 1, k + 1) || search(board, word, i, j + 1, k + 1);
        board[i][j] -= 256;
        return result;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        res[0] = binarySearch(nums, target, true);
        res[1] = binarySearch(nums, target, false);
        return res;
    }

    //leftOrRight为true找左边界 false找右边界
    public int binarySearch(int[] nums, int target, boolean leftOrRight) {
        int res = -1;
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target < nums[mid])
                right = mid - 1;
            else if (target > nums[mid])
                left = mid + 1;
            else {
                res = mid;
                //处理target == nums[mid]
                if (leftOrRight)
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return res;
    }


    int ans;
    int[] temp;

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    public void merge(int[] nums, int l, int mid, int r) {
        int i = l, j = mid + 1, id = l;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[id++] = nums[i++];
            } else {
                ans += mid - i + 1;
                temp[id++] = nums[j++];
            }
        }
        while (i <= mid) temp[id++] = nums[i++];
        while (j <= r) temp[id++] = nums[j++];
        for (int k = l; k <= r; k++) nums[k] = temp[k];
    }

    /**
     * 剑指 Offer 51. 数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     *
     * @param nums
     * @return
     */
    public int reversePairs(int[] nums) {
        ans = 0;
        int n = nums.length;
        temp = new int[n];
        mergeSort(nums, 0, n - 1);
        return ans;
    }


    /**
     * 862. 和至少为 K 的最短子数组
     * <p>
     * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
     * <p>
     * 如果没有和至少为 K 的非空子数组，返回 -1 。
     *
     * @param A
     * @param K
     * @return
     */

    /*
  思路： 遍历数组 L R 为滑窗左右边界 只增不减
        双向队列保存当前窗口中最大的值的数组下标 双向队列中的数从大到小排序，
        新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
        当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
        数组下标在[L，R]中，并将当前最大值记录
  举例： nums[1，3，-1，-3，5，3，6，7] k=3
     1：L=0，R=0，队列【0】 R-L+1 < k
            队列代表值【1】
     2: L=0,R=1, 队列【1】 R-L+1 < k
            队列代表值【3】
     解释：当前数为3 队列中的数为【1】 要保证队列中的数从大到小 弹出1 加入3
          但队列中保存的是值对应的数组下标 所以队列为【1】 窗口长度为2 不添加记录
     3: L=0,R=2, 队列【1，2】 R-L+1 = k ,result={3}
            队列代表值【3，-1】
     解释：当前数为-1 队列中的数为【3】 比队列尾值小 直接加入 队列为【3，-1】
          窗口长度为3 添加记录记录为队首元素对应的值 result[0]=3
     4: L=1,R=3, 队列【1，2，3】 R-L+1 = k ,result={3，3}
            队列代表值【3，-1,-3】
     解释：当前数为-3 队列中的数为【3，-1】 比队列尾值小 直接加入 队列为【3，-1，-3】
          窗口长度为4 要保证窗口大小为3 L+1=1 此时队首元素下标为1 没有失效
          添加记录记录为队首元素对应的值 result[1]=3
     5: L=2,R=4, 队列【4】 R-L+1 = k ,result={3，3，5}
            队列代表值【5】
     解释：当前数为5 队列中的数为【3，-1，-3】 保证从大到小 依次弹出添加 队列为【5】
          窗口长度为4 要保证窗口大小为3 L+1=2 此时队首元素下标为4 没有失效
          添加记录记录为队首元素对应的值 result[2]=5
    依次类推 如果队首元素小于L说明此时值失效 需要弹出
*/
    public int shortestSubarray(int[] A, int K) {
        int n = A.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
        }
        LinkedList<Integer> queue = new LinkedList();
        int min = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!queue.isEmpty() && sum[queue.peekLast()] >= sum[i]) {
                queue.pollLast();
            }
            while (!queue.isEmpty() && sum[i] - sum[queue.peek()] >= K) {
                min = Math.min(min, i - queue.poll());
            }
            queue.add(i);
        }
        if (min == n + 1) {
            return -1;
        }
        return min;
    }


    /**
     * 239. 滑动窗口最大值
     * <p>
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回滑动窗口中的最大值。
     *
     * @param nums
     * @param k
     * @return
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小 弹出
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if (list.peek() <= i - k) {
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if (i - k + 1 >= 0) {
                result[i - k + 1] = nums[list.peek()];
            }
        }
        return result;
    }

    /**
     * 剑指 Offer 61. 扑克牌中的顺子
     * <p>
     * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
     * <p>
     *  
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCnt = 0, diff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                zeroCnt++;
            } else {
                if (nums[i] == nums[i + 1]) return false;
                if (nums[i] + 1 != nums[i + 1]) {
                    diff += nums[i + 1] - nums[i] - 1;
                }
            }
        }
        return zeroCnt >= diff;
    }

    /**
     * 670. 最大交换
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     *
     *
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        if (num == 0)
            return 0;
        char[] chars = String.valueOf(num).toCharArray();
        int[] maxIndex = new int[chars.length];
        int max = chars.length - 1;
        //倒过来寻找，当前位置往右，最大的数的下标
        for (int j = chars.length - 1; j >= 0; j--) {
            if (chars[j] - '0' > chars[max] - '0') {
                max = j;
            }
            maxIndex[j] = max;
        }
        //正序遍历，找到第一个不是最大的数，将该位置和右边最大数换位置
        for (int i = 0; i < chars.length; i++) {
            int iValue = chars[i] - '0';
            int maxValue = chars[maxIndex[i]] - '0';
            if (maxValue != iValue) {
                chars[i] = (char) (maxValue + '0');
                chars[maxIndex[i]] = (char) (iValue + '0');
                break;
            }
        }
        return Integer.parseInt(new String(chars));
    }
}
