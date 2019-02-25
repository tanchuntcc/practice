package sort;

/**
 * Created by TanChun on 2019/1/14.
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {
                1, 3, 4, 5, 2, 6, 9, 7, 8, 0
        };
        int temp=0;
        for(int i=0;i<array.length-1;i++){
            for(int j=1;j<=array.length-1-i;j++){
                if(array[j]<array[j-1]){
                    temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;
                }
            }
        }
        for (int ss:array) {
            System.out.print(ss+",");
        }
    }
}
