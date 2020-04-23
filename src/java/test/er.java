package test;

import java.util.LinkedList;

/**
 * @author 谭春
 * Date: 2020/3/30
 * Description:
 */
public class er {
    public static void main(String[] args) {
        System.out.println(2);
new LinkedList<>();
        for (int i = 3; i < 100; i++) {
            boolean isZ=false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j==0){
                    isZ=true;
                }
            }

            if (isZ==false){
                System.out.println(i);
            }

        }
    }
}

