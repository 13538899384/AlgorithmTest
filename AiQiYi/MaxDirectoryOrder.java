package AiQiYi;

import java.util.Scanner;

/**
 * Created by XQM on 2018/9/2.
 */
public class MaxDirectoryOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(maxStrValue(str));
    }

    private static String maxStrValue(String str) {
        StringBuilder sb = new StringBuilder(str);
        String s = sb.reverse().toString();//反转字符串
        char[] reverseChar = s.toCharArray();
        int k = 0;
        char[] chars = new char[reverseChar.length];
        //如果前面的比后面的大，保留前面的字符，删除后面
        for (int i = 0;i < reverseChar.length-1;i++){
            if (reverseChar[i] > reverseChar[i+1]){
                chars[k++] = reverseChar[i];
            }
        }

        for (int j = 0;j < k;j++){
            System.out.print(chars[j] + ",");
        }
        return null;
    }
}
