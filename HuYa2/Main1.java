package HuYa2;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0;i < n;n++){
            for (int j = 0;j < m;m++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(solve(a));
    }

    private static int solve(int[][] a) {
        return 0;
    }
}
