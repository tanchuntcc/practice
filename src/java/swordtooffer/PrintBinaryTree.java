package swordtooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * @author 谭春
 * Date: 2019/10/16
 * Description:从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 思路：二叉树的层序遍历  使用一个队列存当前行的节点，然后将节点取出进入循环，循环后又将下一行节点加入队列进行循环。
 */
public class PrintBinaryTree {
     class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //二叉树的层序遍历
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList();
        ArrayList<TreeNode> integers = new ArrayList<>();
        if (root==null){
            return arr;
        }
        integers.add(root);
        while (integers.size()!=0){
            TreeNode remove = integers.remove(0);
            if (remove.left!=null){
                integers.add(remove.left);
            }
            if (remove.right!=null){
                integers.add(remove.right);
            }
            final HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            arr.add(remove.val);
        }

        return arr;
    }
}

