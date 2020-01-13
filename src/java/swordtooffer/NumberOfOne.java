package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/12
 * Description:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 思路：1.1的二进制为 前面都是0，最后一位为1，也就是只有一个1，每次向左移位一下，
 * 使得flag的二进制表示中始终只有一个位为1，每次与n做位与操作，这样就相当于逐个检测n的每一位是否是1了。
 *       2.使用n = (n - 1) & n 将二进制中的最右边的那个1相与变成0。
 */
public class NumberOfOne {
    //1.使用1去相与，每次将1的二进制中的1的位置往左移动
//    public int NumberOf1(int n) {
//        int flag=1;
//        int count=0;
//        while (flag!=0){
//            if ((flag & n)==1){
//                count++;
//            }
//            flag=flag<<1;
//        }
//        return count;
//    }
//2.用n和n-1相与，去除末位的1。
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }
    //3.硬核解法  Interger的方法,统计n中最大数字的个数
//    public static int NumberOf1(int n) {
//        return Integer.bitCount(n);
//    }

    public static void main(String[] args) {
        //使用n=10,二进制形式为1010，则1的个数为2；
        int n = 10;
        System.out.println(n + "的二进制中1的个数：" + NumberOf1(n));
    }
}

