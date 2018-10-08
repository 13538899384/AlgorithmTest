package HuYa;

import java.util.Scanner;

/**
 * 加密算法
 * 题目描述：
 * 用程序写一个对称加密算法，输入数字仅限于（1，2，3，4，5）五个数字，
 * 然后按下面规则进行加密码，1变成2，2变成4，3变成1，4变成5，5变成3，请编写最简单的程序，不能使用if语句。
 * 输入描述:
 * 在范围1，2，3，4，5内的任意个数字,用逗号分开
 * 输出描述:
 * 转换之后的数字,按顺序输出,用逗号分开
 * 示例1：
 * 输入：
 * 1,4,3,2,1,5
 * 输出：
 * 2,5,1,4,2,3
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class DecodeNumber {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        if (str.isEmpty()) {
            return;
        }
        String[] strNums = str.split(",");
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            switch (s) {
                case "1":
                    sb.append("2,");
                    break;
                case "2":
                    sb.append("4,");
                    break;
                case "3":
                    sb.append("1,");
                    break;
                case "4":
                    sb.append("5,");
                    break;
                case "5":
                    sb.append("3,");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1));
    }
}
