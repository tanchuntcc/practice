package test;

/**
 * @author 谭春
 * Date: 2019/9/12
 * Description:
 */
public class HashTab {
    public static void main(String[] args) {

    }

    //创建HashTab 管理多条链表
    class Hash{
        private int size;
        private EmpLinkedList[] empLinkedListArray;

        public Hash(int size) {
           this.size=size;
            empLinkedListArray=new EmpLinkedList[size];
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i]=new EmpLinkedList();
            }
        }
        public void add(Emp emp){
            int empLinkedListNo = hashFun(emp.id);
            empLinkedListArray[empLinkedListNo].add(emp);
        }
        public void list(){
            for (int i = 0; i < size; i++) {
                empLinkedListArray[i].list();
            }
        }

        public int hashFun(int id){
            return id % size;
        }
    }
    //表示一个雇员
    class Emp{
        public int id;
        public String name;
        public Emp next;

        public Emp(int id,String name) {
            super();
            this.id = id;
            this.name=name;
        }
    }
    //创建EmpLinkedList,表示链表
    class EmpLinkedList{
        //头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
        private Emp head;

        //添加雇员到链表
        //说明
        //1.假定，当添加雇员时，id时自增长，即id的分配总是从小到大
        //因此我们将该雇员直接加入到本链表的最后即可
        public void add(Emp emp){
            if (head==null){
                head=emp;
                return;
            }
            //如果不算第一个雇员，则使用一个辅助执政，帮助定位到最后
            Emp curEmp=head;
            while (true){
                if (curEmp.name==null){
                    break;
                }
                curEmp=curEmp.next;
            }
            //退出时，直接将emp加入链表
            curEmp.next=emp;
        }

        //遍历链表的雇员信息
        public void list(){
            if (head==null) {
                System.out.println("当前链表为空");
                return;
            }
            System.out.println("当前链表信息为");
            Emp curEmp=head;
            while (true){
                System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
                if (curEmp.next==null){
                    break;
                }
                curEmp=curEmp.next;
            }
        }
    }
}

