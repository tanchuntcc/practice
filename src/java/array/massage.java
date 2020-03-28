package array;

import java.util.BitSet;

/**
 * 已同步至博客
 * @author 谭春
 * Date: 2020/3/24
 * Description:
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * 思路1.动态规划法，最大的序列和为 Max(前一位之前最大的数,前两位之前最大的数加上现在着这个数)
 */
public class massage {
//    public int massage(int[] nums) {
//        int[] dp = new int[nums.length];
//        if (nums.length == 0) {
//            return 0;
//        }
//        if (nums.length == 1) {
//            return nums[0];
//        }
//
//        dp[0] = nums[0];
//        dp[1] = Math.max(dp[0], nums[1]);
//        //最大的序列和为 Max(前一位之前最大的数,前两位之前最大的数加上现在着这个数)
//        for (int i = 2; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
//        }
//        return dp[nums.length - 1];
//
//    }

    public int massage(int[] nums) {
        int fast = 0, slow = 0;
        //fast为往前一位  slow为往前两位
        for (int i = 0; i < nums.length; i++) {
            int dp = Math.max(fast, slow + nums[i]);
            slow = fast;
            fast = dp;
        }
        return fast;
    }

}


