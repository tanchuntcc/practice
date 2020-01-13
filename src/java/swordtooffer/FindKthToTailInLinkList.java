package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/14
 * Description:输入一个链表，输出该链表中倒数第k个结点。
 * 思路：1.统计链表一共有多少个节点，再减去k，题目变成输出正数第n个节点
 *       2.反转链表 再输出第k个节点（反转过后当k为原来的链表头节点时有问题）
 *       3.将链表节点输出到栈中，在找出第K个值
 *       4.前后指针，定义p、q两个指针，将q指向第k个节点然后两个节点同时后移，当q为空时，p还差k个节点没走完，即为倒数第k个指针
 *       5.快慢指针（暂未想到解法）
 */
public class FindKthToTailInLinkList {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //1.先一轮循环统计节点数，再一轮循环输出正数第n-k个节点
//    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode node1=head;
//        int n=0;
//        int i=0;
//        while (node1!=null){
//            n++;
//            node1=node1.next;
//        }
//        int z=n-k;
//        ListNode node2=head;
//        while (node2!=null){
//            if (i==z){
//                break;
//            }
//            node2=node2.next;
//            i++;
//        }
//        return node2;
//    }
    //2.反转链表再找出第k个节点  （此方法在输出头节点时会出错）
//    public ListNode FindKthToTail(ListNode head,int k) {
//        ListNode node=head;
//        ListNode pHeadNode=null;
//        ListNode pPre=null;
//        ListNode pNext=null;
//        int i=1;
//        while (node!=null){
//            pNext=node.next;
//
//            if (node.next==null){
//               pHeadNode=node;
//            }
//            //先将node的指针指向空指针pPre。
//            node.next=pPre;
//            //然后将node的指赋值给pPre
//            pPre=node;
//            //然后将node.next的值和后面的左右节点赋给node。
//            node=pNext;
//        }
//        ListNode pHead1=pHeadNode;
//        while (pHead1!=null){
//            if (i==k){
//                break;
//            }
//            pHead1=pHead1.next;
//            i++;
//        }
//        return pHead1;
//    }
    //3.双指针同步走
    //首先定义两个指向链表头的指针p  ,q;
    // 先令指针q指向第k节点，然后两个指针同时向后移动，
    // 最后q走到最后时p还差k个节点走到最后，即走到倒数第k个节点
    public ListNode FindKthToTail(ListNode head,int k) { //5,{1,2,3,4,5}
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k) {
                q = q.next;
            }
            p = p.next;
        }
        return i < k ? null : q;
    }
}

