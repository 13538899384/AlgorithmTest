package MeiTuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 你打开了美了么外卖，选择了一家店，你手里有一张满X元减10元的券，店里总共有n种菜，第i种菜一份需要Ai元，
 * 因为你不想吃太多份同一种菜，所以每种菜你最多只能点一份，现在问你最少需要选择多少元的商品才能使用这张券。
 * <p>
 * 第一行两个正整数n和X，分别表示菜品数量和券的最低使用价格。（1≤n≤100, 1≤X≤10000）
 * <p>
 * 接下来一行n个整数，第i个整数表示第i种菜品的价格。（1≤Ai≤100）
 * <p>
 * 一个数，表示最少需要选择多少元的菜才能使用这张满X元减10元的券，保证有解。
 * Created by XQM on 2018/10/9.
 */
public class WaiMaiDiscount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] mAi = new int[n];
        for (int i = 0; i < n; i++) {
            mAi[i] = sc.nextInt();
        }

        getMinMoney(mAi, x);
    }

    private static void getMinMoney(int[] array, int x) {
        int minSum = x;
        int sum = 0;
        int tmp = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (sum >= x) {
                sum = array[i];
                list.add(sum);

            } else {
                sum += array[i];
                i--;
            }
        }
        System.out.println(list);

    }
}
