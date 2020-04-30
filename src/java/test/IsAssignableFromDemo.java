package test;

/**
 * @author 谭春
 * Date: 2020/4/28
 * Description:
 */
public class IsAssignableFromDemo {
    static class Father{}
    static class Child extends Father{}

    public static void main(String[] args) {
        Father father = new Father();
        Child child = new Child();
        //instanceof 用法
        boolean b1 = father instanceof Child;
        boolean b2 = child instanceof Father;
        boolean b3 = child instanceof Child;
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        //isAssignableFrom用法
        boolean a1 = Father.class.isAssignableFrom(Child.class);
        boolean a2 = Child.class.isAssignableFrom(Father.class);
        boolean a3 = Father.class.isAssignableFrom(Father.class);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
    }
}

