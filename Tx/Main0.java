package Tx;

import java.util.Scanner;

/**
 * 判断和谐数字
 * 定义S(n)为数字n各位数字之和，如果S(n)能够整除n，就称n为一个“和谐数字”
 * 如果是输出“Yes”,否则输出“No”
 *输入：
 7
 34
 66
 72
 6
 32
 33
 86
 输出：
 No
 No
 Yes
 Yes
 No
 No
 No
 * <p>
 * Created by XQM on 2018/9/16.
 */
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrays = new int[n];

        for (int i = 0; i < n; i++) {
            arrays[i] = sc.nextInt();
        }

        isHeXieNumber(arrays);
    }

    private static void isHeXieNumber(int[] numbers) {
        for (int number : numbers) {
            int mSn = getSum(number);
            if (number % mSn == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    /**
     * 递归找到每个整数的个位数，求和
     *
     * @param number
     * @return
     */
    private static int getSum(int number) {
        if (number / 10 == 0) {
            return number;
        } else {
            return getSum(number / 10) + getSum(number % 10);
        }
    }
}
