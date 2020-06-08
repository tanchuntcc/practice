package temptest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author 谭春
 * Date: 2020/6/5
 * Description:
 */
public class StringAndInteger {
    public static void main(String[] args) {
        Integer a=1;
        String s1 = a.toString();
        System.out.println(s1+"111");

        String b="1";
        String s = String.valueOf(a);
        System.out.println(s);
        Integer integer = Integer.valueOf(b);
        System.out.println(integer);

        Integer z = null;
        String s2 = String.valueOf(z);
        System.out.println(s2);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+"--"+entry.getValue()) );


    }
}

