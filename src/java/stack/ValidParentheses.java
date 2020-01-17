package stack;

import java.util.Stack;

/**
 * @author 谭春
 * Date: 2020/1/14
 * Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 *
 * 思路：将字符串遍历，左括号就存入栈中。遇到右括号就将上一个元素出栈，然后比较他们是不是一对合格的括号。
 * 如果还没遍历完且遇到右括号此时栈为空时就返回false,遍历完栈为空也返回false。
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> strings = new Stack<>();
        if (s.length()==0) {
            return true;
        }
        if (isRight(s.charAt(0))){
            return false;
        }
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (isLeft(c)) {
                strings.push(s.charAt(i));
            }else if (isRight(c) && !strings.isEmpty()){
                    Character pop = strings.pop();
                    boolean sym = isSym(pop, c);
                    if (!sym){
                        return false;
                    }
            }else {
                return false;
            }
        }
        if (!strings.isEmpty()){
            return false;
        }
        return true;
    }
    private boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']') || (c1 == '{' && c2 == '}');
    }
    private boolean isLeft(char c1) {
        return (c1 == '(' || c1 == '[' || c1 == '{') ;
    }
    private boolean isRight(char c1) {
        return (c1 == ')' || c1 == ']' || c1 == '}') ;
    }
//
//    public boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
//        char[] chars = s.toCharArray();
//        for (char aChar : chars) {
//            if (stack.size() == 0) {
//                stack.push(aChar);
//            } else if (isSym(stack.peek(), aChar)) {
//                stack.pop();
//            } else {
//                stack.push(aChar);
//            }
//        }
//        return stack.size() == 0;
//    }


}

