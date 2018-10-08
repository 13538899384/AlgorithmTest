package ShenXinFu;

import java.util.Scanner;

/**
 * Created by XQM on 2018/9/21.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arrays = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                arrays[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            getSinglePrice(arrays[i]);
        }
    }

    private static void getSinglePrice(int[] array) {
        if (array.length == 0) {
            return;
        }
        int a1 = array[0];
        int b1 = array[1];
        int v1 = array[2];
        int a2 = array[3];
        int b2 = array[4];
        int v2 = array[5];
        int x = 0, y = 0;
        int x1 = b1 * v2 - b2 * v1;
        int x2 = a2 * b1 - a1 * b2;
        if (x1 == 0 || x2 == 0) {
            System.out.println("UNKNOWN");
            return;
        }
        if (x1 % x2 != 0){
            System.out.println("UNKNOWN");
            return;
        }else {
            x = x1 / x2;
        }
        int y1 = a2 * b1 * v1 - a1 * b1 * v2;
        int y2 = a2 * b1 * b1 - a1 * b1 * b2;
        if (y1 == 0 || y2 == 0) {
            System.out.println("UNKNOWN");
            return;
        }
        if (y1 % y2 != 0){
            System.out.println("UNKNOWN");
            return;
        }
        y = y1 / y2;
        if (x == 0 || y == 0 || x < 0 && y > 0 || x > 0 && y < 0) {
            System.out.println("UNKNOWN");
        } else {
            System.out.println(x + " " + y);
        }
    }
}
