package string;

import java.util.HashMap;

/**
 * 已同步到博客
 * @author 谭春
 * Date: 2020/3/19
 * Description:给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * 思路：1、使用hashmap，统计重复的字符
 *      2、使用字符数组，统计非重复字符，然后s.lenth()减去非重复字符+1就是回文串长度
 */
public class LongestPalindrome {
    //1、使用hashmap，统计重复的字符
//    public int longestPalindrome(String s) {
//        int count=0;
//        HashMap<Character, Integer> stringIntegerHashMap = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (stringIntegerHashMap.containsKey(c)){
//                count+=2;
//                stringIntegerHashMap.remove(c);
//            }else {
//                stringIntegerHashMap.put(c,1);
//            }
//        }
//        if (stringIntegerHashMap.size() != 0){
//            count++;
//        }
//        return count;
//    }


    //2、使用数组，统计非重复字符，然后s.lenth()减去非重复字符+1就是回文串长度
    public int longestPalindrome(String s) {
        int[] ints = new int[128];
        for (char c : s.toCharArray()) {
            ints[c]++;
        }
        int count=0;
        for (int anInt : ints) {
            if (anInt%2==1) {
                count++;
            }
        }
        return  count==0?s.length():s.length()-count+1;
    }

}

