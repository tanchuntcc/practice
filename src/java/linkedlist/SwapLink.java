package linkedlist;

/**
 * @author 谭春
 * Date: 2020/1/14
 * Description:
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 思路：先创建一个哨兵节点pre,创建一个temp用于操作pre指向的整条链表，保存要交换的两个节点为start和end,
 * 将temp指向end，将start.next指向end.next，将end.next指向start。完成反转两个节点，然后将start赋给temp进
 * 行下两个节点的交换
 */
public class SwapLink {
    public ListNode swapPairs(ListNode head) {
            ListNode pre = new ListNode(0);
            pre.next = head;
            ListNode temp = pre;
            while(temp.next != null && temp.next.next != null) {
                ListNode start = temp.next;
                ListNode end = temp.next.next;
                temp.next = end;
                start.next = end.next;
                end.next = start;
                temp = start;
            }
            return pre.next;
        }
}

