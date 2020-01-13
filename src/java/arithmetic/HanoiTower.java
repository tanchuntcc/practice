package arithmetic;

/**
 * Created by TanChun on 2018/12/12.
 * 汉诺塔（递归问题）
 */
public class HanoiTower {
    private static int count = 1;
    public static void main(String[] args) {
        moved(3, "A柱子", "B柱子", "C柱子");
    }
    
    /**
     * 
     * @param i  圆盘数量
     * @param a  圆盘初始所在塔座
     * @param b  圆盘将要移动到的塔座
     * @param c     辅助圆盘移动的塔座
     */
    public static void moved(int i,String a,String b,String c){
        if(i == 1){
            System.out.println("将第"+1+"个塔 从 "+a+" 到 "+b);
        }else{
            //将i-1根圆盘由A移动到C
            moved(i-1, a, c, b);
            //将圆盘i 由A移动到B
            System.out.println("将第"+i+"个塔 从 "+a+" 到 "+b);
            //将i-1根圆盘由C移动到B
            moved(i-1,c,b,a);
        }
    }

}