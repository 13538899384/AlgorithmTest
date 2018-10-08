package SanQiHuYu;

import java.util.Scanner;

/**
 * 给定一个整数，判断该数是否为三七数。
 * 三七数的定义为：若该数含有3或7的因子，
 * 则该数为三七数，如：3，7，9，21均为三七数，
 * 但6不是三七数，因为6包含因子2；1默认为三七数。
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class SanQiNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int target = scanner.nextInt();
            boolean isSanQi = isSanQiNumber(target);
            if (isSanQi) {
                System.out.println(target + "是三七数");
            } else {
                System.out.println(target + "不是三七数");
            }
        }
    }

    private static boolean isSanQiNumber(int target) {
        //如果target小于8
        if (target < 8) {
            if (target == 1 || target == 3 || target == 7) {
                return true;
            } else {
                return false;
            }
        } else {
            //判断target是否能被3或者7整除，递归判断
            boolean isThree = false, isSeven = false;
            if (target % 3 == 0) {
                isThree = isSanQiNumber(target / 3);
            }

            if (target % 7 == 0) {
                isSeven = isSanQiNumber(target / 7);
            }

            return isThree || isSeven;
        }
    }
}
