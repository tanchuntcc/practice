package test;

/**
 * @author 谭春
 * Date: 2020/4/11
 * Description:
 */
public class ExceptionB {
    public static void main(String[] args) throws Exception {
        ExceptionA exception = new ExceptionA();
            exception.test();

        System.out.println("后面是否正常运行");
    }
}

