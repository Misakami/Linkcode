
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTravrsal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 树的简单遍历
     *
     * 中序遍历！！！！！
     *
     * @param root
     * @return
     */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            helper(res, root);
            return res;
        }

        private void helper(List<Integer> res, TreeNode target) {
            if (target.left!=null)
                helper(res,target.left);
            res.add(target.val);
            if (target.right!=null)
                helper(res,target.right);
        }

    /**
     * 中序遍历
     * 迭代算法              1
     * 使用栈 ——>        2   3       ->  1 2 4  4出栈 2出栈 5入栈
     * @param root       4 5    6
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            while (cur!= null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /**
     * 前序遍历！！迭代。。。。。。。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null || !stack.isEmpty()){
            while (cur!=null){
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return list;
    }

    /**
     * 后序遍历   迭代！！！！！！！
     *
     * @param root
     * @return
     */


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null) stack.push(node.left);//和传统先序遍历不一样，先将左结点入栈
            if(node.right != null) stack.push(node.right);//后将右结点入栈
            res.add(0,node.val);                        //逆序添加结点值
        }
        return res;
    }
}
