package test;



import java.util.*;

/**
 * @author 谭春
 * Date: 2020/3/23
 * Description:
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]

 */

public class testa {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        //此题必须用队列,因为用栈时，会一边出栈一边入栈，不能保证上一层元素和下一层元素的顺序。
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        //queue用于放入一层的节点
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            //这一层中有多少个数
            count = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            while (count > 0) {
                //将queue上一层中的数依次遍历加入list，并把当前的数的左右节点加入queue
                TreeNode pop = queue.poll();
                integers.add(pop.val);
                if (pop.left != null) {
                    queue.add(pop.left);
                }
                if (pop.right != null) {
                    queue.add(pop.right);
                }
                //count数记录上一层剩余的数
                count--;
            }
            lists.add(integers);
        }
        return lists;
    }
}

