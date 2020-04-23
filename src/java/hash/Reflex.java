//package hash;
//
//import javax.security.auth.login.Configuration;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//
///**
// * @author 谭春
// * Date: 2020/4/20
// * Description:
// */
//public class Reflex {
//    private Integer age;
//    public String   name;
//
//    public Reflex() {
//    }
//
//    public Reflex(Integer age, String name) {
//        this.age = age;
//        this.name = name;
//    }
//    public int testMethod(int a){
//        return a;
//    }
//
//    public static void main(String[] args) {
//        //方法一：通过实例对象获取类对象
//        Reflex reflex1 = new Reflex(1,"tcc");
//        Class<? extends Reflex> aClass = reflex1.getClass();
//        //方法二：通过类名.class获取类对象
//        Class<Reflex> reflexClass = Reflex.class;
//        //方法三：通过Class.forName("全类名")获取类对象
//        try {
//            Class<?> reflex = Class.forName("hash.Reflex");
//            if (aClass==reflexClass && aClass==reflex) {
//                System.out.println("类对象是唯一的");
//            }
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        //获取类中方法(不包括父类方法)
//        Method[] declaredMethods = reflexClass.getDeclaredMethods();
//        //获取类中方法(包含父类的public方法)
//        Method[] methods = reflexClass.getMethods();
//        try {
//            Method method = reflexClass.getDeclaredMethod("testMethod", int.class);
//            method.setAccessible(true);
//            //通过method方法和对象实例调用方法
//            Integer invoke = (Integer) method.invoke(reflex1,1);
//            System.out.println(invoke);
//            //获取方法名
//            String name = method.getName();
//            //获取方法返回值类型
//            Class<?> returnType = method.getReturnType();
//            //获取方法参数类型
//            Class<?>[] parameterTypes = method.getParameterTypes();
//            //获取方法访问修饰符
//            int modifiers = method.getModifiers();
//
//            //方法是否包含Bean注解
//            boolean annotationPresent = method.isAnnotationPresent(Bean.class);
//            //获取Bean注解的名字
//            Bean bean = method.getAnnotation(Bean.class);
//        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//        //获取类中的属性
//        Field[] declaredFields = reflexClass.getDeclaredFields();
//        Field[] fields = reflexClass.getFields();
//        try {
//            Field field = reflexClass.getDeclaredField("name");
//            //设置属性为可访问
//            field.setAccessible(true);
//            //获取属性的值
//            Object o = field.get(reflex1);
//            //修改属性的值
//            field.set(reflex1,"tcc1");
//            //属性是否包含Bean注解
////            boolean annotationPresent = field.isAnnotationPresent(Autowired.class);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
