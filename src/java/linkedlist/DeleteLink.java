package linkedlist;

/**
 * Created by TanChun on 2019/2/13.
 * 节点删除方法
 */
public class DeleteLink {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
