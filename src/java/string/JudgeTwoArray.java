package string;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by TanChun on 2019/2/13.
 * 比较两个数组中字符是否相同,不管顺序
 */
public class JudgeTwoArray {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] sArray = new int[26];
        int[] tArray = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i)-97] ++;
            tArray[t.charAt(i)-97] ++;
        }

        for (int i = 0; i < 26; i++)
            if (sArray[i]!=tArray[i])
                return false;

        return true;
    }
}
