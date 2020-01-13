package swordtooffer;

import java.util.HashMap;

/**
 * @author 谭春
 * Date: 2019/10/22
 * Description:输入两个链表，找出它们的第一个公共结点。
 * 思路：1.将第一个链表节点加入hashMap，再遍历第二个节点，第一次hashmap包含节点时，即为公共节点。
 *       2.有公共节点证明他们公共节点以后的节点都相同，先让长链表走两个链表长度只差，再一次走，走到第一个相同的节点即
 * 为公共节点
 */
public class FindFirstCommonNode {
        class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;
        ListNode current2 = pHead2;


        HashMap<ListNode, Integer> hashMap = new HashMap<ListNode, Integer>();
        while (current1 != null) {
            hashMap.put(current1, null);
            current1 = current1.next;
        }
        while (current2 != null) {
            if (hashMap.containsKey(current2))
                return current2;
            current2 = current2.next;
        }

        return null;

    }




//方法2：

    public ListNode FindFirstCommonNodeII(ListNode pHead1, ListNode pHead2) {
        ListNode current1 = pHead1;// 链表1
        ListNode current2 = pHead2;// 链表2
        if (pHead1 == null || pHead2 == null)
            return null;
        int length1 = getLength(current1);
        int length2 = getLength(current2);
        // 两连表的长度差

        // 如果链表1的长度大于链表2的长度
        if (length1 >= length2) {
            int len = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current1 = current1.next;
                len--;
            }

        }
        // 如果链表2的长度大于链表1的长度
        else if (length1 < length2) {
            int len = length2 - length1;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (len > 0) {
                current2 = current2.next;
                len--;
            }

        }
        //开始齐头并进，直到找到第一个公共结点
        while(current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        return current1;

    }

    // 求指定链表的长度
    public static int getLength(ListNode pHead) {
        int length = 0;

        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

