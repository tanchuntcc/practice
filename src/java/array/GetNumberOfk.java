package array;

/**
 * Created by TanChun on 2019/2/21.
 * 统计一个数字在排序数组中出现的次数。
 * 正常的思路就是二分查找了，我们用递归的方法实现了查找k第一次出现的下标，用循环的方法实现了查找k最后一次出现的下标。
 * 除此之外，还有另一种奇妙的思路，因为data中都是整数，所以我们不用搜索k的两个位置，而是直接搜索k-0.5和k+0.5这两个数应该插入的位置，然后相减即可。
 */
public class GetNumberOfk {
    public int GetNumberOfk(int[] array,int k){
        int len=array.length;
        if(len==0)
            return 0;
        int first=getFist(array,k,0,len-1);
        int last=getlast(array,first);
        if(first!=-1 && last!=-1){
            return last-first+1;
        }
        return 0;
    }
    public int getFist(int[] array,int k,int start,int end){
        int mid;
        while (start<=end){
            mid=(start+end)/2;
            if(k<=array[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        if(start<array.length && array[start]==k){
            return start;
        }else {
            return -1;
        }
    }
    public  int getlast(int [] array,int k){
        int z=1;
        z=array[k+1]==array[k]?z:z+1;
        return z;
    }


}
