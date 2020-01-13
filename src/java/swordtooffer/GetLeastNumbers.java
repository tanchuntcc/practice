package swordtooffer;

import java.util.ArrayList;

/**
 * @author 谭春
 * Date: 2019/10/21
 * Description:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 思路：通过堆排序，构建最小堆，再将最小数从堆顶拿出来放在堆尾，输入的数组长度也逐渐递减。当输入的数组长度为0时即排序好，
 * 本题中只需要遍历k次。
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        if (k>input.length){
            return integers;
        }
        for (int i=input.length/2-1;i>=0;i--){
            Heap(i,input.length,input);
        }

        for (int z=input.length-1;z>=input.length-k;z--){
            integers.add(input[0]);
            int temp=input[0];
            input[0]=input[z];
            input[z]=temp;
            Heap(0,z,input);
        }

        return integers;
    }
    public void Heap(int k,int n,int[] input){
        int temp=input[k];
        for (int i = 2*k+1; i <n ; i=2*k+1) {
            if (i+1<n && input[i]>input[i+1]){
                i++;
            }
            if (input[k]>input[i]){
                input[k]=input[i];
                k=i;
            }else {
                break;
            }
        }
        input[k]=temp;

    }
}

