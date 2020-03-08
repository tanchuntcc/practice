package binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author 谭春
 * Date: 2020/1/17
 * Description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 思路：按照中序遍历的顺序遍历并比较每两两之间的元素，如果不是排序好的则返回false
 */

public class ValidateBinarySerachTree {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

//    public boolean helper(TreeNode node, Integer lower, Integer upper) {
//        if (node == null) return true;
//
//        int val = node.val;
//        if (lower != null && val <= lower) return false;
//        if (upper != null && val >= upper) return false;
//
//        if (! helper(node.right, val, upper)) return false;
//        if (! helper(node.left, lower, val)) return false;
//        return true;
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        return helper(root, null, null);
//    }

}

