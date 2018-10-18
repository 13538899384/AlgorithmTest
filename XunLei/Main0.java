package XunLei;

import java.util.*;
/**
 * 题目描述：
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），
 * 而 s 是个短字符串（长度 <=100）。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
 * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 示例 1: s = "abc", t = "ahbgdc"
 * <p>
 * 返回 true.
 * <p>
 * 示例 2: s = "axc", t = "ahbgdc"
 * <p>
 * 返回 false
 * <p>
 * Created by XQM on 2018/10/18.
 */
public class Main0 {
    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return false;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = k; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    k = j;
                    if (i == s.length() - 1) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }

    /******************************
     * 结束写代码
     ******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res;

        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }

        String _t;
        try {
            _t = in.nextLine();
        } catch (Exception e) {
            _t = null;
        }

        res = isSubsequence(_s, _t);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
