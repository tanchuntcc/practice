package swordtooffer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 谭春
 * Date: 2019/10/15
 * Description:定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 思路：1.dataStack为存储数据的栈，minStack为存储最小值的栈；
 *       2.push的时候将value值与minStack中的top值比较，小则minStack push value，大则push 之前的最小值
 */
public class MinInStack {
        Stack<Integer> dataStack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        public void push(int node) {
            dataStack.push(node);
            if(minStack.isEmpty() || node < minStack.peek()){
                minStack.push(node);
            }
            else{
                minStack.push(minStack.peek());
            }
        }

        public void pop() {
            dataStack.pop();
            minStack.pop();
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
}

