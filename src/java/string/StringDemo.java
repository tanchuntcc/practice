package string;

/**
 * @author 谭春
 * Date: 2020/5/25
 * Description:
 */
public class StringDemo {
    public static void main(String[] args) {
        String s1 = new StringBuilder("go")
                .append("od").toString();
        System.out.println(s1.intern() == s1);
        String s2 = new StringBuilder("ja")
                .append("va").toString();
        System.out.println(s2.intern() == s2);


        String  a = "abc";
        String test1 = new String("abc");
        System.out.println(a == test1);


        String b = "ab";
        String c ="c";
        String test2 = b+c;
        System.out.println(a == test2);

        String test3 = "ab"+"c";
        System.out.println(a == test3);

        final String d ="ab";
        String test4 = d+"c";
        System.out.println(a == test4);

    }
}

