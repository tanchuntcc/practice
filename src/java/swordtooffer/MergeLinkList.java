package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/14
 * Description:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 思路：创建一个新的链表，遍历并比较两个链表，较小的赋给新的链表并迭代循环，最后当其中一个链表为空时，直接将另一个链表赋给新的链表
 */
public class MergeLinkList {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    //遍历并比较两个链表
        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null) {
                return list2;
            }
            if (list2 == null) {
                return list1;
            }
            ListNode mergeHead = null;
            ListNode current = null;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    if (mergeHead == null) {
                        mergeHead = current = list1;
                    } else {
                        current.next = list1;
                        current = current.next;
                    }
                    list1 = list1.next;
                } else {
                    if (mergeHead == null) {
                        mergeHead = current = list2;
                    } else {
                        current.next = list2;
                        current = current.next;
                    }
                    list2 = list2.next;
                }
            }
            if (list1 == null) {
                current.next = list2;
            } else {
                current.next = list1;
            }
            return mergeHead;
        }
}

