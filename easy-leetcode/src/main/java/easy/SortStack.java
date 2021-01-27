package easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:00 2021/1/12
 */
public class SortStack {

    /**
     * 单调栈，下一个更大元素
     *
     * @param nums
     * @return
     */
    public static int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    /**
     * 给定两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * <p>
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
     * 对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
     * 对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
     * 示例 2:
     * <p>
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
     * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     * <p>
     * <p>
     * 通过Stack、HashMap解决
     * <p>
     * 先遍历大数组nums2，首先将第一个元素入栈；
     * 继续遍历，当当前元素小于栈顶元素时，继续将它入栈；当当前元素大于栈顶元素时，栈顶元素出栈，此时应将该出栈的元素与当前元素形成key-value键值对，存入HashMap中；
     * 当遍历完nums2后，得到nums2中元素所对应的下一个更大元素的hash表；
     * 遍历nums1的元素在hashMap中去查找‘下一个更大元素’，当找不到时则为-1。
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hasMap = new HashMap<>();

        int[] result = new int[nums1.length];
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                hasMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i++) {
            result[i] = hasMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    /**
     * 739
     * <p>
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * <p>
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     *
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; ++i) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * 42
     * <p>
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curIdx = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[curIdx]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    int stackTop = stack.peek();
                    ans += (Math.min(height[stackTop], height[i]) - height[curIdx]) * (i - stackTop - 1);
                }
            }
            stack.add(i);
        }
        return ans;
    }

    /**
     * 407 接雨水
     *
     * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
     *
     *
     * @param heights
     * @return
     */

    /**
     * 把每一个元素称作块。因为那个图片给的好像瓷砖啊。
     * 其实做这题一开始都是想的是对于每一个块，去找它四个方向最高的高度中的最小值(二维下则是左右最高的高度取较小的那一个)作为上界，当前块作为下界
     * 但是这4个方向每次遍历复杂度过高，且不能像二维那样去提前预存每个方向的最大值
     * 那可以反过来我不以每个块为处理单元，而是以块的四周作为处理单元
     * 那如何保证所有四周的可能性都考虑到呢？
     * 我们从矩阵的最外围往里面遍历，像一个圈不断缩小的过程
     * 为了防止重复遍历用visited记录
     * 其次要用小顶堆(以高度为判断基准)来存入所有快的四周(即圈是不断缩小的，小顶堆存的就是这个圈)
     * 为什么要用小顶堆？
     * 这样可以保证高度较小的块先出队
     * * 为什么要让高度较小的块先出队？(关键点)
     * 1. 一开始时候就讲了基础做法是：对于每一个块，去找它四个方向最高的高度中的最小值(二维下则是左右最高的高度取较小的那一个)作为上界，当前块作为下界
     * 2. 而我们现在反过来不是以中心块为处理单元，而是以四周作为处理单元
     * 3. 我们如果能确保当前出队的元素对于该中心块来说是它周围四个高度中的最小值那么就能确定接雨水的大小
     * 4. 为什么队头元素的高度比中心块要高它就一定是中心块周围四个高度中的最小值呢？
     * 因为我们的前提就是小顶堆：高度小的块先出队，所以对于中心块来说，先出队的必然是中心块四周高度最小的那一个
     * 步骤：
     * 1. 构建小顶堆，初始化为矩阵的最外围(边界所有元素)
     * 2. 不断出队，倘若队头元素的四周(队头元素的四周其实就是上面说的中心块，队头元素是中心块的四周高度中最矮的一个)
     * 即代表能够接雨水：队头元素减去该中心块即当前中心块能接雨水的值
     * 3. 但是接完雨水之后中心块还要存进队列中，但这时要存入的中心块是接完雨水后的中心块
     */
    public int trapRainWater(int[][] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        int m = heights[0].length;
        // 用一个vis数组来标记这个位置有没有被访问过
        boolean[][] vis = new boolean[n][m];
        // 优先队列中存放三元组 [x,y,h] 坐标和高度
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        // 先把最外一圈放进去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.offer(new int[]{i, j, heights[i][j]});
                    vis[i][j] = true;
                }
            }
        }
        int res = 0;
        // 方向数组，把dx和dy压缩成一维来做
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            // 看一下周围四个方向，没访问过的话能不能往里灌水
            for (int k = 0; k < 4; k++) {
                int nx = poll[0] + dirs[k];
                int ny = poll[1] + dirs[k + 1];
                // 如果位置合法且没访问过
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny]) {
                    // 如果外围这一圈中最小的比当前这个还高，那就说明能往里面灌水啊
                    if (poll[2] > heights[nx][ny]) {
                        res += poll[2] - heights[nx][ny];
                    }
                    // 如果灌水高度得是你灌水后的高度了，如果没灌水也要取高的
                    pq.offer(new int[]{nx, ny, Math.max(heights[nx][ny], poll[2])});
                    vis[nx][ny] = true;
                }
            }
        }
        return res;
    }

    /**
     * 11
     * <p>
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
     * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     *
     * @param height
     * @return
     */
    int maxArea(int[] height) {
        if (height.length <= 1) return -1;
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            res = Math.max(res, h * (j - i));
            if (height[i] < height[j]) ++i;
            else --j;
        }
        return res;
    }

    /**
     * 4
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * <p>
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = nums1.length + nums2.length;
        int val1 = 0, val2 = 0, p = 0, k = 0;
        while (p + k < length / 2 + 1) {
            val1 = val2;
            if (k == n) {
                val2 = nums1[p++];
                continue;
            }
            if (p == m || nums1[p] >= nums2[k]) {
                val2 = nums2[k++];
            } else {
                val2 = nums1[p++];
            }
        }

        if (length % 2 == 0) {
            return (double) (val1 + val2) / 2;
        }
        return Math.max(val1, val2);
    }


    public static void main(String[] args) {
        System.out.println(nextGreaterElement(new int[]{2, 1, 2, 4, 3}));
        System.out.println(nextGreaterElement(new int[]{2, 1, 2, 3, 4}));
        System.out.println(nextGreaterElement(new int[]{1, 2, 1, 2, 4, 3}));
        System.out.println(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}));
    }


}
