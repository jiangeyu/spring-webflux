package middle.greedy;

import java.util.*;

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
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (preSum[j] - preSum[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int subarraySum1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>(1);
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k) + 1;
            }
            map.put(sum, map.getOrDefault(sum - k, 0) + 1);
        }
        return count;
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int slow = 0;
        int fast = 1;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

    /**
     * 1047. 删除字符串中的所有相邻重复项
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * <p>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * <p>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        int n = S.length();
        char[] ss = S.toCharArray();//转为字符数组
        char[] stack = new char[n];//定义栈
        int top = -1; //定义栈指针
        //以下for循环将不重复的字符存放在栈里
        for (int j = 0; j < n; j++) {
            if (top > -1 && stack[top] == ss[j]) {
                top--;//栈针移动，代替真是出栈
            } else {
                stack[++top] = ss[j];//根据栈针移动直接覆盖重复的值
            }
        }
        //以下打印栈内不重复的字符
        char[] ans = new char[top + 1];
        for (int i = 0; i < top + 1; i++) {
            ans[i] = stack[i];
        }
        //通过有参构造传递字符数组，直接创建字符串对象
        String str = new String(ans);
        return str;
    }

    /**
     * 57. 插入区间
     * <p>
     * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
     * <p>
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * <p>
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * <p>
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);
        list.sort((o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o1[0], o2[0]));
        List<int[]> res = new ArrayList<>();
        for (int[] cur : list) {
            if (res.isEmpty()) {
                res.add(cur);
            } else {
                int[] last = res.get(res.size() - 1);
                if (cur[0] > last[1]) {
                    res.add(cur);
                } else {
                    last[1] = Math.max(last[1], cur[1]);
                }
            }
        }
        return res.toArray(new int[][]{});
    }


    public static void main(String[] args) {
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2},{2,3}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
//        System.out.println(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {-100, -2}, {5, 7}}));
//        System.out.println(subarraySum(new int[]{1, 1, 1, 2}, 2));
//        System.out.println(subarraySum1(new int[]{1, 1, 1, 2}, 2));
//        System.out.println(subarraySum(new int[]{0, 1, 1, 1, 2}, 2));
//        System.out.println(subarraySum1(new int[]{0, 1, 1, 1, 2}, 2));
//        System.out.println(subarraySum(new int[]{1, 2, 3}, 3));
//        System.out.println(subarraySum1(new int[]{1, 2, 3}, 3));
//        System.out.println(removeDuplicates(new int[]{1, 2, 3, 4, 4, 4}));
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 4, 4, 4, 4}));
//        System.out.println(removeDuplicates(new int[]{1, 2}));
//        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
    }

}
