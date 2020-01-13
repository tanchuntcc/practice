package java8;

import java.util.function.Predicate;

/**
 * @author 谭春
 * Date: 2019/12/17
 * Description:
 */
public class test {
    public static void main(String[] args) {
        Predicate<Integer> predicate=x->x>5;
        System.out.println(predicate.test(10));
    }
}

