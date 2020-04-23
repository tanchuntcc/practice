package test;

/**
 * @author 谭春
 * Date: 2020/4/22
 * Description:
 */
public class binarySearch {
    public static int search(int[] a,int left,int right,int target){
        int mid=(left+right)/2;
        if (left<=right){
            if (a[mid]<target){
                return search(a,mid+1,right,target);
            }else if (a[mid]>target){
                return search(a,left,mid-1,target);
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int search(int[] a,int target) {
        int left=0;
        int right=a.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (a[mid]<target){
                left=mid+1;
            }else if (a[mid]>=target){
                right=mid-1;
            }
        }
        if (left<a.length && a[left]==target){
            return left;
        }
        return -1;
    }

        public static void main(String[] args) {
        int[] ints = {1, 2,2,2, 4, 7, 9, 10};
//        int search = search(ints, 0, ints.length - 1, 9);
//        System.out.println(search);
            int search1 = search(ints, 2);
            System.out.println(search1);
        }
}

