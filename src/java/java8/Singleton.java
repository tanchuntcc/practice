package java8;

/**
 * @author 谭春
 * Date: 2020/1/17
 * Description:
 */
public class Singleton {
    //1.懒汉式
    private  static  Singleton singleton;

    public Singleton() {
    }
    public static Singleton getInstance(){
        if (singleton==null){
            singleton=new Singleton();
        }
        return singleton;
    }

    //2.饿汉式
//    private static Singleton singleton=new Singleton();
//
//    public Singleton() {
//    }
//    public static Singleton getSingleton(){
//        return singleton;
//    }

    //3.双检锁
//    private static Singleton singleton;
//
//    public Singleton() {
//    }
//
//    public static Singleton getInstance(){
    //在外层写一个判断为了省去其他线程访问Singleton.class的时间
//        if (singleton==null){
//            synchronized (Singleton.class){
//                if (singleton==null){
//                    singleton=new Singleton();
//                }
//            }
//        }
//        return singleton;
//    }

    //4.静态内部类
//    public static class SingletonHolder{
//        private static final Singleton singleton=new Singleton();
//
//        public SingletonHolder() {
//        }
//        public static final Singleton getInstance(){
//            return SingletonHolder.singleton;
//        }
//    }
    //5.枚举型
//    public enum Singleton  {
//        INSTANCE
//
//        //doSomething 该实例支持的行为
//
//        //可以省略此方法，通过Singleton.INSTANCE进行操作
//        public static Singleton get Instance() {
//            return Singleton.INSTANCE;
//        }
//        }
}

