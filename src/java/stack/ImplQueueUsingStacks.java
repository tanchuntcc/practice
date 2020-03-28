package stack;

import java.util.Stack;

/**
 * 已同步至博客
 * @author 谭春
 * Date: 2020/1/14
 * Description:
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 思路：创建两个栈，一个用于输入，一个用于输入。输入的栈负责队列的push进来的数据。当队列需要pop或者peek时，
 * 需要把输入栈的内容进入输出栈,再在输出栈中执行pop或者peek，当输出栈中还有值时就不要将输入栈的内容进入输出栈。
 */
public class ImplQueueUsingStacks {
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    public ImplQueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}

