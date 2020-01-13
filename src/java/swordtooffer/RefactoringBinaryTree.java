package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/11
 * Description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 思路：使用递归处理，每次将左右子树当成新的子树处理，使用for循环找到新的树在中序遍历中的位置，以便知道左右节点个数
 */

public class RefactoringBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=constructSmallBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    public TreeNode constructSmallBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn){

        if(startPre>endPre||startIn>endIn) {
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);
        for (int i=startIn;i<=endIn;i++){
            if (in[i]==pre[startPre]){
                root.left=constructSmallBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=constructSmallBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn);
                break;
            }
        }
        return root;
    }
}

