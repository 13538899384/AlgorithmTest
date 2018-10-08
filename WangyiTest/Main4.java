package WangyiTest;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] strStr = new String[n];

        for (int i = 0; i < n; i++) {
            strStr[i] = sc.nextLine();
        }

        Set<String> directory = new LinkedHashSet<>();//字典
        directory.add("235959");

        int maxLength = 6;
        for (String str : strStr) {
            str = str.replace("", ":");
        }
    }

    private static boolean matchCh(char[] chars, int i) {
        switch (i) {
            case 0:
                if ('0' <= chars[i] && chars[i] <= '2') {
                    return true;
                }
                break;
            case 1:
                if ('0' <= chars[i] && chars[i] <= '3') {
                    return true;
                }
                break;
            case 2:
                if ('0' <= chars[i] && chars[i] <= '5') {
                    return true;
                }
                break;
            case 3:
                if ('0' <= chars[i] && chars[i] <= '9') {
                    return true;
                }
                break;
            case 4:
                if ('0' <= chars[i] && chars[i] <= '5') {
                    return true;
                }
                break;
            case 5:
                if ('0' <= chars[i] && chars[i] <= '9') {
                    return true;
                }
                break;
            default:
                break;
        }
        return false;
    }

}
