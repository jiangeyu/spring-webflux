package middle.dynamic;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午11:03 2020/12/19
 */
public class SubArray {


    /**
     * 最大子序和 53
     *
     * @param nums
     * @return
     */

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

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            List<List<Integer>> tmp = threeSum(nums, i + 1, target - nums[i]);
            if (tmp != null && tmp.size() > 0) {
                for (List<Integer> subList : tmp) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(subList.get(0));
                    list.add(subList.get(1));
                    list.add(subList.get(2));
                    result.add(list);
                }
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;

    }

    public static List<List<Integer>> threeSum(int[] nums, int start, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = start; i < n; i++) {
            List<int[]> tmp = twoSum(nums, i + 1, target - nums[i]);
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

    /**
     * 209
     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的
     * 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                sum -= nums[i++];
            }
        }
        return len;
    }

    /**
     * 152. 乘积最大子数组
     * <p>
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字）
     * ，并返回该子数组所对应的乘积。
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            } //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }


    /**
     * 75 颜色分类
     * <p>
     * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 计数排序
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int[] temp = new int[3];
        for (int num : nums) {
            temp[num]++;
        }

        int index = 0;
        for (int i = 0; i < temp.length; i++) {
            int count = temp[i];
            for (int j = 0; j < count; j++) {
                nums[index] = i;
                index++;
            }
        }
    }

    /**
     * 9. 回文数
     * 回文数判断
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    /**
     * 229. 求众数 II
     * <p>
     * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
     * <p>
     * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
     *
     * @param nums
     * @return
     */
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length / 3;
        // 开始构建一个哈希表
        for (int num : nums) {
            map.compute(num, (k, v) -> map.get(k) != null ? map.get(k) + 1 : 1);
        }
        // 对哈希表进行遍历，求出值大于n/3的值
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len) {
                res.add(entry.getKey());
            }
        }
        return res;

    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = 0;
        int count = 1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
            if (count == k) {
                result = nums[i - 1];
                break;
            }
        }
        return result;
    }

    /**
     * 680. 验证回文字符串 Ⅱ
     * <p>
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isValid(s, i + 1, j) || isValid(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
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
        List<List<Integer>> result1 = fourSum(new int[]{-1, 0, 1, 2, -1, -4}, 2);
//        int[] aa = new int[]{-1, 0, 1, 2, -1, -4};
//        Arrays.sort(aa);
//        List<int[]> result1 = twoSum(aa, 0, 0);
        System.out.println(result1);
        System.out.println(result);
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(findKthLargest(new int[]{-1, 0, 1, 2, -1, -4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        Map<String, Object> staticResMap = new HashMap<>();
//        System.out.println(Optional.ofNullable(staticResMap.get("videoUrl").toString()).orElse(null));
        System.out.println(Optional.ofNullable(staticResMap.get("videoUrl")).map(o -> o.toString()).orElse(null));

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        System.out.println(list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList()));
        System.out.println(list.remove(list.get(1)));
    }


}
