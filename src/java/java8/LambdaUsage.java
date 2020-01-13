package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author 谭春
 * Date: 2019/12/18
 * Description:
 */
public class LambdaUsage {
    private List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result=new ArrayList<>();
        for (Apple a:source){
            if (predicate.test(a)){
                result.add(a);
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        Runnable r1=()-> System.out.println("Hello");
//        Runnable r2=new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello");
//            }
//        };
//        process(r1);
//        process(r2);
//        process(()->System.out.println("Hello"));


    }

    private static void process(Runnable r){
        r.run();
    }
}

