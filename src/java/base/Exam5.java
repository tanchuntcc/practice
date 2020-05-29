package base;

/**
 * @author 谭春
 * Date: 2020/5/19
 * Description:
 */
public class Exam5 {
public  int s(int n){
    if (n<=2){
        return n;
    }
    return s(n-1)+s(n-2);
}
}

