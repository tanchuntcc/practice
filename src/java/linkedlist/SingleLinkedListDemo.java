package linkedlist;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2019/9/5
 * Description:
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //按编号加入链表测试
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero3);
        singleLinkedList.list();
        //测试修改节点的代码
//        HeroNode heroNode = new HeroNode(2, "小鹿", "linlin");
//        singleLinkedList.update(heroNode);
//        singleLinkedList.list();
//        System.out.println("删除节点----------------------");
//        singleLinkedList.delete(1);
//        singleLinkedList.list();
//        System.out.println(singleLinkedList.getLength(singleLinkedList.getHead()));
//        //测试得到倒数第K个节点
//        HeroNode lastNode = singleLinkedList.findLastNode(singleLinkedList.getHead(), 3);
//        System.out.println(lastNode);
        System.out.println("反转后");
        SingleLinkedList reverse = singleLinkedList.reverse(singleLinkedList.getHead());
        reverse.list();
    }
}


//定义SingleLinkedList管理我们的英雄
class SingleLinkedList{
    //先初始化一个头节点，头节点不要动，不存放任何数据
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode){
        //因为head节点不能东，因此我们需要一个辅助便利temp
        HeroNode temp=head;
        //遍历链表，找到最后
        while (true){
            //找到链表的最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp=temp.next;
        }
        //当推出while循环时，temp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        temp.next=heroNode;
    }

    //第二种方式添加英雄，将英雄按照序号排列
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们仍然通过一个辅助指针来帮助找到添加位置
        //因为单链表，因此我们找的temp是位于添加位置的前一个节点，否则插不了
        HeroNode temp=head;
        boolean flag=false; //添加标号是否存在
        while (true){
            if (temp.next==null){//说明temp已经在链表最后
                break;
            }
            if(temp.next.no>heroNode.no){ //位置找到，就在temp后面插入
                break;
            }else if (temp.next.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next; //后移
        }
        if (flag){
            System.out.printf("准备插入的英雄的编号 %d 已经存在了，不能加入\n",heroNode.no);
        }else {
            heroNode.next=temp.next;
            temp.next=heroNode;
        }
    }

    public void update(HeroNode heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head.next;
        boolean flag=false; //是否找到该节点
        while (true){
            if (temp==null){
                break; //已经遍历完链表
            }
            if (temp.no==heroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=heroNode.name;
            temp.nickName=heroNode.nickName;
        }else {
            System.out.printf("没有找到编号%d的节点",heroNode.no);
        }
    }

    public void delete(int heroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助变量
        HeroNode temp = head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break; //已经遍历完链表
            }
            if (temp.next.no==heroNode){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在",heroNode);
        }

    }

    //方法：获取单链表的节点的个数
    public  int getLength(HeroNode head){
        if (head.next==null){
            return 0;
        }
        int length=0;

        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur=cur.next;
        }
        return length;
    }
    //方法：查找单链表中的倒数第k个节点
    //思路：1.编写一个方法，接受head节点，同时接收一个要给index
    //2.index表示是倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总长度getLength
    //4.得到size后，我们从链表的第一个开始遍历（size-index）个，
    public  HeroNode findLastNode(HeroNode head,int index){
        if (head.next==null){
            return null;
        }
        //第一个遍历的到链表的长度（节点个数）
        int size=new SingleLinkedList().getLength(head);

        //第二次遍历 size-index位置，就是我们倒数的第k个节点
        //先做一个index的校验
        if (index<=0 || index>size){
            return null;
        }
        //定义给辅助变量,for循环定位到倒数的index
        HeroNode cur=head.next;
        for (int i = 0; i < size - index; i++) {
            cur=cur.next;
        }
        return cur;
    }
    //显示链表[遍历]
    public void list(){
        //判断链表是否为空
        if (head.next==null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因为我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true){
            //判断是否到链表最后
            if (temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            //将temp后移
            temp=temp.next;

        }
    }
    //单链表反转
    public  SingleLinkedList  reverse(HeroNode head){
        HeroNode temp = head;
        Stack<HeroNode> stack = new Stack<>();
        while (temp.next!=null){
            temp=temp.next;
            stack.push(temp);
        }


        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
        while (!stack.isEmpty()){
            singleLinkedList2.add(stack.pop());
        }
        return singleLinkedList2;

    }

}
//定义HeroNode,每个HeroNode对象就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

