package linkedlist;

/**
 * @author 谭春
 * Date: 2020/1/14
 * Description:给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 思路：排序数组，所以重复的节点时连续的，所以只需要遍历链表且删除掉后面重复的节点
 */
public class RemoveDuplicatesLink {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pNode=head;
        while (pNode!=null && pNode.next!=null) {
            if (pNode.next.val==pNode.val) {
                pNode.next = pNode.next.next;
            }else{
                pNode = pNode.next;
            }
        }
        return head;
    }
}

