package array;

import java.util.HashMap;

/**
 * Created by TanChun on 2019/2/22.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 * 法一：大家都能想到的HashMap法
 * 法二：异或法
 *
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for(int i = 0; i < array.length; i++){
            if(temp.containsKey(array[i]))
                temp.remove(array[i]);
            else
                temp.put(array[i], 1);
        }
        int [] a = new int [array.length];
        int i = 0;
        for(Integer k: temp.keySet()){
            a[i] = k;
            i++;
        }
        num1[0] = a[0];
        num2[0] = a[1];
    }
}
