package swordtooffer;

import java.util.HashMap;


/**
 * @author 谭春
 * Date: 2019/10/22
 * Description:统计一个数字在排序数组中出现的次数。
 * 思路：1.二分查找，找到后再判断左右的数是否相等。
 *       2.使用hashmap
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int count=0;
        int left=0;
        int right=array.length-1;
        while (right>left){
            int mid=(left+right)/2;
            if (array[mid]>k){
                right=mid-1;
            }else if (array[mid]<k){
                left=mid;
            }else {
                count++;
                int temp=mid;
                while (temp-1>=0 && array[--temp]==k){
                    count++;
                }
                while (mid+1<=array.length-1 && array[++mid]==k){
                    count++;
                }
                return count;
            }
        }
        return count;
    }
//public int GetNumberOfK(int [] array , int k) {
//    HashMap<Integer, Integer> map = new HashMap<>();
//    for (int i = 0; i < array.length; i++) {
//        if (map.containsKey(array[i])){
//            map.put(array[i],map.get(array[i])+1);
//        }else {
//            map.put(array[i],1);
//        }
//    }
//    for (int i = 0; i < array.length; i++){
//        if (array[i]==k) {
//            return map.get(array[i]);
//        }
//    }
//    return 0;
//}

    public static void main(String[] args) {
        int[] ints={3,3,3,3,3,3};

        GetNumberOfK getNumberOfK = new GetNumberOfK();
        final int i = getNumberOfK.GetNumberOfK(ints, 3);
        System.out.println(i);
    }
}

