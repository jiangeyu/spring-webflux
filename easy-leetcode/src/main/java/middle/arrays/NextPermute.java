package middle.arrays;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:57 2021/1/27
 */
public class NextPermute {


    /**
     *   31
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
        backtrack(candidates, target, res, 0, new ArrayList<>());
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

    /**
     * 287. 寻找重复数
     * <p>
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * <p>
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        /**
         快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         即按照寻找链表环入口的思路来做
         **/
        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
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
     * <p>
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
        Arrays.fill(result, 1);
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
     * <p>
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
     * <p>
     * 接下来说点别的，为什么第二个重复元素只能去和倒数的 上一次没有出现重复元素时，retList的长度个
     * 元素进行组合？
     * <p>
     * 原因是这样的，比如当nums[i] != num[i-1]时，此时nums[i]需要和retList中所有元素进行组合
     * 该过程完成后retList的大小会由原大小m 变化为2m。当我们继续往后走时，当前nums[i] == nums[i-1]
     * 我们直到我们当前的nums[i]只应该和之前的nums[i-1]没处理过的部分，或者之前的nums[i-1]在上一次
     * 组合中新生成的部分进行组合（否则必然造成重复），那这个新生成部分的大小是多少呢？答案是m，因为再不重复时
     * 每一次的组合结束大小都会变为原来的1倍，一半是之前的值，一半是新生成的值，而这个m就是上一次没有出现重复元素时，retList的长度。
     * <p>
     * 以此类推 当我们的nums[1,2,2,2] 当i=3时，这个时候他还是只需要和上一次retList的最后m个元素进行组合
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();
        retList.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return retList;
        Arrays.sort(nums);


        List<Integer> tmp = new ArrayList<>();
        tmp.add(nums[0]);
        retList.add(tmp);
        if (nums.length == 1) return retList;

        int lastLen = 1;

        for (int i = 1; i < nums.length; i++) {
            int size = retList.size();
            if (nums[i] != nums[i - 1]) {
                lastLen = size;
            }

            for (int j = size - lastLen; j < size; j++) {
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
        //我们遍历数组中的每一个数 x，它可能已经被打了标记，因此原本对应的数为
        // |x|，其中 ∣∣ 为绝对值符号。如果∣x∣∈[1,N]，那么我们给数组中的第 |x| - 1个位
        // 置的数添加一个负号。注意如果它已经有负号，不需要重复添加
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //在遍历完成之后，如果数组中的每一个数都是负数，那么答案是 N+1，否则
        // 答案是第一个正数的位置加 1
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            while (left < right && nums[left] % 2 != 0) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        return nums;
    }


    /**
     * 210. 课程表 II
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，
     * 我们用一个匹配来表示他们: [0,1]
     * <p>
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * <p>
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        /*
        我们先记录每个节点的入度，以及使用 map 记录每个节点所能到达的其他节点

        当某个节点的入度为 0，表示没有节点指向它，即该课程不需要先修其他课程，那么我们就可以从 该课程 出发

        然后我们将入度为 0 的节点存储进队列中，将它和它所能到达的节点 next 的通路断开，即 next 的入度 -1，
        当减为 0 的时候，表示入度为 0，那么添加进队列中
        */

        //存储某个节点能够到达的其他节点集合（这里最开始我是使用 map 的，后面发现节点是 [0, n -1] ，那么节点值可以直接作为下标
        List<Integer>[] lists = new ArrayList[numCourses];
        //记录某个节点的入度
        int[] points = new int[numCourses];
        for (int[] p : prerequisites) {
            /*
            [3, 5] 表示学习 3 之前需要先学习 5
            那么对于 3 来说， 5 指向 3，即 3 的入度 + 1
            而 5 能到达的节点集合需要增加 3 这个节点
            */
            points[p[0]]++;
            if (lists[p[1]] == null) {
                lists[p[1]] = new ArrayList<>();
            }
            lists[p[1]].add(p[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        //找到入度为 0 的节点

        for (int i = 0; i < numCourses; i++) {
            //入度为 0，添加到队列中
            if (points[i] == 0) {
                queue.add(i);
            }
        }

        //记录遍历的课程顺序
        int[] res = new int[numCourses];
        int idx = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            /*
            首先我们应该明确这么一点，在队列中的元素都是 0 入度的课程，即没有需要前修的课程就可以直接学习
            那么我们遍历到该课程，假设学习完，那么它指向的课程入度都需要 -1，当它指向的某个课程入度为 0 的时候，同时也需要将该课程添加到队列中
            */
            while (size-- > 0) {
                int p = queue.poll();
                res[idx++] = p;
                List<Integer> list = lists[p];
                if (list == null) {
                    continue;
                }
                for (int val : list) {
                    points[val]--;
                    if (points[val] == 0) {
                        queue.add(val);
                    }
                }
            }
        }
        //idx == numCourses 意味着全部课程都访问过了，即最终都能够满足 0 入度的条件，即全部能够学习完成
        return idx == numCourses ? res : new int[0];
    }

    /**
     * 71. 简化路径
     * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     * <p>
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * <p>
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * <p>
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     *
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] split = path.split("\\/");
        if (split.length == 0) {
            return "/";
        }
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : split) {
            switch (s) {
                case ".":
                case "":
                    continue;
                case "..":
                    if (linkedList.isEmpty()) {
                        continue;
                    } else {
                        linkedList.removeLast();
                    }
                    break;
                default:
                    linkedList.add(s);
                    break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!linkedList.isEmpty()) {
            stringBuilder.append("/");
            stringBuilder.append(linkedList.removeFirst());
        }
        if (stringBuilder.length() == 0) {
            stringBuilder.append("/");
        }
        return stringBuilder.toString();
    }


    /**
     * 503. 下一个更大元素 II
     * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），
     * 输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，
     * 这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = num;
            }
            if (i < n) stack.add(i);
        }
        return res;
    }

    /**
     * 比较版本号
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.abs(-1));
        System.out.println(productExceptSelf(new int[]{1, 2, 3, 4}));
    }

}
