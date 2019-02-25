package arithmetic;

/**
 * Created by TanChun on 2018/12/12.
 * 汉诺塔（递归问题）
 */
public class HanoiTower {
    private static int count = 1;
    public static void main(String[] args) {
        moved(4, "第一根柱子", "第二根柱子", "第三根柱子");
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
            disPaly(1, a, b);
        }else{
            //将i-1根圆盘由A移动到C
            moved(i-1, a, c, b);
            //将圆盘i 由A移动到B
            disPaly(i, a, b);
            //将i-1根圆盘由C移动到A
            moved(i-1,c,b,a);
        }
    }
    
    public static void disPaly(int i,String a,String b){
        System.out.println("第"+count+"步：移动第"+i+"个塔从"+a+"到"+b);
        count++;
    }
}