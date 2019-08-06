package week3;

import java.util.Stack;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 */
public class SymmetricTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 剑指offer题   我自己的思路是递归输出 前序和对称的前序遍历
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null) return false;
        else if (right == null) return false;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    /**
     * 迭代的写法
     */
    private boolean helper2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        TreeNode l = root.left, r = root.right;
        while (!left.empty() || l != null || r != null || !right.empty()) {
            while (l != null && r != null) {
                left.push(l);
                l = l.left;
                right.push(r);
                r = r.right;
            }
            if (l != null || r != null) return false;
            l = left.peek();
            left.pop();
            r = right.peek();
            right.pop();
            if (l.val != r.val) return false;

            l = l.right;
            r = r.left;
        }
        return true;
    }
}
