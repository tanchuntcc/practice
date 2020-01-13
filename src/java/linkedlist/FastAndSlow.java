package linkedlist;

/**
 * Created by TanChun on 2019/2/13.
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点
 *
 *  思路：快慢节点同时跑，当快指针跑完时，慢指针就在中间，且判断条件为fast != null && fast.next != null
 *      如果是偶数个节点，则快指针走完时，满指针肯定在第二个中间节点。
 */
public class FastAndSlow {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }
}
