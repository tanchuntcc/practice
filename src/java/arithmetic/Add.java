package arithmetic;

import java.util.Scanner;

/**
 * @author 谭春
 * Date: 2020/3/25
 * Description:
 */
public class Add {
    public static void add(String str, int temp,int n) {
        str += temp + "+";
        System.out.println(str + n);
        for (int i = temp; i <= n - 1; i++) {
            if (2*i <= n) {
                add(str, i, n - i);
            }
        }
    }
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        final int n = scanner.nextInt();
        String string="";
        for (int i=1;i<=n/2;i++) {
            add(string, i, n-i);
        }
    }
}

