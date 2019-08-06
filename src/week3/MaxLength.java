package week3;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 * <p>
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。
 * 该路径至少包含一个节点，且不一定经过根节点。
 */
public class MaxLength {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int max = 0;

    public int maxPathSum(TreeNode root) {
        getDeap(root);
        return max;
    }

    private int getDeap(TreeNode root) {
        if (root != null) {
            int leftMax = getDeap(root.left);
            int rightMax = getDeap(root.right);
            max = Math.max(max, leftMax + rightMax + root.val);
            return Math.max(0,root.val+Math.max(rightMax,leftMax));
        }
        return 0;
    }
}
