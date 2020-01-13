package swordtooffer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author 谭春
 * Date: 2019/10/22
 * Description:在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 思路：1.使用hashmap遍历
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str.length()==0) {
            return -1;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))){
                hashMap.remove(str.charAt(i));
                hashMap.put(str.charAt(i),hashMap.get(str.charAt(i))+1);
            }else {
                hashMap.put(str.charAt(i),1);
            }
        }
        int i=0;
        for (; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i))==1){
                break;
            }
        }
        return i;
    }

}

