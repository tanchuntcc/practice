package queueandinn;

import java.util.Stack;

/**
 * Created by TanChun on 2019/2/13.
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，
 * 判断二者是否相等，并返回结果。 # 代表退格字符。
 */
public class JudgeSame {
    public boolean backspaceCompare(String S, String T) {

        return getStack(S).equals(getStack(T));

    }
    public Stack getStack(String str){
        Stack stack=new Stack();
        for(char ch:str.toCharArray()){
            if(ch!='#'){
                stack.push(ch);
            }else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }

        }
        return stack;

    }
}
