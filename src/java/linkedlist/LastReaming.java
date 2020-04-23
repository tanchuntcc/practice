package linkedlist;

import java.util.ArrayList;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 * 思路1.开始用环形链表做，果断超时。使用list模拟环形链表，把数字放入list中，当值超过最右边时候，通过%当前list长度，达到闭环的作用。
 */
public class LastReaming {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> integers = new ArrayList<>();
        int index = 0;
        //使用list模拟环形链表
        for (int i = 0; i < n; i++) {
            integers.add(i);
        }

        while (n > 1) {
            //需要删除的数的索引，索引从自身开始计算，所以m-1。
            index = (index + m - 1) % n;
            n--;
            integers.remove(index);
        }
        return integers.get(0);
    }

//    public int lastRemaining(int n, int m) {
//        int result = 0;
//        for (int i = 2; i <= n; ++i) {
//            result = (result + m) % i;
//        }
//        return result;
//    }
//}


}

