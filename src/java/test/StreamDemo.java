package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 谭春
 * Date: 2020/4/15
 * Description:
 */
public class StreamDemo {
    public static void main(String[] args) {
//        List<Integer> integers = new ArrayList<>();
//        integers.add(3);
//        integers.add(1);
//        integers.add(1);
//        integers.add(2);
//        integers.add(4);
//        integers.add(5);
//        //取出list中重复的元素,System.out::println与integer-> System.out.println(integer)等价
//        integers.stream().distinct().forEach(System.out::println);
//        //过滤掉list中大于等于4的元素
//        integers.stream().filter(integer -> integer<4).forEach(System.out::println);
//        //跳过前三个元素
//        integers.stream().skip(3).forEach(System.out::println);
//        //取出前三个元素
//        integers.stream().limit(3).forEach(System.out::println);
//        //对集合中的元素进行排序
//        integers.stream().sorted().forEach(System.out::println);
//        //集合元素的个数
//        System.out.println(integers.stream().count());
//        //将集合中的元素都变为以前的二次方
//        integers.stream().map(integer -> integer*integer).forEach(System.out::println);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("tcc1",1));
        items.add(new Item("tcc2",2));
        items.add(new Item("tcc3",3));
        items.add(new Item("tcc4",4));
        items.add(new Item("tcc5",1));
        items.add(new Item("tcc3",2));
        Map<String, Integer> map = items.stream().collect(Collectors.toMap(Item::getName, Item::getAge,(l1,l2)->l2));
        System.out.println(map);
//      //取出items中name元素，并存入set集合Item::getName等价于item->item.getName()
//        Set<String> groupCodes = items.stream().map(Item::getName).collect(Collectors.toSet());
//        System.out.println(groupCodes);
////      //取出items中name和age分别作为key和value,放入map
//
//        //将集合以年龄排序,返回年龄 和 年龄对应的集合的map
//        Map<Integer, List<Item>> collect = items.stream().collect(Collectors.groupingBy(Item::getAge));
//        System.out.println(collect);
//        //将集合以年龄排序,返回年龄和 年龄中对应集合中的name集合的map
//        Map<Integer, Set<String>> collect1 = items.stream().collect(
//                Collectors.groupingBy(Item::getAge,
//                        Collectors.mapping(Item::getName, Collectors.toSet())));
//        System.out.println(collect1);
    }
}

