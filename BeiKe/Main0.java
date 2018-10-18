package BeiKe;

import java.util.Scanner;

/**
 * 题目描述：
 * 有多少长度为N的整数序列A1到AN，满足AN=M，1≤Ai≤M且Ai能整除Ai+1（1≤i<N）？
 * <p>
 * 输入两个空格隔开的整数N和M，1≤N，M≤1000。
 * 输出满足给定条件的整数序列个数对109+7取模后的结果。
 * <p>
 * 输入：3 3
 * 输出：3
 * 提示：满足给定条件的序列为{1 1 3}、{1 3 3}和{3 3 3}。
 * <p>
 * AC 27%
 * Created by XQM on 2018/10/15.
 */
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(getLCM(n, m));
    }

    private static int getGCD(int i, int j) {
        if (i == 1 || j == 1) {
            return 1;
        }
        return (i % j == 0) ? j : getGCD(j, i % j);
    }

    private static int getLCM(int i, int j) {
        return i * j / getGCD(i, j);
    }

}
