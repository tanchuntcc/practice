package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 谭春
 * Date: 2020/4/11
 * Description:
 */
public class ExceptionA {
        public void test() throws Exception{
//            try {
            new ArrayList<>();
            new Hashtable<>();
            new HashSet<>();
            new ConcurrentHashMap<>();
                System.out.println("开始");
                throw  new Exception("ooo");
//            } catch (Exception e) {
//                System.out.println("出现异常");
//            }finally {
//                System.out.println("finally语句");
//            }
//            System.out.println("结束");
        }
}

