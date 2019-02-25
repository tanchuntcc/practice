package array;

/**
 * Created by TanChun on 2019/2/21.
 * 求一个数组中连续数之和最大等于多少
 * 对于一个数组中的一个数x，若是x的左边的数加起来非负，那么加上x能使得值变大，这样我们认为x之前的数的和对整体和是有贡献的。如果前几项加起来是负数，则认为有害于总和。
 * 我们用cur记录当前值, 用max记录最大值，如果cur<0,则舍弃之前的数，让cur等于当前的数字，否则，cur = cur+当前的数字。若cur和大于max更新max。
 */
public class FindGreatSumOfSubArray {
    public int Find(int[] array){
        if(array.length==0)
            return 0;
        int cur=array[0],max=array[0];
        for(int i=1;i<array.length;i++){
            cur=cur>0 ?cur+array[i]:array[i];
            if(max<cur){
                max=cur;
            }
        }
        return max;
    }
}
