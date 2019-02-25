package arithmetic;

/**
 * Created by TanChun on 2019/2/13.
 * 给出一个数，求连续的数之和等于它
 */
public class CountContinuous {
    //    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
//        int l = 1;
//        int r = 2;
//        int totalSum = 3;
//        int mid = (sum+1)/2;
//        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
//        while(l<mid){
//            if(sum==totalSum){
//                ArrayList<Integer> subList = new ArrayList<Integer>();
//                for(int i=l; i<=r; i++){
//                    subList.add(i);
//                }
//                ret.add(subList);
//            }
//            if(sum<totalSum){
//                totalSum -= l;
//                l++;
//            }
//            else{
//                r++;
//                totalSum += r;
//            }
//        }
//        return ret;
//    }
//
//    public static void main(String[] args) {
//        TopK solution = new TopK();
//        ArrayList<ArrayList<Integer>> arrayLists = solution.FindContinuousSequence(9);
//        System.out.println(arrayLists);
//    }
    public static void geta( int num) {
        int sum = 0;
        for (int n = 1; n < num; n++) {
            for (int i = n + 1; i < num; i++) {
                sum = addNum(i, n);
                if (sum == num) {
                    while (i>=n){
                        System.out.print(n);
                        n++;
                    }
                }
            }
        }
    }
    public static int addNum(int n,int min){
        if(n==min){
            return  min;
        }else {
            return  n+addNum(n-1,min);
        }
    }
    public static void main(String[] args) {
        geta(31);
    }
}
