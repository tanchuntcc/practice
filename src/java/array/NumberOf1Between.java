package array;

/**
 * Created by TanChun on 2019/2/21.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数
 */
public class NumberOf1Between {
    public int NumberOf1(int n){
        int res=0;
        for(int i=1;i<=n;i++){
            res+=number1(i);
        }
        return res;
    }
    public int number1(int n){
        int res=0;
        while (n>0){
            if(n%10==1)
                res++;
            n/=10;
        }
        return res;
    }
}
