package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 谭春
 * Date: 2020/3/15
 * Description:
 */
public class ArrayTest {
//    public void f() throws  IOException {
//        String str = "123";
//        str = "abc";
//        int num = 0;
//
//        num = Integer.parseInt(str);
//
//        System.out.println("hello-----1");
//
//        System.out.println(num);
//
//        System.out.println("hello-----2");
//
//        File file = new File("hello.txt");
//        FileInputStream fis = new FileInputStream(file);
//
//        int data = fis.read();
//        while(data != -1){
//            System.out.print((char)data);
//            data = fis.read();
//        }
//
//        fis.close();
//        System.out.println("aaaafege");
//    }
//    public static void main(String[] args) throws IOException {
//        ArrayList<String> arrayList = new ArrayList();
//        arrayList.add("a");
//        arrayList.add("b");
//        arrayList.add("c");
//        arrayList.add("d");
//        arrayList.add("e");
//        arrayList.add("f");
//
//        for (int i = arrayList.size()-1; i >= 0; i--) {
//            arrayList.remove(i);
//        }
//
//        System.out.println(arrayList.size()+arrayList.toString());
//
//        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
//        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
//        ConcurrentHashMap<Object, Object> objectObjectConcurrentHashMap = new ConcurrentHashMap<>();
//        Type type ;
//            String s1 = "runoob";
//            String s2 = "runoob";
//            System.out.println("s1 == s2 is:" + s1 == s2);
//        ArrayTest arrayTest = new ArrayTest();

//            arrayTest.f();
//        System.out.println("aaa");
//arrayTest.ZS(199);
//
//    }
//
//    public void ZS(int n){
//        for (int i =2; i <= n; i++) {
//            boolean flag=false;
//            for (int j = 2; j < Math.sqrt(i); j++) {
//                if (i % j == 0){
//                    flag=true;
//                    break;
//                }
//            }
//            if (!flag) {
//                System.out.println(i + "是质数");
//            }
//        }
//    }
    private  int count=0;
    public void isD(File file){

        File[] files = file.listFiles();
        for (File file1 : files) {
            if (file1.isDirectory()) {
                isD(file1);
            }else {
                System.out.println(file1.getName());
                count++;
            }

        }

    }

    public static void main(String[] args) {
        ArrayTest arrayTest = new ArrayTest();
        File file = new File("D:/百度云盘/Nginx/尚硅谷nginx/笔记资料");
      arrayTest.isD(file);
        System.out.println(arrayTest.count);
    }
}

