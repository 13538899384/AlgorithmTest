package _51CreditCard;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 字符串AB
 * 题目描述：   有两个都是大写的字符串A和B，判断A中是否包含B中所有的字符。
 * 注意：字符串B中的字符在A中不需要连续或有序
 * 输入描述:
 * 输入包括n+1行。
 * 第一行包括两个正整数(1 <= n <= 20, 1 <= m <= 100), 表示糖果的种数和一盒糖果盒的糖果个数。
 * 输出描述:
 * 输入：A="ABCU51NB"，B="NB51"
 * 示例1：
 * 输入：
 * ABCU51NB;NB51
 * 输出：
 * true
 * 输入：
 * ACGBEF;DB
 * 输出：
 * false
 * <p>
 * Created by XQM on 2018/9/2.
 */
public class StrAContansB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputStr = input.split(";");

        //A字符数组
        char[] haystackArray = inputStr[0].toCharArray();
        //B字符数组
        char[] needleArray = inputStr[1].toCharArray();

        System.out.println(isAContantsB(haystackArray,needleArray));
    }

    /**
     * 通过A的Set集合判断是否包含B的set集合
     *
     * @param haystackArray
     * @param needleArray
     * @return
     */
    private static boolean isAContantsB(char[] haystackArray, char[] needleArray) {
        Set<Character> mASet = new HashSet<>();
        Set<Character> mBSet = new HashSet<>();
        for (char a : haystackArray){
            mASet.add(a);
        }

        for (char b : needleArray){
            mBSet.add(b);
        }

        if (mASet.containsAll(mBSet)){
            return true;
        }
        return false;
    }
}
