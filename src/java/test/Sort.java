package test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 谭春
 * Date: 2019/9/11
 * Description:
 */
public class Sort {
    public static int[] bubbleSort(int[] a){
        int temp=0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i-1; j++) {
                if (a[j]>a[j+1]){
                    temp=a[j+1];
                    a[j+1]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a;
    }
    public static int[] selectSort(int[] a){

        for (int i = 0; i < a.length-1; i++) {
            int minIndex=i;
            int minValue=a[i];
            for(int j = i+1; j < a.length; j++) {
                if (a[j]<minValue){
                    minValue=a[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                a[minIndex]=a[i];
                a[i]=minValue;
            }
        }
        return a;
    }
    public static int[] insertSort(int[] a){
//        for (int i = 1; i < a.length; i++) {
//            int temp= a[i];
//            int minIndex=i;
//            for (int j = i-1; j>=0; j--) {
//                if (a[j]>temp){
//                    a[j+1]=a[j];
//                    minIndex=j;
//                }
//            }
//            if(minIndex!=i){
//                a[minIndex]=temp;
//            }
//        }
//        return a;

        for (int i = 1; i < a.length; i++) {
            int minIndex = i;
            int minValue = a[i];
            if (a[i] < a[i - 1]) {
                while (minIndex - 1 >= 0 && minValue < a[minIndex - 1]) {
                    a[minIndex] = a[minIndex - 1];
                    minIndex--;
                }
                if (minValue != a[i]) {
                    a[minIndex] = minValue;
                }
            }
        }
        return a;
    }
    public static int[] shellSort(int[] a){
        //移位式
        //一共被分作多少组
        for (int gap=a.length/2; gap>0; gap/=2) {
            //这些组排完序需要多少躺
            for (int i = gap;i<a.length; i++) {
                int minIndex=i;
                int minValue=a[i];
//                if (a[minIndex]<a[minIndex-gap]){
                    //跟插入排序类似
                    while (minIndex-gap>=0 && minValue<a[minIndex-gap]){
                        a[minIndex]=a[minIndex-gap];
                        minIndex-=gap;
                    }
                    a[minIndex]=minValue;
//                }
            }
        }
        return a;
    }
    public static int[] quickSort(int[] num, int left, int right) {
        //如果left等于right，即数组只有一个元素，直接返回
        if(left>=right) {
            return num;
        }
        //设置最左边的元素为基准值
        int key=num[left];
        //数组中比key小的放在左边，比key大的放在右边，key值下标为i
        int i=left;
        int j=right;
        while(i<j){
            //j向左移，直到遇到比key小的值
            while(num[j]>=key && i<j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while(num[i]<=key && i<j){
                i++;
            }
            //i和j指向的元素交换
            if(i<j){
                int temp=num[i];
                num[i]=num[j];
                num[j]=temp;
            }
        }
        num[left]=num[i];
        num[i]=key;
        quickSort(num,left,i-1);
        quickSort(num,i+1,right);
        return num;
    }
    public static void mergeSort(int[] num, int left, int right, int[] temp){
        if (left<right){
            int mid=(left+right)/2;
            //向左递归进行分解
            mergeSort(num,left,mid,temp);
            //向右递归进行分解
            mergeSort(num,mid+1,right,temp);
            //合并
            merge(num,left,mid,right,temp);
        }
    }
    public static int[] merge(int[] num, int left, int mid, int right, int[] temp){
        int i=left; //初始化i，左边有序序列的初始索引
        int j=mid+1; //初始化j，右边有序序列的初始索引
        int t=0;  //指向temp数组的当前索引
        //1
        //先把左右两边(有序)的数组按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (i<=mid && j<=right){
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即将左边的当前元素，拷贝到temp数组
            //然后i++,t++
            if (num[i]<num[j]){
                temp[t]=num[i];
                i+=1;
                t+=1;
            }else {
                temp[t]=num[j];
                t+=1;
                j+=1;
            }
        }
        //2
        //把剩余数据的一边的数据全部填充到temp

        while (i<=mid){
            temp[t]=num[i];
            i+=1;
            t+=1;
        }
        while (j<=right){
            temp[t]=num[j];
            j+=1;
            t+=1;
        }
        //3
        //将temp数组的元素拷贝到num
        //注意，并不是每次都拷贝所有
        t=0;
        int tempLeft=left;
        //第一次合并tL=0,right=1 //tL=2,right=3 //tL=0,right=3
        //最后一次 tL=0,right=7
        while (tempLeft<=right){
            num[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
        return num;
    }

    public static void  heapSort(int[] n){
        int temp=0;
        System.out.println(Arrays.toString(n));
        //循环每一个i,将数组调整成完全大根堆
        for (int i = n.length/2-1; i >=0 ; i--) {
            adjustHeap(n,i,n.length);
        }

        for (int j = n.length - 1; j>0;j--) {
            //交换
            temp=n[j];
            n[j]=n[0];
            n[0]=temp;
            adjustHeap(n,0,j);
        }
        System.out.println(Arrays.toString(n));
    }

    /**
     * 功能：完成将以i对应的非叶子节点的数调整成大顶堆
     * @param arr  待调整的数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp=arr[i]; //先取出当前元素的值，保存在临时变量
        //开始调整
        //1.k=i*2+1 k是i节点的左子节点
        for (int k = i*2+1; k <length ; k=k*2+1) {
            //判断左子节点的值和右子节点的值大小，取较大值
                if (k+1<length && arr[k]<arr[k+1]){
                    k++;
                }
            //如果子节点大于父节点，把较大的值赋给当前节点i的值,然后i指向k,继续循环比较
                if(arr[k] >temp){
                    arr[i]=arr[k];
                    i=k;
                }else {
                    //如果下面是有序的就跳出本轮循环
                    break;
                }
//            arr[i]=temp;
        }
        //当for循环结束后，我们已经将以i为父节点的最大值放在了堆顶
        arr[i]=temp;
    }



    public static void main(String[] args) {
        int[] a={8,7,6,5,4,3,2,1};

        heapSort(a);
        //冒泡
//        int[] ints = bubbleSort(a);
        //选择
//        int[] ints = selectSort(a);
        //插入
//        int[] ints = insertSort(a);
        //希尔
//        int[] ints = shellSort(a);
        //快速
//        int[] ints = quickSort(a, 0, a.length - 1);
        //归并
//        int[] temp = new int[a.length];
//        mergeSort(a,0,a.length-1,temp);
//        System.out.println(Arrays.toString(a));
//

//
//        int[] arr = new int[80000];
//        for (int i = 0; i < 80000; i++) {
//            arr[i]=(int)(Math.random() * 8000000);
//        }
//        Date date1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format1 = simpleDateFormat.format(date1);
//        System.out.println("排序前的时间="+format1);
//        quickSort(arr,0,arr.length-1);
//        Date date2 = new Date();
//        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format2 = simpleDateFormat1.format(date2);
//        System.out.println("排序前的时间="+format2);
//        System.out.println(Arrays.toString(a));
    }
}

