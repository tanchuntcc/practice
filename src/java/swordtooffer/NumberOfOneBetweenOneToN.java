package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/21
 * Description:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字
 * 有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的
 * 求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * 思路：遍历1到n,将每一个数取余并与1想与
 */
public class NumberOfOneBetweenOneToN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        int res=-1;
        int j=0;
        for (int i = 1; i <= n; i++) {
            j=i;
            while (j%10!=0 ||j>=10){
                res=j%10;
                count=res==1?++count:count;
                j=j/10;
            }

        }
    return count;
    }

    public static void main(String[] args) {
        final NumberOfOneBetweenOneToN numberOfOneBetweenOneToN = new NumberOfOneBetweenOneToN();
        System.out.println(numberOfOneBetweenOneToN.NumberOf1Between1AndN_Solution(10000));
    }
}

