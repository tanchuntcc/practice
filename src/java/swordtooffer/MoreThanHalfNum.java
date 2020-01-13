package swordtooffer;

import java.util.Arrays;

/**
 * @author 谭春
 * Date: 2019/10/21
 * Description:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数
 * 组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 思路：摩尔投票法
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        int cur=array[0];
        int count=1;
//        [1,2,3,2,4,2,5,2,3]
//        2,1,1,2,2,2,2,1,1
        for (int i = 1; i < array.length; i++) {

            if (array[i]!=cur){
                count--;
            }else {
                count++;
            }
            if (count==0){
                cur=array[i];
                count++;
            }

        }
        int index=0;
        for (int i = 0; i < array.length;i++) {
            if (array[i]==cur){
                index++;
            }
        }

        return index<=array.length/2?0:cur;
    }
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }


    public static void main(String[] args) {
        int[] a={2,1,1,2,2,1,1,2,2};
        MoreThanHalfNum moreThanHalfNum = new MoreThanHalfNum();
        final int i = moreThanHalfNum.MoreThanHalfNum_Solution(a);
        System.out.println(i);
    }
}

