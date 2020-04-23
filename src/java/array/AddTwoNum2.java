package array;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2020/4/14
 * Description:
 */
public class AddTwoNum2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int last = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || last > 0) {
            last += stack1.isEmpty() ? 0 : stack1.pop();
            last += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(last % 10);
            node.next = head;
            head = node;
            last = last / 10;
        }
        return head;
    }
}

