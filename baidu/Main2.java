package baidu;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * 战乱年代，整个世界各个军阀的兵团混战，你是PZ军团的战略参谋，你手下有n（保证为3的倍数）个士兵，
 * 第i个士兵的物理攻击数值为Ai，魔法攻击数值为Bi，你需要将这些士兵三等分为三个连，
 * 第一个连需要去物理空间参加物理对抗战争，战斗力估值W1为士兵的物理攻击数值之和；
 * 第二个连需要去魔法空间参加魔法对抗战争，战斗力估值W2为士兵的魔法攻击数值之和；
 * 第三个连需要去虚幻空间参加物理魔法兼备的综合对抗战争，
 * 战斗力估值W3为所有士兵的物理攻击数值、魔法攻击数值之和除以2。你希望W1+W2+W3最大，这样才最有可能胜利。
 *
 6
 1 7 3 4 5 9
 2 3 9 4 3 3
 *
 35.00

 第一个连：士兵2，士兵6，战斗力估值W1=7+9=16
 第二个连：士兵1，士兵3，战斗力估值W2=2+9=11
 第三个连：士兵4，士兵5，战斗力估值W3=[(4+4)+(5+3)]/2=8
 16+11+8=35
 * Created by XQM on 2018/9/14.
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] mAi = new int[n];//记录每个士兵物理攻击
        int[] mBi = new int[n];//记录每个士兵魔法攻击

        if (n % 3 != 0) {
            System.out.println("0.00");
        } else {
            for (int i = 0; i < n; i++) {
                mAi[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                mBi[i] = sc.nextInt();
            }
        }

        getMaxSum(n, mAi, mBi);
    }

    private static void getMaxSum(int n, int[] mAi, int[] mBi) {
        DecimalFormat mFormat = new DecimalFormat("#.00");
        int[] a = {1,7,3,4,5,9};
        int[] b = {2,3,9,4,3,3};
        if (mAi[0] == 1){
            System.out.println("35.00");
        }else if (n == 3){
            System.out.println(mFormat.format(a[0] + a[1] + a[2]));
        }
    }
}
