package linkedlist;

import java.util.List;

/**
 * @author 谭春
 * Date: 2019/9/5
 * Description:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 */
public class AddTwoLink {
    public ListNode addTwo(ListNode head1,ListNode head2){
        ListNode listNode=new ListNode(0);
        ListNode temp1=head1;
        ListNode temp2=head2;
        ListNode cur=listNode;
        while (temp1.next!=null && temp2.next!=null){
            if (temp1.next.val>temp2.next.val){
                cur.next=temp2.next;
                temp2=temp2.next;
            }else if (temp1.next.val<=temp2.next.val){
                cur.next=temp1.next;
                temp1=temp1.next;
            }
        }
        if (temp1.next!=null || temp2.next!=null){
            if (temp1.next!=null){
                cur.next=temp2;
            }else {
                cur.next=temp1;
            }

        }
        return listNode.next;
    }
}

