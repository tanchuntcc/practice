package array;

import sort.HeapSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 已同步到博客
 * @author 谭春
 * Date: 2020/3/21
 * Description:输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 * 思路 1.暴力法，对数组进行排序，然后遍历取前K个数。
 * 2.建立一个大根堆求前k小。
 * 3.可以使用优点队列来实现。
 * 4.使用快排思想，只需要排好前面K个数就好。
 * 5.数据有限时，使用频率数组。
 *
 */
public class TopK {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        if ( k==0 || arr.length==0){
//            return new int[0];
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
//        //优先队列默认为升序排列，重写compare方法为降序排列。使用lombda表示，等价于以下代码
////        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
////            @Override
////            public int compare(Integer o1, Integer o2) {
////                return o2-o1;
////            }
////        });
//
//        for (int i : arr) {
//            if (queue.size()<k){
//                queue.offer(i);
//            }else if (queue.peek()>i){ //当优先队列满k个后，取最大值和待放入的值比较，如果待放入值小，则放入。
//                queue.poll();
//                queue.offer(i);
//            }
//        }
//
//        int[] ints = new int[queue.size()];
//        for (int i = 0; i < ints.length; i++) {
//            ints[i]=queue.poll();
//        }
//        return ints;
//    }
//public int[] getLeastNumbers(int[] arr, int k) {
//    Arrays.sort(arr);
//    int[] ints = new int[k];
//    for (int i = 0; i < k - 1; i++) {
//        ints[i]=arr[i];
//    }
//    return ints;
//}


//    public int[] getLeastNumbers(int[] arr, int k) {
//        if (k == 0 || arr.length == 0) {
//            return new int[0];
//        }
//        //k-1为我们要找的基准的下标。
//        return quickSort(arr, 0, arr.length - 1, k - 1);
//    }
//
//    public int[] quickSort(int[] arr, int left, int right, int k) {
//        // 对数组进行分割，取出下次分割的基准标号
//        int division = division(arr, left, right);
//        //如果基准与k正好相等，则返回k左边的部分。
//        if (division == k) {
//            return Arrays.copyOf(arr, k + 1);
//        }
//        // 如果k在基准的右边，则对右段进行递归排序。
//        // 如果k在基准的坐边，则对左段进行递归排序。
//        return division < k ? quickSort(arr, division + 1, right, k) : quickSort(arr, left, division - 1, k);
//
//    }
//
//    public int division(int[] list, int left, int right) {
//        // 以最左边的数(left)为基准
//        int base = list[left];
//        while (left < right) {
//            // 从序列右端开始，向左遍历，直到找到小于base的数
//            while (left < right && list[right] >= base) {
//                right--;
//            }
//            // 找到了比base小的元素，将这个元素放到最左边的位置
//            list[left] = list[right];
//
//            // 从序列左端开始，向右遍历，直到找到大于base的数
//            while (left < right && list[left] <= base) {
//                left++;
//            }
//            // 找到了比base大的元素，将这个元素放到最右边的位置
//            list[right] = list[left];
//        }
//
//        // 最后将base放到left位置。都比此时，left位置的左侧数值应该left小；
//        // 而left位置的右侧数值应该都比left大。
//        list[left] = base;
//        return left;
//    }
//public int[] getLeastNumbers(int[] arr, int k) {
//    if (k == 0 || arr.length == 0) {
//        return new int[0];
//    }
//    // 统计每个数字出现的次数
//    int[] hash = new int[10001];
//    for (int num : arr) {
//        hash[num]++;
//    }
//    // 根据counter数组从头找出k个数作为返回结果
//    int[] ans = new int[k];
//    int count=0;
//    for (int num = 0; num < hash.length; num++) {
//        if (count == k) {
//            break;
//        }
//        while (hash[num]>0 && k>count){
//            ans[count++]=num;
//            hash[num]--;
//        }
//    }
//    return ans;
//}

    public  int[] getLeastNumbers(int[] arr,int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] ints = Arrays.copyOf(arr, k);
        //构建k个数的大根堆，堆顶为最大的数
        for (int i =ints.length/ 2>3?3:ints.length/ 2; i >= 0; i--) {
            setHeap(ints, i, k);
        }

        //每次取数组中剩下的数与堆顶的数比较
        for (int i = k; i <arr.length; i++) {
            //如果数组中的数比堆顶的数小，则放入堆顶，再构建一次大根堆
            if (ints[0]>arr[i]){
                ints[0]=arr[i];
                setHeap(ints,0,k);
            }
        }
        return ints;
    }

    public  void  setHeap(int [] array,int parent,int length){
        int temp=array[parent];
        int child=parent*2+1;
        //判断父节点
        while (length>child){
            //取出子节点中较大的数的索引
            if(child+1<length && array[child]<array[child+1]){
                child++;
            }
            //如果父节点值大于子节点则不用交换值
            if(temp>=array[child]){
                break;
            }
            //交换父节点和子节点的值
            array[parent]=array[child];
            parent=child;
            child=2*child+1;
        }
        array[parent]=temp;
    }




    public void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }






    public static void main(String[] args) {

        // 初始化一个序列
        int[] array = {
//                5,11,20,0,1, 3, 4, 5, 2, 6, 9, 7, 8, 0
                4,6,8,5,9,1,11,2,52,3
        };

        // 调用快速排序方法
        TopK topK = new TopK();
        int[] leastNumbers = topK.getLeastNumbers(array, 5);
        System.out.print("堆的结构:\t");
        topK.printPart(leastNumbers, 0,  leastNumbers.length-1);


//
//        TopK topK = new TopK();
//        int[] leastNumbers = topK.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4}, 8);
//        System.out.println(leastNumbers.toString());
    }
}

