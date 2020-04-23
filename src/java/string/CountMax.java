package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by TanChun on 2018/12/12.
 * 统计每个字符出现了几次
 */
public class CountMax {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "hidjahgugahjjaiosdhgbh";
        Map<Character, Integer> map = new <Character, Integer>HashMap();
        int len = s.length();


        for(int i=0; i<s.length();i++) {
            Character k = s.charAt(i);
            map.put(k, (map.get(k) == null ? 1: map.get(k) + 1));
        }

        System.out.println(map);

    }
}
