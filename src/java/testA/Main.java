package testA;

import java.util.Scanner;

/**
 * @author 谭春
 * Date: 2020/5/27
 * Description:
 */
public class Main {
    public static int findBadWine(int n, int target) {
        int left = 1;
        int right = n;
        int num = 0;
        int mid;
        while (left < right) {
            num++;
            if ( (right - left) % 2 == 0 && target == right) {
                return num;
            }
            if ( (right - left) % 2 == 0){
                right--;
            }
            mid = (right + left) / 2;
            if (target <= mid) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(findBadWine(a, b));
    }
}

