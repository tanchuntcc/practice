package linkedlist;

/**
 * Created by TanChun on 2019/2/13.
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 *
 * 思路：将下一个节点的值赋给当前节点，然后将当前节点的next指向下下一个节点，就做到了将要删除节点的值覆盖并删除掉。
 */
public class DeleteLink {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
