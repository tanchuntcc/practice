package array;

import java.util.BitSet;

/**
 * @author 谭春
 * Date: 2020/3/26
 * Description:
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 思路：1.双指针法，左右指针同时扫描，如果左边为奇数，右边为偶数，则交换，否则指针向中间靠拢
 */
public class SortArray {
    public int[] sortArrayByParity(int[] A) {
        if (A == null || A.length == 1) {
            return A;
        }
        //左、右指针初始化
        int left = 0;
        int right = A.length - 1;
        int tem;
        while (left < right) {
            //左边为奇数，右边为偶数，互换值
            if ((A[left] & 1) == 1 && (A[right] & 1) == 0) {
                tem = A[left];
                A[left] = A[right];
                A[right] = tem;
            } else if ((A[left] & 1) == 0) {
                //左边为偶数，指针向右移动
                left++;
            } else if ((A[right] & 1) == 1) {
                //右边为奇数，指针向左移动
                right--;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        final BitSet bitSet = new BitSet();
//        a[31>>5] |= 1 << (31 & 0x1F)
    }
}

