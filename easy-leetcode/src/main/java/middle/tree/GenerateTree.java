package middle.tree;

import middle.dfs.TreeNode;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:47 2021/1/26
 */
public class GenerateTree {


    /**
     * 96
     * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        // dp[i] 表示i个节点能组成的二叉搜索树的数量
        // 那么我们可以通过枚举根节点把原二叉搜索树分解为左子树 根 右子树 三部分，那么问题就变成了规模更小的子问题。
        // 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，
        // 同理当2为根节点时，其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];

    }


    /**
     * 95. 不同的二叉搜索树 II
     * <p>
     * <p>
     * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new LinkedList<>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> subLeftTree = generateTrees(start, i - 1);
            List<TreeNode> subRightTree = generateTrees(i + 1, end);
            for (TreeNode left : subLeftTree) {
                for (TreeNode right : subRightTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    res.add(node);
                }
            }
        }
        return res;
    }


    /**
     * 105. 从前序与中序遍历序列构造二叉树
     * <p>
     * <p>
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 例如，给出
     * <p>
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        for (int x : preorder) {
            queue.offer(x);
        }
        int size = map.size();
        return help(0, size - 1, map, queue);
    }

    public TreeNode help(int start, int end, HashMap<Integer, Integer> map, LinkedList queue) {
        if (queue.isEmpty() || end < start)
            return null;
        int v = (int) queue.poll();
        int index = map.get(v);
        TreeNode res = new TreeNode(v);
        res.left = help(start, index - 1, map, queue);
        res.right = help(index + 1, end, map, queue);
        return res;
    }

    /**
     * 114. 二叉树展开为链表
     * <p>
     * 给定一个二叉树，原地将它展开为一个单链表。
     *
     * @param root
     */
    public void flatten(TreeNode root) {

        if (root == null) return;
        flatten(root.left);
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            root.right = left;
            while (left.right != null) left = left.right;
            left.right = right;
            root.left = null;
        }
        flatten(root.right);

    }

    /**
     * 199
     * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
     *
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode treeNode = queue.poll();
                if (size == 0) {
                    list.add(treeNode.val);
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

            }
        }
        return list;
    }

    /**
     * 655. 输出二叉树
     * <p>
     * <p>
     * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
     * <p>
     * 行数 m 应当等于给定二叉树的高度。
     * 列数 n 应当总是奇数。
     * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
     * 每个未使用的空间应包含一个空的字符串""。
     * 使用相同的规则输出子树。
     *
     * @param root
     * @return
     */
    public List<List<String>> printTree(TreeNode root) {
        int level = getLevel(root);
        int cul = (int) Math.pow(2, level) - 1;
        List<List<String>> res = new ArrayList<>(level);
        for (int i = 0; i < level; i++) {
            List<String> list = new ArrayList<>(cul);
            res.add(list);
            for (int j = 0; j < cul; j++) {
                list.add("");
            }
        }
        dfs(root, 0, cul - 1, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int left, int right, int level, List<List<String>> res) {
        if (root == null) return;
        int mid = (left + right) / 2;
        res.get(level).set(mid, Integer.toString(root.val));
        dfs(root.left, left, mid - 1, level + 1, res);
        dfs(root.right, mid + 1, right, level + 1, res);
    }

    private int getLevel(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getLevel(root.left), getLevel(root.right)) + 1;
    }

    double last = -Double.MAX_VALUE;

    /**
     * 98. 验证二叉搜索树
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }


    static int sum;

    /**
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        sum = 0;
        childSum(0, root);
        return sum;
    }
    public static void  childSum(int val, TreeNode root) {
        if(root == null) return;
        int k = (val * 10 + root.val) ;
        if(root.left == null && root.right == null) {
            sum += k;
        }
        childSum(k, root.left);
        childSum(k, root.right);
    }


    /**
     * 二叉树前序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private void pre(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
    }


}
