package designpatterns.singleton;


/**
 * @author 谭春
 * Date: 2020/3/11
 * Description:
 */
public class Singleton {
    //懒汉式
//    private static Singleton singleton;
//
//    public Singleton() {
//    }
//    public static synchronized Singleton getInstance(){
//       if (singleton==null) {
//           singleton=new Singleton();
//       }
//       return singleton;
//    }

    //饿汉式
//    private static Singleton singleton=new Singleton();
//
//    public Singleton() {
//    }
//
//    public static synchronized Singleton getInstance(){
//       return singleton;
//    }


    //静态内部类
//    private static class SingletonHolder {
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
//    public Singleton() {
//    }
//    public static final Singleton getInstance(){
//        return SingletonHolder.INSTANCE;
//    }

    //双重校验锁
    private volatile static Singleton singleton;

    public Singleton() {
    }

    public static Singleton getInstance(){
        if (singleton==null){
            synchronized (Singleton.class){
                if (singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }
}

