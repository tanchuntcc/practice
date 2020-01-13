package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/12
 * Description:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 思路：斐波那契的实际应用，其实跳到每个台阶的跳法就是斐波那契数列中项的值。
 * 问题化为计算跳到倒数第二步和倒数第二部到最后一个台阶的步数之和，其中倒数第二部到最后一部又两种跳法，即1步或2步。
 */
public class JumpStep {
    public int JumpFloor(int target) {
        if (target<=2){
            return target;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}

