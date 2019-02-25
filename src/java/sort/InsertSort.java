package sort;

/**
 * Created by TanChun on 2019/1/14.
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] array = {
                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
        };
        int temp=0;
        for(int i=1;i<array.length;i++){
            temp=array[i];
            int j=0;
            for( j=i-1;j>=0 && temp<array[j];j--){
                    array[j+1]=array[j];
            }
            array[j+1]=temp;
        }
        for (int ss:array) {
            System.out.print(ss+",");
        }
    }
}
