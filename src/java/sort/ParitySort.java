package sort;

/**
 * Created by TanChun on 2019/2/13.
 * 一个游标从左到右查找奇数，一个游标从右向左查找偶数，然后交换这两个数的位置。
 * 重复上述过程直到两游标相遇。
 */
public class ParitySort {
    public int[] sortArrayByParity(int[] A) {
        int[] a=new int[A.length];
        int z=0;
        int b=A.length-1;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){
                a[z]=A[i];
                z++;
            }
            if(A[i]%2==1){
                a[b]=A[i];
                b--;
            }
        }
        return a;
    }
}
