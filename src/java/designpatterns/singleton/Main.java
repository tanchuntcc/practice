package designpatterns.singleton;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
     	while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        System.out.println(a);  
    }
}