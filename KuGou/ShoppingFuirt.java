package KuGou;

import java.util.Scanner;

/**
 * <p>
 * 小明去附近的水果店买橙子，水果商贩只提供整袋购买，有每袋6个和每袋8个的包装（包装不可拆分）。
 * 可是小明只想购买恰好n个橙子，并且尽量少的袋数方便携带。如果不能购买恰好n个橙子，小明将不会购买。
 * 请根据此实现一个程序，要求：
 * 输入一个整数n，表示小明想要购买n（1≤n≤100）个橙子
 * 输出一个整数表示最少需要购买的袋数，如果不能买恰好n个橙子则输出-1
 * 例如，输入20，输出3。
 * <p>
 *
 * Created by XQM on 2018/9/1.
 */
public class ShoppingFuirt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getMinChenZi(n));
    }

    private static int getMinChenZi(int n) {
        if (n == 10 || n < 6 || n % 2 != 0) {
            return -1;
        }

        if (n % 8 == 0) {
            return n / 8;
        } else {
            return n / 8 + 1;
        }
    }
}
