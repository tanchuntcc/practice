package string;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class FindCenterNum {
    public int pivotIndex(int[] nums) {
        int leftnum=0, rightnum=0;
        for (int a:nums) {
            rightnum+=a;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(rightnum==nums[i]+2*leftnum){
                return i;
            }
            leftnum+=nums[i];
        }
        return -1;

    }

    public static void main(String[] args) {
       int[] a={1,2,3,5,2,4};
        FindCenterNum findCenterNum = new FindCenterNum();
        System.out.println(findCenterNum.pivotIndex(a));
    }

}
