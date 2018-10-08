package toutiao;

import java.util.*;

/**
 * 求給定字符串無重複字符的最長子字符串的長度
 * abcabcbb 輸出5
 * <p>
 * Created by XQM on 2018/9/9.
 */
public class Main0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(getMaxStringLength(str).length());
    }

    private static int getValue(char[] chars, int k) {
        int max = chars.length;
        for (int i = k; i < max - 1; i++)
            for (int j = i + 1; j < max; j++)
                if (chars[i] == chars[j]) {
                    max = j;
                    break;
                }
        return max - k;
    }

    private static String getMaxStringLength(String str) {
        char[] chars = str.toCharArray();
        int max = 0;
        int j = 0;
        int value = 0;

        for (int i = 0; i < chars.length; i++) {
            if ((i - 1) < (max + j) && i > 0 && chars[i - 1] != chars[max + j])
                continue;
            value = getValue(chars, i);
            if (max < value) {
                j = i;
                max = value;
            }
            if (max >= chars.length - i - 1) {
                break;
            }
        }

        return new String(chars, j, max);
    }

}


