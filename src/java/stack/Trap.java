package stack;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2020/4/4
 * Description:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 思路：使用单调栈，加入元素好要保持单调必须再加入前将之前的元素出栈，出栈的元素个数*栈高度差就是可装入的水。
 *
 */
public class Trap {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            //如果入栈元素比栈顶元素大时执行出栈操作
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int pop = stack.pop();
                // 与栈顶相同的都出栈。
                while (!stack.isEmpty() && height[stack.peek()] == height[pop]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    //取左边柱子和右边柱子高度的最小值减去已经出栈的栈顶值即是水的高度，乘上水的宽度就是这层能装水多少。
                    res += (Math.min(height[stack.peek()], height[i]) - height[pop]) * (i - stack.peek() - 1);
                }
            }
            stack.add(i);
        }
        return res;
    }
}

