package middle.tree;

import java.util.*;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午7:59 2021/4/22
 */
public class TravelTree2 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    public void preOrder(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = root.right;
        }
    }

    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.val);
                root = node.right;
            }
        }
    }

    public void postOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (root == null) {
            return;
        }
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode head = s1.pop();
            s2.push(head);
            if (root.left != null) {
                s1.push(root.left);
            }
            if (root.right != null) {
                s1.push(root.right);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val);
        }
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int length = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < length) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
            right++;
            while (map.get(c) != null && map.get(c) > 1) {
                char c1 = s.charAt(left);
                map.put(c, map.get(c1) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public int numIslands(char[][] grid) {
        int lands = 0;
        if (grid.length <= 1) {
            return lands;
        }
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; i < n; i++) {
                if (grid[i][j] == '1') {
                    search(grid, i, j);
                    lands++;
                }
            }
        }
        return lands;
    }

    public void search(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        search(grid, i + 1, j);
        search(grid, i - 1, j);
        search(grid, i, j + 1);
        search(grid, i, j - 1);

    }
}
