package _51CreditCard;

import Sort.MaoPaoSort;

import java.util.Scanner;

/**
 * 红绿蓝
 * 题目描述：  分别表示红、绿、蓝三种颜色，给定一个包含这三种颜色的长度为n的数组，现在要求对数组进行分组，使相同颜色的相邻，并按照红、绿、蓝的顺序进行排序。
 * 注意事项：排序需要在原数组中进行。
 * 输入描述:
 * 输入：[‘R’,’G’,’R’,’B’]
 * 输出描述:
 * 输出：[‘R’,’R’,’G’,’B’]
 * 示例1：
 * 输入：
 * RGRB
 * 输出：
 * RRGB
 * <p>
 * Created by XQM on 2018/9/2.
 */

public class RGB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rgbStr = scanner.nextLine();

        char[] rgbChar = rgbStr.toCharArray();

        //冒泡处理
        rgbChar = maoPaoSortRgb(rgbChar);

        //插入排序处理
//        rgbChar = insertSortRgb(rgbChar);

        for (int i = 0; i < rgbChar.length; i++) {
            System.out.print(rgbChar[i]);
        }
    }

    private static char[] maoPaoSortRgb(char[] rgbChar) {
        boolean flag = true;
        for (int i = 0; i < rgbChar.length - 1 && flag; i--) {
            flag = false;
            for (int j = 0; j < rgbChar.length - 1; j++) {
                if (rgbChar[j] < rgbChar[j + 1]) {
                    char temp = rgbChar[j];
                    rgbChar[j] = rgbChar[j + 1];
                    rgbChar[j + 1] = temp;
                    flag = true;
                }
            }
        }

        return rgbChar;
    }

    private static char[] insertSortRgb(char[] rgbChar) {
        int size = rgbChar.length;
        char temp = 0;
        int j = 0;
        for (int i = 1; i < size; i++) {
            temp = rgbChar[i];
            for (j = i; j > 0 && temp < rgbChar[j - 1]; j--) {
                //如果前面的数比后面的数大，将前面的数往后移一下,小到大
                rgbChar[j] = rgbChar[j-1];
            }
            rgbChar[j] = temp;
        }
        return rgbChar;
    }
}
