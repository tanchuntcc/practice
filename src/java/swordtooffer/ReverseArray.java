package swordtooffer;

import java.util.ArrayList;
/**
 * @author 谭春
 * Date: 2019/10/11
 * Description:把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序（递增）的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 思路1.循环数组进行比较。
 *     2.使用二分法，若中间数小于左边数，则最小值在左边，若中间数大于右边数，则最小值在右边
 */
public class ReverseArray {
    //1.循环比较
//        public int minNumberInRotateArray(int [] array) {
//            for (int i=0;i<array.length-1;i++){
//                if (array[i]>array[i+1]){
//                    return array[i+1];
//                }
//            }
//            return 0;
//        }
    //2.使用二分法
    public int minNumberInRotateArray(int [] array) {
        int left=0;
        int right=array.length-1;
        while (right>left){
            int mid=(left+right)/2;
            if (array[mid]<array[left]){
                right=mid-1;
                if (array[right]>array[right+1]){
                    return array[right+1];
                }
            }else if (array[mid]>array[right]){
                left=mid+1;
                if (array[left]<array[left-1]){
                    return array[left];
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] array={6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};

        ReverseArray reverseArray = new ReverseArray();
        System.out.println(reverseArray.minNumberInRotateArray(array));
    }
}

