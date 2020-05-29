package testA;

import java.util.Scanner;

class Solution {
    private  static Integer NUM=10;
    
    public static int findNum(int N) {
        int i=1;
        int res = N;
        while(i <= res/NUM){
            int n = res / i % 100;
            i *= NUM;
            if(n/NUM > n % NUM){
                res = res/ i*i -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(findNum(a));
    }
}