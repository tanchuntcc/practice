package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谭春
 * Date: 2020/5/12
 * Description:
 */
public class MapDemo {
    public static void main(String[] args) {
//        HashMap<Integer, String> map = new HashMap<>();
//        map.put(1, "tcc");
//        map.putIfAbsent(2, "tcc2");
//        System.out.println(map);
//        map.putIfAbsent(1, "tccIf");
//        System.out.println(map);
//        map.put(1, "tccPut");
//        System.out.println(map);

//        map.computeIfAbsent(1, v -> "tcc");
//        map.computeIfAbsent(1, v -> "tccIf");
//        System.out.println(map);
//        map.computeIfAbsent(2, v -> null);
//        System.out.println(map);

//        String s="tcc";
//        HashMap<Character, Integer> map = new HashMap<>();
//        //将字符串的字符放入map中
//        for (int i=0;i<s.length();i++){
//            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
//        }
//        System.out.println(map);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,2);
        map.merge(1,5,(v1,v2)->v1+v2);
        map.merge(2,10,(v1,v2)->v2);
        System.out.println(map);

    }
}

