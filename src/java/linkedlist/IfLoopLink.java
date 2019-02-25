package linkedlist;

/**
 * Created by TanChun on 2019/2/13.
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 假设单链表的总长度为L，头结点到环入口的距离为a，环入口到快慢指针相遇的结点距离为x，环的长度为r，慢指针总共走了s步，
 * 则快指针走了2s步。另外，快指针要追上慢指针的话快指针至少要在环里面转了一圈多(假设转了n圈加x的距离)，得到以下关系：
 * s = a + x
 * 2s = a + nr + x
 * =>a + x = nr
 * =>a = nr - x
 * 由上式可知：若在头结点和相遇结点分别设一指针，同步(单步)前进，则最后一定相遇在环入口结点。
 */
public class IfLoopLink {
        public ListNode detectCycle(ListNode head) {
            if(head==null){
                return null;
            }
            ListNode slow=head;
            ListNode fast=head;
            while(fast.next!=null&&fast.next.next!=null){
                slow=slow.next;
                fast=fast.next.next;
                if(slow==fast){
                    ListNode temp=head;
                    while(slow!=null){
                        if(slow==temp){
                            return slow;
                        }
                        slow=slow.next;
                        temp=temp.next;
                    }
                }
            }
            return null;
        }
}
