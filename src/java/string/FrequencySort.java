package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * @author 谭春
 * Date: 2020/4/30
 * Description:
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * 示例 1:
 *
 * 输入:
 * "tree"
 *
 * 输出:
 * "eert"
 *
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 示例 2:
 *
 * 输入:
 * "cccaaa"
 *
 * 输出:
 * "cccaaa"
 *
 * 解释:
 * 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 示例 3:
 *
 * 输入:
 * "Aabb"
 *
 * 输出:
 * "bbAa"
 *
 * 解释:
 * 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 */
public class FrequencySort {
//    public String frequencySort(String s) {
//        HashMap<Character, Integer> hashMap = new HashMap<>();
//        //将字符串的字符放入map中
//        for (int i=0;i<s.length();i++){
//            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
//        }
//        //创建优先队列且重写Comparator,实现value降序排列
//        PriorityQueue<Character> maxQueue = new PriorityQueue<>(((o1, o2) ->hashMap.get(o2)-hashMap.get(o1) ));
//        //将map加入优先队列中
//        maxQueue.addAll(hashMap.keySet());
//        StringBuilder res = new StringBuilder();
//        while (!maxQueue.isEmpty()) {
//            //字符重复几次就遍历几遍
//            Character poll = maxQueue.poll();
//            for (int i=0;i<hashMap.get(poll);i++) {
//                res.append(poll);
//            }
//        }
//        return res.toString();
//    }
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //将字符串的字符放入map中
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        //将map的entrySet放入到List中
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        //调用sort排序并重写Comparator方法实现value降序排列
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder res = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            //字符重复几次就遍历几遍
            for (int i = 0; i < entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }
        return res.toString();
    }
}

