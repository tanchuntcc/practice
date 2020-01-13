package recursion;

/**
 * @author 谭春
 * Date: 2019/9/10
 * Description:
 */
public class Queue8 {
    //定义一个max表示共有多少个皇后
    int max=8;
    //定义数组array，保存皇后放置位置得结果，比如arr={0,4,7,5,2,6,1,3}
    int[] array=new int[max];
    static int count=0;
    static int judgeCount=0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.printf("一共有%d种解法",count);
        System.out.println();
        System.out.printf("一共判断冲突%d次",judgeCount);


    }

    //放置第n个皇后
    //特别注意：check是每一次递归时，进入到check中都有for (int i = 0; i < max; i++),因此会有回溯
    private void check(int n){
        if (n==max){

            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后 n 放到该行的第1列
            array[n]=i;
            //判断当放置第n个皇后到i列时，是否冲突
            if (judge(n)){
                check(n+1);
            }
            //如果冲突，就继续执行array[n]=i;即将第n个皇后，放置在本行得后移的一个位置
        }
    }

    /**
     * 查看当我们放置第n个皇后，就去检测该皇后是否和前面已经摆放的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        judgeCount++;
        for (int i = 0; i < n; i++) {
            //1.array[n]==array[i] 表示第n个皇后是否和之前的皇后在同一列
            //2.Math.abs(n-i)==Math.abs(array[n]-array[i]) 表示第n个皇后和之前的皇后是否在同意斜线
            if (array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    //写一个方法，可以将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}

