package array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TanChun on 2019/2/13.
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那
 * 两个整数,并返回他们的数组下标。
 */
public class FindNum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int a=target-nums[i];
            if(map.containsKey(a) && i!=map.get(a)){
                return new int[]{i,map.get(a)};
            }
        }
        return null;
    }
}
