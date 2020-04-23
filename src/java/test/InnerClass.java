package test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 谭春
 * Date: 2020/4/14
 * Description:
 */
public class InnerClass {
    private String name="tcc";
    public String age="1";
    static Integer id=10;

    public void show1(){
        System.out.println(StaticInner.test);
        System.out.println(name);
        System.out.println(id);
        System.out.println(age);
    }

    public class Inner{
         Integer id=0;
        public void show(){
            show1();
            System.out.println(name);
            System.out.println(age);
            System.out.println(InnerClass.id);
            System.out.println(this.id);
        }
    }
        static class StaticInner{
            Integer s=0;
            static Integer test=10;

            public void show(){
                System.out.println(InnerClass.id);
                System.out.println(s);
                System.out.println(test);
            }
        }


    public static void main(String[] args) {
        InnerClass aClass = new InnerClass();
        Inner inner=aClass.new Inner();
        inner.show();
        System.out.println(StaticInner.test);
        StaticInner staticInner = new StaticInner();
        staticInner.show();
    }
}

