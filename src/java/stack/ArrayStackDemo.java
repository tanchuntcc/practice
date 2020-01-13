package stack;

import java.util.Scanner;

/**
 * @author 谭春
 * Date: 2019/9/9
 * Description:
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key="";
        boolean loop=true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show:显示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入：");
            key=scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int pop = stack.pop();
                        System.out.printf("出栈的数据时%d\n",pop);
                    }catch (Exception e){

                    }
                    break;
                case "exit":
                    scanner.close();
                    loop=false;

                    break;
                    default:break;
            }
        }
        System.out.println("程序退出");
    }
}
class  ArrayStack{
    private  int maxSize;
    private  int[] stack;
    private  int top=-1;

    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    public  boolean isFull(){
        return top==maxSize-1;
    }
    public  boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int num){
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top]=num;
    }

    public int pop(){
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        return stack[top--];
    }

    //遍历栈,需要从栈顶开始显示数据
    public void list(){
        if (isEmpty()) {
            System.out.println("栈空");
        }
        for (int i = top; i >0 ; i--) {
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }


}

