package swordtooffer;

import java.util.Stack;
/**
 * @author 谭春
 * Date: 2019/10/11
 * Description:用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路1.push时先将stack2的元素返还给stack1,pop时将stack1入到stack2中。
 *     2.pop时将第一个栈的元素入第二个栈，下次pop当第二个栈不为空时，不用从第一个栈中导数据，直接将第二个栈中元素出栈。
 */

public class QueueWithStack {

        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
//1.当stack2中任然右元素时，又将元素返还给栈1.
//        public void push(int node) {
//            while (!stack2.isEmpty()){
//                stack1.push(stack2.pop());
//            }
//            stack1.push(node);
//        }
//
//        public int pop() {
//
//
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }
//
//            return stack2.pop();
//        }

//2.（别人家的解法）  pop时判断stack2是否为空，不为空，则不将stack1的内容入栈，直接pop之前存在的数据。
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithStack queueWithStack = new QueueWithStack();
        queueWithStack.push(1);
        queueWithStack.push(2);
        queueWithStack.push(3);
        System.out.print(queueWithStack.pop()+",");
        System.out.print(queueWithStack.pop()+",");
        queueWithStack.push(4);
        System.out.print(queueWithStack.pop()+",");
        queueWithStack.push(5);
        System.out.print(queueWithStack.pop()+",");
        System.out.print(queueWithStack.pop()+",");
    }
}

