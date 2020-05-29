package designpatterns.singleton;

/**
 * @author 谭春
 * Date: 2020/5/26
 * Description:
 * 优点：节约资源、启动快
 * 缺点：线程不安全
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton singleton;

    public LazySimpleSingleton() {
    }
    public static synchronized LazySimpleSingleton getInstance(){
       if (singleton==null) {
           singleton=new LazySimpleSingleton();
       }
       return singleton;
    }
}

