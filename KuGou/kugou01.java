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
 * Created by XQM on 2018/7/15.
 */
public class kugou01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        System.out.println(getMinChenZi(n));
        getMinChenZi(n);
    }

    private static void getMinChenZi(int n) {
        int yushu = n % 8;// 20 % 8 = 4
        int min = n / 8;// 20 / 8 = 2
        if (yushu == 0) {
            //能够被8整除，说明符合要求
            System.out.print(min);
        } else {
            while (min >= 0) {
                if (yushu % 6 == 0) {
                    //n%8的余数可以被6整除的话说明余数=6
                    System.out.print(min + yushu / 6);
                    return;
                } else {
                    min--;//1
                    yushu += 8;// 12
                }
            }
            System.out.print(-1);
        }
    }
}
