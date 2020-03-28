package array;

import java.util.Arrays;

/**
 * 已同步至博客
 * @author 谭春
 * Date: 2020/3/22
 * Description:给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 *
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例 2:
 *
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * 提示：
 *
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * 思路1.创建频次数组，如果当前频次大于1则后面一位的频次加上前面频次减1,操作数加上当前频次-1个，移动直到所有位频次都为1。
 *     2.对数组进行排序，然后遍历数组，如果当前数和前一个数相等，就将当前数加1，知道所有数不相等。
 */
public class MinIncrementForUnique {
//    public int minIncrementForUnique(int[] A) {
//        //题目限制小于等于40000，假如4万个数的值都为40000，则可能移动到80000
//        int[] ints = new int[80001];
//        for (int i : A) {
//            ints[i]++;
//        }
//        int count=0;
//        //遍历数组，若当前频次大于1，将重复的频次往后移
//        for (int i = 0; i < ints.length; i++) {
//            if (ints[i]>=1){
//                ints[i+1]+=ints[i]-1;
//                count+=ints[i]-1;
//            }
//        }
//        return count;
//    }

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                int temp = A[i];
                A[i] = A[i - 1] + 1;
                count += A[i] - temp;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinIncrementForUnique minIncrementForUnique = new MinIncrementForUnique();
        int i = minIncrementForUnique.minIncrementForUnique(new int[]{2, 2, 2, 1});
        System.out.println(i);
    }
}

