package middle.tree;

import middle.dfs.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

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
}
