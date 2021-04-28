package middle.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午12:15 2021/1/27
 */
public class Codec {

    /**
     * 297. 二叉树的序列化与反序列化
     * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以
     * 将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * <p>
     * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑
     * ，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * <p>
     * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
     * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder ans = new StringBuilder("");
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                ans.append("N ");
                continue;
            } else {
                ans.append(cur.val).append(" ");
            }
            queue.add(cur.left);
            queue.add(cur.right);
        }
        return ans.toString().trim();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }
        String[] ss = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        int val = Integer.parseInt(ss[0]);
        TreeNode root = new TreeNode(val);
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (ss[i].equals("N")) {
                i++;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                node.left = left;
                queue.add(left);
            }
            if (ss[i].equals("N")) {
                i++;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(ss[i]));
                i++;
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }


    private int maxL = 0;

    /**
     * 687
     * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
     *
     * @param root
     * @return
     */
    public int longestUnivaluePath(TreeNode root) {
        /**
         解题思路类似于124题, 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
         1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
         2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
         需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
         **/
        if (root == null) return 0;
        getMaxL(root, root.val);
        return maxL;
    }

    private int getMaxL(TreeNode r, int val) {
        if (r == null) return 0;
        int left = getMaxL(r.left, r.val);
        int right = getMaxL(r.right, r.val);
        maxL = Math.max(maxL, left + right); // 路径长度为节点数减1所以此处不加1
        if (r.val == val) // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
            return Math.max(left, right) + 1;
        return 0;
    }



}
