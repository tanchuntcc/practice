package linkedlist;

import java.util.Stack;

/**
 * Created by TanChun on 2019/2/13.
 * 反转链表
 * 思路：先定义号反转后的头节点pRev为null,定义一个存储前一个节点的pPrev为空。定义一个pNode指向pHead
 * 循环遍历pNode链表，定义pNext为下一个节点，判断如果pNext为空则为反转后的头节点。  然后将当前节点
 * pNode的下一个节点指向前一个节点pPrev（即为pNode），然后将前一个节点赋值给pPrev，（即将pNode赋值）
 * pPrev,然后将pNode的下一个节点（即为pNext）赋值给pNode实现循环。 最后返回pRev。
 */
public class ReverseList {
    public ListNode reverseList(ListNode pHead){
        //反转过后的单链表存储头结点
        ListNode pReversedHead = null;
        //定义pNode指向pHead;
        ListNode pNode = pHead;
        //定义存储前一个结点
        ListNode pPrev = null;
        while(pNode != null){
            //定义pNext指向pNode的下一个结点
            ListNode pNext = pNode.next;
            //如果pNode的下一个结点为空，则pNode即为反转后的头指针
            if(pNext==null){
                pReversedHead = pNode;
            }
            //修改pNode的指针域指向pPrev
            pNode.next = pPrev;
            //将pNode结点复制给pPrev
            pPrev = pNode;
            //将pNode的下一个结点复制给pNode
            pNode = pNext;
        }
        return pReversedHead;
    }
    //递归
//    public ListNode reverseList3(ListNode pHead){
//        if(pHead==null || pHead.next == null){ //如果没有结点或者只有一个结点直接返回pHead
//            return pHead;
//        }
//        ListNode pNext = pHead.next; //保存当前结点的下一结点
//        pHead.next = null; //打断当前结点的指针域
//        ListNode reverseHead = reverseList3(pNext); //递归结束时reverseHead一定是新链表的头结点
//        pNext.next = pHead; //修改指针域
//        return reverseHead;
//    }
}
