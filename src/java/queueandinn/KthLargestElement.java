package queueandinn;

import java.util.PriorityQueue;

/**
 * @author 谭春
 * Date: 2020/1/15
 * Description:
 * 设计一个找到数据流中第K大元素的类（class）。注意是排序后的第K大元素，不是第K个不同的元素。
 *
 * 你的 KthLargest 类需要一个同时接收整数 k 和整数数组nums 的构造器，它包含数据流中的初始元素。
 * 每次调用 KthLargest.add，返回当前数据流中第K大的元素。
 *
 * 思路：构造一个优先队列，默认是升序排列，将元素往队列中加，每加一个元素队列都会重新排序。当队满时，
 * 判断队最前面的值（即为最小值）与待插入的值的大小，如果待插入的值大，则将最小值出队，然后将新值插入，。
 */
public class KthLargestElement {
        private int k;
        private PriorityQueue<Integer> queue;
        public KthLargestElement(int k, int[] nums) {
            this.k  = k;
            queue = new PriorityQueue<>();
            if(nums.length <= k) {
                for(int ele:nums) {
                    queue.add(ele);
                }
                }else {
                for(int i = 0;i<k;i++) {
                    queue.add(nums[i]);
                }
                for(int i = k;i<nums.length;i++) {
                    if(queue.peek()<nums[i]) {
                        queue.poll();
                        queue.add(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if(queue.size()<k) {
                queue.offer(val);
            }else if(queue.peek()<val) {
                queue.poll();
                queue.offer(val);
            }
            return queue.peek();
        }

    }

