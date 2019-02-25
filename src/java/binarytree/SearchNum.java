package binarytree;

/**
 * Created by TanChun on 2018/12/18.
 * 给定二叉搜索树的根节点和一个值，让你找到BST中节点值等于给定节点值得节点，
 * 返回以该节点为根的子树（其特点是：每个节点的值大于其任意左侧子节点的值，
 * 小于其任意右节点的值。常用三个操作是查找插入删除）
 */
public class SearchNum {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) { // 在左子树中查找
            return searchBST(root.left, val);
        } else { // 在右子树中查找
            return searchBST(root.right, val);
        }
    }
    }

