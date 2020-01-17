package queueandinn;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author 谭春
 * Date: 2020/1/14
 * Description:使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 * 思路：创建两个队列，入队列和出队列。入队列用于push操作。push后将output队列的数据放入到出队列这样就达到了数据
 * 颠倒，然后将交换入队列和出队列。
 *
 */
public class ImplStacksUsingQueue {
    private Queue<Integer> inputQueue;
    private Queue<Integer> outputQueue;
    /** Initialize your data structure here. */
    public ImplStacksUsingQueue() {
       inputQueue = new LinkedList<>();
       outputQueue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        inputQueue.offer(x);
        while (!outputQueue.isEmpty()) {
            inputQueue.offer(outputQueue.poll());
            }
            Queue<Integer> temp=inputQueue;
            inputQueue=outputQueue;
            outputQueue=temp;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return outputQueue.poll();

    }

    /** Get the top element. */
    public int top() {
        return  outputQueue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return outputQueue.isEmpty();
    }
}

