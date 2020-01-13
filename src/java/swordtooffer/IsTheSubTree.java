package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/14
 * Description:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 思路：第一步先找到子树的根节点在父树的位置，再分别比较左边和右边是否相等
 */
public class IsTheSubTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean flag=false;
        if (root1!=null&&root2!=null) {
            if (root1.val == root2.val) {
                //如果是跟子树有些相似时  falg为false ，再进行递归
               flag= doesTree1HaveTree2(root1, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.left, root2);
            }
            if (!flag) {
                flag = HasSubtree(root1.right, root2);
            }
        }
            return flag;
        }
        //根据两个根节点，比较数树是否相同
    public boolean doesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 != null) {
            return false;
        }
        if(root2 == null) {
            return true;
        }
        if(root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree2(root1.left,root2.left) && doesTree1HaveTree2(root1.right,root2.right);
    }
}

