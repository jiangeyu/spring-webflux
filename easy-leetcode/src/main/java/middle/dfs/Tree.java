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
     * 104. 二叉树的最大深度
     *
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
     * 104. 二叉树的最大深度
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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


    /**
     * 226. 翻转二叉树
     *
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        // 前序遍历反转即可
        preorder(root);
        return root;
    }

    public void preorder(TreeNode node) {
        if(node==null){
            return;
        }
        TreeNode left = node.left;
        node.left = node.right;
        node.right = left;
        preorder(node.left);
        preorder(node.right);
    }


    /**
     * 108. 将有序数组转换为二叉搜索树
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return nums == null ? null : buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);
        return root;
    }


    List<String> ans = new ArrayList<>();

    /**
     * 257. 二叉树的所有路径
     *
     *
     * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return ans;
        }
        dfs(root, "");
        return ans;
    }

    public void dfs(TreeNode root, String s){
        s += root.val;  //拼接上新的节点值
        if(root.left == null && root.right == null){
            ans.add(s);
        }
        if(root.left != null){
            dfs(root.left, s + "->");
        }
        if(root.right != null){
            dfs(root.right, s + "->");
        }
    }

    /**
     *
     * 112. 路径总和
     *
     * 定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val)
                || hasPathSum(root.right, targetSum - root.val);
    }


    /**
     * 101. 对称二叉树
     *
     * 给定一个二叉树，检查它是否是镜像对称的。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmertric(root.left, root.right);
    }

    private boolean isSymmertric(TreeNode t1,TreeNode t2) {
        if(t1 == null && t2 == null) return true;
        if(t1 == null || t2 == null) return false;
        if(t1.val != t2.val) return false;
        return isSymmertric(t1.left, t2.right) && isSymmertric(t1.right, t2.left);
    }
}
