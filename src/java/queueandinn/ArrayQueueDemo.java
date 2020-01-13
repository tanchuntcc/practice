package queueandinn;

import java.util.Scanner;

/**
 * @author 谭春
 * Date: 2019/9/5
 * Description:
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

class ArrayQueue{
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//存放数据

    public ArrayQueue(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头，分析出front是指向队列头的前一个位置。
        rear = -1; //指向队列尾，指向队列尾的数据(包含队列最后一个数据)。
    }
    //判断队满
    public boolean isFull(){
        return rear==maxSize-1;
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
        arr[++rear]=n;
    }
    //获取队列的头数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队空，不能取数据");
        }
        return arr[++front];
    }

    //显示队列所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队空，没有数据");
            return ;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示队列头数据，不取出
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队空，不能查看数据");
        }
        return arr[front+1];
    }

}


