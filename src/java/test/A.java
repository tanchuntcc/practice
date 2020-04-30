package test;

/**
 * @author 谭春
 * Date: 2020/4/28
 * Description:
 */
public class A {
    public static void main(String[] args) {
        String string="a:3;b:5;c:2@a:2;b:1@e:1";
        String replace = string.replace("@", ";");
        System.out.println(replace);
    }
}

