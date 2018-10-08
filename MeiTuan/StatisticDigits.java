package MeiTuan;

import java.util.Scanner;

/**
 * 题目描述：
 * 沫璃在探寻数学的奥秘，她现在想知道n以内的正整数一共有多少位数字。不统计前导零。
 * 例如：n为13时，12345678910111213，共17位，则输出为17。
 * 输入:
 * 第一行一个数T(T<=100)，表示数据组数。
 * 对于每组数据，第一行1个整数n (1 <= n <= 10^9)
 * 输出:
 * 对于每组数据，输出一行，表示数字位数和
 * 样例输入:
 * 2
 * 13
 * 4
 * 样例输出:
 * 17
 * 4
 * 样例解释:
 * n为13时，12345678910111213，共17位，则输出为17
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class StatisticDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println(getDigitSum(scanner.nextInt()));
        }

        System.out.println(getDigitSum(999999999));
        scanner.close();

    }

    /**
     * 返回位数和
     *
     * @param num
     * @return
     */
    static long getDigitSum(int num) {
        long result = 0L;

        long digitNums = getDigitNums(num);
        if (digitNums == 10) {
            return 8888888889L + 10;
        }
        System.out.println("digitNums=" + digitNums);
        int i;
        for (i = 0; i < digitNums - 1; i++) {
            result += 9 * (int) Math.pow(10, i) * (i + 1);
        }
        System.out.println("result=" + result);
        System.out.println("(int) Math.pow(10, digitNums - 1)=" + (int) Math.pow(10, digitNums - 1));
        // 最高位多少个数字
        int count = num - (int) Math.pow(10, digitNums - 1) + 1;
        System.out.println("count=" + count);
        result += (long) count * (long) digitNums;

        return result;
    }

    //获取一个数字的位数
    static int getDigitNums(int num) {
        return (num + "").length();
    }
}
