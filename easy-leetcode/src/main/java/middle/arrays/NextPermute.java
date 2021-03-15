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



    /**
     * 这个题目的解题思想是这样的。由于nums内的元素存在重复，那么我们必然需要
     * 考虑如果元素重复了，怎么去处理这个元素。最直观的想法是说比如我碰到了
     * nums[i] == nums[i-1]表示当前元素我处理过了，拿题目中的数组举例子
     * nums:[1,2,2]  i=2的时候就满足上式，那么我们可以认为这个元素已经处理过了
     * 就直接跳过吗？ 显然不能 因为如果直接跳过我们就会漏掉[2,2] 和 [1,2,2]
     * 这两个组合。那么说明我们必须找出某种方式，将部分重复的元素去除。
     *
     * 我们仔细思考一下nums[1,2,2] 当i=0的时候由于我们用于存储所有已知集合的
     * retList只含有一个[]元素，那么不存在重复问题，我们经过这一步可以得到
     * retList: [] [1] 来到2的时候我们在看 由于也不存在重复我们的2可以和
     * 之前的retlist中的元素全组合一遍得到retList:[] [1] [2] [1,2]
     * 等i=2来到这个重复的2的时候，我们发现他和前面的元素重复了，那么如果我们
     * 先不考虑重复的问题重复会得到[] [1] [2] [1,2] [2] [1,2] [2,2] [1,2,2]
     * 我们发现[2] [1,2]这部分是重复的部分是需要被踢出的部分 那么我们的目标现在
     * 就转变成了如何鉴别出引起重复的这一部分，然后在组合的时候跳过他们。我们回忆一下
     * 重复的这个[2] [1,2]来源于 2 这个元素和 [] [1] 组合导致的，因为在这个重复的
     * 2之前，已经有一个2和[] [1]发生过组合，所以这里再去组合 必然发生重复现象。
     * 那实际上这个第二次出现的2，只应该和[2] [1,2]发生组合。在这个例子中[2] [1,2]
     * 是两个组合，很容易看出来，但是我们需要一个值，来表示说出现重复时我到底该匹配的值
     * 有多少个？ 这个值就是上一次没有出现重复元素时，retList的长度。这么说太抽象了
     * 我们举个例子 假设我们来到了[] [1] 现在2要和他们进行组合 此时2和1不相同，那么
     * 他应该和整个retList进行组合 需要进行组合的元素数为2.那么当 来到第二个2时，此时
     * retList中有四个元素[] [1] [2] [1,2] 按照刚才我们说的他只可以组合两个元素，
     * 否则必然引起重复，而且是从后往前数两个元素（这个方向是因为，新的组合总是添加在数组的
     * 尾巴上），如果照我们说的 他只应该和[2],[1,2]发生组合最后的出[] [1] [2] [1,2] [2,2] [1,2,2].
     *
     * 接下来说点别的，为什么第二个重复元素只能去和倒数的 上一次没有出现重复元素时，retList的长度个
     * 元素进行组合？
     *
     * 原因是这样的，比如当nums[i] != num[i-1]时，此时nums[i]需要和retList中所有元素进行组合
     * 该过程完成后retList的大小会由原大小m 变化为2m。当我们继续往后走时，当前nums[i] == nums[i-1]
     * 我们直到我们当前的nums[i]只应该和之前的nums[i-1]没处理过的部分，或者之前的nums[i-1]在上一次
     * 组合中新生成的部分进行组合（否则必然造成重复），那这个新生成部分的大小是多少呢？答案是m，因为再不重复时
     * 每一次的组合结束大小都会变为原来的1倍，一半是之前的值，一半是新生成的值，而这个m就是上一次没有出现重复元素时，retList的长度。
     *
     * 以此类推 当我们的nums[1,2,2,2] 当i=3时，这个时候他还是只需要和上一次retList的最后m个元素进行组合
     *
     *
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<>());
        if(nums == null || nums.length == 0) return retList;
        Arrays.sort(nums);


        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        retList.add(tmp);
        if(nums.length == 1) return retList;

        int lastLen = 1;

        for(int i = 1; i < nums.length; i++){
            int size = retList.size();
            if(nums[i] != nums[i-1]){
                lastLen = size;
            }

            for(int j = size - lastLen; j < size; j++){
                List<Integer> inner = new ArrayList(retList.get(j));
                inner.add(nums[i]);
                retList.add(inner);
            }
        }
        return retList;

    }

    /**
     * 41. 缺失的第一个正数
     *
     * @param nums
     * @return
     */
    //对于一个长度为 N 的数组，其中没有出现的最小正整数只能在[1,N+1] 中
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        //将数组中所有小于等于 0 的数修改为 N+1；
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        //我们遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为 |x|，其中 ∣∣ 为绝对值符号。如果∣x∣∈[1,N]，那么我们给数组中的第 |x| - 1个位置的数添加一个负号。注意如果它已经有负号，不需要重复添加
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则答案是第一个正数的位置加 1
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

}
