package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/16
 * Description:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 思路：递归判断，当数组左边的数都比根节点小，直到有一个数比根节点大时，再判断这个数右边是否都比根节点大不是则返回false。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
//             1  3  2  5  6

        if (sequence.length==0){
            return false;
        }
        if (sequence.length==1){
            return true;
        }
        return  judge(sequence,0,sequence.length-1);

    }
    public boolean judge(int [] sequence,int start,int end){
        if (start>=end){
            return true;
        }

        int root = sequence[end];
//        int index=0;
        //index为递归的start
        int index=start;
        while (sequence[index]<root){
            index++;
        }
        for (int i = index; i <end ; i++) {
            if (sequence[i]<root){
                return false;
            }
        }
        return judge(sequence,start,index-1) && judge(sequence,index,end-1);
    }

    public static void main(String[] args) {
        int[] a={4,8,6,12,16,14,10};
        final VerifySquenceOfBST verifySquenceOfBST = new VerifySquenceOfBST();
        final boolean judge = verifySquenceOfBST.judge(a, 0, a.length - 1);
        System.out.println(judge);
    }
}

