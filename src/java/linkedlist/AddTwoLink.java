package linkedlist;

import java.util.List;

/**
 * @author 谭春
 * Date: 2019/9/5
 * Description:
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

