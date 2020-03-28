package linkedlist;

import java.util.List;

/**
 * @author 谭春
 * Date: 2020/1/13
 * Description:
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * 思路：先创建一个节点作为链表头，再创建一个节点用来操作后面的链表。一次判断l1和l2的节点大小，当其中一个为空时，将另一个链表
 * 连接到尾部把即可。（注意：必须创建cur来操作链表，不然空指针异常）
 *
 */
public class MergeLink {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode listNode = null;
        ListNode cur = null;
        //将l1和l2依次遍历，按照大小加入到cur节点后面
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                if (listNode == null) {
                    listNode = cur = l1;
                } else {
                    cur.next = l1;
                    cur = cur.next;
                }
                l1 = l1.next;
            } else {
                if (listNode == null) {
                    listNode = cur = l2;
                } else {
                    cur.next = l2;
                    cur = cur.next;
                }
                l2 = l2.next;
            }
        }
        //如果l1为空，将剩余的l2加入到cur节点后面
        if (l1 == null) {
            cur.next = l2;
        }
        //如果l2为空，将剩余的l2加入到cur节点后面
        if (l2 == null) {
            cur.next = l1;
        }
        return listNode;
    }
}

