package array;

/**
 * Created by TanChun on 2019/2/21.
 * 现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）
 * 解题思路
 * 公式:
 * f(n) = n, n <= 1
 * f(n) = f(n-1) + f(n-2), n > 1
 * 可以直接使用递归的方法：
 *
 * if(n<=1) return n;
 * else return Fibonacci(n-1)+Fibonacci(n-2);
 * 递归的方法可能会遇到Stack Overflow，
 * 所以我们可以考虑用动态规划的方法来实现。
 * 采用自底向上方法来保存了先前计算的值，为后面的调用服务。
 */
public class Fibonacci {
    public int Fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
        int fn1=0;
        int fn2=1;
        for(int i=2;i<=n;i++){
            fn2+=fn1;
            fn1=fn2-fn1;
        }
        return fn2;
    }
}
