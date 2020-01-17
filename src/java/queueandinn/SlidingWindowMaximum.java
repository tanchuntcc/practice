package queueandinn;

import java.util.LinkedList;

/**
 * @author 谭春
 * Date: 2020/1/15
 * Description:
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 *
 * 思路： 遍历数组 L R 为滑窗左右边界 只增不减
 *         双向队列保存当前窗口中最大的值的数组下标 双向队列中的数从大到小排序，
 *         新进来的数如果大于等于队列中的数 则将这些数弹出 再添加
 *         当R-L+1=k 时 滑窗大小确定 每次R前进一步L也前进一步 保证此时滑窗中最大值的
 *         数组下标在[L，R]中，并将当前最大值记录
 *
 */
public class SlidingWindowMaximum {
            public int[] maxSlidingWindow(int[] nums, int k) {
                if(nums==null||nums.length<2){
                    return nums;
                }
                // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
                LinkedList<Integer> list = new LinkedList();
                // 结果数组
                int[] result = new int[nums.length-k+1];
                for(int i=0;i<nums.length;i++){
                    // 保证从大到小 如果前面数小 弹出
                    while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                        list.pollLast();
                    }
                    // 添加当前值对应的数组下标
                    list.addLast(i);
                    // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
                    if(list.peek()<=i-k){
                        list.poll();
                    }
                    // 窗口长度为k时 再保存当前窗口中最大值
                    if(i-k+1>=0){
                        result[i-k+1] = nums[list.peek()];
                    }
                }
                return result;
            }
        }
