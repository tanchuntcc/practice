package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/12
 * Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 思路：跟一次只能跳一步或者两部思路相同，对式子进行分析得到   f(n)=2*f(n-1)
 */
public class JumpSteps {
//      f(n-1) = f(0) + f(1)+f(2)+f(3) + ... + f((n-1)-1) = f(0) + f(1) + f(2) + f(3) + ... + f(n-2)
//      f(n) = （f(0) + f(1) + f(2) + f(3) + ... + f(n-2) ） + f(n-1) = f(n-1) + f(n-1)
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII(target - 1);
        }
    }
}

