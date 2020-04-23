package hash;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WorkHandler implements InvocationHandler {

    //被代理的对象
    private Object object;

    //代理类的构造函数,用于构造被代理类实例
    public WorkHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法之前要干什么------");
        Object invoke = method.invoke(object, args);
        System.out.println("调用方法之后要干什么------");
        return invoke;
    }
    public static void main(String[] args) {
        //被代理的对象
        Hello people = new HelloWorld();
        //代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，代理对象的调用处理程序会调用被代理对象的方法
        InvocationHandler handler = new WorkHandler(people);
        Hello proxy = (Hello)Proxy.newProxyInstance(
                handler.getClass().getClassLoader(),// 传入ClassLoader
                people.getClass().getInterfaces(),// 传入要实现的接口
                handler);//传入处理调用方法的InvocationHandler
        System.out.println(proxy.hello());
    }
}
