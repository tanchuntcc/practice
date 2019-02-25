package array;

/**
 * Created by TanChun on 2019/2/21.
 */
public class OddAndEvenNum {
    public void reOrder(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if(array[j]%2==0  && array[j+1]%2!=0){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
