package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 已同步到博客
 * @author 谭春
 * Date: 2020/3/19
 * Description:给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 *
 * 以数组形式返回答案。
 *
 * 示例 1：
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 *
 * 思路：1、暴力直接双循环解。
 *       2、对数组进行排序后，针对其中一个元素。比它小的数的个数就是他的下标位置。
 *       第0个元素没有比他小的数，第一个元素有1个比他小的数......
 */
public class LessCurrentNum {
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] a=new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int count=0;
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i]>nums[j]) {
//                    count++;
//                }
//                a[i]=count;
//            }
//        }
//        return a;
//    }

    //2、对数组进行排序后，比它小的数的个数就是他的下标位置。
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] temp = Arrays.copyOf(nums, n);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(i == 0){
                map.put(temp[i],0);
            }else{
                if(temp[i] > temp[i-1]){
                    map.put(temp[i],i);
                }
            }
        }
        for(int i = 0; i < n; i++){
            temp[i] = map.get(nums[i]);
        }
        return temp;
    }

//        //有多少小于当前数字的数字，频次数组加前缀和解法，数组元素取值范围不过[0, 100]
//        public int[] smallerNumbersThanCurrent(int[] nums) {
//            //频次数组
//            int[] valNum = new int[101];
//            for (int v : nums){
//                valNum[v]++;
//            }
//            //前缀和数组
//            int[] perSum = new int[valNum.length + 1];
//            perSum[0] = 0;
//            for (int i = 1; i < perSum.length; i++){
//                perSum[i] = valNum[i - 1] + perSum[i - 1];
//            }
//            //结果数组
//            int[] res = new int[nums.length];
//            for (int i = 0; i < res.length; i++){
//                res[i] = perSum[nums[i] + 1] - valNum[nums[i]];
//            }
//            return res;
//        }
//    }

    public static void main(String[] args) {
        int[] ints = {8, 1, 2, 2, 3};
        int[] ints1 = new LessCurrentNum().smallerNumbersThanCurrent(ints);
        System.out.println(ints);
    }

}

