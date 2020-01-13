package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/23
 * Description:输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 思路：1.先写递归求出树的深度，再递归求出每一步高度差 然后递归左右子树。
 */
public class IsBanlanced {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    public boolean IsBalanced_Solution(TreeNode root) {
            if (root==null){
                return true;
            }
            int left=TreeDepth(root.left);
            int right=TreeDepth(root.right);
            return Math.abs(left-right)<=1? true:false && IsBalanced_Solution(root.left) &&IsBalanced_Solution(root.right);


    }
    public int TreeDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
    }
}

