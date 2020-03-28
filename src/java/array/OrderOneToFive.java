package array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author 谭春
 * Date: 2020/3/18
 * Description:编写程序解决以下问题：长度为200的数组，随机放入值为1-50中间的任意整数，
 * 请编写程序找出其中的偶数数字，并按照该数字在数组中出现次数从多到少排序输出
 */
public class OrderOneToFive {
    public static ArrayList<Map.Entry<Integer,Integer>> sortMap(Map map){
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> obj1 , Map.Entry<Integer, Integer> obj2) {
                return obj2.getValue() - obj1.getValue();
            }
        });
        return (ArrayList<Map.Entry<Integer, Integer>>) entries;
    }
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> integers1 = new ArrayList<>(200);
        for (int j = 0; j < 200; j++) {
            integers1.add(random.nextInt(50));
            System.out.println(random.nextInt(50));
        }
        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();

        Iterator<Integer> iterator = integers1.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item%2==1) {
                iterator.remove();
            }else {
                if (integerIntegerTreeMap.containsKey(item)) {
                    integerIntegerTreeMap.put(item,integerIntegerTreeMap.get(item)+1);
                }else {
                    integerIntegerTreeMap.put(item,1);
                }
            }
        }

        ArrayList<Map.Entry<Integer, Integer>> entries = sortMap(integerIntegerTreeMap);
        System.out.println("====================");
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey() +":" + entry.getValue());

        }



    }
}

