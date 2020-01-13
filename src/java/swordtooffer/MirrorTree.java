package swordtooffer;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2019/10/14
 * Description:操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 * 思路：1.交换左右子树，然后再递归直到递归结束
 *       2.利用栈
 */
public class MirrorTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public void Mirror(TreeNode root) {
        if (root==null){
            return;
        }
        TreeNode temp=null;
        temp=root.left;
        root.left=root.right;
        root.right=temp;
        Mirror(root.left);
        Mirror(root.right);
    }


//        public void Mirror(TreeNode root) {
//            if(root == null){
//                return;
//            }
//            Stack<TreeNode> stack = new Stack<TreeNode>();
//            stack.push(root);
//            while(!stack.isEmpty()){
//                TreeNode node = stack.pop();
//                if(node.left != null||node.right != null){
//                    TreeNode temp = node.left;
//                    node.left = node.right;
//                    node.right = temp;
//                }
//                if(node.left!=null){
//                    stack.push(node.left);
//                }
//                if(node.right!=null){
//                    stack.push(node.right);
//                }
//            }
//        }


}

