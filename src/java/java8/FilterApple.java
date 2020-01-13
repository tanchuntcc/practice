package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 谭春
 * Date: 2019/12/18
 * Description:
 */
public class FilterApple {

    public interface AppleFilter{
        boolean filter(Apple apple);
    }
    public static List<Apple> findApple(List<Apple> apples,AppleFilter appleFilter){
        ArrayList<Apple> list = new ArrayList<>();
        for (Apple apple:apples){
            if (appleFilter.filter(apple)){
                list.add(apple);
            }
        }
        return list;
    }
    public static class GreenAnd150WeightFilet implements AppleFilter{

        @Override
        public boolean filter(Apple apple) {
            return (apple.getColor().equals("green")&&apple.getWeight()>=150);
        }
    }

    public static List<Apple> findGreenApple(List<Apple> apples){
        List<Apple> list = new ArrayList<>();
        for (Apple apple:apples) {
            if("green".equals(apple.getColor())){
                list.add((apple));
            }
        }
        return list;
    }
    public  static  List<Apple> findApple(List<Apple> apples,String color){
        List<Apple> list = new ArrayList<>();
        for (Apple apple:apples) {
            if(color.equals(apple.getColor())){
                list.add((apple));
            }
        }
        return list;
    }


    public static void main(String[] args) {
//        List<Apple> list= Arrays.asList(new Apple("green",150),new Apple("red",100));
//        List<Apple> greenApples=findGreenApple(list);
//        System.out.println(greenApples);
//        List<Apple> gre=findApple(list,"red");
//        System.out.println(gre);
//
//        List<Apple> re=findApple(list,new GreenAnd150WeightFilet());
//        System.out.println(re);
//
//        List<Apple> yellowList=findApple(list, new AppleFilter() {
//            @Override
//            public boolean filter(Apple apple) {
//                return "red".equals(apple.getColor());
//            }
//        });
//        System.out.println(yellowList);
//        List<Apple> lmbda=findApple(list,apple->{
//          return apple.getColor().equals("green");
//        });
//        System.out.println(lmbda);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(()-> System.out.println(Thread.currentThread().getName()));

    }
}

