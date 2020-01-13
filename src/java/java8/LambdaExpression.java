package java8;

import jdk.nashorn.internal.ir.FunctionCall;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * @author 谭春
 * Date: 2019/12/18
 * Description:
 */
public class LambdaExpression {
    public static void main(String[] args) {
        Comparator<Apple> byColor=new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };
        List<Apple> list=Collections.emptyList();
        list.sort(byColor);
        Comparator<Apple> byColor2=(o1,o2)->o1.getColor().compareTo(o2.getColor());

        Function<String,Integer> lambda= s->s.length();
    }
}

