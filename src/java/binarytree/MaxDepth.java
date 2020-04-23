package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 谭春
 * Date: 2020/4/3
 * Description:
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 思路：1.使用递归分别计算左右两边的层数的最大值。
 *      2.使用广度优先遍历思路，求得树高度。
 */
public class MaxDepth {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        int size=0,depth=0;
        while (!treeNodes.isEmpty()){
            size = treeNodes.size();
            while (size>0) {
                TreeNode pop = treeNodes.poll();

                if (pop.left != null) {
                    treeNodes.add(pop.left);
                }
                if (pop.right != null) {
                    treeNodes.add(pop.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }
}

