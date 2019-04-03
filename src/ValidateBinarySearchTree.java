public class ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断是不是二叉搜索树
     * <p>
     * 提示深度优先搜
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, null, null);
    }

    private boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;
        if (max != null && root.val >= max){
            return false;
        }
        if (min != null && root.val <= min){
            return false;
        }
        return helper(root.right,root.val,max)&&helper(root.left,min,root.val);

    }
}
