import java.util.Stack;

public class RecoverBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉搜索树的特性，中序遍历为递增       6
     * 0 8 2 3 5 6                         8
     * pre = 0 8 2 3 5                   0  3
     * first = null null 8 8 8 8           2  5
     * second = null null 2
     * @param root
     */
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prv = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (prv != null && prv.val >= root.val) {
            if (first == null) first = prv;
            second = root;
        }
        prv = root;
        helper(root.right);
    }

    /**
     * 迭代!!!
     *
     * @param root
     */
    public void recoverTree2(TreeNode root) {
        if (root == null) return;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prv = null;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty()||cur!=null){
            if (cur !=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (prv != null && cur.val <= prv.val){
                    if (first == null) first = prv;
                    second = cur;
                }
                prv = cur;
                cur = cur.right;
            }
        }
    }
}
