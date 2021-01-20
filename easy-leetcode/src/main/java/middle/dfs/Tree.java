package middle.dfs;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午12:35 2021/1/14
 */
public class Tree {


    /**
     * 111. 二叉树的最小深度
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }


    /**
     *给定一个二叉树，找出其最大深度。
     *
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int minDepth = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            minDepth++;
        }
        return minDepth;
    }


    /**
     * 662
     * <p>
     * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
     * <p>
     * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int maxW = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        queue.add(root);
        indexList.add(1);
        int size = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            size--;
            int index = indexList.removeFirst();
            if (node.left != null) {
                queue.add(node.left);
                indexList.add(2 * index);
            }
            if (node.right != null) {
                queue.add(node.right);
                indexList.add(2 * index + 1);
            }
            if (size == 0) {
                if (indexList.size() >= 2) {
                    maxW = Math.max(maxW, indexList.getLast() - indexList.getFirst() + 1);
                }
                size = queue.size();
            }
        }

        return maxW;

    }

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

    private List<TreeNode> buildTrees(int start, int end){
        List<TreeNode> result = new ArrayList<>();
        if (start==end){
            result.add(new TreeNode(start));
            return result;
        }
        else if (start>end){
            result.add(null);
            return result;
        }
        else {
            for (int i=start;i<=end;i++){
                List<TreeNode> left = buildTrees(start,i-1);
                List<TreeNode> right = buildTrees(i+1, end);
                for (TreeNode l:left){
                    for (TreeNode r:right){
                        result.add(new TreeNode(i, l, r));
                    }
                }
            }
            return result;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n==0)
            return new ArrayList<>();
        return buildTrees(1,n);
    }
}
