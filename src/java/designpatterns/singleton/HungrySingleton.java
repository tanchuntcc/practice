package designpatterns.singleton;

/**
 * @author 谭春
 * Date: 2020/5/26
 * Description:
 * 优点：线程安全、简单、执行效率高、无锁
 * 缺点：在类加载时候创建对象，占用内存。当单例类的数量不可控的时，内存空间不可控，有风险。
 */
public class HungrySingleton {
    private static HungrySingleton singleton=new HungrySingleton();

    public HungrySingleton() {
    }

    public static synchronized HungrySingleton getInstance(){
        return singleton;
    }
}

