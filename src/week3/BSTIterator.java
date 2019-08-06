package week3;

import java.util.Stack;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 *
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 *
 * 就是一个中序遍历二叉树的过程 因为能保证每一次遍历的值一定是最小值
 */
public class BSTIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    Stack<TreeNode> stack = new Stack();
    public BSTIterator(TreeNode root) {
        while (root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pop();
        int res = p.val;
        p = p.right;
        while (p!=null){
            stack.push(p);
            p = p.left;
        }
        return res;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}
