package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/10
 * Description:在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * 思路  :从左下角开始比较，大于往右看  小于往上看。
 */
public class FindFromArray {
    public boolean Find(int target, int [][] array) {
        //数据为空时判断会出错
//        if (target<array[0][0] || target>array[array.length-1][array[0].length-1]){
//            return false;
//        }

        int col=0;
        int row=array.length-1;

        while (row>=0 && col<=array[0].length-1){
            if (target==array[row][col]){
                return true;
            }else if (target>array[row][col]){
                col++;
            }else if (target<array[row][col]){
                row--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int array[][]={{1,3,7,15},{2,5,8,17},{4,6,9,19}};
        FindFromArray findFromArray = new FindFromArray();
        boolean find = findFromArray.Find(15, array);
        System.out.println(find);
    }
}

