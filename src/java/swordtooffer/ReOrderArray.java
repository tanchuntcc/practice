package swordtooffer;

import java.util.Arrays;

/**
 * @author 谭春
 * Date: 2019/10/14
 * Description:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 思路：1.创建一个新数组，然后先将奇数遍历进去再遍历偶数
 *       2.再原有数组上将偶数向后移动
 */
public class ReOrderArray {
    //1.将奇数偶数分别放入两个不同的数组中再合并(以空间换时间)
//    public void reOrderArray(int [] array) {
//        int[] array1=new int[array.length];
//        int a1=0;
//        int[] array2=new int[array.length];
//        int a2=0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i]%2==1){
//                array1[a1++]=array[i];
//            }else {
//                array2[a2++]=array[i];
//            }
//        }
//        int[] a=new int[a1+a2];
//        int a3=0;
//        for (int i = 0; i <a1; i++) {
//            a[a3++]=array1[i];
//        }
//        for (int i = 0; i <a2; i++) {
//            a[a3++]=array2[i];
//        }
//        System.out.println(Arrays.toString(a));
//    }
    //思路1的改进版本
        public void reOrderArray(int [] array) {

        int[] a=new int[array.length];
        int a3=0;
        for (int i = 0; i <array.length; i++) {
            if (array[i]%2==1) {
                a[a3++] = array[i];
            }
        }
        for (int i = 0; i <array.length; i++) {
            if (array[i]%2==0) {
                a[a3++] = array[i];
            }
        }
        System.out.println(Arrays.toString(a));
    }
    //2.将偶数全部后移（以时间换空间）
//    public void reOrderArray(int [] array) {
//        int temp=0;
//        int n;
//        for (int i = array.length-2; i >0 ; i--) {
//            n=i;
//            while (n<array.length-1 && array[n]%2==0 && array[n+1]%2==1){
//                temp=array[n];
//                array[n]=array[n+1];
//                array[n+1]=temp;
//                n++;
//            }
//        }
//        System.out.println(Arrays.toString(array));
//
//    }

    public static void main(String[] args) {
        int[] i ={1,2,3,4,11,5,6,7,8};
        final ReOrderArray reOrderArray = new ReOrderArray();
        reOrderArray.reOrderArray(i);
    }
}

