package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/17
 * Description:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * ，返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 思路：先将原链表每个节点的next节点复制出来，再将random指针复制出来。最后再将复制出来的节点抽离出来
 */

public class CopyLinkList {
    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
            if (pHead==null){
                return null;
            }
            RandomListNode pNode=pHead;
            RandomListNode var=null;
            RandomListNode pNext=null;
                while (pNode!=null){
                    var = new RandomListNode(pNode.label);
                    pNext=pNode.next;
                    pNode.next=var;
                    var.next=pNext;
                    pNode=pNext;
                }
            pNode=pHead;
                while (pNode!=null){
                    pNode.next.random=pNode.random==null?null:pNode.random.next;
                    pNode=pNode.next.next;
                }

              pNode=pHead;
             RandomListNode copy3=pHead.next;
             RandomListNode copy2=null;
                while (pNode!=null){

                    copy2=pNode.next;
                    pNode.next=copy2.next;
                    copy2.next=copy2.next==null?null: copy2.next.next;
                    pNode=pNode.next;
                }
            return copy3;
    }

    public static void main(String[] args) {
        RandomListNode randomListNode = new RandomListNode(1);
        randomListNode.next=new RandomListNode(2);
        randomListNode.next.next=new RandomListNode(3);
        CopyLinkList copyLinkList = new CopyLinkList();
        RandomListNode clone = copyLinkList.Clone(randomListNode);
        System.out.println(clone.label);
    }


}

