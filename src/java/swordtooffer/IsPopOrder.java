package swordtooffer;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2019/10/15
 * Description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 思路：先将压入顺序的数组依次压入栈中，当入栈的元素和出栈的第一个元素相等时，先出栈，然后记录出栈顺序的元素下标。
 * 再入栈与出栈的顺序进行比较，当相同时就出栈，然后下标一次增加。当最后栈为空则代表顺序是出栈顺序。
 */
public class IsPopOrder {
    //1,2,3,4,5   入栈
    //4,3,5,1,2   出栈
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> s = new Stack<Integer>();

        int popIndex = 0;
        for (int i=0;i<pushA.length;i++){
            s.push(pushA[i]);
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }

        }
        return s.isEmpty();

    }
}

