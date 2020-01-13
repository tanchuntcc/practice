package swordtooffer;

import java.util.HashMap;
import java.util.Set;

/**
 * @author 谭春
 * Date: 2019/10/23
 * Description:一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * 思路：1.遍历加入到hashmap中，然后循环数组，遇到value为1的即为出现一次的。
 *       2.先对所有数异或运算，得出的结果为两个单数的抑或结果，再用1与他们与运算，如果为0，则将1左移再与，
 *       直到！=1时就找到异或结果中1所在位置，并保存这个数K， 然后再循环数组，与K相与，实际上是通过与那一位1相与，
 *       等于1的放num1[],等于0的放num2[]。分成两块后，左右都有一个单独的数，然后再分别对两个数组相与，得出最终结果。
 *
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])){
                map.put(array[i],map.get(array[i])+1);
            }else {
                map.put(array[i],1);
            }
        }
        int[] a=new int[2];
        int count=0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])==1){
                a[count]=array[i];
                count++;
            }
        }
        num1[0]=a[0];
        num2[0]=a[1];
    }
}

