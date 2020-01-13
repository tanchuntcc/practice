package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 谭春
 * Date: 2019/9/12
 * Description:
 */
public class Search {
    public static int maxSize=20;
    public static ArrayList<Integer>  serach(int[] a,int left,int right,int tar){
        ArrayList<Integer> integers = new ArrayList<>();
        if (left>right){
            return new ArrayList<Integer>();
        }
        int mid=(left+right)/2;
        //插值查找法的mid取值
//        mid=left+(right-left)*(tar-a[left])/(a[right]-a[left]);
        if (a[mid]<tar){
            return serach(a,mid+1,right,tar);
        }else if(a[mid]>tar){
            return serach(a,left,mid,tar);
        }else {
            int temp=mid-1;
            while (true){
                if (temp<0 ||a[temp]!=tar){
                    break;
                }
                integers.add(temp);
                temp-=1;
            }
            integers.add(mid);
            temp=mid+1;
            while (true){
                if (temp>a.length-1 ||a[temp]!=tar){
                    break;
                }
                integers.add(temp);
                temp+=1;
            }

        }
        return integers;
    }

    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0]=1;
        f[1]=1;
        for (int i = 2; i <maxSize ; i++) {
            f[i]=f[i-1]+f[i-2];
        }
        return f;
    }
    public static int fibSearch(int[] a,int key){
        //未完待续
        int low=0;
        int high=a.length-1;
        int k=0;//表示斐波那契额分割数值的下标
        int mid=0;//存放mid值
        int f[]=fib();
        //获取斐波那契分割数值的下标
        while (high>f[k]-1){
            k++;
        }
        int[] temp=Arrays.copyOf(a,f[k]);
        for (int i = high+1; i <temp.length ; i++) {
            temp[i]=a[high];
        }
        //使用while来循环处理，找到我们的数key
        while (low<=high){
            mid=low+f[k-1]-1;
            if (key<temp[mid]){
                high=mid-1;
                k--;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] a={1,2,3,4,4,4,5,6,6,6};
        ArrayList<Integer> serach = serach(a, 0, a.length - 1, 1);
        if (serach.size()==0){
            System.out.println(-1);
        }else {
            System.out.println(serach);
        }
    }
}

