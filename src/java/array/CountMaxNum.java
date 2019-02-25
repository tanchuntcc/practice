package array;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by TanChun on 2018/12/18.
 * 摩尔投票法和HashMap方法找出一个数组中出现最多的字符和次数
 */
public class CountMaxNum {
//    public int majorityElement(int[] nums) {
//        int count = 0;
//        int majority = 0;
//        for(int i = 0; i < nums.length; i ++ ){
//            if(count == 0){
//                majority = nums[i];
//                count ++;
//            }else if(majority == nums[i]){
//                count++;
//            }else{
//                count--;
//            }
//        }
//        return majority;
//    }

        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i=0;i<nums.length;i++){
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else{
                    map.put(nums[i],1);
                }
            }
            Collection<Integer> count = map.values();
            int maxCount = Collections.max(count);
            int maxNumber = 0;
            for(Map.Entry<Integer, Integer> entry:map.entrySet()){

                if(entry.getValue() == maxCount)
                {
                    maxNumber = entry.getKey();
                }
            }
            System.out.println("出现次数最多的数字为：" + maxNumber);
            System.out.println("该数字一共出现" + maxCount + "次");
            return maxNumber;
        }

    public static void main(String[] args) {
        CountMaxNum ggg = new CountMaxNum();
        System.out.println(ggg.majorityElement(new int[]{1, 3, 3, 2, 4, 3, 4, 5, 6, 5}));
    }
    }
