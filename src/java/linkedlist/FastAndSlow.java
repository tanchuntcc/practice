package linkedlist;

/**
 * Created by TanChun on 2019/2/13.
 * 使用快慢指针找节点
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
