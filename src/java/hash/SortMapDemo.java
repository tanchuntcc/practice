package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author 谭春
 * Date: 2020/4/30
 * Description:
 */
public class SortMapDemo {
    private static void getKeySet(Map<Integer,Integer> map){
        //获取map的key的集合
        Set<Integer> keySet = map.keySet();
        //遍历输出key
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next+":"+map.get(next));
        }
    }
    private static void getEntrySet(Map<Integer,Integer> map){
        //获取map的entry的集合
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        //遍历输出entry中的key和value
        Iterator<Map.Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey()+":"+next.getValue());
        }
    }
    //将键值对放入list并重写Comparator方法实现对value排序
    private static void sortByValue(Map<Integer,Integer> map) {
        //将键值对放入list中
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        //重写list的排序算法，按照map中的value降序排列
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        //遍历list输出键值
        for (Map.Entry<Integer, Integer> e: list) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
    //使用treeMap实现按照key排序
    private static void sortByKey(Map<Integer,Integer> map) {
        Map<Integer,Integer> treeMap = new TreeMap<>(map);
        //实现按照key倒序排列
        treeMap = ((TreeMap<Integer, Integer>) treeMap).descendingMap();
        //遍历list输出键值
        for (Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
            System.out.println(e.getKey()+":"+e.getValue());
        }
    }
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(3, 3);
        map.put(2, 1);
        System.out.println("getKeySet");
        getKeySet(map);
        System.out.println("getEntrySet");
        getEntrySet(map);
        System.out.println("sortByValue");
        sortByValue(map);
        System.out.println("sortByKey");
        sortByKey(map);
    }
}

