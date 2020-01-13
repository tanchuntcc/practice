package swordtooffer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 谭春
 * Date: 2019/10/16
 * Description:输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到 ***叶结点***所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 * 思路：当先序遍历递归二叉树，递归一个元素就将target减去该元素。当递归到底没找到时就回退掉最后一元素
 *
 *                            1
 *                    （/）   |    （\）
 *                   2        |        3
 *                          return;
 */

public class FindPathInBinaryTree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> integers = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root==null){
            return arrayLists;
        }
        int val = root.val;
        target-=val;
        integers.add(val);
        if (target==0  && root.left==null && root.right==null){
            arrayLists.add(new ArrayList<>(integers));
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        integers.remove(integers.size()-1);
        return arrayLists;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
         FindPathInBinaryTree findPathInBinaryTree = new FindPathInBinaryTree();
        ArrayList<ArrayList<Integer>> arrayLists = findPathInBinaryTree.FindPath(treeNode, 3);
        System.out.println(arrayLists);
    }

}

