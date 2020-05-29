package base;

import java.util.Arrays;

/**
 * @author 谭春
 * Date: 2020/5/19
 * Description:
 */
public class Exam4 {
    public static void main(String[] args) {
    int i=1;
    String str="hello";
    Integer num=2;
    MyData myData = new MyData();

        int[] arr={1,2,3,4,5};
        System.out.println(i);
        System.out.println(str);
        System.out.println(num);
        System.out.println(Arrays.toString(arr));
        System.out.println(myData.a);
}
public static void change(int j,String s,Integer n,int[] a,MyData m){
        j+=1;
        s+="world";
        n+=1;
        a[0]+=1;
        m.a+=1;
}
}
class MyData{
    int a=10;
}
