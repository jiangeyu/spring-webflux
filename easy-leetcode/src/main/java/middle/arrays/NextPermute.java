package middle.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:57 2021/1/27
 */
public class NextPermute {


    /**
     * 31
     * <p>
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int j = nums.length - 1;
        while (j - 1 >= 0 && nums[j - 1] >= nums[j]) {
            --j;
        }
        if (j == 0) {
            for (int i = 0; i < nums.length / 2; ++i) {
                swap(nums, i, nums.length - 1 - i);
            }
            return;
        }
        int r = nums.length - 1;
        while (r >= j) {
            if (nums[r] > nums[j - 1]) break;
            --r;
        }
        swap(nums, r, j - 1);
        int cnt = (nums.length - j) / 2;
        int i = 0;
        while (cnt > 0) {
            swap(nums, j + i, nums.length - 1 - i);
            ++i;
            --cnt;
        }
        return;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;

    }

    /**
     * 39
     * <p>
     * <p>
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的数字可以无限制重复被选取。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        //System.out.println(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmp_list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(tmp_list));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < 0) break;
            //System.out.println(start);
            tmp_list.add(candidates[start]);
            //System.out.println(tmp_list);
            backtrack(candidates, target - candidates[start], res, start, tmp_list);
            tmp_list.remove(tmp_list.size() - 1);
        }
    }


    /**
     * 216 组合总数
     * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(n, k, new ArrayList<>(), 0);
        return ans;
    }

    int[] ary = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    List<List<Integer>> ans = new ArrayList<>();

    void backtrack(int n, int k, List<Integer> slc, int idx) {
        if (k == 0) {
            if (n == 0)
                ans.add(new ArrayList<>(slc));
            return;
        }


        for (int i = idx; i < 9; i++) {
            if (n >= ary[i]) {
                slc.add(ary[i]);
                k--;
                n -= ary[i];
                backtrack(n, k, slc, i + 1);
                k++;
                n += ary[i];
                slc.remove(slc.size() - 1);
            }
        }

    }

    /**
     * 442. 数组中重复的数据
     * <p>
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     * <p>
     * 找到所有出现两次的元素。
     * <p>
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                ret.add(num);
            }
        }
        return ret;
    }

    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> ret = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 2 * n) ret.add(i + 1);
        }
        return ret;
    }


    /**
     * 238
     *
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int left = 1;
        int right = 1;
        int[] result = new int[length];
        Arrays.fill(result,1);
        for (int i = 0; i < length; i++) {

            result[i] *= left;
            left *= nums[i];

            result[length - 1 - i] *= right;
            right *= nums[length - 1 - i];

        }
        return result;

    }


    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

}
