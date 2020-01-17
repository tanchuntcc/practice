package linkedlist;

import java.util.List;

/**
 * @author 谭春
 * Date: 2020/1/13
 * Description:给你一个单链表的引用结点 head。链表中每个结点的值不是 0 就是 1。已知此链表是一个整数数字的二进制表示形式。

 * 请你返回该链表所表示数字的 十进制值 。
 *
 * 输入：head = [1,0,1]
 * 输出：5
 * 解释：二进制数 (101) 转化为十进制数 (5)
 *
 * 思路：先遍历链表算出链表的长度，从而得到从第一位开始是2的几次方，再遍历一遍计算值。
 */
public class LinkedToInteger {
    public int getDecimalValue(ListNode head) {
        ListNode node=head;
        ListNode node1=head;
        int index=0,sum=0;
        while (node!=null){
            index++;
            node=node.next;
        }

        while (node1!=null){
            sum+=node1.val*Math.pow(2,index);
            index--;
            node1=node1.next;
        }

        return sum;
    }

    //直接解法，多一个位前面的数就乘上2.
    public int getDecimalValue2(ListNode head) {
        int sum = 0;
        while(head!=null){
            sum = sum*2 + head.val;
            head = head.next;
        }
        return sum;
    }

}

