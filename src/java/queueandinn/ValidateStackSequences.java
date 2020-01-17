package queueandinn;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2020/1/16
 * Description:
 * 给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 思路：使用一个辅助栈，将需要push的元素push进去，每次push后个pop元素进行对比，如果push进去的是第一个pop出来的，
 * 就把他pop出来，然后再push第二个元素，然后再与第二个pop数组的元素对比，如果相同则pop出来。依次执行，当pop出去的元素
 * 等于push进去的元素的个数则返回true.
 *
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int length = pushed.length;
        Stack<Integer> stack = new Stack<>();
        int index=0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && index<length && stack.peek()==popped[index]){
                stack.pop();
                index++;
            }
        }
     return index==length;
    }
}

