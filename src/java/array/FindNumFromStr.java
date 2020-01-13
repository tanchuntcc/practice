package array;

/**
 * Created By TanChun On 2019/7/15
 * Description:在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *  *
 *  * 输入: [3,2,1,5,6,4] 和 k = 2
 *  * 输出: 5
 *  *
 *  * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 *  * 输出: 4
 */
public class FindNumFromStr {
    public int findKthLargest(int[] nums, int k) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return  nums[k-1];
    }
}

