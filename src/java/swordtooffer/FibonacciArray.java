package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/12
 * Description:大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）, n<=39
 * 思路1.动态规划 构造一个斐波那契数列，返回第n项
 *     2.递归 0和1直接返回，return Fibonacci(n-1) + Fibonacci(n-2);
 */
public class FibonacciArray {
//1.动态规划，构造数组
    public int Fibonacci(int n) {
        int[] array=new int[41];
        array[0]=0;
        array[1]=1;
        for (int i = 0; i <n; i++) {
            array[i+2]=array[i]+array[i+1];
        }
        return array[n];
    }

//2.递归
//    public int Fibonacci(int n) {
//        if (n <= 1) {
//            return n;
//        }
//        else {
//            return Fibonacci(n-1) + Fibonacci(n-2);
//        }
//    }
//  当n=4，
//    Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
//                 = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
//                 = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
//      由于我们的代码并没有记录Fibonacci(1)和Fibonacci(0)的结果，对于程序来说它每次递归都是未知的，
//      因此光是n=4时f(1)就重复计算了3次之多。

    public static void main(String[] args) {
//        0 1 1 2 3 5 8
        FibonacciArray fibonacciArray = new FibonacciArray();
        System.out.println(fibonacciArray.Fibonacci(3));
    }
}

