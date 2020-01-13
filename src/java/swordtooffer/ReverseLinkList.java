package swordtooffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author 谭春
 * Date: 2019/10/10
 * Description:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 思路：1.使用入栈出栈操作
 *       2.使用链表反转操作
 */
public class ReverseLinkList {

        public class ListNode {
            int val;
           ListNode next = null;

             ListNode(int val) {
                 this.val = val;
           }
        }

        //使用栈
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            Stack<Integer> strings = new Stack<>();
            ArrayList<Integer> integers = new ArrayList<>();
            ListNode head=listNode;
                while (head!=null){
                    strings.push(head.val);
                    head=head.next;
                }
                while (!strings.isEmpty()){
                    integers.add(strings.pop());
                }
                return integers;
        }

        //反转链表
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        ArrayList<Integer> integers = new ArrayList<>();
//            ListNode head=listNode;
//            ListNode pPre=null;
//             ListNode preHead=null;
//            while (head!=null){
//                ListNode pNext=head.next;
//
//                if (head.next==null){
//                    preHead=head;
//                }
//                head.next=pPre;
//                pPre=head;
//                head=pNext;
//            }
//
//            if(preHead==null){
//                return integers;
//            }
//            while (preHead!=null){
//                integers.add(preHead.val);
//                preHead=preHead.next;
//            }
//            return integers;
//    }

    }


