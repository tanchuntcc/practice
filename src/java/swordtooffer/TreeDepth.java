package swordtooffer;

import java.util.*;

/**
 * @author 谭春
 * Date: 2019/10/22
 * Description:输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成
 * 树的一条路径，最长路径的长度为树的深度。
 * 思路：1.递归求出树的深度。
 *       2.将节点加入到队列中，然后使用lastCount存储上一层的节点个数，使用count存储当前节点数，当lashCount=count时，表示
 *       当前层遍历结束，深度加1，将当层的个数queue.size()赋值给lashCount，再将count归0重新循环。
 */
public class TreeDepth {
     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
//     递归
//    public int TreeDepth(TreeNode root) {
//         if (root==null){
//             return 0;
//         }
//        return Math.max(TreeDepth(root.left),TreeDepth(root.right))+1;
//    }
    public int TreeDepth(TreeNode root) {
         if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int count=0,lastCount=1,length=0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            count++;
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
            if (count==lastCount){
                lastCount=queue.size();
                count=0;
                length++;
            }

        }
        return length;
}
}

