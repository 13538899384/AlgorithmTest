package ShenXinFu;

import java.util.Scanner;

/**
 * Created by XQM on 2018/9/21.
 */
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        System.out.println(getMinSumTime(array));
    }

    private static int getMinSumTime(int[] array) {
        int minSum = array[0];
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (sum >= 0) {
                sum = array[i];
            } else {
                sum += array[i];
            }

            if (sum < minSum) {
                minSum = sum;
            }
        }

        return minSum;
    }

}
