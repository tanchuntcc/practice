package array;

import java.lang.reflect.Array;
import java.util.*;

/**
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
        List<List<Integer>> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int l=i+1,r=nums.length-1;
            while (l<r){
                if (nums[l]+nums[r]+nums[i]==0) {
                    while (l+1<nums.length && nums[l]==nums[l+1]){
                        l++;
                    }while (r-1>0 && nums[r]==nums[r-1]){
                        r--;
                    }

                    List<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
                    list.add(integers);
                    l++;
                    r--;
                }else if (nums[l]+nums[r]+nums[i]<0){
                    l++;
                }else {
                    r--;
                }
            }
            while (i+1<nums.length && nums[i]==nums[i+1]){
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        AddThreeNum addThreeNum = new AddThreeNum();
        List<List<Integer>> lists = addThreeNum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}

