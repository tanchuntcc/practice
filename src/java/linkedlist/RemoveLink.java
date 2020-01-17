package linkedlist;

/**
 * @author 谭春
 * Date: 2020/1/14
 * Description:
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * 思路：创建head前驱节点，用来判断头部节点是否是需要删除的节点。然后循环链表，判断出需要删除后，用pre。next=cur.next删除节点。
 */
public class RemoveLink {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur=head;
        ListNode pre=sentinel;
        while (cur!=null){
            if (cur.val==val) {
                pre.next = cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return sentinel.next;
    }
}

