package testA;

import java.util.Scanner;

public class QuickSort {
    public static int division(int[] list, int left, int right) {
        int base = list[left];
        while (left < right) {
            while (left < right && list[right] <= base) {
                right--;
            }
            list[left] = list[right];

            while (left < right && list[left] >= base) {
                left++;
            }
            list[right] = list[left];
        }

        list[left] = base;
        return left;
    }

    private static void quickSort(int[] list, int left, int right) {

        if (left < right) {
            int base = division(list, left, right);
            quickSort(list, left, base - 1);
            quickSort(list, base + 1, right);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();

        int[] array = new int[a];
        for (int i = 0; i < a; i++) {
            array[i] = in.nextInt();
        }

        quickSort(array, 0, a - 1);

        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }
}
