package array;

/**
 * Created by TanChun on 2019/2/21.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 */
public class FindSmall {
        public int minNumberInRotateArray(int [] array) {
            int len = array.length;
            if(len == 0)
                return 0;
            int low = 0, high = len - 1;
            while(low < high){
                int mid = low + (high - low) / 2;
                if(array[mid] > array[high]){
                    low = mid + 1;
                }else if(array[mid] == array[high]){
                    high = high - 1;
                }else{
                    high = mid;
                }
            }
            return array[low];
        }
    }
