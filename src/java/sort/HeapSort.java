package sort;

/**
 * Created by TanChun on 2019/1/14.
 * 堆排序
 */
public class HeapSort {
    public  void  setHeap(int [] array,int parent,int length){
        int temp=array[parent];
        int child=parent*2+1;
        while (length>child){
                if(child+1<length && array[child]<array[child+1]){
                    child++;
                }
                if(temp>=array[child]){
                break;
                }
            array[parent]=array[child];
                parent=child;
                child=2*child+1;
        }
        array[parent]=temp;

    }
    public  void getHeap(int[] list) {
        for (int i = list.length  / 2; i >= 0; i--) {
            setHeap(list, i, list.length);
        }
        // 进行n-1次循环，完成排序
        for (int i = list.length - 1; i > 0; i--) {
            // 最后一个元素和第一元素进行交换
            int temp = list[i];
            list[i] = list[0];
            list[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            setHeap(list, 0, i);
            System.out.format("第 %d 趟: \t", list.length - i);
            printPart(list, 0, list.length - 1);

        }
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
                    1, 3, 4, 5, 2, 6, 9, 7, 8, 0
            };

            // 调用快速排序方法
            HeapSort heap = new HeapSort();
            System.out.print("排序前:\t");
            heap.printPart(array, 0, array.length - 1);
            heap.getHeap(array);
            System.out.print("排序后:\t");
            heap.printPart(array, 0, array.length - 1);
        }
    }


