package array;

import java.util.HashMap;

/**
 * Created by TanChun on 2019/2/22.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 */
public class Duplicate {
    public Integer duplicate(int[] numbers){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(numbers[i])){
                return numbers[i];
            }else {
                map.put(numbers[1],1);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ints={2,3,0,5,4,2,3};
        Duplicate duplicate = new Duplicate();
        System.out.println(duplicate.duplicate(ints));
    }
}

