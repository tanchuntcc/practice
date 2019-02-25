package array;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by TanChun on 2018/12/18.
 * 判断一个数字中是否包含重复值
 */
class ContainsSame {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        if(map.size()==nums.length){
            return false;
        }
        return true;
    }
}