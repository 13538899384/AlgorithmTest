package BeiKe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 题目描述：
 * 给你一个合法的算术表达式，只包含整数和加号，减号。但整数不一定都是十进制的数，可能是八进制，
 * 十六进制，规定包含前缀0x的是十六进制，包含前缀0的是八进制，其他情况是十进制。
 * 现在你能计算出这个式子最终的值吗？
 * <p>
 * 输入的表达式式子只会是 整数 +(-) 整数 +(-) 整数 …… +(-) 整数
 * <p>
 * 保证给定的整数不会超过6位（包括前缀0或者前缀0x）
 * <p>
 * 输入：输入有且只有一行，是一个字符串，保证是合法的表达式式子 如：027555+692-0xD32C
 * 输出：输出仅一行，表示最终的运算结果，要求以10进制的格式输出答案  如：-41227
 *
 * Created by XQM on 2018/10/15.
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(getResult(text));
    }

    private static String getResult(String text) {
        if (text.isEmpty()) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = text.length() - 1; i >= 0; i--) {
            stack.push(text.charAt(i));
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            char c = stack.peek();
            switch (c) {
                case '+':
                    stack.pop();
                    String tmp = sb.toString();
                    tmp = getTemNum(tmp);
                    if (!tmp.isEmpty()) {
                        list.add(tmp);
                    }
                    list.add("+");
                    sb.setLength(0);
                    break;
                case '-':
                    stack.pop();
                    String tmpNum = sb.toString();
                    tmpNum = getTemNum(tmpNum);
                    if (!tmpNum.isEmpty()) {
                        list.add(tmpNum);
                    }
                    list.add("-");
                    sb.setLength(0);
                    break;
                default:
                    c = stack.pop();
                    sb.append(c);

                    if (stack.isEmpty()) {
                        String endNum = sb.toString();
                        endNum = getTemNum(endNum);
                        if (!endNum.isEmpty()) {
                            list.add(endNum);
                        }
                    }
                    break;
            }
        }

        Integer integer = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == "+") {
                integer = Integer.valueOf(list.get(i - 1)) + Integer.valueOf(list.get(i + 1));
                if (i + 1 < list.size()) {
                    list.set(i + 1, integer + "");
                }
            } else if (list.get(i) == "-") {
                integer = Integer.valueOf(list.get(i - 1)) - Integer.valueOf(list.get(i + 1));
                if (i + 1 < list.size()) {
                    list.set(i + 1, integer + "");
                }
            }
        }
        return list.get(list.size() - 1);
    }

    public static String getTemNum(String tmp) {
        boolean isEight = true;
        String tmpNum = tmp;

        for (int j = 0; j < tmp.length(); j++) {
            if (tmp.charAt(j) == '0') {
                if (tmp.charAt(j + 1) == 'x') {
                    isEight = false;
                } else {
                    isEight = true;
                }
                break;
            } else {
                return tmpNum;
            }
        }
        if (isEight) {
            int valueEightToTen = Integer.parseInt(tmp.substring(1), 8);
            tmpNum = String.valueOf(valueEightToTen);
        } else {
            int valueSixToTen = Integer.parseInt(tmp.substring(2), 16);
            tmpNum = String.valueOf(valueSixToTen);
        }
        return tmpNum;
    }
}
