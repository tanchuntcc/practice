package queueandinn;

import java.util.Scanner;

/**
 * @author 谭春
 * Date: 2019/9/5
 * Description:
 */
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
        char key=' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop=true;
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取出数据");
            System.out.println("h(head):查看队列的头数据");
             key=scanner.next().charAt(0);
             switch (key){
                 case 's':
                     arrayQueue.showQueue();
                     break;
                 case 'a':
                     System.out.println("请输入一个数：");
                     int value = scanner.nextInt();
                     arrayQueue.addQueue(value);
                     break;
                 case 'e':
                     scanner.close();
                     loop=false;
                     break;
                 case 'g':
                     try {
                         int queue = arrayQueue.getQueue();
                         System.out.printf("取出的数据是%d\n",queue);
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                     break;
                 case 'h':
                     try {
                         int queue = arrayQueue.headQueue();
                         System.out.printf("队列头的数据是%d\n",queue);
                     }catch (Exception e){
                         System.out.println(e.getMessage());
                     }
                     break;

             }
        }
        System.out.println("程序结束");

    }
}

class CircleArray{
    private int maxSize;//数组最大容量
    //front 初始值=0，front指向队列第一个元素
    private int front;//队列头
    //rear初始值=0，rear指向队列最后一个元素的后一个位置。
    private int rear;//队列尾
    private int[] arr;//存放数据

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //判断队满
    public boolean isFull(){
        return (rear+1) % maxSize==front;
    }
    //判断队空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public  void  addQueue(int n){
        if (isFull()){
            System.out.println("队满");
            return;
        }
        //直接将数据加入
        arr[rear]=n;
        //将rear后移，这里必须考虑取模，使其可以循环使用
        rear=(rear+1)%maxSize;
    }
    //获取队列的头数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队空，不能取数据");
        }
        //这里需要分析出front是指向队列第一个元素
        //1.先把front对应的值保存到一个临时变量
        //2.将front后移，考虑取模
        //3.将临时保存的变量返回
        int value=arr[front];
        front=(front+1)%maxSize;
        return value;
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队空，没有数据");
            return ;
        }
        //思路：从front开始遍历，便利多少个元素
        for (int i = front; i <front+size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
    //显示队列头数据，不取出
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队空，不能查看数据");
        }
        return arr[front];
    }

}


