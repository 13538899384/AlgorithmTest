package Tx;

import java.util.Scanner;

/**
 * Created by XQM on 2018/9/16.
 */


public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int b[] = new int[n];
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            if (a[i] == 1) {
                b[j] = i;
                j++;
                count++;
            }

        }
        int k;
        if (count == 0) {
            k = 0;
        } else {
            k = 1;
            for (int i = j - 1; i > 0; i--) {
                k *= (b[i] - b[i - 1]);

            }
        }
        System.out.println(k);
    }
}
