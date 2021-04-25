package middle.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 上午9:30 2021/4/10
 */
public class TravelTree {

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


    /**
     * 中序遍历
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        // 非递归中序遍历
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            if (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            } else {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }

    }

    /**
     * 后续遍历
     *
     * @param root
     */
    public void postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.peek();
            if (node.right == null || node.right == lastVisit) {
                System.out.println(node.val);
                stack.pop();
                lastVisit = node;
                node = null;
            } else {
                node = node.right;
            }
        }
    }


    /**
     * 后续遍历
     *
     * @param root
     */
    public void postOrder1(TreeNode root) {
        System.out.println("");
        if (root != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                TreeNode head = s1.pop();
                s2.push(head);
                if (head.left != null) {
                    s1.push(head.left);
                }
                if (head.right != null) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().val);
            }
        }
        System.out.println("");

    }


}
