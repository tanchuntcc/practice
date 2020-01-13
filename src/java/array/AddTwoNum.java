package array;

import java.util.HashMap;

/**
 * @author 谭春
 * Date: 2020/1/6
 * Description:
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * 思路：数组两数之和等于target，相当于target-num[i]的结果也为数组中的数。创建一个hashMap,遍历list时判断map中
 * 是否包含 target-num[i]的值，不包含就把值和他的索引i存入map,一直遍历list，就找到结果。
 */
public class AddTwoNum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] ints = new int[2];
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (!hashMap.containsKey(target-nums[i])) {
                hashMap.put(nums[i], i);
            }else {
                ints[index] = hashMap.get(target - nums[i]);
                ints[++index] = i;
                break;
            }
        }
        return  ints;
    }

    public static void main(String[] args) {
        int[] a={3,2,4};
        AddTwoNum addTwoNum = new AddTwoNum();
        int[] ints = addTwoNum.twoSum(a, 6);
        System.out.println(ints);
    }
}

