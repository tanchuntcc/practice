package hash;

public class HelloWorld implements Hello {
    @Override
    public String hello() {
        System.out.println("执行代理对象的方法");
        return "返回代理对象的结果";
    }
}
