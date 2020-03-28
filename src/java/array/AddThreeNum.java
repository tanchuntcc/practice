package array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 已同步至博客
 * @author 谭春
 * Date: 2020/1/17
 * Description:
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 * 思路：先将数组排序，然后遍历数组，先选出最左边元素为准，从右边数组的两端取元素与最左边元素相加之和是否为0，
 *          >0 则整体过大，将右端元素往坐移一位
 *          <0 则整体过小，将左端元素往右移一位
 *    其中元素需要双重去重，
 *          1.在最外层，选取最左边元素时，重复的则跳过。
 *          2.在三个数相加等于0的判断层，在左右两端缩进时，重复元素也掉过。
 */
public class AddThreeNum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        //遍历数组，从小到大取元素，然后从右边两个指针内取值判断
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                break;
            }
            //选取前后两个指针
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                //如果三个数相加为0，则需要对指针的边界去重
                if (nums[l] + nums[r] + nums[i] == 0) {
                    //如果左边指针数值重复，则将指针移到重复中最右边的一个
                    while (l + 1 < nums.length && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    //如果右边指针数值重复，则将指针移到重复中最左边的一个
                    while (r - 1 > 0 && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
                    list.add(integers);
                    //缩小指针范围，对现有的i再从新的指针范围中取值判断
                    l++;
                    r--;
                } else if (nums[l] + nums[r] + nums[i] < 0) {
                    //将左边指针往右移
                    l++;
                } else {
                    //将右边指针往左移
                    r--;
                }
            }
            //对最左边的数进行去重，相同的数只参与一次完整的遍历。
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return list;
    }


//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<List<Integer>> list = new ArrayList<>();
//        //遍历数组，从小到大取元素，然后从右边两个指针内取值判断
//        for (int j = 0; j < nums.length-3; j++) {
//            if(j>0&&nums[j]==nums[j-1]){
//                continue;
//            }
//            /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
//            int min1=nums[j]+nums[j+1]+nums[j+2]+nums[j+3];
//            if(min1>target){
//                break;
//            }
//            /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
//            int max1=nums[j]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3];
//            if(max1<target){
//                continue;
//            }
//
//            for (int i = j+1; i < nums.length; i++) {
//                if(i>j+1&&nums[i]==nums[i-1]){
//                    continue;
//                }
//
//                /*获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏*/
//                int min2=nums[j]+nums[i]+nums[i+1]+nums[i+2];
//                if(min1>target){
//                    break;
//                }
//                /*获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略*/
//                int max2=nums[j]+nums[i]+nums[nums.length-1]+nums[nums.length-2];
//                if(max1<target){
//                    continue;
//                }
//
//                //选取前后两个指针
//                int l = i + 1, r = nums.length - 1;
//                while (l < r) {
//                    //如果三个数相加为0，则需要对指针的边界去重
//                    if (nums[l] + nums[r] + nums[i]+nums[j] == target) {
//                        //如果左边指针数值重复，则将指针移到重复中最右边的一个
//                        while (l + 1 < nums.length && nums[l] == nums[l + 1]) {
//                            l++;
//                        }
//                        //如果右边指针数值重复，则将指针移到重复中最左边的一个
//                        while (r - 1 > 0 && nums[r] == nums[r - 1]) {
//                            r--;
//                        }
//
//                        List<Integer> integers = new ArrayList<>();
//                        integers.add(nums[j]);
//                        integers.add(nums[i]);
//                        integers.add(nums[l]);
//                        integers.add(nums[r]);
//
//                        list.add(integers);
//                        //缩小指针范围，对现有的i再从新的指针范围中取值判断
//                        l++;
//                        r--;
//                    } else if (nums[l] + nums[r] + nums[i]+nums[j]  < target) {
//                        //将左边指针往右移
//                        l++;
//                    } else {
//                        //将右边指针往左移
//                        r--;
//                    }
//                }
//            }
//        }
//        return list;
//    }

    public static void main(String[] args) {
        AddThreeNum addThreeNum = new AddThreeNum();
        List<List<Integer>> lists = addThreeNum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}

