package middle.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:03 2020/12/19
 */
public class SubArray {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * @param nums
     * @return
     */

    public static int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int[][] dp = new int[nums.length][nums.length + 1];
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                dp[i][j] = dp[i][j - 1] + nums[j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum = Math.max(sum, dp[i][j]);
            }
        }
        return sum;
    }

    public static int maxSubArray2(int[] nums) {
        /**
         * nums[i]为结尾的「最大子数组和」为dp[i]
         *
         */
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;

    }

    /**
     * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
     * <p>
     * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * @param nums
     * @param S
     * @return
     */
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        return subsets(nums, (sum + S) / 2);

    }


    public static int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<int[]> tmp = twoSum(nums, i + 1, -nums[i]);
            if (tmp != null && tmp.size() > 0) {
                for (int[] b : tmp) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(b[0]);
                    list.add(b[1]);
                    result.add(list);
                }
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    public static List<int[]> twoSum(int[] numbers, int start, int target) {
        int end = numbers.length - 1;
        List<int[]> list = new ArrayList<>();
        while (start < end) {
            int left = numbers[start];
            int right = numbers[end];
            int sum = left + right;
            if (sum < target) {
                while (start < end && numbers[start] == left) {
                    start++;
                }
            } else if (sum > target) {
                while (start < end && numbers[end] == right) {
                    end--;
                }
            } else {
                int[] result = new int[2];
                result[0] = numbers[start];
                result[1] = numbers[end];
                list.add(result);
                while (start < end && numbers[start] == left) {
                    left++;
                }
                while (start < end && numbers[end] == right) {
                    end--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(maxSubArray1(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
////        System.out.println(twoSum(new int[]{2, 7, 11, 15}, 9));
//        System.out.println(twoSum1(new int[]{2, 7, 11, 15}, 9));
//        System.out.println(twoSum1(new int[]{3, 2, 4}, 6));
//
//        Integer[] array = new Integer[]{1, 5, 2, 3, 7, 0, 8};
//        Arrays.sort(array, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 == o2 ? 0 : o1 - o2;
//            }
//        });
//
//        Arrays.sort(array, (o1, o2) -> o1 == o2 ? 0 : o2 - o1);
//        System.out.println(array[0]);
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        int[] aa = new int[]{-1, 0, 1, 2, -1, -4};
//        Arrays.sort(aa);
//        List<int[]> result1 = twoSum(aa, 0, 0);
//        System.out.println(result1);
        System.out.println(result);

    }


}
