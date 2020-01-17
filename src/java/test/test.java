package test;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 谭春
 * Date: 2019/10/22
 * Description:
 */
public class test {

    static  int hash(int h) {
        final HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        return (h ==0) ? 0 : h ^ (h >>> 16);
    }
    public static void main(String[] args) {
        System.out.println(hash(4^(4>>>16)));
        System.out.println(2);
    }
}

