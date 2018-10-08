package MeiTu;

import java.util.Scanner;

/**
 * 题目描述：不使用java 基础类提供的函数，不使用正则表达式，在一个较长的字符串中，查找一个给定的子字符串的第一个出现位置。
 * 输入：输入两个字符串，str1 和 str2
 * 输出：如果 str2 在 str1 中出现，则返回第一个出现的位置。     如果 str2 没有在 str1 中出现，则返回 -1 。
 * 样例输入1：abcde12   cd
 * 样例输出1：2
 * 样例输入2：abided   o
 * 样例输出2：-1
 * <p>
 * Created by XQM on 2018/9/1.
 */
public class StrStrIndexOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String haystack = scanner.nextLine();
        String needle = scanner.nextLine();
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        int j;
        for (int i = 0; i < haystack.length(); i++) {
            j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                int temp = i;
                while (temp < haystack.length() && j < needle.length()
                        && haystack.charAt(temp++) == needle.charAt(j++)) {
                    if (j == needle.length()){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
