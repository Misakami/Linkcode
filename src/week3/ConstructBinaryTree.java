package week3;

import java.util.HashMap;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 还是剑指offer上的题 中序遍历和前序遍历能确定当前根节点内的左子树和右子树的范围
     */

    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i],i);
        }
        return dfs(preorder,inorder,0,n-1,0,n-1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr) return null;
        int val = preorder[pl];
        int k = map.get(val);
        int len = k - il;
        TreeNode root = new TreeNode(val);
        root.left = dfs(preorder,inorder,pl+1,pl+len,il,k-1);
        root.right = dfs(preorder,inorder,pl+len+1,pr,k+1,ir);
        return root;
    }
}
