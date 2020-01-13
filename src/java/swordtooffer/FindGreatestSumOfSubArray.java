package swordtooffer;

/**
 * @author 谭春
 * Date: 2019/10/21
 * Description:HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中
 * ,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，
 * 返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * 思路：贪心法。先记录第一个数，再记录累加的数，每一次循环对比较一次大小，将较大的值存入pre,当i前面数之和小于0,从i+1重新开始算，
 * 并和i之前的最大和比较。
 */
public class FindGreatestSumOfSubArray {
//    6,-3,-2,7,-15,1,2,2

    public int FindGreatestSumOfSubArray(int[] array) {
        int pre=array[0];
        int cur=0;
        for (int i = 0; i < array.length; i++) {
            if (cur>0){
                cur+=array[i];
            }else {
                cur=array[i];
            }
            pre=Math.max(cur,pre);
        }
        return pre;
    }
}

