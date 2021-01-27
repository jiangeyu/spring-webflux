package middle.arrays;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:57 2021/1/27
 */
public class NextPermute {


    /**
     *
     * 31
     *
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     *
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     *
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

}
