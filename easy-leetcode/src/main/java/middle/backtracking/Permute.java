package middle.backtracking;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午9:11 2020/11/28
 */
public class Permute {
    /**
     * 回溯法算法
     * <p>
     * result = []
     * def backtrack (路径，选择列表)
     * if 满足条件
     * result.add(路径)
     * return
     * <p>
     * for 选择 in 选择列表
     * 做选择
     * backtrack (路径，选择列表)
     * 撤销选择
     */

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * <p>
     * leetcode 47
     *
     * 组合总和 39
     *
     * @param num
     * @return
     */
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(path, num, result);
        return result;
    }

    public static void backtrack(LinkedList<Integer> path, int[] num, List<List<Integer>> result) {
        if (path.size() == num.length) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int select : num) {
            if (path.contains(select)) {
                continue;
            }
            path.add(select);
            backtrack(path, num, result);
            path.removeLast();
        }
    }


    /**
     * leetcode  46 全排列
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * 其实这个全排列算法就是固定一个数的位置(left)，然后从下一位数再开始全排列(递归过程)...直到最后一位数，
     * 模拟手动全排列的过程。所以如果要去重的话，只要控制每次排列时，固定的那个数是不一样的就行了。因为固定的数不一样，
     * 那从这个数开始产生的全排列就不一样。所以只要让每次的left位置的数不一样就行，所以先sort，保证只有相邻的数是可能一样的，
     * 然后if (i != left && nums[left] == nums[i]) continue;使得每次固定的数(即left)都不一样，就行了。希望能解答你的疑问
     *
     * @param num
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] num) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(num);
        int left = 0;
        int right = num.length;
        backtrack(result, num, left, right);
        return new ArrayList<>(result);
    }

    public static void backtrack(Set<List<Integer>> result, int[] num, int left, int right) {
        if (left == right) {
            List<Integer> list = new ArrayList<>();
            for (int n : num) {
                list.add(n);
            }
            result.add(list);
            return;
        }
        for (int i = left; i < right; i++) {
            if (i != left && num[left] == num[i]) {
                continue;
            }
            swap(num, left, i);
            backtrack(result, num, left + 1, right);
            swap(num, left, i);
        }
    }

    public static void swap(int[] num, int i, int j) {
        int tmp = num[j];
        num[j] = num[i];
        num[i] = tmp;
    }


    /**
     * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     *
     * 子集 78
     *
     * <p>
     * 说明：解集不能包含重复的子集。
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     * [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack(result, path, 0, nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, LinkedList<Integer> path, int start, int[] nums) {
        result.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(result, path, i + 1, nums);
            path.removeLast();
        }
    }

    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = res.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newtemp = new ArrayList<>(res.get(j));
                newtemp.add(nums[i]);
                res.add(newtemp);
            }
        }
        return res;
    }


    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * 输入: n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     *
     * @param n
     * @param k
     * @return
     */
    public static List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtrack2(result, path, k,0, nums);
        return result;
    }
    public static void backtrack2(List<List<Integer>> result, LinkedList<Integer> path, int k, int start,int[] nums) {

        if(path.size() == k) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack2(result, path, k,i + 1, nums);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
//        System.out.println(permuteUnique(new int[]{1, 2, 3}));
//        System.out.println(permuteUnique(new int[]{1, 1, 2, 3}));
//        System.out.println(permuteUnique(new int[]{1, -1, 1, 2, -1, 2, 2, -1}));
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets2(new int[]{1, 2, 3}));
        System.out.println(combine(3, 2));


    }

}
