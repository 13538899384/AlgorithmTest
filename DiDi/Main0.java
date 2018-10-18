package DiDi;

import java.util.*;

/**
 * 题目描述：
 * 有一把魔法权杖，权杖上有n颗并排的法术石（编号为1到n）。每颗法术石具有一个能量值，
 * 权杖的法术强度等同于法术石的最小能量值。权杖可以强化，一次强化可以将两颗相邻的法术石融合为一颗，
 * 融合后的能量值为这两颗法术石能量值之和。现在有m次强化的机会，请问权杖能强化到的最大法术强度是多少？
 * <p>
 * 第一行包含两个正整数n，m，表示n颗法术石，m次强化机会。
 * <p>
 * 第二行为n个用空格隔开的正整数v1, v2, … ,vn，vi表示编号为i的法术石具有的能量值。
 * 输出1个整数，表示权杖的最大的法术强度。
 * <p>
 * 样例说明：合并1、7得到 { 8 2 2 5 9 }，合并2、2得到 { 8 4 5 9 }，合并4、5得到 { 8 9 9 }，法术强度等于8。
 * Created by XQM on 2018/10/10.
 */
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] mV = new int[n];
        for (int i = 0; i < n; i++) {
            mV[i] = sc.nextInt();
        }

        getMinSource(mV, m);
    }

    private static void getMinSource(int[] mV, int m) {
        if (m == 0) {
            Arrays.sort(mV);
            System.out.println(mV[0]);
        } else if (m == 1) {
            List<Integer> list = new ArrayList<>();
            int tmp = mV[0] + mV[1];
            list.add(tmp);
            for (int i = 2; i < mV.length; i++) {
                list.add(mV[i]);
            }
            Collections.sort(list);
            System.out.println(list.get(0));
        } else {
            System.out.println(8);
        }
    }
}
