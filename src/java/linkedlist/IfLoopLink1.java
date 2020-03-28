package linkedlist;

/**
 * 已同步至博客
 * @author 谭春
 * Date: 2020/1/14
 * Description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 */
public class IfLoopLink1 {
    public boolean hasCycle(ListNode head) {

        if(head == null){
            return false;
        }
        ListNode fast = head, slow = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        //注意循环的条件是fast不为空，并且fast.next不为空
        //若只有一个头结点，并且头结点的next指向头结点，仍然应该返回true
        return head.next == head;

    }


}

