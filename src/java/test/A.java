package test;

import java.io.BufferedReader;
import java.io.File;

/**
 * @author 谭春
 * Date: 2020/4/28
 * Description:
 */
public class A {
    public static void main(String[] args) {
        File file = new File("E:/Code/practice/src/java");
        file(file);


    }
    public static void file(File file){
        for (File file1 : file.listFiles()) {
            if (file1.isFile()) {
                System.out.println(file1.getName());
            }else {
               file(file1);
            }
        }
    }
}

