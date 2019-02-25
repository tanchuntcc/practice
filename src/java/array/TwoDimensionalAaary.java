package array;

/**
 * Created by TanChun on 2019/2/18.
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序
 */
public class TwoDimensionalAaary {
    public boolean Find(int target,int[][] array){
        if(array.length==0 || array[0].length==0) {
            return false;
        }
       int m=array.length-1;
        int n=0;
        int i = array[n][m];
        while(target!=i){
            if(m>0 && n<array.length-1) {
                if (target>i){
                    n=n+1;
                }else if(target<i){
                    m=m-1;
                }
                i=array[n][m];
            }else {
                return  false;
            }

        }
        return true;
    }

}
